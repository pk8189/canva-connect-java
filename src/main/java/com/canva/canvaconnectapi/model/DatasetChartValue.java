package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = DatasetChartValue.Builder.class)
public final class DatasetChartValue {
    private final DataTable chartData;
    private final DatasetChartValueTypeEnum type;

    private DatasetChartValue(
        DataTable chartData,
        DatasetChartValueTypeEnum type
    ) {
        this.chartData = chartData;
        this.type = type;
    }

    @JsonProperty("chart_data")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DataTable getChartData() {
        return chartData;
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public DatasetChartValueTypeEnum getType() {
        return type;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof DatasetChartValue && equalTo((DatasetChartValue) other);
    }

    private boolean equalTo(DatasetChartValue other) {
        return
            chartData.equals(other.chartData) &&

            type.equals(other.type)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.chartData,
                   this.type
               );
    }

    @Override
    public String toString() {
        return "DatasetChartValue{" +
               "chartData=" + chartData +
               "type=" + type +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private DataTable chartData = null;
        private DatasetChartValueTypeEnum type = null;

        private Builder() {}

        public Builder from(DatasetChartValue other) {
            chartData(other.getChartData());
            type(other.getType());
            return this;
        }

        @JsonSetter("chart_data")
        public Builder chartData(DataTable chartData) {
            if (chartData == null) {
                throw new IllegalArgumentException("chartData cannot be null");
            }

            this.chartData = chartData;
            return this;
        }


        @JsonSetter("type")
        public Builder type(DatasetChartValueTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }



        public DatasetChartValue build() {
            if (chartData == null) {
                throw new IllegalStateException("chartData is required");
            }

            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new DatasetChartValue(
                       chartData,
                       type
                   );
        }
    }

}




