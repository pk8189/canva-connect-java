package com.canva.canvaconnectapi;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.model.MoveFolderItemRequest;
import com.canva.canvaconnectapi.resources.v1.folders.move.params.CreateRequest;
import org.junit.jupiter.api.Test;

public final class V1FoldersMoveTestClient {
    @Test
    void testCreate204SuccessDefault() {
        Client client = Client
                        .builder()
                        .withBasicAuth(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"))
                        .withOauthAuthCode(System.getenv("API_TOKEN"))
                        .url("https://api.sideko.dev/v1/mock/public/canva-api/1.0.1")
                        .build();

        try {
            client.v1().folders().move().create(CreateRequest
                                                .builder()
                                                .data(MoveFolderItemRequest
                                                        .builder()
                                                        .itemId("Msd59349ff")
                                                        .toFolderId("FAF2lZtloor")
                                                        .build())
                                                .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
}

