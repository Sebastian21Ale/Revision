/**
 * 
 */
package com.analytics.util;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;

import org.apache.log4j.Logger;

import com.analytics.co.model.response.ResponseAnalytics;

import co.com.claro.schema.analytics.prmt.response.ResponseChildVariable;
import co.com.claro.schema.util.GeneralMethods;
import co.com.claro.schema.util.ResponseCodes;
import co.com.claro.schema.util.TypeChildVariable;

/**
 * Invocation class and saving of variable logs in cache
 * 
 * @author Andres Capera
 * @version 0.1
 */
public class ChildVariableGlobal {
	
	private static final Logger logger = Logger.getLogger(ChildVariableGlobal.class);
	
	private GeneralMethods generalMetodos = new GeneralMethods();
	
	private ConsumerApis consumerApis = new ConsumerApis();
	
	private ProcessLog processLog = new ProcessLog();
	
	private ResponseChildVariable responseChildVariable = new ResponseChildVariable();

	/**
	 * metric limit query method
	 * 
	 * @return ResponseChildVariable
	 */
	public ResponseChildVariable postChildVariableMetricsLimit() {
		ResponseAnalytics responseAnalytics = new ResponseAnalytics();
		try {

			responseAnalytics.setTimeStart(LocalTime.now());
			responseAnalytics.setDateStart(new Timestamp(new Date().getTime()));
			responseChildVariable = consumerApis.postChildVariable(TypeChildVariable.LIMIT.getValue());
			
			responseAnalytics.setStatusResponse(responseChildVariable.getStatusResponse());
			responseAnalytics.setErrorMessage(responseChildVariable.getErrorMessage());
			
		} catch (Exception e) {
			String message = "AnalyticsServiceImpl postChildVariableMetricsLimit : " + e.getMessage() + " " + e.getCause();
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
