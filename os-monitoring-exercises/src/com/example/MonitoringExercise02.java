package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MonitoringExercise02 {
    private static final int THREAD_COUNT = 10;
    private static final int INCREMENT_COUNT = 1_000_000_000;
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < INCREMENT_COUNT; j++) {
                    incrementCounter();
                }
            });
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // Wait for all tasks to complete
        }

        System.out.println("Final counter value: " + counter);
    }

    private static void incrementCounter() {
            counter.incrementAndGet();
    }
}

