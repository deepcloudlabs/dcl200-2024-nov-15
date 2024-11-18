package com.example;

import java.util.HashSet;
import java.util.Objects;

public class MemoryLeakExample {

	public static void main(String[] args) {
		HashSet<Customer> customers= new HashSet<>();
		while (true) {
			customers.add(new Customer("1", "kate austen")); // add
			customers.remove(new Customer("1", "kate austen")); // remove
			System.err.println(customers.size());
		}

	}

}

record Customer(String identity,String fullname) {

	@Override
	public int hashCode() {
		return Objects.hash(identity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(identity, other.identity);
	}
	
}