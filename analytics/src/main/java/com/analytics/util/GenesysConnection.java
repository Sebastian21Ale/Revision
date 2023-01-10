package com.analytics.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mypurecloud.sdk.v2.ApiClient;
import com.mypurecloud.sdk.v2.ApiException;
import com.mypurecloud.sdk.v2.ApiResponse;
import com.mypurecloud.sdk.v2.Configuration;
import com.mypurecloud.sdk.v2.api.AnalyticsApi;
import com.mypurecloud.sdk.v2.api.BillingApi;
import com.mypurecloud.sdk.v2.api.ConversationsApi;
import com.mypurecloud.sdk.v2.api.OrganizationApi;
import com.mypurecloud.sdk.v2.api.UsersApi;
import com.mypurecloud.sdk.v2.extensions.AuthResponse;

/**
 * Connection class Genesys
 *
 * @author Andres Capera
 * @version 0.1
 */
@Component
public class GenesysConnection {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(GenesysConnection.class);

	GenesysParameter genesysParameter = new GenesysParameter();

	/**
	 * Builds an ApiClient object using given credentials, this client is able to
	 * perform multiple api calls such as authentication
	 *
	 * @return ApiClient instance
	 *
	 * @throws IOException  Exception thrown in case invalid credentials
	 * @throws ApiException Exception thrown in case credentials restrictions
	 */
	@SuppressWarnings("unused")
	public ApiClient getApiClient() throws IOException, ApiException {
		ApiClient apiClient = ApiClient.Builder.standard().withBasePath(genesysParameter.getRegion()).build();
		ApiResponse<AuthResponse> authResponse = apiClient.authorizeClientCredentials(genesysParameter.getClientid(),
				genesysParameter.getClientSecret());
		return apiClient;
	}

	/**
	 * UserApi instance builder, sets default api client to current configuration
	 *
	 * @return new instance of UsersApi with default ApiClient configuration
	 *
	 * @throws IOException  Exception thrown in case invalid credentials
	 * @throws ApiException Exception thrown in case credentials restrictions
	 */
	public UsersApi getUsersApiInstance() throws IOException, ApiException {
		ApiClient apiClient = getApiClient();
		Configuration.setDefaultApiClient(apiClient);
		return new UsersApi();
	}

	/**
	 * AnalyticsApi instance builder, sets default api client to current
	 * configuration
	 *
	 * @return new instance of AnalyticsApi with default ApiClient configuration
	 *
	 * @throws IOException  Exception thrown in case invalid credentials
	 * @throws ApiException Exception thrown in case credentials restrictions
	 */
	public AnalyticsApi getAnalyticsApiInstance() throws IOException, ApiException {
		ApiClient apiClient = getApiClient();
		Configuration.setDefaultApiClient(apiClient);
		return new AnalyticsApi();
	}
	
	public AnalyticsApi getAnalyticsApiInstanceClose() throws Exception {
		getApiClient().close();
		return new AnalyticsApi();
	}

	/**
	 * ConversationsApi instance builder, sets default api client to current
	 * configuration
	 *
	 * @return new instance of ConversationsApi with default ApiClient configuration
	 *
	 * @throws IOException  Exception thrown in case invalid credentials
	 * @throws ApiException Exception thrown in case credentials restrictions
	 */
	public ConversationsApi getConversationsApiInstance() throws IOException, ApiException {
		ApiClient apiClient = getApiClient();
		Configuration.setDefaultApiClient(apiClient);
		return new ConversationsApi();
	}

	/**
	 * BillingApi instance builder, sets default api client to current configuration
	 *
	 * @return new instance of BillingApi with default ApiClient configuration
	 *
	 * @throws IOException  Exception thrown in case invalid credentials
	 * @throws ApiException Exception thrown in case credentials restrictions
	 */
	public BillingApi getBillingApiInstance() throws IOException, ApiException {
		ApiClient apiClient = getApiClient();
		Configuration.setDefaultApiClient(apiClient);
		return new BillingApi();
	}

	public OrganizationApi getOrganizationApiInstance() throws IOException, ApiException {
		ApiClient apiClient = getApiClient();
		Configuration.setDefaultApiClient(apiClient);
		return new OrganizationApi();
	}
}
