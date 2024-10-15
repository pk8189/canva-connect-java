package com.canva.canvaconnectapi.core;

public class BinaryResponse {
    private final byte[] content;

    public BinaryResponse(byte[] content) {
        this.content = content;
    }

    public byte[] getContent() {
        return content;
    }
}