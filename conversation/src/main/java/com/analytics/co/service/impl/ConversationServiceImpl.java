/**
 * 
 */
package com.analytics.co.service.impl;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analytics.co.dao.ConversationDao;
import com.analytics.co.service.ConversationService;

import co.com.claro.schema.analytics.cnvr.request.RequesConversation;
import co.com.claro.schema.analytics.cnvr.response.ResponseConversation;

/**
 * Conversational Class of Service
 * 
 * You only have to validate the information to be saved
 * 
 * @author Andres Capera
 * @version 0.1
 *
 */
@Service
@Transactional
public class ConversationServiceImpl implements ConversationService {

	@Autowired
	private ConversationDao service;

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ConversationServiceImpl.class);

	/**
	 * 
	 * Conversation record method in Jsondoc table
	 * 
	 * @param data
	 * @return ResponseConversationSP
	 */
	@Override
	public ResponseConversation insertUpdConversationSPJs(RequesConversation requesConversation) {
		return service.insertUpdConversationSPJs(requesConversation.getData());
	}

}
