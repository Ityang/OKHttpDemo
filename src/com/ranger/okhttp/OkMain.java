package com.ranger.okhttp;



import com.ranger.okhttp.demo01.AsyncCall;
import com.ranger.okhttp.demo01.Dispatcher;
import com.ranger.okhttp.demo02.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OkMain {

    public static void main(String[] args) throws IOException {
        //demo01调用
        new Dispatcher().enqueue(new AsyncCall("22","33"));

        //demo02调用
        Request request = new Request();
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new RetryAndFollowUpInterceptor());
        interceptors.add(new BridgeInterceptor());
        interceptors.add(new CacheInterceptor());
        interceptors.add(new ConnectInterceptor());

        Interceptor.Chain chain = new RealInterceptorChain(interceptors,0,request);

        Response response = chain.proceed(request);
    }
}
