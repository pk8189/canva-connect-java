package com.canva.canvaconnectapi.model;

import com.fasterxml.jackson.annotation.JsonValue;



// Type Definition
public enum ErrorCodeEnum {
    APP_NOT_FOUND("app_not_found"),
    ASSET_NOT_FOUND("asset_not_found"),
    AUTOFILL_DATA_INVALID("autofill_data_invalid"),
    BAD_HTTP_METHOD("bad_http_method"),
    BAD_QUERY_PARAMS("bad_query_params"),
    BAD_REQUEST_BODY("bad_request_body"),
    BAD_REQUEST_PARAMS("bad_request_params"),
    COMMENT_NOT_FOUND("comment_not_found"),
    CONTENT_NOT_FOUND("content_not_found"),
    DESIGN_NOT_FILLABLE("design_not_fillable"),
    DESIGN_NOT_FOUND("design_not_found"),
    DESIGN_TYPE_NOT_FOUND("design_type_not_found"),
    DOCTYPE_NOT_FOUND("doctype_not_found"),
    ENDPOINT_NOT_FOUND("endpoint_not_found"),
    FEATURE_NOT_AVAILABLE("feature_not_available"),
    FOLDER_NOT_FOUND("folder_not_found"),
    GROUP_NOT_FOUND("group_not_found"),
    INTERNAL_ERROR("internal_error"),
    INVALID_ACCESS_TOKEN("invalid_access_token"),
    INVALID_BASIC_HEADER("invalid_basic_header"),
    INVALID_CLIENT("invalid_client"),
    INVALID_FIELD("invalid_field"),
    INVALID_FILE_FORMAT("invalid_file_format"),
    INVALID_GRANT("invalid_grant"),
    INVALID_HEADER_VALUE("invalid_header_value"),
    INVALID_REQUEST("invalid_request"),
    INVALID_SCOPE("invalid_scope"),
    ITEM_IN_MULTIPLE_FOLDERS("item_in_multiple_folders"),
    LICENSE_REQUIRED("license_required"),
    MAX_LIMIT_REACHED("max_limit_reached"),
    MESSAGE_TOO_LONG("message_too_long"),
    MISSING_FIELD("missing_field"),
    MISSING_SCOPE("missing_scope"),
    NOT_FOUND("not_found"),
    OFFSET_TOO_LARGE("offset_too_large"),
    PAGE_NOT_FOUND("page_not_found"),
    PERMISSION_DENIED("permission_denied"),
    PERMISSION_EXISTS("permission_exists"),
    PERMISSION_NOT_FOUND("permission_not_found"),
    QUOTA_EXCEEDED("quota_exceeded"),
    REQUEST_TOO_LARGE("request_too_large"),
    REVOKED_ACCESS_TOKEN("revoked_access_token"),
    TEAM_NOT_FOUND("team_not_found"),
    TOO_MANY_COMMENTS("too_many_comments"),
    TOO_MANY_REPLIES("too_many_replies"),
    TOO_MANY_REQUESTS("too_many_requests"),
    UNAUTHORIZED_CLIENT("unauthorized_client"),
    UNAUTHORIZED_USER("unauthorized_user"),
    UNSUPPORTED_CONTENT_TYPE("unsupported_content_type"),
    UNSUPPORTED_GRANT_TYPE("unsupported_grant_type"),
    UNSUPPORTED_VERSION("unsupported_version"),
    USER_NOT_FOUND("user_not_found");

    private final String value;

    ErrorCodeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}



