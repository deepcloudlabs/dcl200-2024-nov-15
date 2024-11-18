package com.example.java12;

public class Exercise02 {

	public static void main(String[] args) {
		int weekDay = 3;
		var status = 
		switch (weekDay) {
		case 1, 2, 3, 4, 5 -> {
			yield "working";
		}
		case 6, 7 -> {
			yield "resting";
		}
		default -> {
			yield "unknown";
		}
		};
		System.out.println(status);
	}

}
