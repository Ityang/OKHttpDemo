package com.ranger.okhttp.demo02;

public final class Request {

    String method;

    public Request() {
    }

    public Request(Builder builder) {
        this.method = builder.method;
    }

    public static class Builder {
        String method;

        Builder(Request request) {
            this.method = request.method;
        }

        public Request build() {
            return new Request(this);
        }
    }

    public Builder newBuilder() {
        return new Builder(this);
    }
}
