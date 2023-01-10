/**
 * 
 */
package com.analytics.util;

import co.com.claro.schema.util.PureCloudRegionHosts;

/**
 * Genesys connection parameters class
 *
 * @author Andres Capera
 * @version 0.1
 */
public class GenesysParameter {
	private String clientid = "23de22ff-b5fd-4882-8963-4923466adce3";
	private String clientSecret = "DWrea_hV-M5N6Ux8VK0mkc5kXxFtOBjRAxLFAIz2IbA";
	private String region = PureCloudRegionHosts.US_EAST_1.getApiHost();
	private String intervalDate = "2022-09-01T00:00:00/2022-09-30T23:59:59";

	/**
	 * @return the clientid
	 */
	public String getClientid() {
		return clientid;
	}

	/**
	 * @param clientid the clientid to set
	 */
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	/**
	 * @return the clientSecret
	 */
	public String getClientSecret() {
		return clientSecret;
	}

	/**
	 * @param clientSecret the clientSecret to set
	 */
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the intervalDate
	 */
	public String getIntervalDate() {
		return intervalDate;
	}

	/**
	 * @param intervalDate the intervalDate to set
	 */
	public void setIntervalDate(String intervalDate) {
		this.intervalDate = intervalDate;
	}

}
