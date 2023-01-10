/**
 * 
 */
package com.analytics.co.service;

import com.analytics.co.model.response.ResponseAnalytics;
import com.analytics.co.model.resquest.RequestAnalytics;

/**
 * @author Andres Capera
 *
 */
public interface AnalyticsService {
	/**
	 * Method of obtaining conversations in detail
	 * 
	 * @param requestAnalytics
	 * @return ResponseAnalytics
	 */
	public ResponseAnalytics getConversations(RequestAnalytics requestAnalytics);

}
