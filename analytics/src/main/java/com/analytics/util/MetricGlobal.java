/**
 * 
 */
package com.analytics.util;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;

import org.apache.log4j.Logger;

import com.analytics.co.model.response.ResponseAnalytics;
import com.analytics.co.model.response.ResponseMetric;
import com.analytics.co.model.resquest.RequesMetric;

import co.com.claro.schema.util.GeneralMethods;
import co.com.claro.schema.util.ResponseCodes;

/**
 * 
 * Class of invocation and saving of errors, for validation of metrics
 * 
 * @author User
 *
 */
public class MetricGlobal {
	
	private static final Logger logger = Logger.getLogger(MetricGlobal.class);
	
	private GeneralMethods generalMetodos = new GeneralMethods();

	private ConsumerApis consumerApis = new ConsumerApis();
	
	private ProcessLog processLog = new ProcessLog();
	
	/**
	 * Method of consumption and validation of genesys metrics
	 * 
	 * @param requesMetric
	 * @return ResponseMetric
	 */
	public ResponseMetric postMetric(RequesMetric requesMetric) {
		ResponseAnalytics responseAnalytics = new ResponseAnalytics();
		ResponseMetric responseChildVariable = new ResponseMetric();
		try {

			responseAnalytics.setTimeStart(LocalTime.now());
			responseAnalytics.setDateStart(new Timestamp(new Date().getTime()));
			responseChildVariable = consumerApis.postMetric(requesMetric);
			if (responseChildVariable.getStatusResponse().getStatus().equals(ResponseCodes.SUCCESS.getStatus())) {
				String message = "postMetric SUCCESS";
				logger.info(message);
			} else {
				responseAnalytics.setStatusResponse(responseChildVariable.getStatusResponse());
				responseAnalytics.setErrorMessage(responseChildVariable.getErrorMessage());
			}
		} catch (Exception e) {
			String message = "MetricGlobal postMetric : " + e.getMessage() + " " + e.getCause();
			logger.error(message);
			responseAnalytics.setStatusResponse(ResponseCodes.TECHNICAL_ERROR);
			responseChildVariable.setStatusResponse(ResponseCodes.TECHNICAL_ERROR);
		}

		responseAnalytics.setTimeEnd(LocalTime.now());
		responseAnalytics.setDateEnd(new Timestamp(new Date().getTime()));
		responseAnalytics.setTimeResponse(generalMetodos.getBetween(responseAnalytics.getTimeStart(), responseAnalytics.getTimeEnd()));

		processLog.postProcessLog(responseAnalytics);

		return responseChildVariable;
	}
}
