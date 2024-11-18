package com.example.java7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise07 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Map<String,List<Integer>> map1 = new HashMap<String,List<Integer>>();
		// since java 7
		Map<String,List<Integer>> map2 = new HashMap<>();
		// since java 10
		var map3 = new HashMap<String,List<Integer>>();

	}

}
