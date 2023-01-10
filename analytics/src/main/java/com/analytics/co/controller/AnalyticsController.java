package com.analytics.co.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.analytics.co.model.response.ResponseAnalytics;
import com.analytics.co.model.resquest.RequestAnalytics;
import com.analytics.co.service.AnalyticsService;
import com.analytics.co.service.ChildVariableCacheService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Analytics controller class
 * 
 * Only methods to expose and signature annotations or swagger documentation
 * should go
 * 
 * @author Andres Capera
 * @version 0.1
 *
 */

@CrossOrigin
@RestController
@RequestMapping(value = "v1/")
public class AnalyticsController {

	@Autowired
	AnalyticsService service;

	@Autowired
	ChildVariableCacheService childVariableCacheService;

	/**
	 * Genesys limit variables method
	 */
	@PostConstruct
	public void init() {
		childVariableCacheService.getChildVariableMetricsLimit();
	}


	/**
	 * Method of obtaining conversations in detail
	 * 
	 * @param requestAnalytics
	 * @return ResponseAnalytics
	 */
	@Operation(summary = "Method of obtaining conversations in detail")
	@ApiResponses(value = { @ApiResponse(responseCode = "400", description = "Technical Error"),
			@ApiResponse(responseCode = "408", description = "ConnectionTimeout"),
			@ApiResponse(responseCode = "430", description = "Database Exception"),
			@ApiResponse(responseCode = "204", description = "Data Not Found"),
			@ApiResponse(responseCode = "200", description = "Success", content = @Content) })
	@PostMapping("extraction-process")
	@ResponseBody
	public ResponseAnalytics getConversations(@RequestBody RequestAnalytics requestAnalytics) {
		return service.getConversations(requestAnalytics);
	}

}
