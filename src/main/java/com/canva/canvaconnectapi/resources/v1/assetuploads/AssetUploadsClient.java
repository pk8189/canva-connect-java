package com.canva.canvaconnectapi.resources.v1.assetuploads;

import java.io.IOException;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.model.CreateAssetUploadJobResponse;
import com.canva.canvaconnectapi.model.GetAssetUploadJobResponse;
import com.canva.canvaconnectapi.resources.v1.assetuploads.params.CreateRequest;
import com.canva.canvaconnectapi.resources.v1.assetuploads.params.GetRequest;
import okhttp3.Response;

public class AssetUploadsClient {
    protected final ClientOptions clientOptions;
    public AssetUploadsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * Get the result of an asset upload job that was created using the [Create asset upload job API](https://www.canva.dev/docs/connect/api-reference/assets/create-asset-upload-job/).

    You might need to make multiple requests to this endpoint until you get a `success` or `failed` status.
    */
    public GetAssetUploadJobResponse get(GetRequest request) {
        return get(request, null);
    }



    /**
    * Get the result of an asset upload job that was created using the [Create asset upload job API](https://www.canva.dev/docs/connect/api-reference/assets/create-asset-upload-job/).

    You might need to make multiple requests to this endpoint until you get a `success` or `failed` status.
    */
    public GetAssetUploadJobResponse get(GetRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/asset-uploads/{jobId}")
            .addPathParam("jobId", request.getJobId())
            .method("GET")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .execute();
            return ResponseHandler.processJsonResponse(response, GetAssetUploadJobResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


    /**
    * Starts a new job to upload an asset to a user's content library.

    The request format for this endpoint is an `application/octet-stream` body of bytes. Attach
    information about the upload using an `Asset-Upload-Metadata` header.

    You can check the status and get the results of asset upload jobs created with this API using the [Get asset upload job API](https://www.canva.dev/docs/connect/api-reference/assets/get-asset-upload-job/).
    */
    public CreateAssetUploadJobResponse create(CreateRequest request) {
        return create(request, null);
    }



    /**
    * Starts a new job to upload an asset to a user's content library.

    The request format for this endpoint is an `application/octet-stream` body of bytes. Attach
    information about the upload using an `Asset-Upload-Metadata` header.

    You can check the status and get the results of asset upload jobs created with this API using the [Get asset upload job API](https://www.canva.dev/docs/connect/api-reference/assets/get-asset-upload-job/).
    */
    public CreateAssetUploadJobResponse create(CreateRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/asset-uploads")
            .addHeader("Asset-Upload-Metadata", request.getAssetUploadMetadata().toString())
            .method("POST")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .setBinaryBody(request.getData(), "application/octet-stream")
            .execute();
            return ResponseHandler.processJsonResponse(response, CreateAssetUploadJobResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }




}

