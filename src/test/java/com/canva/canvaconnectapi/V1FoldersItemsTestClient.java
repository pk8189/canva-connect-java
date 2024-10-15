package com.canva.canvaconnectapi;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.resources.v1.folders.items.params.ListRequest;
import org.junit.jupiter.api.Test;

public final class V1FoldersItemsTestClient {
    @Test
    void testList200GeneratedSuccess() {
        Client client = Client
                        .builder()
                        .withBasicAuth(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"))
                        .withOauthAuthCode(System.getenv("API_TOKEN"))
                        .url("https://api.sideko.dev/v1/mock/public/canva-api/1.0.1")
                        .build();

        try {
            client.v1().folders().items().list(ListRequest
                                               .builder()
                                               .folderId("string")
                                               .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
}

