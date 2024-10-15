package com.canva.canvaconnectapi.resources.v1.connect.keys;

import java.io.IOException;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.model.GetSigningPublicKeysResponse;
import okhttp3.Response;

public class KeysClient {
    protected final ClientOptions clientOptions;
    public KeysClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * <Warning>

    This API is currently provided as a preview. Be aware of the following:

    - There might be unannounced breaking changes.
    - Any breaking changes to preview APIs won't produce a new [API version](https://www.canva.dev/docs/connect/versions/).
    - Public integrations that use preview APIs will not pass the review process, and can't be made available to all Canva users.

    </Warning>

    The Keys API (`connect/keys`) is a security measure you can use to verify the authenticity
    of webhooks you receive from Canva Connect. The Keys API returns a
    [JSON Web Key (JWK)](https://www.rfc-editor.org/rfc/rfc7517#section-2), which you can use to
    decrypt the webhook signature and verify it came from Canva and not a potentially malicious
    actor. This helps to protect your systems from
    [Replay attacks](https://owasp.org/Top10/A08_2021-Software_and_Data_Integrity_Failures/).

    The keys returned by the Keys API can rotate. We recommend you cache the keys you receive
    from this API where possible, and only access this API when you receive a webhook signed
    with an unrecognized key. This allows you to verify webhooks quicker than accessing this API
    every time you receive a webhook.
    */
    public GetSigningPublicKeysResponse list() {
        return list(null);
    }



    /**
    * <Warning>

    This API is currently provided as a preview. Be aware of the following:

    - There might be unannounced breaking changes.
    - Any breaking changes to preview APIs won't produce a new [API version](https://www.canva.dev/docs/connect/versions/).
    - Public integrations that use preview APIs will not pass the review process, and can't be made available to all Canva users.

    </Warning>

    The Keys API (`connect/keys`) is a security measure you can use to verify the authenticity
    of webhooks you receive from Canva Connect. The Keys API returns a
    [JSON Web Key (JWK)](https://www.rfc-editor.org/rfc/rfc7517#section-2), which you can use to
    decrypt the webhook signature and verify it came from Canva and not a potentially malicious
    actor. This helps to protect your systems from
    [Replay attacks](https://owasp.org/Top10/A08_2021-Software_and_Data_Integrity_Failures/).

    The keys returned by the Keys API can rotate. We recommend you cache the keys you receive
    from this API where possible, and only access this API when you receive a webhook signed
    with an unrecognized key. This allows you to verify webhooks quicker than accessing this API
    every time you receive a webhook.
    */
    public GetSigningPublicKeysResponse list(RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/connect/keys")
            .method("GET")
            .execute();
            return ResponseHandler.processJsonResponse(response, GetSigningPublicKeysResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


}

