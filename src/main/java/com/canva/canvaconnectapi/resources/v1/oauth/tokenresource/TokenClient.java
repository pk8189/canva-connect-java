package com.canva.canvaconnectapi.resources.v1.oauth.tokenresource;

import java.io.IOException;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.model.ExchangeAccessTokenResponse;
import com.canva.canvaconnectapi.resources.v1.oauth.tokenresource.params.CreateRequest;
import okhttp3.Response;

public class TokenClient {
    protected final ClientOptions clientOptions;
    public TokenClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * This endpoint implements the OAuth 2.0 `token` endpoint, as part of the Authorization Code flow with Proof Key for Code Exchange (PKCE). For more information, see [Authentication](https://www.canva.dev/docs/connect/authentication/).

    To generate an access token, you must provide one of the following:

    - An authorization code
    - A refresh token

    Generating a token using either an authorization code or a refresh token allows your integration to act on behalf of a user. You must first [obtain user authorization and get an authorization code](https://www.canva.dev/docs/connect/authentication/#obtain-user-authorization).

    Access tokens may be up to 4 KB in size, and are only valid for a specified period of time. The expiry time (currently 4 hours) is shown in the endpoint response and is subject to change.

    **Endpoint authentication**

    Requests to this endpoint require authentication with your client ID and client secret, using _one_ of the following methods:

    - **Basic access authentication** (Recommended): For [basic access authentication](https://en.wikipedia.org/wiki/Basic_access_authentication), the `{credentials}` string must be a Base64 encoded value of `{client id}:{client secret}`.
    - **Body parameters**: Provide your integration's credentials using the `client_id` and `client_secret` body parameters.

    **Generate an access token using an authorization code**

    To generate an access token with an authorization code, you must:

    - Set `grant_type` to `authorization_code`.
    - Provide the `code_verifier` value that you generated when creating the user authorization URL.
    - Provide the authorization code you received after the user authorized the integration.

    **Generate an access token using a refresh token**

    Using the `refresh_token` value from a previous user token request, you can get a new access token with the same or smaller scope as the previous one, but with a refreshed expiry time. You will also receive a new refresh token that you can use to refresh the access token again.

    To refresh an existing access token, you must:

    - Set `grant_type` to `refresh_token`.
    - Provide the `refresh_token` from a previous token request.
    */
    public ExchangeAccessTokenResponse create(CreateRequest request) {
        return create(request, null);
    }



    /**
    * This endpoint implements the OAuth 2.0 `token` endpoint, as part of the Authorization Code flow with Proof Key for Code Exchange (PKCE). For more information, see [Authentication](https://www.canva.dev/docs/connect/authentication/).

    To generate an access token, you must provide one of the following:

    - An authorization code
    - A refresh token

    Generating a token using either an authorization code or a refresh token allows your integration to act on behalf of a user. You must first [obtain user authorization and get an authorization code](https://www.canva.dev/docs/connect/authentication/#obtain-user-authorization).

    Access tokens may be up to 4 KB in size, and are only valid for a specified period of time. The expiry time (currently 4 hours) is shown in the endpoint response and is subject to change.

    **Endpoint authentication**

    Requests to this endpoint require authentication with your client ID and client secret, using _one_ of the following methods:

    - **Basic access authentication** (Recommended): For [basic access authentication](https://en.wikipedia.org/wiki/Basic_access_authentication), the `{credentials}` string must be a Base64 encoded value of `{client id}:{client secret}`.
    - **Body parameters**: Provide your integration's credentials using the `client_id` and `client_secret` body parameters.

    **Generate an access token using an authorization code**

    To generate an access token with an authorization code, you must:

    - Set `grant_type` to `authorization_code`.
    - Provide the `code_verifier` value that you generated when creating the user authorization URL.
    - Provide the authorization code you received after the user authorized the integration.

    **Generate an access token using a refresh token**

    Using the `refresh_token` value from a previous user token request, you can get a new access token with the same or smaller scope as the previous one, but with a refreshed expiry time. You will also receive a new refresh token that you can use to refresh the access token again.

    To refresh an existing access token, you must:

    - Set `grant_type` to `refresh_token`.
    - Provide the `refresh_token` from a previous token request.
    */
    public ExchangeAccessTokenResponse create(CreateRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/oauth/token")
            .method("POST")
            .addAuth(clientOptions.getAuth("basicAuth"))
            .setFormUrlEncodedBody(request.getData())
            .execute();
            return ResponseHandler.processJsonResponse(response, ExchangeAccessTokenResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


}

