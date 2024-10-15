package com.canva.canvaconnectapi.resources.v1.apps.jwks;

import java.io.IOException;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.model.GetAppJwksResponse;
import com.canva.canvaconnectapi.resources.v1.apps.jwks.params.ListRequest;
import okhttp3.Response;

public class JwksClient {
    protected final ClientOptions clientOptions;
    public JwksClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * Returns the Json Web Key Set (public keys) of an app. These keys are used to
    verify JWTs sent to app backends.
    */
    public GetAppJwksResponse list(ListRequest request) {
        return list(request, null);
    }



    /**
    * Returns the Json Web Key Set (public keys) of an app. These keys are used to
    verify JWTs sent to app backends.
    */
    public GetAppJwksResponse list(ListRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/apps/{appId}/jwks")
            .addPathParam("appId", request.getAppId())
            .method("GET")
            .execute();
            return ResponseHandler.processJsonResponse(response, GetAppJwksResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


}

