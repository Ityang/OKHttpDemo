package com.ranger.okhttp.demo01;


import com.sun.istack.internal.Nullable;

import java.util.concurrent.*;


public class Dispatcher {

    private String name;

    public Dispatcher() {
    }

    /**
     * Executes calls. Created lazily.
     */
    private @Nullable
    ExecutorService executorService;

    public synchronized ExecutorService executorService() {
        if (executorService == null) {
            executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS,
                    new SynchronousQueue<>(), threadFactory("OkHttp Dispatcher", false));
        }
        return executorService;
    }

    public void enqueue(AsyncCall call) {
        name = call.name;
        System.out.println("---Dispatcher---enqueue-");

        promoteAndExecute();
    }

    private void promoteAndExecute() {
        AsyncCall asyncCall = new AsyncCall("");
        asyncCall.executeOn(executorService());
    }

    public ThreadFactory threadFactory(String name, boolean daemon) {
        return runnable -> {
            Thread result = new Thread(runnable, name);
            result.setDaemon(daemon);
            return result;
        };
    }
}
