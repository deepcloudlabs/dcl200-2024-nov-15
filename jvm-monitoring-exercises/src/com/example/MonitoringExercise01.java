package com.example;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MonitoringExercise01 {
    private static final int THREAD_COUNT = 2;
    private static final int INCREMENT_COUNT = 1_000_000_000;
	public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
	
		for (var i=0;i<THREAD_COUNT;++i) {
			executorService.submit(() -> {
                for (int j = 0; j < 2; j++) {
                    fun();
                }
            });
		}
		executorService.shutdown();
        while (!executorService.isTerminated()) {
            // Wait for all tasks to complete
        }
	}
	
	private static void fun() {
		var list = new ArrayList<>();
        for (int j = 0; j < INCREMENT_COUNT; j++) {
            // var s = new String("jack shephard"); // Heap
            var s = "jack shephard"; // CP (Constant Pool)
            list.add(s);
        }
	}

}


