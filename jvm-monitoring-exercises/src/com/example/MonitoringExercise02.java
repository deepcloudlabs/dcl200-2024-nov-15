package com.example;

public class MonitoringExercise02 {

	public static void main(String[] args) {
		var start = System.currentTimeMillis();
		var s = new StringBuilder(100_000_000);
		for (var i=0;i<10_000_000;++i) {
			s.append(i);
		}
		var stop = System.currentTimeMillis();
		System.out.println("string length: %d @ %d ms.".formatted(s.length(),(stop-start)));
	}

}
