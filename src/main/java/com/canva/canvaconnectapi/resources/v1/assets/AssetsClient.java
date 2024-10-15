package com.canva.canvaconnectapi.resources.v1.assets;

import java.io.IOException;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.model.GetAssetResponse;
import com.canva.canvaconnectapi.model.UpdateAssetResponse;
import com.canva.canvaconnectapi.resources.v1.assets.params.DeleteRequest;
import com.canva.canvaconnectapi.resources.v1.assets.params.GetRequest;
import com.canva.canvaconnectapi.resources.v1.assets.params.PatchRequest;
import okhttp3.Response;

public class AssetsClient {
    protected final ClientOptions clientOptions;
    public AssetsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * You can delete an asset by specifying its `assetId`. This operation mirrors the behavior
    in the Canva UI. Deleting an item moves it to the trash.
    Deleting an asset doesn't remove it from designs that already use it.
    */
    public void delete (DeleteRequest request) {
        delete (request, null);
    }



    /**
    * You can delete an asset by specifying its `assetId`. This operation mirrors the behavior
    in the Canva UI. Deleting an item moves it to the trash.
    Deleting an asset doesn't remove it from designs that already use it.
    */
    public void delete (DeleteRequest request, RequestOptions requestOptions) {

        try {
            new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/assets/{assetId}")
            .addPathParam("assetId", request.getAssetId())
            .method("DELETE")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .execute();
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


    /**
    * You can retrieve the metadata of an asset by specifying its `assetId`.
    */
    public GetAssetResponse get(GetRequest request) {
        return get(request, null);
    }



    /**
    * You can retrieve the metadata of an asset by specifying its `assetId`.
    */
    public GetAssetResponse get(GetRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/assets/{assetId}")
            .addPathParam("assetId", request.getAssetId())
            .method("GET")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .execute();
            return ResponseHandler.processJsonResponse(response, GetAssetResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


    /**
    * You can update the name and tags of an asset by specifying its `assetId`. Updating the tags
    replaces all existing tags of the asset.
    */
    public UpdateAssetResponse patch(PatchRequest request) {
        return patch(request, null);
    }



    /**
    * You can update the name and tags of an asset by specifying its `assetId`. Updating the tags
    replaces all existing tags of the asset.
    */
    public UpdateAssetResponse patch(PatchRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/assets/{assetId}")
            .addPathParam("assetId", request.getAssetId())
            .method("PATCH")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .setJsonBody(request.getData())
            .execute();
            return ResponseHandler.processJsonResponse(response, UpdateAssetResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }






}

