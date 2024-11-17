package com.example;

public class Exercise03 {

	public static void main(String[] args) {
		// -XX:AutoBoxCacheMax=2048
		Integer x = Integer.valueOf(42);
		Integer y = 42;
		Integer m = 549;
		Integer n = 549;
		System.out.println("x==y: "+(x==y));
		System.out.println("m==n: "+(m==n));
	}

}
