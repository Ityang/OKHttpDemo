package com.ranger.okhttp.demo02;

import java.io.IOException;

public class RetryAndFollowUpInterceptor implements Interceptor {

    public RetryAndFollowUpInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        RealInterceptorChain realChain = (RealInterceptorChain) chain;
        Request request = chain.request();

        System.out.println("1.失败重试拦截器");
        return  realChain.proceed(request);
    }
}
