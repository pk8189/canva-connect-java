package com.canva.canvaconnectapi.resources.v1.brandtemplates;

import java.io.IOException;
import java.util.function.Supplier;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.core.Suppliers;
import com.canva.canvaconnectapi.model.GetBrandTemplateResponse;
import com.canva.canvaconnectapi.model.ListBrandTemplatesResponse;
import com.canva.canvaconnectapi.resources.v1.brandtemplates.dataset.DatasetClient;
import com.canva.canvaconnectapi.resources.v1.brandtemplates.params.GetRequest;
import com.canva.canvaconnectapi.resources.v1.brandtemplates.params.ListRequest;
import okhttp3.Response;

public class BrandTemplatesClient {
    protected final ClientOptions clientOptions;
    protected final Supplier<DatasetClient> dataset;
    public BrandTemplatesClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.dataset = Suppliers.memoize(() -> new DatasetClient(clientOptions));
    }

    public DatasetClient dataset() {
        return this.dataset.get();
    }


    /**
    * <Warning>

    Later this year, we'll be updating all brand template IDs. If your integration stores brand template IDs, you'll need to migrate to the new IDs. Once we implement this change, you'll have 6 months to update the IDs.

    </Warning>

    <Note>

    To use this API, your integration must act on behalf of a user that's a member of a [Canva Enterprise](https://www.canva.com/enterprise/) organization.

    </Note>

    Get a list of the [brand templates](https://www.canva.com/help/publish-team-template/) the user has access to.
    */
    public ListBrandTemplatesResponse list() {
        return list(ListRequest.builder().build(), null);
    }



    /**
    * <Warning>

    Later this year, we'll be updating all brand template IDs. If your integration stores brand template IDs, you'll need to migrate to the new IDs. Once we implement this change, you'll have 6 months to update the IDs.

    </Warning>

    <Note>

    To use this API, your integration must act on behalf of a user that's a member of a [Canva Enterprise](https://www.canva.com/enterprise/) organization.

    </Note>

    Get a list of the [brand templates](https://www.canva.com/help/publish-team-template/) the user has access to.
    */
    public ListBrandTemplatesResponse list(ListRequest request) {
        return list(request, null);
    }



    /**
    * <Warning>

    Later this year, we'll be updating all brand template IDs. If your integration stores brand template IDs, you'll need to migrate to the new IDs. Once we implement this change, you'll have 6 months to update the IDs.

    </Warning>

    <Note>

    To use this API, your integration must act on behalf of a user that's a member of a [Canva Enterprise](https://www.canva.com/enterprise/) organization.

    </Note>

    Get a list of the [brand templates](https://www.canva.com/help/publish-team-template/) the user has access to.
    */
    public ListBrandTemplatesResponse list(ListRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/brand-templates")
            .addQueryParamExploding("continuation",
                                    request.getContinuation() != null ? request.getContinuation() : null)
            .addQueryParamExploding("dataset",
                                    request.getDataset() != null ? request.getDataset().toString() : null)
            .addQueryParamExploding("ownership",
                                    request.getOwnership() != null ? request.getOwnership().toString() : null)
            .addQueryParamExploding("query", request.getQuery() != null ? request.getQuery() : null)
            .addQueryParamExploding("sort_by",
                                    request.getSortBy() != null ? request.getSortBy().toString() : null)
            .method("GET")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .execute();
            return ResponseHandler.processJsonResponse(response, ListBrandTemplatesResponse.class);
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

    Retrieves the metadata for a brand template.
    */
    public GetBrandTemplateResponse get(GetRequest request) {
        return get(request, null);
    }



    /**
    * <Warning>

    Later this year, we'll be updating all brand template IDs. If your integration stores brand template IDs, you'll need to migrate to the new IDs. Once we implement this change, you'll have 6 months to update the IDs.

    </Warning>

    <Note>

    To use this API, your integration must act on behalf of a user that's a member of a [Canva Enterprise](https://www.canva.com/enterprise/) organization.

    </Note>

    Retrieves the metadata for a brand template.
    */
    public GetBrandTemplateResponse get(GetRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/brand-templates/{brandTemplateId}")
            .addPathParam("brandTemplateId", request.getBrandTemplateId())
            .method("GET")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .execute();
            return ResponseHandler.processJsonResponse(response, GetBrandTemplateResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }




}

