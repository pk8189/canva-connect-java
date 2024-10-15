package com.canva.canvaconnectapi;




public final class Environment {

    private final String url;
    public static final Environment DEFAULT = new Environment("https://api.canva.com/rest");
    public static final Environment MOCK_SERVER = new
    Environment("https://api.sideko.dev/v1/mock/public/canva-api/1.0.1");

    private Environment(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public static Environment custom(String url) {
        return new Environment(url);
    }
}
