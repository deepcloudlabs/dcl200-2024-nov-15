package com.example.java8;

public class Exercise04 {
	public static void main(String[] args) {
			
	}
}

interface I {
	public static final int x = 42;
	public abstract void fun();
	public abstract void gun();
	// since java 8
	public default void sun() {
		mun();
	}
	// since java 8
	public static void run() {
		pun();
	}
	// since java 9
	private void mun() {}
	// since java 9
	private static void pun() {}
	// 
}

interface U {
	public void fun();
	default void gun() {}
}

class AA implements U {

	@Override
	public void fun() {
		// TODO Auto-generated method stub
		
	}
	
}