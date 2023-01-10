/**
 * 
 */
package com.analytics.co.dao;

import co.com.claro.schema.analytics.cnvr.response.ResponseConversation;

/**
 * @author Andres Capera
 *
 */
public interface ConversationDao {
	/**
	 * 
	 * Conversation record method in Jsondoc table
	 * 
	 * @param data
	 * @return ResponseConversationSP
	 */
	public ResponseConversation insertUpdConversationSPJs(String data);

}
