package com.canva.canvaconnectapi;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.model.CreateFolderRequest;
import com.canva.canvaconnectapi.model.UpdateFolderRequest;
import com.canva.canvaconnectapi.resources.v1.folders.params.CreateRequest;
import com.canva.canvaconnectapi.resources.v1.folders.params.DeleteRequest;
import com.canva.canvaconnectapi.resources.v1.folders.params.GetRequest;
import com.canva.canvaconnectapi.resources.v1.folders.params.PatchRequest;
import org.junit.jupiter.api.Test;

public final class V1FoldersTestClient {
    @Test
    void testDelete204GeneratedSuccess() {
        Client client = Client
                        .builder()
                        .withBasicAuth(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"))
                        .withOauthAuthCode(System.getenv("API_TOKEN"))
                        .url("https://api.sideko.dev/v1/mock/public/canva-api/1.0.1")
                        .build();

        try {
            client.v1().folders().delete(DeleteRequest
                                         .builder()
                                         .folderId("string")
                                         .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
    @Test
    void testGet200GeneratedSuccess() {
        Client client = Client
                        .builder()
                        .withBasicAuth(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"))
                        .withOauthAuthCode(System.getenv("API_TOKEN"))
                        .url("https://api.sideko.dev/v1/mock/public/canva-api/1.0.1")
                        .build();

        try {
            client.v1().folders().get(GetRequest
                                      .builder()
                                      .folderId("string")
                                      .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
    @Test
    void testPatch200SuccessDefault() {
        Client client = Client
                        .builder()
                        .withBasicAuth(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"))
                        .withOauthAuthCode(System.getenv("API_TOKEN"))
                        .url("https://api.sideko.dev/v1/mock/public/canva-api/1.0.1")
                        .build();

        try {
            client.v1().folders().patch(PatchRequest
                                        .builder()
                                        .folderId("string")
                                        .data(UpdateFolderRequest
                                              .builder()
                                              .name("My awesome holiday")
                                              .build())
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
            client.v1().folders().create(CreateRequest
                                         .builder()
                                         .data(CreateFolderRequest
                                               .builder()
                                               .name("My awesome holiday")
                                               .parentFolderId("FAF2lZtloor")
                                               .build())
                                         .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
}

