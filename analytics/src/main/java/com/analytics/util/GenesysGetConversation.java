/**
 * 
 */
package com.analytics.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.analytics.co.model.dto.AnalyticsConv;
import com.analytics.co.model.response.ResponseConversationDetails;
import com.analytics.co.model.response.ResponseMetric;
import com.analytics.co.model.resquest.RequesMetric;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypurecloud.sdk.v2.ApiException;
import com.mypurecloud.sdk.v2.api.AnalyticsApi;
import com.mypurecloud.sdk.v2.model.AnalyticsConversation;
import com.mypurecloud.sdk.v2.model.AnalyticsConversationAsyncQueryResponse;
import com.mypurecloud.sdk.v2.model.AsyncConversationQuery;
import com.mypurecloud.sdk.v2.model.AsyncConversationQuery.OrderByEnum;
import com.mypurecloud.sdk.v2.model.AsyncQueryResponse;
import com.mypurecloud.sdk.v2.model.AsyncQueryStatus;

import co.com.claro.schema.analytics.prmt.dto.ChildVariableDTO;
import co.com.claro.schema.util.ResponseCodes;
import co.com.claro.schema.util.TypeChildVariable;

/**
 * Genesys Data Fetch Logic Class
 *
 * @author Andres Capera
 * @version 0.1
 */
@Component
public class GenesysGetConversation {

	private static final Logger logger = Logger.getLogger(GenesysGetConversation.class);

	private GenesysConnection genesysConnection = new GenesysConnection();
	
	private List<ChildVariableDTO> childVariableList = new ArrayList<>();
	
	private MetricGlobal metricGlobal = new MetricGlobal();

	/**
	 * Conversations query method in detail
	 * 
	 * @param intervalDate
	 * @return ResponseConversationDetails
	 * @throws Exception 
	 */
	public ResponseConversationDetails getConversationDetails(String intervalDate) throws Exception {
		ResponseConversationDetails response = new ResponseConversationDetails();
		ObjectMapper mapper = new ObjectMapper();
		String message = "";
		RequesMetric requesMetric  = new RequesMetric();
		try {
			
			AsyncConversationQuery request = new AsyncConversationQuery();
			request.setInterval(intervalDate);
			request.setStartOfDayIntervalMatching(Boolean.FALSE);
			request.setOrder(AsyncConversationQuery.OrderEnum.ASC);
			request.setOrderBy(OrderByEnum.CONVERSATIONSTART);

			message = "Job interval is: %s" + intervalDate;
			logger.info(message);
			
			String requestString = mapper.writeValueAsString(request);
			final byte[] nofrequest= requestString.getBytes(StandardCharsets.UTF_8);
			requesMetric.setNofAnCnvrAbsoReqBytes(Integer.valueOf(nofrequest.length));
			
			ResponseMetric responseMetric = validMetrics(requesMetric);
			if (responseMetric.getStatusResponse().getStatus().equals(ResponseCodes.SUCCESS.getStatus())) {
				
				AnalyticsApi analyticsApi = genesysConnection.getAnalyticsApiInstance();
				AsyncQueryResponse jobRequestResults = analyticsApi.postAnalyticsConversationsDetailsJobs(request);
				
				analyticsApi = genesysConnection.getAnalyticsApiInstanceClose();
				
				String jobId = jobRequestResults.getJobId();
				AsyncQueryStatus jobRequestStatus = analyticsApi.getAnalyticsConversationsDetailsJob(jobId);
				
				/***
				 * Validacion de estado del job
				 */
				while (jobRequestStatus.getState() != AsyncQueryStatus.StateEnum.FULFILLED) {
					jobRequestStatus = analyticsApi.getAnalyticsConversationsDetailsJob(jobId);
					logger.info(jobRequestStatus.getState());
					TimeUnit.SECONDS.sleep(1);
					// parametro de espera para volver a lanzar llamado del job
				}
				logger.info(String.format("Job status: %s jobId %s", jobRequestStatus, jobId));
				Long convSize = 0L;
				String cursor; // Indicates where to resume query results (not required for first page)
				Integer pageSize = 1000; // The desired maximum number of results
				AnalyticsConversationAsyncQueryResponse jobResults = analyticsApi.getAnalyticsConversationsDetailsJobResults(jobId, null, pageSize);
				List<AnalyticsConversation> conversationList = new ArrayList<>(jobResults.getConversations());
				convSize += conversationList.size();
				cursor = jobResults.getCursor();
				logger.info(String.format("first conversations fetched: %s cursor %s total amount %s",
						conversationList.size(), cursor, convSize));
				while (cursor != null) {
					logger.info(String.format("Total conversations fetched: %s cursor %s total amount %s", conversationList.size(), cursor, convSize));
					jobResults = analyticsApi.getAnalyticsConversationsDetailsJobResults(jobId, cursor, pageSize);
					conversationList.addAll(jobResults.getConversations());
					convSize += jobResults.getConversations().size();
					cursor = jobResults.getCursor();
				}
				logger.info(String.format("Total conversations found: %s", convSize));
				
				AnalyticsConv analyticsConv= new AnalyticsConv();
				analyticsConv.setConversationList(conversationList);
				
				String jsonInString = mapper.writeValueAsString(analyticsConv);
				final byte[] nofConversationBytes= jsonInString.getBytes(StandardCharsets.UTF_8);
				
				response.setNofConversation(convSize);
				response.setNofConversationBytes(Long.valueOf(nofConversationBytes.length));
				response.setData(jsonInString);
				response.setStatusResponse(ResponseCodes.SUCCESS);
			}else {
				response.setStatusResponse(responseMetric.getStatusResponse());
				response.setErrorMessage(responseMetric.getErrorMessage());
			}
			
		} catch (ApiException e) {
			message = "GenesysGetConversation getConversationDetails ApiException " + e.getMessage() + " " + e.getCause();
			logger.error(message);
			response.setErrorMessage(message);
			response.setStatusResponse(ResponseCodes.TECHNICAL_ERROR);
		} catch (IOException e) {
			message = "GenesysGetConversation getConversationDetails IOException " + e.getMessage() + " " + e.getCause();
			logger.error(message);
			response.setErrorMessage(message);
			response.setStatusResponse(ResponseCodes.TECHNICAL_ERROR);
		} catch (InterruptedException e) {
			response.setErrorMessage(message);
			message = "GenesysGetConversation getConversationDetails InterruptedException " + e.getMessage() + " " + e.getCause();
			logger.error(message);
			Thread.currentThread().interrupt();
			response.setStatusResponse(ResponseCodes.TECHNICAL_ERROR);
		}
		return response;
	}
	
