package com.canva.canvaconnectapi;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.model.CreateDesignRequest;
import com.canva.canvaconnectapi.model.DesignTypeInput;
import com.canva.canvaconnectapi.model.PresetDesignTypeInput;
import com.canva.canvaconnectapi.model.PresetDesignTypeInputTypeEnum;
import com.canva.canvaconnectapi.model.PresetDesignTypeNameEnum;
import com.canva.canvaconnectapi.resources.v1.designs.params.CreateRequest;
import com.canva.canvaconnectapi.resources.v1.designs.params.GetRequest;
import com.canva.canvaconnectapi.resources.v1.designs.params.ListRequest;
import org.junit.jupiter.api.Test;

public final class V1DesignsTestClient {
    @Test
    void testList200GeneratedSuccess() {
        Client client = Client
                        .builder()
                        .withBasicAuth(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"))
                        .withOauthAuthCode(System.getenv("API_TOKEN"))
                        .url("https://api.sideko.dev/v1/mock/public/canva-api/1.0.1")
                        .build();

        try {
            client.v1().designs().list(ListRequest
                                       .builder()
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
            client.v1().designs().get(GetRequest
                                      .builder()
                                      .designId("string")
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
            client.v1().designs().create(CreateRequest
                                         .builder()
                                         .data(CreateDesignRequest
                                               .builder()
                                               .assetId("Msd59349ff")
                                               .designType(DesignTypeInput.of(PresetDesignTypeInput
                                                       .builder()
                                                       .name(PresetDesignTypeNameEnum.DOC)
                                                       .type(PresetDesignTypeInputTypeEnum.PRESET)
                                                       .build()))
                                               .title("My Holiday Presentation")
                                               .build())
                                         .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
}

