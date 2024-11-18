package com.example;

public class UseArrayList {
//	static ArrayList<int> list = new ArrayList<>(100_000_000);

	public static void main(String[] args) {
		Integer[] array = new Integer[100_000_000];
		var start = System.currentTimeMillis();
		for (var i=0;i<100_000_000;++i)
//			list.add(Integer.valueOf(i));
			array[i] = Integer.valueOf(i);
		var stop = System.currentTimeMillis();
		System.err.println("list.size()=%d @ %d ms.".formatted(1_000_000,stop-start));
	}

}
