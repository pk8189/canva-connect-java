package com.canva.canvaconnectapi;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.model.CreateCommentRequest;
import com.canva.canvaconnectapi.model.DesignCommentObjectInput;
import com.canva.canvaconnectapi.model.DesignCommentObjectInputTypeEnum;
import com.canva.canvaconnectapi.resources.v1.comments.params.CreateRequest;
import org.junit.jupiter.api.Test;

public final class V1CommentsTestClient {
    @Test
    void testCreate200SuccessDefault() {
        Client client = Client
                        .builder()
                        .withBasicAuth(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"))
                        .withOauthAuthCode(System.getenv("API_TOKEN"))
                        .url("https://api.sideko.dev/v1/mock/public/canva-api/1.0.1")
                        .build();

        try {
            client.v1().comments().create(CreateRequest
                                          .builder()
                                          .data(CreateCommentRequest
                                                .builder()
                                                .assigneeId("oUnPjZ2k2yuhftbWF7873o")
                                                .attachedTo(DesignCommentObjectInput
                                                        .builder()
                                                        .designId("DAFVztcvd9z")
                                                        .type(DesignCommentObjectInputTypeEnum.DESIGN)
                                                        .build())
                                                .message("Great work [oUnPjZ2k2yuhftbWF7873o:oBpVhLW22VrqtwKgaayRbP]!")
                                                .build())
                                          .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
}

