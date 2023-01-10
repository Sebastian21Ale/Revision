/**
 * 
 */
package com.analytics.util;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.analytics.co.model.response.ResponseConversation;
import com.analytics.co.model.response.ResponseMetric;
import com.analytics.co.model.resquest.RequesMetric;

import co.com.claro.schema.analytics.cnvr.request.RequesConversation;
import co.com.claro.schema.analytics.ctrl.dto.DataProcessLogDTO;
import co.com.claro.schema.analytics.ctrl.request.RequestProcessLog;
import co.com.claro.schema.analytics.prmt.response.ResponseChildVariable;
import co.com.claro.schema.util.ResponseCodes;
import io.netty.handler.timeout.TimeoutException;

/**
 * Class of connection to microservices
 * 
 * @author Andres Capera
 * @version 0.1
 */
public class ConsumerApis {
	private static final Logger logger = Logger.getLogger(ConsumerApis.class);

	/**
	 * Conversation recording method in detail
	 * 
	 * @param data
	 * @return ResponseApi
	 */

	public ResponseConversation postConversation(String data) {
		ResponseConversation consumerApis = new ResponseConversation();
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
		RequesConversation requesConversa = new RequesConversation();
		try {
			requesConversa.setData(data);
			HttpEntity<RequesConversation> requesConversation = new HttpEntity<>(requesConversa);
			ResponseEntity<ResponseConversation> response = restTemplate.exchange("http://localhost:9093/conversation/v1/conversation", HttpMethod.POST, requesConversation,
					ResponseConversation.class);
				
			ResponseConversation obj = Optional.ofNullable(response.getBody()).orElse(null);
			if (obj != null) {
				consumerApis.setStatusResponse(obj.getStatusResponse());
				consumerApis.setErrorMessage(obj.getErrorMessage());
			} else {
				consumerApis.setStatusResponse(ResponseCodes.TECHNICAL_ERROR);
				consumerApis.setErrorMessage("");
			}
		} catch (TimeoutException e) {
			String message = "ConsumerApis postConversation TimeoutException " + e.getMessage() + " " + e.getCause();
			logger.error(message);
			consumerApis.setErrorMessage(message);
			consumerApis.setStatusResponse(ResponseCodes.TIMEOUT_EXCEPTION);
		} catch (Exception e) {
			String message = "ConsumerApis postConversation Exception " + e.getMessage() + " " + e.getCause();
			logger.error(message);
			consumerApis.setErrorMessage(message);
			consumerApis.setStatusResponse(ResponseCodes.TECHNICAL_ERROR);
		}

		return consumerApis;
	}

	/**
	 * Error Log Method
	 * 
	 * @param dataProcessLogDTO
	 * @return ResponseApi
	 */
	public ResponseConversation postProcessLog(DataProcessLogDTO dataProcessLogDTO) {
		ResponseConversation consumerApis = new ResponseConversation();
		RestTemplate restTemplate = new RestTemplate();
		RequestProcessLog requestProces = new RequestProcessLog();
		try {
			requestProces.setDataProcessLog(dataProcessLogDTO);
			HttpEntity<RequestProcessLog> requesConversation = new HttpEntity<>(requestProces);
			ResponseEntity<ResponseConversation> response = restTemplate.exchange("http://localhost:9091/an-control/v1/log/error", HttpMethod.POST, requesConversation,
					ResponseConversation.class);
			ResponseConversation obj = Optional.ofNullable(response.getBody()).orElse(null);
			if (obj != null) {
				consumerApis.setStatusResponse(obj.getStatusResponse());
				consumerApis.setErrorMessage(obj.getErrorMessage());
			} else {
				consumerApis.setStatusResponse(ResponseCodes.TECHNICAL_ERROR);
				consumerApis.setErrorMessage("");
			}
		} catch (TimeoutException e) {
			String message = "ConsumerApis postProcessLog TimeoutException " + e.getMessage() + " " + e.getCause();
			consumerApis.setErrorMessage(message);
			logger.error(message);
			consumerApis.setStatusResponse(ResponseCodes.TIMEOUT_EXCEPTION);
		} catch (Exception e) {
			String message = "ConsumerApis postProcessLog Exception " + e.getMessage() + " " + e.getCause();
			logger.error(message);
			consumerApis.setErrorMessage(message);
			consumerApis.setStatusResponse(ResponseCodes.TECHNICAL_ERROR);
		}
		return consumerApis;
	}
	