	/**
	 * Genesys platform variables data map method
	 * 
	 * @param requesMetric
	 * @return ResponseMetric
	 */
	public ResponseMetric validMetrics(RequesMetric requesMetric) {		
			requesMetric.setNofAnCnvrDetJobsId(getChildVariableMetricsLimit(TypeChildVariable.LMT_AN_CNVR_DETAILS_JOBS_CONCURRENT_ACCESS_MAX.getValue()));
			requesMetric.setNofAnCnvrDetJobsRateId(getChildVariableMetricsLimit(TypeChildVariable.LMT_AN_CNVR_DETAILS_JOBS_RATE_PER_SECOND.getValue()));
			requesMetric.setNofAnCnvrAbsoReqBytesId(getChildVariableMetricsLimit(TypeChildVariable.LMT_AN_CNVR_ABSOLUTE_REQUEST_BYTES_MAX.getValue()));
			requesMetric.setNofAnCnvrCliCredTokenId(getChildVariableMetricsLimit(TypeChildVariable.LMT_AN_CNVR_CLIENT_CREDENTIALS_TOKEN_RATE_PER_MINUTE.getValue()));
			
		return metricGlobal.postMetric(requesMetric);
	}
	
	/**
	 * Genesys platform variable extraction map method
	 * 
	 * @param nameChildVariable
	 * @return ChildVariableDTO childVariableDTO.getId
	 */
	public Integer getChildVariableMetricsLimit(String nameChildVariable) {

		ChildVariableDTO childVariableDTO = getChildVariableList().stream()
				.filter(customer -> nameChildVariable.equals(customer.getName())).findAny().orElse(null);
		if (childVariableDTO != null) {
			return Integer.valueOf(String.valueOf(childVariableDTO.getId()));
		} else {
			return null;
		}
	}

	/**
	 * @return the childVariableList
	 */
	public List<ChildVariableDTO> getChildVariableList() {
		return childVariableList;
	}

	/**
	 * @param childVariableList the childVariableList to set
	 */
	public void setChildVariableList(List<ChildVariableDTO> childVariableList) {
		this.childVariableList = childVariableList;
	}
}
