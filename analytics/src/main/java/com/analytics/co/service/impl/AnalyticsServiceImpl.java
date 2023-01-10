/**
 * 
 */
package com.analytics.co.service.impl;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.analytics.co.model.response.ResponseAnalytics;
import com.analytics.co.model.response.ResponseConversation;
import com.analytics.co.model.response.ResponseConversationDetails;
import com.analytics.co.model.resquest.RequestAnalytics;
import com.analytics.co.service.AnalyticsService;
import com.analytics.co.service.ChildVariableCacheService;
import com.analytics.util.ConsumerApis;
import com.analytics.util.GenesysGetConversation;
import com.analytics.util.ProcessLog;

import co.com.claro.schema.analytics.prmt.response.ResponseChildVariable;
import co.com.claro.schema.util.ResponseCodes;
import co.com.claro.schema.util.GeneralMethods;

/**
 * Service layer class for microservices
 *
 * @author Andres Capera
 * @version 0.1
 */
@Service
@Transactional
public class AnalyticsServiceImpl implements AnalyticsService {

	private static final Logger logger = Logger.getLogger(AnalyticsServiceImpl.class);

	private GenesysGetConversation genesysGetConversation = new GenesysGetConversation();

	private ConsumerApis consumerApis = new ConsumerApis();
	
	private GeneralMethods generalMetodos = new GeneralMethods();
	
	private ProcessLog processLog = new ProcessLog();
	
	@Autowired
	ChildVariableCacheService childVariableCacheService;


	/**
	 * Method of obtaining conversations in detail
	 * 
	 * @param requestAnalytics
	 * @return ResponseAnalytics
	 */
	@Override
	public ResponseAnalytics getConversations(RequestAnalytics requestAnalytics) {
		ResponseAnalytics responseAnalytics = new ResponseAnalytics();

		responseAnalytics.setTimeStart(LocalTime.now());
		responseAnalytics.setDateStart(new Timestamp(new Date().getTime()));
		ResponseConversationDetails responseConversationDetails;
		try {
			// Valiadacion de cargue en cache exitoso de variables
			ResponseChildVariable responseChildVariable = childVariableCacheService.postChildVariableMetricsLimit();
			
			if (responseChildVariable.getStatusResponse().getStatus().equals(ResponseCodes.SUCCESS.getStatus())) {
				genesysGetConversation.setChildVariableList(responseChildVariable.getChildVariableList());
				responseConversationDetails = genesysGetConversation.getConversationDetails(requestAnalytics.getIntervalDate());
				if (responseConversationDetails.getStatusResponse().equals(ResponseCodes.SUCCESS)) {

					// Proceso de consugo de conversation, para guardado de informacion de base de
					// datos
					ResponseConversation responseConversation = consumerApis.postConversation(responseConversationDetails.getData());

					responseAnalytics.setNofConversation(responseConversationDetails.getNofConversation());
					responseAnalytics.setNofConversationBytes(responseConversationDetails.getNofConversationBytes());
					responseAnalytics.setStatusResponse(responseConversation.getStatusResponse());
				} else {
					responseAnalytics.setErrorMessage(responseConversationDetails.getErrorMessage());
					responseAnalytics.setStatusResponse(responseConversationDetails.getStatusResponse());
				}
			} else {
				responseAnalytics.setStatusResponse(responseChildVariable.getStatusResponse());
				responseAnalytics.setErrorMessage(responseChildVariable.getErrorMessage());
			}
			
		} catch (Exception e) {
			String message = "AnalyticsServiceImpl getConversations : " + e.getMessage() + " " + e.getCause();
			logger.error(message);
			responseAnalytics.setStatusResponse(ResponseCodes.TECHNICAL_ERROR);
		}
		
		responseAnalytics.setTimeEnd(LocalTime.now());
		responseAnalytics.setDateEnd(new Timestamp(new Date().getTime()));
		responseAnalytics.setTimeResponse(generalMetodos.getBetween(responseAnalytics.getTimeStart(), responseAnalytics.getTimeEnd()));
		
		processLog.postProcessLog(responseAnalytics);
		
		return responseAnalytics;

	}
}
