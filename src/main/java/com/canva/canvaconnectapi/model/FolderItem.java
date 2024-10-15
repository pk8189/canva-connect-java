package com.canva.canvaconnectapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Type Definition
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = FolderItem.Builder.class)
public final class FolderItem {
    private final Folder folder;
    private final FolderItemTypeEnum type;

    private FolderItem(
        Folder folder,
        FolderItemTypeEnum type
    ) {
        this.folder = folder;
        this.type = type;
    }

    @JsonProperty("folder")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public Folder getFolder() {
        return folder;
    }

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    public FolderItemTypeEnum getType() {
        return type;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        return other instanceof FolderItem && equalTo((FolderItem) other);
    }

    private boolean equalTo(FolderItem other) {
        return
            folder.equals(other.folder) &&

            type.equals(other.type)
            ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                   this.folder,
                   this.type
               );
    }

    @Override
    public String toString() {
        return "FolderItem{" +
               "folder=" + folder +
               "type=" + type +
               '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Folder folder = null;
        private FolderItemTypeEnum type = null;

        private Builder() {}

        public Builder from(FolderItem other) {
            folder(other.getFolder());
            type(other.getType());
            return this;
        }

        @JsonSetter("folder")
        public Builder folder(Folder folder) {
            if (folder == null) {
                throw new IllegalArgumentException("folder cannot be null");
            }

            this.folder = folder;
            return this;
        }


        @JsonSetter("type")
        public Builder type(FolderItemTypeEnum type) {
            if (type == null) {
                throw new IllegalArgumentException("type cannot be null");
            }

            this.type = type;
            return this;
        }



        public FolderItem build() {
            if (folder == null) {
                throw new IllegalStateException("folder is required");
            }

            if (type == null) {
                throw new IllegalStateException("type is required");
            }

            return new FolderItem(
                       folder,
                       type
                   );
        }
    }

}




