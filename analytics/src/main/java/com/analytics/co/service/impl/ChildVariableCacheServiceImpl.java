/**
 * 
 */
package com.analytics.co.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.analytics.co.service.ChildVariableCacheService;
import com.analytics.util.ChildVariableGlobal;

import co.com.claro.schema.analytics.prmt.response.ResponseChildVariable;

/**
 * Clase de invocación y guardado de variables en cache
 * 
 * @author User
 *
 */
@Component
public class ChildVariableCacheServiceImpl implements ChildVariableCacheService {

	ChildVariableGlobal childVariableGlobal = new ChildVariableGlobal();

	private ResponseChildVariable responseChildVariable = new ResponseChildVariable();

	/**
	 * Genesys limit variables method
	 */
	@Override
	@Cacheable("ResponseChildVariable")
	public ResponseChildVariable postChildVariableMetricsLimit() {
		return responseChildVariable;
	}

	/**
	 * 
	 */
	public void getChildVariableMetricsLimit() {
		responseChildVariable = childVariableGlobal.postChildVariableMetricsLimit();
	}

}
