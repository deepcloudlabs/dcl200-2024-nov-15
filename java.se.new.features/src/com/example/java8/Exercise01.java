package com.example.java8;

import java.util.List;

public class Exercise01 {

	public static void main(String[] args) {
		var numbers = List.of(4, 8, 15, 16, 23, 42);
		// imperative programming
		var sum = 0;
		for (var number : numbers) { // external loop
			if (number % 2 == 0) {
				var cubed = number * number * number;
				sum += cubed;
			}
		}
		// 78760
		System.out.println("Sum of cube of even numbers is %d".formatted(sum));
	}

}
