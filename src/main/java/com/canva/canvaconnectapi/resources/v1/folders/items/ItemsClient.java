package com.canva.canvaconnectapi.resources.v1.folders.items;

import java.io.IOException;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.model.ListFolderItemsResponse;
import com.canva.canvaconnectapi.resources.v1.folders.items.params.ListRequest;
import okhttp3.Response;

public class ItemsClient {
    protected final ClientOptions clientOptions;
    public ItemsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * Lists the items in a folder, including each item's `type`.

    Folders can contain:

    - Other folders.
    - Designs, such as Instagram posts, Presentations, and Documents ([Canva Docs](https://www.canva.com/create/documents/)).
    - Image assets.
    */
    public ListFolderItemsResponse list(ListRequest request) {
        return list(request, null);
    }



    /**
    * Lists the items in a folder, including each item's `type`.

    Folders can contain:

    - Other folders.
    - Designs, such as Instagram posts, Presentations, and Documents ([Canva Docs](https://www.canva.com/create/documents/)).
    - Image assets.
    */
    public ListFolderItemsResponse list(ListRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/folders/{folderId}/items")
            .addPathParam("folderId", request.getFolderId())
            .addQueryParamExploding("continuation",
                                    request.getContinuation() != null ? request.getContinuation() : null)
            .addQueryParam("item_types", request.getItemTypes() != null ? request.getItemTypes().toString() :
                           null)
            .addQueryParamExploding("sort_by",
                                    request.getSortBy() != null ? request.getSortBy().toString() : null)
            .method("GET")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .execute();
            return ResponseHandler.processJsonResponse(response, ListFolderItemsResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


}

