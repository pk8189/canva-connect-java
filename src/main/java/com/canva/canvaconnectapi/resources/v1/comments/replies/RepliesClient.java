package com.canva.canvaconnectapi.resources.v1.comments.replies;

import java.io.IOException;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.model.CreateReplyResponse;
import com.canva.canvaconnectapi.resources.v1.comments.replies.params.CreateRequest;
import okhttp3.Response;

public class RepliesClient {
    protected final ClientOptions clientOptions;
    public RepliesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * <Warning>

    This API is currently provided as a preview. Be aware of the following:

    - There might be unannounced breaking changes.
    - Any breaking changes to preview APIs won't produce a new [API version](https://www.canva.dev/docs/connect/versions/).
    - Public integrations that use preview APIs will not pass the review process, and can't be made available to all Canva users.

    </Warning>

    Creates a reply to a comment in a design.
    To reply to an existing thread of comments, you can use either the `id` of the parent
    (original) comment, or the `thread_id` of a comment in the thread. Each comment can
    have a maximum of 100 replies created for it.

    For information on comments and how they're used in the Canva UI, see the
    [Canva Help Center](https://www.canva.com/help/comments/).
    */
    public CreateReplyResponse create(CreateRequest request) {
        return create(request, null);
    }



    /**
    * <Warning>

    This API is currently provided as a preview. Be aware of the following:

    - There might be unannounced breaking changes.
    - Any breaking changes to preview APIs won't produce a new [API version](https://www.canva.dev/docs/connect/versions/).
    - Public integrations that use preview APIs will not pass the review process, and can't be made available to all Canva users.

    </Warning>

    Creates a reply to a comment in a design.
    To reply to an existing thread of comments, you can use either the `id` of the parent
    (original) comment, or the `thread_id` of a comment in the thread. Each comment can
    have a maximum of 100 replies created for it.

    For information on comments and how they're used in the Canva UI, see the
    [Canva Help Center](https://www.canva.com/help/comments/).
    */
    public CreateReplyResponse create(CreateRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/comments/{commentId}/replies")
            .addPathParam("commentId", request.getCommentId())
            .method("POST")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .setJsonBody(request.getData())
            .execute();
            return ResponseHandler.processJsonResponse(response, CreateReplyResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


}

