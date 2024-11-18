package com.example.java8;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercise02 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		var numbers = List.of(4, 8, 15, 16, 23, 42);
		// declarative programming: functional programming
		// 1. High-order Functions: filter, map, reduce, ... 
		// 2. Pure Functions: evenNumber, toCube, toSum
		//                pipeline : 4,8,15,16,23,42 ==>
		//                function composition
		// Functional Interface -> SAM
		// Pure Function: 1) lambda expression -> function;
		Predicate<Integer> evenNumber = t -> t%2 == 0 ;
		Function<Integer,Integer> toCube = x -> x*x*x;
		BinaryOperator<Integer> toSum = (u,v) -> u+v;
		//                2) method reference 
		BinaryOperator<Integer> toSum2 = Integer::sum;
		var sum = numbers.stream() // internal loop
				         .parallel()
				         .filter(evenNumber)
				         .map(toCube)
				         .sequential()
				         .reduce(0,toSum);
		// 78760
		System.out.println("Sum of cube of even numbers is %d".formatted(sum));
	}

}
