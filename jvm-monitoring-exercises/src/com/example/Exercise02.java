package com.example;

import java.util.ArrayList;
import java.util.List;

public class Exercise02 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int x = 42; // 4-Byte
		Integer y = Integer.valueOf(542); // 4-Byte + 12-Byte + 4-Byte = 16 Byte = 20-Byte
		List<Integer> number = new ArrayList<>();
		var sayilar = List.of(Integer.valueOf(4), 8, 15, 16, 23, 42);
		int[] data = new int[] { 4, 8, 15, 16, 23, 42 };
		// cache: L1d, L2, L3
		List<Employee> employees; // "11111111110" "jack bauer" 1000000 "tr1"
	}

}

// immutable
record Employee(
	String identity,
	String fullname,
	double salary,
	String iban,
	boolean fullTime) {}