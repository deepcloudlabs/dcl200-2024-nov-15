package com.example;


import java.util.stream.IntStream;

public class ProfilingExercise3 {

	public static void main(String[] args) {
		new Thread(() -> {
			long sum = IntStream.rangeClosed(1, 1_000_000).parallel().mapToLong(ProfilingExercise3::fun).sum();
			System.err.println(sum);			
		}).start();
		new Thread(() -> {
			long sum = IntStream.rangeClosed(1, 1_000_000).parallel().mapToLong(ProfilingExercise3::fun).sum();
			System.err.println(sum);			
		}).start();
		new Thread(() -> {
			long sum = IntStream.rangeClosed(1, 1_000_000).parallel().mapToLong(ProfilingExercise3::fun).sum();
			System.err.println(sum);			
		}).start();
		new Thread(() -> {
			long sum = IntStream.rangeClosed(1, 1_000_000).parallel().mapToLong(ProfilingExercise3::fun).sum();
			System.err.println(sum);			
		}).start();

	}

	public static long fun(int n) {
		return IntStream.range(0, n).sum();
	}
}
