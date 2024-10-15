package com.canva.canvaconnectapi;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.resources.v1.designs.comments.params.GetRequest;
import org.junit.jupiter.api.Test;

public final class V1DesignsCommentsTestClient {
    @Test
    void testGet200GeneratedSuccess() {
        Client client = Client
                        .builder()
                        .withBasicAuth(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"))
                        .withOauthAuthCode(System.getenv("API_TOKEN"))
                        .url("https://api.sideko.dev/v1/mock/public/canva-api/1.0.1")
                        .build();

        try {
            client.v1().designs().comments().get(GetRequest
                                                 .builder()
                                                 .designId("string")
                                                 .commentId("string")
                                                 .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
}

