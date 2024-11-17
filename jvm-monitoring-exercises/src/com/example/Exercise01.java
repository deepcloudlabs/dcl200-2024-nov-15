package com.example;

public class Exercise01 {

	public static void main(String[] args) {
		var name1 = "Kate Austen";
		var name2 = new String("Kate Austen");
		var name3 = "Kate Austen";
		// Object Pooling -> Immutable
		name2 = name2.intern(); // G1GC Full GC -> -XX:+UseStringDeduplication
		System.out.println("name1 == name2: "+(name1 == name2));  // false
		System.out.println("name1 == name3: "+(name1 == name3));  // true
	}

}
