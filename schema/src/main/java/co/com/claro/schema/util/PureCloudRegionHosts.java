/**
 * 
 */
package co.com.claro.schema.util;

/**
 * @author User
 *
 */
public enum PureCloudRegionHosts {
	US_EAST_1( "https://api.mypurecloud.com"),
	EU_WEST_1("https://api.mypurecloud.ie"),
	AP_SOUTHEAST_2( "https://api.mypurecloud.com.au"),
	AP_NORTHEAST_1("https://api.mypurecloud.jp"),
	EU_CENTRAL_1("https://api.mypurecloud.de"),
	US_WEST_2("https://api.usw2.pure.cloud"),
	CA_CENTRAL_1("https://api.cac1.pure.cloud"),
	AP_NORTHEAST_2("https://api.apne2.pure.cloud"),
	EU_WEST_2("https://api.euw2.pure.cloud"),
	AP_SOUTH_1("https://api.aps1.pure.cloud"),
	US_EAST_2("https://api.use2.us-gov-pure.cloud");


    private String apiHost;
    PureCloudRegionHosts(String apiHost) {
        this.apiHost = apiHost;
    }

    public String getApiHost() {
        return apiHost;
    }
}
