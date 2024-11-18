package com.example;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ProfilingExercise4 {

	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<>();
		Task task = new Task();
		IntStream.rangeClosed(1, 100).forEach(i -> threads.add(new Thread(task)));
		threads.forEach(Thread::start);
		threads.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}

}

class Task implements Runnable {
	private long counter;

	public long getCounter() {
		return counter;
	}

	@Override
	public void run() {
		for (int j = 0; j < 100; ++j) {
			for (int i = 0; i < 2_000_000; ++i)
				synchronized (this) {
					++counter;
				}
		}

	}

}