	/**
	 * Variable consumption method in an-parameter project
	 * 
	 * @param childVariablename
	 * @return ResponseChildVariable
	 */
	@Cacheable(value = "responseChildVariable")
	public ResponseChildVariable postChildVariable(String childVariablename) {
		ResponseChildVariable consumerApis = new ResponseChildVariable();
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<ResponseChildVariable> response = restTemplate.getForEntity("http://localhost:9092/an-parameter/v1/variables/"+childVariablename,
					ResponseChildVariable.class);
			ResponseChildVariable obj = Optional.ofNullable(response.getBody()).orElse(null);
			if (obj != null) {
				consumerApis.setStatusResponse(obj.getStatusResponse());
				consumerApis.setErrorMessage(obj.getErrorMessage());
				consumerApis.setChildVariableList(obj.getChildVariableList());
			} else {
				consumerApis.setStatusResponse(ResponseCodes.TECHNICAL_ERROR);
				consumerApis.setErrorMessage("");
			}
		} catch (TimeoutException e) {
			String message = "ConsumerApis postChildVariable TimeoutException " + e.getMessage() + " " + e.getCause();
			consumerApis.setErrorMessage(message);
			logger.error(message);
			consumerApis.setStatusResponse(ResponseCodes.TIMEOUT_EXCEPTION);
		} catch (Exception e) {
			String message = "ConsumerApis postChildVariable Exception " + e.getMessage() + " " + e.getCause();
			logger.error(message);
			consumerApis.setErrorMessage(message);
			consumerApis.setStatusResponse(ResponseCodes.TECHNICAL_ERROR);
		}
		return consumerApis;
	}
	
	/**
	 * An-control project consumption method for metric validation
	 * 
	 * @param requesMetric
	 * @return postMetric
	 */
	public ResponseMetric postMetric(RequesMetric requesMetric) {
		ResponseMetric consumerApis = new ResponseMetric();
		RestTemplate restTemplate = new RestTemplate();
		try {
			HttpEntity<RequesMetric> requesChildVariable = new HttpEntity<>(requesMetric);
			ResponseEntity<ResponseChildVariable> response = restTemplate.exchange("http://localhost:9091/an-control/v1/variables-platform", HttpMethod.POST, requesChildVariable,
					ResponseChildVariable.class);
			ResponseChildVariable obj = Optional.ofNullable(response.getBody()).orElse(null);
			if (obj != null) {
				consumerApis.setStatusResponse(obj.getStatusResponse());
				consumerApis.setErrorMessage(obj.getErrorMessage());
			} else {
				consumerApis.setStatusResponse(ResponseCodes.TECHNICAL_ERROR);
				consumerApis.setErrorMessage("");
			}
		} catch (TimeoutException e) {
			String message = "ConsumerApis postMetric TimeoutException " + e.getMessage() + " " + e.getCause();
			consumerApis.setErrorMessage(message);
			logger.error(message);
			consumerApis.setStatusResponse(ResponseCodes.TIMEOUT_EXCEPTION);
		} catch (Exception e) {
			String message = "ConsumerApis postMetric Exception " + e.getMessage() + " " + e.getCause();
			logger.error(message);
			consumerApis.setErrorMessage(message);
			consumerApis.setStatusResponse(ResponseCodes.TECHNICAL_ERROR);
		}
		return consumerApis;
	}

	/**
	 * Timeout and retry setting method
	 * 
	 * @return
	 */
	private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		// Connect timeout
		clientHttpRequestFactory.setConnectTimeout(999999999);

		// Read timeout
		clientHttpRequestFactory.setReadTimeout(999999999);
		return clientHttpRequestFactory;
	}
}
