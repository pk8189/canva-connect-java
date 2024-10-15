package com.canva.canvaconnectapi;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.model.CreateDesignExportJobRequest;
import com.canva.canvaconnectapi.model.ExportFormat;
import com.canva.canvaconnectapi.model.PdfExportFormat;
import com.canva.canvaconnectapi.model.PdfExportFormatTypeEnum;
import com.canva.canvaconnectapi.resources.v1.exports.params.CreateRequest;
import com.canva.canvaconnectapi.resources.v1.exports.params.GetRequest;
import org.junit.jupiter.api.Test;

public final class V1ExportsTestClient {
    @Test
    void testGet200GeneratedSuccess() {
        Client client = Client
                        .builder()
                        .withBasicAuth(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"))
                        .withOauthAuthCode(System.getenv("API_TOKEN"))
                        .url("https://api.sideko.dev/v1/mock/public/canva-api/1.0.1")
                        .build();

        try {
            client.v1().exportsMethod().get(GetRequest
                                            .builder()
                                            .exportId("string")
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
            client.v1().exportsMethod().create(CreateRequest
                                               .builder()
                                               .data(CreateDesignExportJobRequest
                                                       .builder()
                                                       .designId("DAVZr1z5464")
                                                       .format(ExportFormat.of(PdfExportFormat
                                                               .builder()
                                                               .type(PdfExportFormatTypeEnum.PDF)
                                                               .build()))
                                                       .build())
                                               .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
}

