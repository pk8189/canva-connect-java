package com.canva.canvaconnectapi.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = DataTable.Builder.class)
public final class DataTable {
    /**
     * Rows of data.
     *
     * The first row usually contains column headers. Maximum of 100 rows.
     */
    private final List<DataTableRow> rows;

    private DataTable(
        List<DataTableRow> rows
    ) {
        this.rows = rows;
    }

    @JsonProperty("rows")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public List<DataTableRow> getRows() {
        return rows;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof DataTable && equalTo((DataTable) other);
    }

    private boolean equalTo(DataTable other) {
        return
            rows.equals(other.rows)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.rows
               );
    }

    @Override
    public String toString() {
        return "DataTable{" +
               "rows=" + rows +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<DataTableRow> rows = null;

        private Builder() {}

        public Builder from(DataTable other) {
            rows(other.getRows());
            return this;
        }

        @JsonSetter("rows")
        public Builder rows(List<DataTableRow> rows) {
            if (rows == null) {
                throw new IllegalArgumentException("rows cannot be null");
            }

            this.rows = rows;
            return this;
        }



        public DataTable build() {
            if (rows == null) {
                throw new IllegalStateException("rows is required");
            }

            return new DataTable(
                       rows
                   );
        }
    }

}




