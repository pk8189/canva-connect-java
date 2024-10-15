package com.canva.canvaconnectapi.resources.v1.folders;

import java.io.IOException;
import java.util.function.Supplier;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.core.Suppliers;
import com.canva.canvaconnectapi.model.CreateFolderResponse;
import com.canva.canvaconnectapi.model.GetFolderResponse;
import com.canva.canvaconnectapi.model.UpdateFolderResponse;
import com.canva.canvaconnectapi.resources.v1.folders.items.ItemsClient;
import com.canva.canvaconnectapi.resources.v1.folders.move.MoveClient;
import com.canva.canvaconnectapi.resources.v1.folders.params.CreateRequest;
import com.canva.canvaconnectapi.resources.v1.folders.params.DeleteRequest;
import com.canva.canvaconnectapi.resources.v1.folders.params.GetRequest;
import com.canva.canvaconnectapi.resources.v1.folders.params.PatchRequest;
import okhttp3.Response;

public class FoldersClient {
    protected final ClientOptions clientOptions;
    protected final Supplier<ItemsClient> items;
    protected final Supplier<MoveClient> move;
    public FoldersClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.items = Suppliers.memoize(() -> new ItemsClient(clientOptions));
        this.move = Suppliers.memoize(() -> new MoveClient(clientOptions));
    }

    public ItemsClient items() {
        return this.items.get();
    }

    public MoveClient move() {
        return this.move.get();
    }


    /**
    * Deletes a folder with the specified `folderID`.
    Deleting a folder moves the user's content in the folder to the
    [Trash](https://www.canva.com/help/deleted-designs/) and content owned by
    other users is moved to the top level of the owner's
    [projects](https://www.canva.com/help/find-designs-and-folders/).
    */
    public void delete (DeleteRequest request) {
        delete (request, null);
    }



    /**
    * Deletes a folder with the specified `folderID`.
    Deleting a folder moves the user's content in the folder to the
    [Trash](https://www.canva.com/help/deleted-designs/) and content owned by
    other users is moved to the top level of the owner's
    [projects](https://www.canva.com/help/find-designs-and-folders/).
    */
    public void delete (DeleteRequest request, RequestOptions requestOptions) {

        try {
            new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/folders/{folderId}")
            .addPathParam("folderId", request.getFolderId())
            .method("DELETE")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .execute();
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


    /**
    * Gets the name and other details of a folder using a folder's `folderID`.
    */
    public GetFolderResponse get(GetRequest request) {
        return get(request, null);
    }



    /**
    * Gets the name and other details of a folder using a folder's `folderID`.
    */
    public GetFolderResponse get(GetRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/folders/{folderId}")
            .addPathParam("folderId", request.getFolderId())
            .method("GET")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .execute();
            return ResponseHandler.processJsonResponse(response, GetFolderResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


    /**
    * Updates a folder's details using its `folderID`.
    Currently, you can only update a folder's name.
    */
    public UpdateFolderResponse patch(PatchRequest request) {
        return patch(request, null);
    }



    /**
    * Updates a folder's details using its `folderID`.
    Currently, you can only update a folder's name.
    */
    public UpdateFolderResponse patch(PatchRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/folders/{folderId}")
            .addPathParam("folderId", request.getFolderId())
            .method("PATCH")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .setJsonBody(request.getData())
            .execute();
            return ResponseHandler.processJsonResponse(response, UpdateFolderResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


    /**
    * Creates a folder in either the top level of a Canva user's
    [projects](https://www.canva.com/help/find-designs-and-folders/) (using the ID `root`), or
    another folder (using the parent folder's ID). When a folder is successfully created, the
    endpoint returns its folder ID, along with other information.
    */
    public CreateFolderResponse create(CreateRequest request) {
        return create(request, null);
    }



    /**
    * Creates a folder in either the top level of a Canva user's
    [projects](https://www.canva.com/help/find-designs-and-folders/) (using the ID `root`), or
    another folder (using the parent folder's ID). When a folder is successfully created, the
    endpoint returns its folder ID, along with other information.
    */
    public CreateFolderResponse create(CreateRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/folders")
            .method("POST")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .setJsonBody(request.getData())
            .execute();
            return ResponseHandler.processJsonResponse(response, CreateFolderResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }








}

