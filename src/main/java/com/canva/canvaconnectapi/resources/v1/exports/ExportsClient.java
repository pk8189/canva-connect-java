package com.canva.canvaconnectapi.resources.v1.exports;

import java.io.IOException;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.model.CreateDesignExportJobResponse;
import com.canva.canvaconnectapi.model.GetDesignExportJobResponse;
import com.canva.canvaconnectapi.resources.v1.exports.params.CreateRequest;
import com.canva.canvaconnectapi.resources.v1.exports.params.GetRequest;
import okhttp3.Response;

public class ExportsClient {
    protected final ClientOptions clientOptions;
    public ExportsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * Gets the result of a design export job that was created using the [Create design export job API](https://www.canva.dev/docs/connect/api-reference/exports/create-design-export-job/).

    If the job is complete, the response includes an array
    of download links for each page of the design.
    */
    public GetDesignExportJobResponse get(GetRequest request) {
        return get(request, null);
    }



    /**
    * Gets the result of a design export job that was created using the [Create design export job API](https://www.canva.dev/docs/connect/api-reference/exports/create-design-export-job/).

    If the job is complete, the response includes an array
    of download links for each page of the design.
    */
    public GetDesignExportJobResponse get(GetRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/exports/{exportId}")
            .addPathParam("exportId", request.getExportId())
            .method("GET")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .execute();
            return ResponseHandler.processJsonResponse(response, GetDesignExportJobResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


    /**
    * Starts a new job to export a file from Canva. Once the exported file is generated, you can download
    it using the link(s) provided.

    The request requires the design ID and the exported file format type.

    Supported file formats (and export file type values): PDF (`pdf`), JPG (`jpg`), PNG (`png`), GIF (`gif`), Microsoft PowerPoint (`pptx`), and MP4 (`mp4`).

    You can check the status and get the results of export jobs created with this API using the [Get design export job API](https://www.canva.dev/docs/connect/api-reference/exports/get-design-export-job/).

    NOTE: If you set `export_quality` to `pro`, the export might fail if the design contains [premium elements](https://www.canva.com/help/premium-elements/), and the calling user either hasn't purchased the elements or isn't on a Canva plan (such as Canva Pro) that has premium features.
    */
    public CreateDesignExportJobResponse create(CreateRequest request) {
        return create(request, null);
    }



    /**
    * Starts a new job to export a file from Canva. Once the exported file is generated, you can download
    it using the link(s) provided.

    The request requires the design ID and the exported file format type.

    Supported file formats (and export file type values): PDF (`pdf`), JPG (`jpg`), PNG (`png`), GIF (`gif`), Microsoft PowerPoint (`pptx`), and MP4 (`mp4`).

    You can check the status and get the results of export jobs created with this API using the [Get design export job API](https://www.canva.dev/docs/connect/api-reference/exports/get-design-export-job/).

    NOTE: If you set `export_quality` to `pro`, the export might fail if the design contains [premium elements](https://www.canva.com/help/premium-elements/), and the calling user either hasn't purchased the elements or isn't on a Canva plan (such as Canva Pro) that has premium features.
    */
    public CreateDesignExportJobResponse create(CreateRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/exports")
            .method("POST")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .setJsonBody(request.getData())
            .execute();
            return ResponseHandler.processJsonResponse(response, CreateDesignExportJobResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }




}

