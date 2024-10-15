package com.canva.canvaconnectapi;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.model.DesignImportMetadata;
import com.canva.canvaconnectapi.resources.v1.imports.params.CreateRequest;
import com.canva.canvaconnectapi.resources.v1.imports.params.GetRequest;
import org.junit.jupiter.api.Test;

public final class V1ImportsTestClient {
    @Test
    void testGet200GeneratedSuccess() {
        Client client = Client
                        .builder()
                        .withBasicAuth(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"))
                        .withOauthAuthCode(System.getenv("API_TOKEN"))
                        .url("https://api.sideko.dev/v1/mock/public/canva-api/1.0.1")
                        .build();

        try {
            client.v1().imports().get(GetRequest
                                      .builder()
                                      .jobId("string")
                                      .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
    @Test
    void testCreate200SuccessDefault() {
        Client client = Client
                        .builder()
                        .withBasicAuth(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"))
                        .withOauthAuthCode(System.getenv("API_TOKEN"))
                        .url("https://api.sideko.dev/v1/mock/public/canva-api/1.0.1")
                        .build();

        try {
            client.v1().imports().create(CreateRequest
                                         .builder()
                                         .importMetadata(DesignImportMetadata
                                                 .builder()
                                                 .titleBase64("TXkgQXdlc29tZSBEZXNpZ24g8J+YjQ==")
                                                 .build())
                                         .data(new java.io.File("uploads/file.pdf"))
                                         .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
}

