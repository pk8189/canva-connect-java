package com.canva.canvaconnectapi.resources.v1.designs.comments;

import java.io.IOException;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.model.GetCommentResponse;
import com.canva.canvaconnectapi.resources.v1.designs.comments.params.GetRequest;
import okhttp3.Response;

public class CommentsClient {
    protected final ClientOptions clientOptions;
    public CommentsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * <Warning>

    This API is currently provided as a preview. Be aware of the following:

    - There might be unannounced breaking changes.
    - Any breaking changes to preview APIs won't produce a new [API version](https://www.canva.dev/docs/connect/versions/).
    - Public integrations that use preview APIs will not pass the review process, and can't be made available to all Canva users.

    </Warning>

    Gets a comment.
    For information on comments and how they're used in the Canva UI, see the
    [Canva Help Center](https://www.canva.com/help/comments/).
    */
    public GetCommentResponse get(GetRequest request) {
        return get(request, null);
    }



    /**
    * <Warning>

    This API is currently provided as a preview. Be aware of the following:

    - There might be unannounced breaking changes.
    - Any breaking changes to preview APIs won't produce a new [API version](https://www.canva.dev/docs/connect/versions/).
    - Public integrations that use preview APIs will not pass the review process, and can't be made available to all Canva users.

    </Warning>

    Gets a comment.
    For information on comments and how they're used in the Canva UI, see the
    [Canva Help Center](https://www.canva.com/help/comments/).
    */
    public GetCommentResponse get(GetRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/designs/{designId}/comments/{commentId}")
            .addPathParam("designId", request.getDesignId())
            .addPathParam("commentId", request.getCommentId())
            .method("GET")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .execute();
            return ResponseHandler.processJsonResponse(response, GetCommentResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


}

