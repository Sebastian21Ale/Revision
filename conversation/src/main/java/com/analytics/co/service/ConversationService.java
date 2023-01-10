/**
 * 
 */
package com.analytics.co.service;

import co.com.claro.schema.analytics.cnvr.request.RequesConversation;
import co.com.claro.schema.analytics.cnvr.response.ResponseConversation;

/**
 * @author Andres Capera
 *
 */
public interface ConversationService {

	/**
	 * 
	 * Conversation record method in Jsondoc table
	 * 
	 * @param data
	 * @return ResponseConversationSP
	 */
	public ResponseConversation insertUpdConversationSPJs(RequesConversation requesConversation);

}
