package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;

public class UseHashMap {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		HashSet<Integer> set = new HashSet<>(200_000,0.5f); // Capacity : 100_000
		byte[] buffer = new byte[4096]; // GC
		try( // try with resources
			FileInputStream fis = new FileInputStream(new File("src","data"));				
		) { // Language
			fis.read(buffer);
		}
		

	}

}
