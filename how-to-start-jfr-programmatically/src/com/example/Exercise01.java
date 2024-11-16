package com.example;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Exercise01 {
	private static Set<String> set = new HashSet<>(100_000);

	public static void main(String[] args) throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		for (int j = 0; j < 2_000_000; ++j) {
			StringBuilder buffer = new StringBuilder(100_000);
			for (int i = 0; i < 10_000; ++i) {
				buffer.append("1");
				set.add(buffer.toString());
				//TimeUnit.MILLISECONDS.sleep(1);
				// System.gc();
			}
		}
		System.out.println(set.size());
		TimeUnit.MINUTES.sleep(10);
	}

}