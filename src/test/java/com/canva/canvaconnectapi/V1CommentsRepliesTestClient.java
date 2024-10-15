package com.canva.canvaconnectapi;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.model.CreateReplyRequest;
import com.canva.canvaconnectapi.model.DesignCommentObjectInput;
import com.canva.canvaconnectapi.model.DesignCommentObjectInputTypeEnum;
import com.canva.canvaconnectapi.resources.v1.comments.replies.params.CreateRequest;
import org.junit.jupiter.api.Test;

public final class V1CommentsRepliesTestClient {
    @Test
    void testCreate200SuccessDefault() {
        Client client = Client
                        .builder()
                        .withBasicAuth(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"))
                        .withOauthAuthCode(System.getenv("API_TOKEN"))
                        .url("https://api.sideko.dev/v1/mock/public/canva-api/1.0.1")
                        .build();

        try {
            client.v1().comments().replies().create(CreateRequest
                                                    .builder()
                                                    .commentId("string")
                                                    .data(CreateReplyRequest
                                                            .builder()
                                                            .attachedTo(DesignCommentObjectInput
                                                                    .builder()
                                                                    .designId("DAFVztcvd9z")
                                                                    .type(DesignCommentObjectInputTypeEnum.DESIGN)
                                                                    .build())
                                                            .message("Thanks!")
                                                            .build())
                                                    .build());
        } catch (ApiException e) {
            System.err.println("Error msg: " + e.toString());
            throw e;
        }
    }
}

