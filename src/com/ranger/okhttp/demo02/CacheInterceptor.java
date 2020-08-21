package com.ranger.okhttp.demo02;

import java.io.IOException;

public class CacheInterceptor implements Interceptor {

    public CacheInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        RealInterceptorChain realChain = (RealInterceptorChain) chain;
        Request request = realChain.request();
        System.out.println("3.缓存拦截器" );
        return realChain.proceed(request);
    }
}
