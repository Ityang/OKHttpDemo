package com.ranger.okhttp.demo02;

import java.io.IOException;

public class BridgeInterceptor implements Interceptor {

    public BridgeInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request userRequest = chain.request();
        Request.Builder requestBuilder = userRequest.newBuilder();
        System.out.println("2.请求和响应转换拦截器" );
        return  chain.proceed(requestBuilder.build());
    }
}
