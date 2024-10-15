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
@JsonDeserialize(builder = DataTableRow.Builder.class)
public final class DataTableRow {
    /**
     * Cells of data in row.
     *
     * All rows must have the same number of cells. Maximum of 20 cells per row.
     */
    private final List<DataTableCell> cells;

    private DataTableRow(
        List<DataTableCell> cells
    ) {
        this.cells = cells;
    }

    @JsonProperty("cells")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public List<DataTableCell> getCells() {
        return cells;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof DataTableRow && equalTo((DataTableRow) other);
    }

    private boolean equalTo(DataTableRow other) {
        return
            cells.equals(other.cells)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.cells
               );
    }

    @Override
    public String toString() {
        return "DataTableRow{" +
               "cells=" + cells +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<DataTableCell> cells = null;

        private Builder() {}

        public Builder from(DataTableRow other) {
            cells(other.getCells());
            return this;
        }

        @JsonSetter("cells")
        public Builder cells(List<DataTableCell> cells) {
            if (cells == null) {
                throw new IllegalArgumentException("cells cannot be null");
            }

            this.cells = cells;
            return this;
        }



        public DataTableRow build() {
            if (cells == null) {
                throw new IllegalStateException("cells is required");
            }

            return new DataTableRow(
                       cells
                   );
        }
    }

}




