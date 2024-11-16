package com.example;

import java.util.List;

public class Exercise02 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int x = 42; // 4-Byte
		Integer y = 42; // 20-Byte
						// y: reference -> 8B -> 4B (-XX:+UseCompressedOops)
						// 12-Byte (Object Header) + 4B = 16-Byte
		List<Integer> numbers;
		
		var circles = List.of( // 120B
				new Circle(1, 2, 3), // 12 + 4 + 4 + 4 = 24 Byte?
				new Circle(2, 3, 4), new Circle(2, 3, 4), new Circle(2, 3, 4), new Circle(2, 3, 4));
		// 12B 1 2 3 2 3 4 2 3 4
		// 1
		// 2
		// 3
		// ...
		// 12B
		// 2
		// 3
		// 4
	}

}

record Circle(int x, int y, int radius) {
}