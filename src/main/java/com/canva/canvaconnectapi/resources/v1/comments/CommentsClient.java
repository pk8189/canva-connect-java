package com.canva.canvaconnectapi.resources.v1.comments;

import java.io.IOException;
import java.util.function.Supplier;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.core.Suppliers;
import com.canva.canvaconnectapi.model.CreateCommentResponse;
import com.canva.canvaconnectapi.resources.v1.comments.params.CreateRequest;
import com.canva.canvaconnectapi.resources.v1.comments.replies.RepliesClient;
import okhttp3.Response;

public class CommentsClient {
    protected final ClientOptions clientOptions;
    protected final Supplier<RepliesClient> replies;
    public CommentsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.replies = Suppliers.memoize(() -> new RepliesClient(clientOptions));
    }

    public RepliesClient replies() {
        return this.replies.get();
    }


    /**
    * <Warning>

    This API is currently provided as a preview. Be aware of the following:

    - There might be unannounced breaking changes.
    - Any breaking changes to preview APIs won't produce a new [API version](https://www.canva.dev/docs/connect/versions/).
    - Public integrations that use preview APIs will not pass the review process, and can't be made available to all Canva users.

    </Warning>

    Create a new top-level comment on a design.
    For information on comments and how they're used in the Canva UI, see the
    [Canva Help Center](https://www.canva.com/help/comments/). A design can have a maximum
    of 1000 comments.
    */
    public CreateCommentResponse create(CreateRequest request) {
        return create(request, null);
    }



    /**
    * <Warning>

    This API is currently provided as a preview. Be aware of the following:

    - There might be unannounced breaking changes.
    - Any breaking changes to preview APIs won't produce a new [API version](https://www.canva.dev/docs/connect/versions/).
    - Public integrations that use preview APIs will not pass the review process, and can't be made available to all Canva users.

    </Warning>

    Create a new top-level comment on a design.
    For information on comments and how they're used in the Canva UI, see the
    [Canva Help Center](https://www.canva.com/help/comments/). A design can have a maximum
    of 1000 comments.
    */
    public CreateCommentResponse create(CreateRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/comments")
            .method("POST")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .setJsonBody(request.getData())
            .execute();
            return ResponseHandler.processJsonResponse(response, CreateCommentResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


}

