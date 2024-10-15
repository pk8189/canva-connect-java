package com.canva.canvaconnectapi;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.model.CreateDesignAutofillJobRequest;
import com.canva.canvaconnectapi.model.CreateDesignAutofillJobRequestData;
import com.canva.canvaconnectapi.resources.v1.autofills.params.CreateRequest;
import com.canva.canvaconnectapi.resources.v1.autofills.params.GetRequest;
import org.junit.jupiter.api.Test;

public final class V1AutofillsTestClient {
    @Test
    void testGet200GeneratedSuccess() {
        Client client = Client
                        .builder()
                        .withBasicAuth(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"))
                        .withOauthAuthCode(System.getenv("API_TOKEN"))
                        .url("https://api.sideko.dev/v1/mock/public/canva-api/1.0.1")
                        .build();

        try {
            client.v1().autofills().get(GetRequest
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
            client.v1().autofills().create(CreateRequest
                                           .builder()
                                           .data(CreateDesignAutofillJobRequest
                                                 .builder()
                                                 .brandTemplateId("DAFVztcvd9z")
                                                 .data(CreateDesignAutofillJobRequestData
                                                         .builder()
                                                         .build())
                                                 .title("string")
                                                 .build())
                                           .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
}

