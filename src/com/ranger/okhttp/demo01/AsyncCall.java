package com.ranger.okhttp.demo01;

import java.util.concurrent.ExecutorService;

public class AsyncCall extends NamedRunnable {

    public AsyncCall(String format, Object... args) {
        super(format, args);
    }

    void executeOn(ExecutorService executorService) {
        executorService.execute(this);
    }

    @Override
    protected void execute() {
        System.out.println("--AsyncCall执行execute方法--");

        getResponseWithInterceptorChain();
    }

    private void getResponseWithInterceptorChain() {


    }
}
