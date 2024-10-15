package com.canva.canvaconnectapi.resources.v1.autofills;

import java.io.IOException;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.model.CreateDesignAutofillJobResponse;
import com.canva.canvaconnectapi.model.GetDesignAutofillJobResponse;
import com.canva.canvaconnectapi.resources.v1.autofills.params.CreateRequest;
import com.canva.canvaconnectapi.resources.v1.autofills.params.GetRequest;
import okhttp3.Response;

public class AutofillsClient {
    protected final ClientOptions clientOptions;
    public AutofillsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * <Note>

    To use this API, your integration must act on behalf of a user that's a member of a [Canva Enterprise](https://www.canva.com/enterprise/) organization.

    </Note>

    Get the result of a design autofill job that was created using the [Create a design autofill job
    API](https://www.canva.dev/docs/connect/api-reference/autofills/create-design-autofill-job/).

    You might need to make multiple requests to this endpoint until you get a `success` or
    `failed` status.
    */
    public GetDesignAutofillJobResponse get(GetRequest request) {
        return get(request, null);
    }



    /**
    * <Note>

    To use this API, your integration must act on behalf of a user that's a member of a [Canva Enterprise](https://www.canva.com/enterprise/) organization.

    </Note>

    Get the result of a design autofill job that was created using the [Create a design autofill job
    API](https://www.canva.dev/docs/connect/api-reference/autofills/create-design-autofill-job/).

    You might need to make multiple requests to this endpoint until you get a `success` or
    `failed` status.
    */
    public GetDesignAutofillJobResponse get(GetRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/autofills/{jobId}")
            .addPathParam("jobId", request.getJobId())
            .method("GET")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .execute();
            return ResponseHandler.processJsonResponse(response, GetDesignAutofillJobResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


    /**
    * <Warning>

    Later this year, we'll be updating all brand template IDs. If your integration stores brand template IDs, you'll need to migrate to the new IDs. Once we implement this change, you'll have 6 months to update the IDs.

    </Warning>

    <Note>

    To use this API, your integration must act on behalf of a user that's a member of a [Canva Enterprise](https://www.canva.com/enterprise/) organization.

    </Note>

    Starts a new job to autofill a Canva design using a brand template and input data.

    To get a list of input data fields, use the [Get brand template dataset
    API](https://www.canva.dev/docs/connect/api-reference/brand-templates/get-brand-template-dataset/).

    Available data field types to autofill include:

    - Images
    - Text
    - Charts

    WARNING: Chart data fields are a [preview feature](https://www.canva.dev/docs/connect/#preview-apis). There might be unannounced breaking changes to this feature which won't produce a new API version.

    You can check the status and get the results of autofill jobs created with this API using the [Get design autofill job API](https://www.canva.dev/docs/connect/api-reference/autofills/get-design-autofill-job/).
    */
    public CreateDesignAutofillJobResponse create(CreateRequest request) {
        return create(request, null);
    }



    /**
    * <Warning>

    Later this year, we'll be updating all brand template IDs. If your integration stores brand template IDs, you'll need to migrate to the new IDs. Once we implement this change, you'll have 6 months to update the IDs.

    </Warning>

    <Note>

    To use this API, your integration must act on behalf of a user that's a member of a [Canva Enterprise](https://www.canva.com/enterprise/) organization.

    </Note>

    Starts a new job to autofill a Canva design using a brand template and input data.

    To get a list of input data fields, use the [Get brand template dataset
    API](https://www.canva.dev/docs/connect/api-reference/brand-templates/get-brand-template-dataset/).

    Available data field types to autofill include:

    - Images
    - Text
    - Charts

    WARNING: Chart data fields are a [preview feature](https://www.canva.dev/docs/connect/#preview-apis). There might be unannounced breaking changes to this feature which won't produce a new API version.

    You can check the status and get the results of autofill jobs created with this API using the [Get design autofill job API](https://www.canva.dev/docs/connect/api-reference/autofills/get-design-autofill-job/).
    */
    public CreateDesignAutofillJobResponse create(CreateRequest request,
            RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/autofills")
            .method("POST")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .setJsonBody(request.getData())
            .execute();
            return ResponseHandler.processJsonResponse(response, CreateDesignAutofillJobResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }




}

