package com.canva.canvaconnectapi.resources.v1.imports;

import java.io.IOException;

import com.canva.canvaconnectapi.core.ApiException;
import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.HttpRequestBuilder;
import com.canva.canvaconnectapi.core.RequestOptions;
import com.canva.canvaconnectapi.core.ResponseHandler;
import com.canva.canvaconnectapi.model.CreateDesignImportJobResponse;
import com.canva.canvaconnectapi.model.GetDesignImportJobResponse;
import com.canva.canvaconnectapi.resources.v1.imports.params.CreateRequest;
import com.canva.canvaconnectapi.resources.v1.imports.params.GetRequest;
import okhttp3.Response;

public class ImportsClient {
    protected final ClientOptions clientOptions;
    public ImportsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }


    /**
    * Gets the status and results of design import jobs created using the [Create design import job API](https://www.canva.dev/docs/connect/api-reference/design-imports/create-design-import-job/).
    */
    public GetDesignImportJobResponse get(GetRequest request) {
        return get(request, null);
    }



    /**
    * Gets the status and results of design import jobs created using the [Create design import job API](https://www.canva.dev/docs/connect/api-reference/design-imports/create-design-import-job/).
    */
    public GetDesignImportJobResponse get(GetRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/imports/{jobId}")
            .addPathParam("jobId", request.getJobId())
            .method("GET")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .execute();
            return ResponseHandler.processJsonResponse(response, GetDesignImportJobResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }


    /**
    * Starts a new job to import an external file as a new design in Canva.

    You can check the status and get the results of import jobs created with this API using the [Get design import job API](https://www.canva.dev/docs/connect/api-reference/design-imports/get-design-import-job/).

    The request format for this endpoint has an `application/octet-stream` body of bytes,
    and the information about the import is attached using an `Import-Metadata` header.

    Supported file types:

    | Name                              | MIME type                                                                 | File extension |
    | --------------------------------- | ------------------------------------------------------------------------- | -------------- |
    | Adobe Illustrator                 | application/illustrator                                                   | .ai            |
    | Adobe Photoshop                   | image/vnd.adobe.photoshop                                                 | .psd           |
    | Apple Keynote                     | application/vnd.apple.keynote                                             | .key           |
    | Apple Numbers                     | application/vnd.apple.numbers                                             | .numbers       |
    | Apple Pages                       | application/vnd.apple.pages                                               | .pages         |
    | Microsoft Excel (pre 2007)        | application/vnd.ms-excel                                                  | .xls           |
    | Microsoft Excel                   | application/vnd.openxmlformats-officedocument.spreadsheetml.sheet         | .xlsx          |
    | Microsoft PowerPoint (pre 2007)   | application/vnd.ms-powerpoint                                             | .ppt           |
    | Microsoft PowerPoint              | application/vnd.openxmlformats-officedocument.presentationml.presentation | .pptx          |
    | Microsoft Word (pre 2007)         | application/msword                                                        | .doc           |
    | Microsoft Word                    | application/vnd.openxmlformats-officedocument.wordprocessingml.document   | .docx          |
    | OpenOffice Draw                   | application/vnd.oasis.opendocument.graphics                               | .odg           |
    | OpenOffice Presentation           | application/vnd.oasis.opendocument.presentation                           | .odp           |
    | OpenOffice Sheets                 | application/vnd.oasis.opendocument.spreadsheet                            | .ods           |
    | OpenOffice Text                   | application/vnd.oasis.opendocument.text                                   | .odt           |
    | PDF                               | application/pdf                                                           | .pdf           |

    For upload formats and requirements, see
    [Canva Help — Upload formats and requirements](https://www.canva.com/help/upload-formats-requirements/).
    */
    public CreateDesignImportJobResponse create(CreateRequest request) {
        return create(request, null);
    }



    /**
    * Starts a new job to import an external file as a new design in Canva.

    You can check the status and get the results of import jobs created with this API using the [Get design import job API](https://www.canva.dev/docs/connect/api-reference/design-imports/get-design-import-job/).

    The request format for this endpoint has an `application/octet-stream` body of bytes,
    and the information about the import is attached using an `Import-Metadata` header.

    Supported file types:

    | Name                              | MIME type                                                                 | File extension |
    | --------------------------------- | ------------------------------------------------------------------------- | -------------- |
    | Adobe Illustrator                 | application/illustrator                                                   | .ai            |
    | Adobe Photoshop                   | image/vnd.adobe.photoshop                                                 | .psd           |
    | Apple Keynote                     | application/vnd.apple.keynote                                             | .key           |
    | Apple Numbers                     | application/vnd.apple.numbers                                             | .numbers       |
    | Apple Pages                       | application/vnd.apple.pages                                               | .pages         |
    | Microsoft Excel (pre 2007)        | application/vnd.ms-excel                                                  | .xls           |
    | Microsoft Excel                   | application/vnd.openxmlformats-officedocument.spreadsheetml.sheet         | .xlsx          |
    | Microsoft PowerPoint (pre 2007)   | application/vnd.ms-powerpoint                                             | .ppt           |
    | Microsoft PowerPoint              | application/vnd.openxmlformats-officedocument.presentationml.presentation | .pptx          |
    | Microsoft Word (pre 2007)         | application/msword                                                        | .doc           |
    | Microsoft Word                    | application/vnd.openxmlformats-officedocument.wordprocessingml.document   | .docx          |
    | OpenOffice Draw                   | application/vnd.oasis.opendocument.graphics                               | .odg           |
    | OpenOffice Presentation           | application/vnd.oasis.opendocument.presentation                           | .odp           |
    | OpenOffice Sheets                 | application/vnd.oasis.opendocument.spreadsheet                            | .ods           |
    | OpenOffice Text                   | application/vnd.oasis.opendocument.text                                   | .odt           |
    | PDF                               | application/pdf                                                           | .pdf           |

    For upload formats and requirements, see
    [Canva Help — Upload formats and requirements](https://www.canva.com/help/upload-formats-requirements/).
    */
    public CreateDesignImportJobResponse create(CreateRequest request, RequestOptions requestOptions) {

        try {
            Response response = new HttpRequestBuilder()
            .baseUrl(this.clientOptions.environment().getUrl())
            .path("/v1/imports")
            .addHeader("Import-Metadata", request.getImportMetadata().toString())
            .method("POST")
            .addAuth(clientOptions.getAuth("oauthAuthCode"))
            .setBinaryBody(request.getData(), "application/octet-stream")
            .execute();
            return ResponseHandler.processJsonResponse(response, CreateDesignImportJobResponse.class);
        } catch (IOException e) {
            throw new ApiException("Error executing HTTP request", e);
        }
    }




}

