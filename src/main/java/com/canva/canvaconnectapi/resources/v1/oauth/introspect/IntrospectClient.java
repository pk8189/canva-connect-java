package com.canva.canvaconnectapi.resources.v1.oauth.introspect;

import java.io.IOException;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.model.IntrospectTokenResponse;
import com.canva.canvaconnectapi.resources.v1.oauth.introspect.params.CreateRequest;
import okhttp3.Response;

public class IntrospectClient {
    protected final ClientOptions clientOptions;
    public IntrospectClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * Introspect an access token to see whether it is valid and active. You can also verify some token properties, such as its claims, scopes, and validity times.

    Requests to this endpoint require authentication with your client ID and client secret, using _one_ of the following methods:

    - **Basic access authentication** (Recommended): For [basic access authentication](https://en.wikipedia.org/wiki/Basic_access_authentication), the `{credentials}` string must be a Base64 encoded value of `{client id}:{client secret}`.
    - **Body parameters**: Provide your integration's credentials using the `client_id` and `client_secret` body parameters.
    */
    public IntrospectTokenResponse create(CreateRequest request) {
        return create(request, null);
    }



    /**
    * Introspect an access token to see whether it is valid and active. You can also verify some token properties, such as its claims, scopes, and validity times.

    Requests to this endpoint require authentication with your client ID and client secret, using _one_ of the following methods:

    - **Basic access authentication** (Recommended): For [basic access authentication](https://en.wikipedia.org/wiki/Basic_access_authentication), the `{credentials}` string must be a Base64 encoded value of `{client id}:{client secret}`.
    - **Body parameters**: Provide your integration's credentials using the `client_id` and `client_secret` body parameters.
    */
    public IntrospectTokenResponse create(CreateRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/oauth/introspect")
            .method("POST")
            .addAuth(clientOptions.getAuth("basicAuth"))
            .setFormUrlEncodedBody(request.getData())
            .execute();
            return ResponseHandler.processJsonResponse(response, IntrospectTokenResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


}

