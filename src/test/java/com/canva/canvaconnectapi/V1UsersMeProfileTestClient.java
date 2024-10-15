package com.canva.canvaconnectapi;

import com.canva.canvaconnectapi.core.ApiException;
import org.junit.jupiter.api.Test;

public final class V1UsersMeProfileTestClient {
    @Test
    void testList200GeneratedSuccess() {
        Client client = Client
                        .builder()
                        .withBasicAuth(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"))
                        .withOauthAuthCode(System.getenv("API_TOKEN"))
                        .url("https://api.sideko.dev/v1/mock/public/canva-api/1.0.1")
                        .build();

        try {
            client.v1().users().me().profile().list();
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
}

