package com.analytics.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.analytics.co.service.ConversationService;

import co.com.claro.schema.analytics.cnvr.request.RequesConversation;
import co.com.claro.schema.analytics.cnvr.response.ResponseConversation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Conversation controller class
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
public class ConversationController {

	@Autowired
	ConversationService service;

	/**
	 * 
	 * Conversation record method in Jsondoc table
	 * 
	 * @param data
	 * @return ResponseConversationSP
	 */
	@Operation(summary = "Conversation record method in Jsondoc table")
	@ApiResponses(value = { @ApiResponse(responseCode = "400", description = "Technical Error"),
			@ApiResponse(responseCode = "408", description = "ConnectionTimeout"),
			@ApiResponse(responseCode = "430", description = "Database Exception"),
			@ApiResponse(responseCode = "204", description = "Data Not Found"),
			@ApiResponse(responseCode = "200", description = "Success", content = @Content) })
	@PostMapping("conversation")
	@ResponseBody
	public ResponseEntity<ResponseConversation> insertConversationSPJs(@RequestBody RequesConversation requesConversation) {
		return new ResponseEntity<> (service.insertUpdConversationSPJs(requesConversation), HttpStatus.OK);
	}

}
