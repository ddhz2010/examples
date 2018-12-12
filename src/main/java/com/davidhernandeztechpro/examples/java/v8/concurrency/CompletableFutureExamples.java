package com.davidhernandeztechpro.examples.java.v8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExamples {

    public static void main(String[] args) {
        anyOf();
    }

    public static void anyOf() {
        ThreadLocal<Integer> threadLocal = new InheritableThreadLocal() {
            @Override
            protected Object childValue(Object parentValue) {
                return super.childValue(parentValue);
            }
        };
        threadLocal.set(5);
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(12);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of Future 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            int waitTimeSec = threadLocal.get();
            try {
                TimeUnit.SECONDS.sleep(waitTimeSec);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of Future 2: " + waitTimeSec + " seconds";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(13);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of Future 3";
        });

        System.out.println("before anyOf()");
        CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2, future3);
        System.out.println("after anyOf()");

        try {
            System.out.println("before anyOfFuture.get()");
            Object anyOfFutureResult = anyOfFuture.get();
            System.out.println("after anyOfFuture.get()");
            System.out.println(anyOfFutureResult); // Result of Future 2
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
