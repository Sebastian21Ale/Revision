/**
 * 
 */
package co.com.claro.schema.util;

/**
 * @author User
 *
 */
public enum TypeChildVariable {
	LIMIT("lmt"),
	NOF("nof"),
	LMT_AN_CNVR_DETAILS_JOBS_CONCURRENT_ACCESS_MAX("lmt.an.cnvr.details.jobs.concurrent.access.max"),
	LMT_AN_CNVR_DETAILS_JOBS_RATE_PER_SECOND("lmt.an.cnvr.details.jobs.rate.per.second"),
	LMT_AN_CNVR_ABSOLUTE_REQUEST_BYTES_MAX("lmt.an.cnvr.absolute.request.bytes.max"),
	LMT_AN_CNVR_CLIENT_CREDENTIALS_TOKEN_RATE_PER_MINUTE("lmt.an.cnvr.client.credentials.token.rate.per.minute"),
	LMT_AN_CNVR_ORG_APP_USER_RATE_PER_MINUTE("lmt.an.cnvr.org.app.user.rate.per.minute"),
	LMT_AN_CNVR_REQUEST_BYTES_MAX("lmt.an.cnvr.request.bytes.max"),
	LMT_AN_CNVR_TOKEN_RATE_PER_MINUTE("lmt.an.cnvr.token.rate.per.minute");

	private String value;

	private TypeChildVariable(String label) {
		this.value = label;
	}

	public String getValue() {
		return value;
	}
}
