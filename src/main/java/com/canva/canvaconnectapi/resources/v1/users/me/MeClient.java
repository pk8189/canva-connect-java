package com.canva.canvaconnectapi.resources.v1.users.me;

import java.io.IOException;
import java.util.function.Supplier;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.core.Suppliers;
import com.canva.canvaconnectapi.model.UsersMeResponse;
import com.canva.canvaconnectapi.resources.v1.users.me.profileresource.ProfileClient;
import okhttp3.Response;

public class MeClient {
    protected final ClientOptions clientOptions;
    protected final Supplier<ProfileClient> profile;
    public MeClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.profile = Suppliers.memoize(() -> new ProfileClient(clientOptions));
    }

    public ProfileClient profile() {
        return this.profile.get();
    }


    /**
    * Returns the User ID, Team ID, and display name of the user
    account associated with the provided access token.
    */
    public UsersMeResponse list() {
        return list(null);
    }



    /**
    * Returns the User ID, Team ID, and display name of the user
    account associated with the provided access token.
    */
    public UsersMeResponse list(RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/users/me")
            .method("GET")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .execute();
            return ResponseHandler.processJsonResponse(response, UsersMeResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


}

