package com.canva.canvaconnectapi.resources.v1.brandtemplates.dataset;

import java.io.IOException;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.model.GetBrandTemplateDatasetResponse;
import com.canva.canvaconnectapi.resources.v1.brandtemplates.dataset.params.ListRequest;
import okhttp3.Response;

public class DatasetClient {
    protected final ClientOptions clientOptions;
    public DatasetClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * <Warning>

    Later this year, we'll be updating all brand template IDs. If your integration stores brand template IDs, you'll need to migrate to the new IDs. Once we implement this change, you'll have 6 months to update the IDs.

    </Warning>

    <Note>

    To use this API, your integration must act on behalf of a user that's a member of a [Canva Enterprise](https://www.canva.com/enterprise/) organization.

    </Note>

    Gets the dataset definition of a brand template. If the brand
    template contains autofill data fields, this API returns an object with the data field
    names and the type of data they accept.

    Available data field types include:

    - Images
    - Text
    - Charts

    You can autofill a brand template using the [Create a design autofill job
    API](https://www.canva.dev/docs/connect/api-reference/autofills/create-design-autofill-job/).

    WARNING: Chart data fields are a [preview feature](https://www.canva.dev/docs/connect/#preview-apis). There might be unannounced breaking changes to this feature which won't produce a new API version.
    */
    public GetBrandTemplateDatasetResponse list(ListRequest request) {
        return list(request, null);
    }



    /**
    * <Warning>

    Later this year, we'll be updating all brand template IDs. If your integration stores brand template IDs, you'll need to migrate to the new IDs. Once we implement this change, you'll have 6 months to update the IDs.

    </Warning>

    <Note>

    To use this API, your integration must act on behalf of a user that's a member of a [Canva Enterprise](https://www.canva.com/enterprise/) organization.

    </Note>

    Gets the dataset definition of a brand template. If the brand
    template contains autofill data fields, this API returns an object with the data field
    names and the type of data they accept.

    Available data field types include:

    - Images
    - Text
    - Charts

    You can autofill a brand template using the [Create a design autofill job
    API](https://www.canva.dev/docs/connect/api-reference/autofills/create-design-autofill-job/).

    WARNING: Chart data fields are a [preview feature](https://www.canva.dev/docs/connect/#preview-apis). There might be unannounced breaking changes to this feature which won't produce a new API version.
    */
    public GetBrandTemplateDatasetResponse list(ListRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/brand-templates/{brandTemplateId}/dataset")
            .addPathParam("brandTemplateId", request.getBrandTemplateId())
            .method("GET")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .execute();
            return ResponseHandler.processJsonResponse(response, GetBrandTemplateDatasetResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


}

