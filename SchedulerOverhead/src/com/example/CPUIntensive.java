package com.example;

import java.util.Arrays;

public class CPUIntensive {
	public static void main(String[] args) {
        // Create a large array and fill it with random numbers
        int[] numbers = new int[2_000_000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) Math.random() * 10_000;
        }

        // Sort the array using bubble sort, which is an inefficient sorting algorithm
        Arrays.sort(numbers);
        /*
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    swap(numbers, j);
                }
            }
        }
        */
    }

	@SuppressWarnings("unused")
	private static void swap(int[] numbers, int j) {
		int temp = numbers[j];
		numbers[j] = numbers[j + 1];
		numbers[j + 1] = temp;
	}
	
}
