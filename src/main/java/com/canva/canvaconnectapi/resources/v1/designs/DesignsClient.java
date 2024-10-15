package com.canva.canvaconnectapi.resources.v1.designs;

import java.io.IOException;
import java.util.function.Supplier;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.core.Suppliers;
import com.canva.canvaconnectapi.model.CreateDesignResponse;
import com.canva.canvaconnectapi.model.GetDesignResponse;
import com.canva.canvaconnectapi.model.GetListDesignResponse;
import com.canva.canvaconnectapi.resources.v1.designs.comments.CommentsClient;
import com.canva.canvaconnectapi.resources.v1.designs.params.CreateRequest;
import com.canva.canvaconnectapi.resources.v1.designs.params.GetRequest;
import com.canva.canvaconnectapi.resources.v1.designs.params.ListRequest;
import okhttp3.Response;

public class DesignsClient {
    protected final ClientOptions clientOptions;
    protected final Supplier<CommentsClient> comments;
    public DesignsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.comments = Suppliers.memoize(() -> new CommentsClient(clientOptions));
    }

    public CommentsClient comments() {
        return this.comments.get();
    }


    /**
    * Lists metadata for all the designs in a Canva user's
    [projects](https://www.canva.com/help/find-designs-and-folders/). You can also:

    - Use search terms to filter the listed designs.
    - Show designs either created by, or shared with the user.
    - Sort the results.
    */
    public GetListDesignResponse list() {
        return list(ListRequest.builder().build(), null);
    }



    /**
    * Lists metadata for all the designs in a Canva user's
    [projects](https://www.canva.com/help/find-designs-and-folders/). You can also:

    - Use search terms to filter the listed designs.
    - Show designs either created by, or shared with the user.
    - Sort the results.
    */
    public GetListDesignResponse list(ListRequest request) {
        return list(request, null);
    }



    /**
    * Lists metadata for all the designs in a Canva user's
    [projects](https://www.canva.com/help/find-designs-and-folders/). You can also:

    - Use search terms to filter the listed designs.
    - Show designs either created by, or shared with the user.
    - Sort the results.
    */
    public GetListDesignResponse list(ListRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/designs")
            .addQueryParamExploding("continuation",
                                    request.getContinuation() != null ? request.getContinuation() : null)
            .addQueryParamExploding("ownership",
                                    request.getOwnership() != null ? request.getOwnership().toString() : null)
            .addQueryParamExploding("query", request.getQuery() != null ? request.getQuery() : null)
            .addQueryParamExploding("sort_by",
                                    request.getSortBy() != null ? request.getSortBy().toString() : null)
            .method("GET")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .execute();
            return ResponseHandler.processJsonResponse(response, GetListDesignResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


    /**
    * Gets the metadata for a design. This includes owner information, URLs for editing and viewing, and thumbnail information.
    */
    public GetDesignResponse get(GetRequest request) {
        return get(request, null);
    }



    /**
    * Gets the metadata for a design. This includes owner information, URLs for editing and viewing, and thumbnail information.
    */
    public GetDesignResponse get(GetRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/designs/{designId}")
            .addPathParam("designId", request.getDesignId())
            .method("GET")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .execute();
            return ResponseHandler.processJsonResponse(response, GetDesignResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


    /**
    * Creates a new Canva design. To create a new design, you can either:

    - Use a preset design type.
    - Set height and width dimensions for a custom design.

    Additionally, you can also provide the `asset_id` of an asset in the user's [projects](https://www.canva.com/help/find-designs-and-folders/) to add to the new design. To list the assets in a folder in the user's projects, use the [List folder items API](https://www.canva.dev/docs/connect/api-reference/folders/list-folder-items/).
    */
    public CreateDesignResponse create(CreateRequest request) {
        return create(request, null);
    }



    /**
    * Creates a new Canva design. To create a new design, you can either:

    - Use a preset design type.
    - Set height and width dimensions for a custom design.

    Additionally, you can also provide the `asset_id` of an asset in the user's [projects](https://www.canva.com/help/find-designs-and-folders/) to add to the new design. To list the assets in a folder in the user's projects, use the [List folder items API](https://www.canva.dev/docs/connect/api-reference/folders/list-folder-items/).
    */
    public CreateDesignResponse create(CreateRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/designs")
            .method("POST")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .setJsonBody(request.getData())
            .execute();
            return ResponseHandler.processJsonResponse(response, CreateDesignResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }






}

