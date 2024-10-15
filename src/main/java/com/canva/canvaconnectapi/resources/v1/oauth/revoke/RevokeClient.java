package com.canva.canvaconnectapi.resources.v1.oauth.revoke;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.resources.v1.oauth.revoke.params.CreateRequest;
import okhttp3.Response;

public class RevokeClient {
    protected final ClientOptions clientOptions;
    public RevokeClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * Revoke an access token or a refresh token.

    If you revoke a _refresh token_, be aware that:

    - The refresh token's lineage is also revoked. This means that access tokens created from that refresh token are also revoked.
    - The user's consent for your integration is also revoked. This means that the user must go through the OAuth process again to use your integration.

    Requests to this endpoint require authentication with your client ID and client secret, using _one_ of the following methods:

    - **Basic access authentication** (Recommended): For [basic access authentication](https://en.wikipedia.org/wiki/Basic_access_authentication), the `{credentials}` string must be a Base64 encoded value of `{client id}:{client secret}`.
    - **Body parameters**: Provide your integration's credentials using the `client_id` and `client_secret` body parameters.
    */
    public Map<?, ?> create(CreateRequest request) {
        return create(request, null);
    }



    /**
    * Revoke an access token or a refresh token.

    If you revoke a _refresh token_, be aware that:

    - The refresh token's lineage is also revoked. This means that access tokens created from that refresh token are also revoked.
    - The user's consent for your integration is also revoked. This means that the user must go through the OAuth process again to use your integration.

    Requests to this endpoint require authentication with your client ID and client secret, using _one_ of the following methods:

    - **Basic access authentication** (Recommended): For [basic access authentication](https://en.wikipedia.org/wiki/Basic_access_authentication), the `{credentials}` string must be a Base64 encoded value of `{client id}:{client secret}`.
    - **Body parameters**: Provide your integration's credentials using the `client_id` and `client_secret` body parameters.
    */
    public Map<?, ?> create(CreateRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/oauth/revoke")
            .method("POST")
            .addAuth(clientOptions.getAuth("basicAuth"))
            .setFormUrlEncodedBody(request.getData())
            .execute();
            return ResponseHandler.processJsonResponse(response, new TypeReference<Map<?, ?>>() {});
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


}

