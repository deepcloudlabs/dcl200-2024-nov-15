package com.example.java8;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercise03 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		var numbers = List.of(4, 8, 15, 16, 23, 42);
		int data = 0; // effectively final
		// data++;
		Predicate<Integer> evenNumber = t -> t%2 == 0 ;
		Function<Integer,Integer> toCube = x -> x*x*x;
		BinaryOperator<Integer> toSum = (u,v) -> u+v;		
		var sum = numbers.stream() // internal loop
		         .parallel()
		         .filter(evenNumber)
		         .map(IntegerUtil::toCubed)
		         .sequential()
		         .reduce(0,toSum);
	}

}

interface IntegerUtil {
	static int toCubed(int x) {
		return x*x*x;
	}
}