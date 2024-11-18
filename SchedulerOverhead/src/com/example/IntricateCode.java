package com.example;

public class IntricateCode {

	public static void main(String[] args) throws InterruptedException {
		// Perform an inefficient calculation that consumes a lot of CPU resources
        for (int i = 0; i < 10; i++) {
            double result = Math.pow(i, 2);
            System.out.println(result);
        }

        // Create a large number of threads that perform unnecessary work
        Thread []threads= new Thread[4];
        for (int i = 0; i < 4; i++) {
            threads[i] = new Thread(() -> {
            	StringBuilder str = new StringBuilder("");
                for (int j = 0; j < 1_000_000; j++) {
                    // Do some pointless work
                    str.append(j); // GC -> GC Thread -> 
                }
                System.out.println(str.length());
            });
            threads[i].start();
        }
        for (var thread: threads)
        	thread.join();
        // Create a recursive method that calls itself repeatedly
        recursiveMethod(0);
    }

    private static void recursiveMethod(int n) {
        if (n < 10) {
            recursiveMethod(n + 1);
        }
    }
	

}
