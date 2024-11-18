package com.example.java11;

@SuppressWarnings("unused")
public class Exercise01 {
	public static void main(String[] args) {
	   Test test1 = (x,y) -> x+y;		
	   Test test2 = (double x,double y) -> x+y;		
	   Test test3 = (var x,var y) -> x+y;		
	   Test test4 = (final double x,@A double y) -> x+y;		
	   Test test5 = (final var x,@A var y) -> x+y;		
	   
	}
}

@interface A {}
@FunctionalInterface 
interface Test { 
 public abstract double math (double x, double y);
}
