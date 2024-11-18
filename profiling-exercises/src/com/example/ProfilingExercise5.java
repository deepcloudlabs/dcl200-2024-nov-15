package com.example;

import static java.util.UUID.randomUUID;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProfilingExercise5 {
	private static Map<Key, Integer> myMap = new HashMap<>();

	public static void main(String[] args) throws InterruptedException {
		for (int j = 0; j < 2_000_000; ++j) {
			for (int i = 0; i < 10_000; ++i) {
				var key = new Key(randomUUID());
				var value = Integer.valueOf(i);
				myMap.put(key, value);
				Thread.onSpinWait();
			}
		}
		System.out.println(myMap.size());
	}

}

class Key {
	private UUID id;

	public Key(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
