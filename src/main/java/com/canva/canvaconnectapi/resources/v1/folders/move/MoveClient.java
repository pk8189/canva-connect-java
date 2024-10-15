package com.canva.canvaconnectapi.resources.v1.folders.move;

import java.io.IOException;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.resources.v1.folders.move.params.CreateRequest;

public class MoveClient {
    protected final ClientOptions clientOptions;
    public MoveClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * Moves an item to another folder. You must specify the folder ID of the destination folder, as well as the ID of the item you want to move.

    NOTE: In some situations, a single item can exist in multiple folders. If you attempt to move an item that exists in multiple folders, the API returns an `item_in_multiple_folders` error. In this case, you must use the Canva UI to move the item to another folder.
    */
    public void create(CreateRequest request) {
        create(request, null);
    }



    /**
    * Moves an item to another folder. You must specify the folder ID of the destination folder, as well as the ID of the item you want to move.

    NOTE: In some situations, a single item can exist in multiple folders. If you attempt to move an item that exists in multiple folders, the API returns an `item_in_multiple_folders` error. In this case, you must use the Canva UI to move the item to another folder.
    */
    public void create(CreateRequest request, RequestOptions requestOptions) {

        try {
            new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/folders/move")
            .method("POST")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .setJsonBody(request.getData())
            .execute();
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


}

