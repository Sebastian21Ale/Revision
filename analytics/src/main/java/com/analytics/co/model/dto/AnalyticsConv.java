/**
 * 
 */
package com.analytics.co.model.dto;

import java.util.List;

import com.mypurecloud.sdk.v2.model.AnalyticsConversation;

/**
 * @author User
 *
 */
public class AnalyticsConv {
	private List<AnalyticsConversation> conversationList;

	/**
	 * @return the conversationList
	 */
	public List<AnalyticsConversation> getConversationList() {
		return conversationList;
	}

	/**
	 * @param conversationList the conversationList to set
	 */
	public void setConversationList(List<AnalyticsConversation> conversationList) {
		this.conversationList = conversationList;
	}

}
