package com.example;

import java.util.ArrayList;

public class UseArrayListOptimization {
    static ArrayList<Integer> list = new ArrayList<>(100_000_000);

	public static void main(String[] args) {
		for (var i=0;i<10;++i) {
			fun();
			list.clear();
		}
	}

	private static void fun() {
		var start = System.currentTimeMillis();
		for (var i=0;i<100_000_000;++i)
			list.add(Integer.valueOf(i));
		var stop = System.currentTimeMillis();
		System.err.println("list.size()=%d @ %d ms.".formatted(1_000_000,stop-start));
	}

}
