/**
 * 
 */
package com.analytics.util;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;

import com.analytics.co.model.response.ResponseAnalytics;

import co.com.claro.schema.analytics.ctrl.dto.DataProcessLogDTO;
import co.com.claro.schema.util.ResponseCodes;

/**
 * Class of error processing method
 * 
 * @author Andres Capera
 * @version 0.1
 */
public class ProcessLog {

	private static final Logger logger = Logger.getLogger(ProcessLog.class);

	private ConsumerApis consumerApis = new ConsumerApis();

	/**
	 * Data mapping method for process registration
	 * 
	 * @param ResponseAnalytics
	 */
	@Async
	public void postProcessLog(ResponseAnalytics responseAnalytics) {
		DataProcessLogDTO dataProcessLogDTO = new DataProcessLogDTO();
		try {
			dataProcessLogDTO.setProcessId(5);
			dataProcessLogDTO.setStart(responseAnalytics.getDateStart());
			dataProcessLogDTO.setEnd(responseAnalytics.getDateEnd());
			dataProcessLogDTO.setExecutionTime(Integer.valueOf((int) Math.round(responseAnalytics.getTimeResponse())));

			if (responseAnalytics.getStatusResponse().getStatus().equals(ResponseCodes.SUCCESS.getStatus())) {
				dataProcessLogDTO.setExecutionStatus(1);
			} else {
				dataProcessLogDTO.setComment(responseAnalytics.getErrorMessage());
				dataProcessLogDTO.setErrorFlag(1);
			}
			consumerApis.postProcessLog(dataProcessLogDTO);
		} catch (Exception e) {
			String message = "AnalyticsServiceImpl postChildVariableMetricsNof : " + e.getMessage() + " "
					+ e.getCause();
			logger.error(message);
			responseAnalytics.setStatusResponse(ResponseCodes.TECHNICAL_ERROR);
		}

	}
}
