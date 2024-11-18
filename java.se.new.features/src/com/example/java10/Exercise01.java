package com.example.java10;

import java.util.List;

public class Exercise01 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// var -> local variable
		var x = 42; // c++: auto

		var numbers1 = List.of(4,8,15,16,23,42); // List<Integer>
		var numbers2 = List.of(4,8,15.0,16,23,42); // List<Number & Comparable>
		var numbers3 = List.of(4,8,15.0,"16",23,42); // List<Object & Comparable & Serializable >
		
	}

}

class A {
	// var x = 42; // not allowed -> attribute/field
	
}
