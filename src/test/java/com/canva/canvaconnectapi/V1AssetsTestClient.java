package com.canva.canvaconnectapi;

import java.util.List;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.model.UpdateAssetRequest;
import com.canva.canvaconnectapi.resources.v1.assets.params.DeleteRequest;
import com.canva.canvaconnectapi.resources.v1.assets.params.GetRequest;
import com.canva.canvaconnectapi.resources.v1.assets.params.PatchRequest;
import org.junit.jupiter.api.Test;

public final class V1AssetsTestClient {
    @Test
    void testDelete204GeneratedSuccess() {
        Client client = Client
                        .builder()
                        .withBasicAuth(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"))
                        .withOauthAuthCode(System.getenv("API_TOKEN"))
                        .url("https://api.sideko.dev/v1/mock/public/canva-api/1.0.1")
                        .build();

        try {
            client.v1().assets().delete(DeleteRequest
                                        .builder()
                                        .assetId("string")
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
            client.v1().assets().get(GetRequest
                                     .builder()
                                     .assetId("string")
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
            client.v1().assets().patch(PatchRequest
                                       .builder()
                                       .assetId("string")
                                       .data(UpdateAssetRequest
                                             .builder()
                                             .name("My Awesome Upload")
                                             .tags(List.of(
                                                     "image",
                                                     "holiday",
                                                     "best day ever"
                                                   ))
                                             .build())
                                       .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
}

