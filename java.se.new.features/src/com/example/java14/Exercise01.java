package com.example.java14;

import java.util.List;

public class Exercise01 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// value-typed
		int x = 42; // 4-Byte
		// reference
		Integer y = Integer.valueOf(42); // 4-byte + Heap(12B + 4B=16B) = 20B
		List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
		Point p1 = new Point(1, 2);
		Point p2 = new Point(1, 2);
		List<Point> points = List.of(new Point(1,2),new Point(2,3));
		// 1|2|2|3|...
		System.out.println(p1);
		System.out.println(p1.equals(p2));
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
	}

}

// Value Class, Immutable Class
// equals, hashCode, toString
record Point(int x, int y) {
	
	public Point move(int dx, int dy) {
		return new Point(this.x + dx, this.y + dy);
	}
	
}
