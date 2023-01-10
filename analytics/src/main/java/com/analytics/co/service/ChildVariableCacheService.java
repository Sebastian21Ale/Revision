/**
 * 
 */
package com.analytics.co.service;

import co.com.claro.schema.analytics.prmt.response.ResponseChildVariable;

/**
 * @author User
 *
 */
public interface ChildVariableCacheService {
	/**
	 * Genesys limit variables method
	 */
	ResponseChildVariable postChildVariableMetricsLimit();

	/**
	 * Genesys limit variables method
	 */
	void getChildVariableMetricsLimit();
}
