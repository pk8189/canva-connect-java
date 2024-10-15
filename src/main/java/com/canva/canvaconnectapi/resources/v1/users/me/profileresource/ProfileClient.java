package com.canva.canvaconnectapi.resources.v1.users.me.profileresource;

import java.io.IOException;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.model.UserProfileResponse;
import okhttp3.Response;

public class ProfileClient {
    protected final ClientOptions clientOptions;
    public ProfileClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * Currently, this returns the display name of the user account associated with the provided access token. More user information is expected to be included in the future.
    */
    public UserProfileResponse list() {
        return list(null);
    }



    /**
    * Currently, this returns the display name of the user account associated with the provided access token. More user information is expected to be included in the future.
    */
    public UserProfileResponse list(RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/users/me/profile")
            .method("GET")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .execute();
            return ResponseHandler.processJsonResponse(response, UserProfileResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


}

