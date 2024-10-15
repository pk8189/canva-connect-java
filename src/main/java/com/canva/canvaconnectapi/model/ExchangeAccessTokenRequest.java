package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.canva.canvaconnectapi.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(using = ExchangeAccessTokenRequest.Deserializer.class)
public final class ExchangeAccessTokenRequest {
    private final Object value;

    private ExchangeAccessTokenRequest(Object value) {
        this.value = value;
    }

    @JsonValue
    public Object getValue() {
        return value;
    }

    public boolean isExchangeAuthCodeRequestVariant() {
        return value instanceof ExchangeAuthCodeRequest;
    }

    public ExchangeAuthCodeRequest asExchangeAuthCodeRequestVariant() {
        return isExchangeAuthCodeRequestVariant() ? (ExchangeAuthCodeRequest) value : null;
    }

    public boolean isExchangeRefreshTokenRequestVariant() {
        return value instanceof ExchangeRefreshTokenRequest;
    }

    public ExchangeRefreshTokenRequest asExchangeRefreshTokenRequestVariant() {
        return isExchangeRefreshTokenRequestVariant() ? (ExchangeRefreshTokenRequest) value : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        ExchangeAccessTokenRequest that = (ExchangeAccessTokenRequest) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static ExchangeAccessTokenRequest of(Object value) {
        if (value instanceof ExchangeAuthCodeRequest || value instanceof ExchangeRefreshTokenRequest) {
            return new ExchangeAccessTokenRequest(value);
        }

        throw new IllegalArgumentException("Unsupported type: " + (value == null ? "null" :
                                           value.getClass()));
    }

    static class Deserializer extends
        com.fasterxml.jackson.databind.JsonDeserializer<ExchangeAccessTokenRequest> {
        @Override
        public ExchangeAccessTokenRequest deserialize(com.fasterxml.jackson.core.JsonParser p,
                com.fasterxml.jackson.databind.DeserializationContext ctxt) throws java.io.IOException {
            Object value = p.readValueAs(Object.class);

            try {
                return ExchangeAccessTokenRequest.of(value);
            } catch (IllegalArgumentException e) {
            }

            try {
                return ExchangeAccessTokenRequest.of(ObjectMappers.JSON_MAPPER.convertValue(value,
                                                     ExchangeAuthCodeRequest.class));
            } catch (IllegalArgumentException e) {
            }

            try {
                return ExchangeAccessTokenRequest.of(ObjectMappers.JSON_MAPPER.convertValue(value,
                                                     ExchangeRefreshTokenRequest.class));
            } catch (IllegalArgumentException e) {
            }

            throw new com.fasterxml.jackson.core.JsonParseException(p, "Failed to deserialize");
        }
    }
}



