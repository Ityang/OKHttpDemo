package com.ranger.okhttp.demo02;

import java.io.IOException;

public class ConnectInterceptor implements Interceptor {
    public ConnectInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        RealInterceptorChain realChain = (RealInterceptorChain) chain;
        Request request = realChain.request();
        System.out.println("4.与服务器建立连接拦截器");
        return realChain.proceed(request);
    }
}
