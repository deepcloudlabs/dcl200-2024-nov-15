package com.example.java7;

public class Exercise06 {
	public void fun() throws E2 {
		
	}
	public void gun() throws E2{
		try {
			fun(); // E2
		} catch (E1 e) {
			System.out.println(e.getMessage());
			throw e;// re-throw: E1
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

@SuppressWarnings("serial")
class E1 extends Exception { // business exception
	
}

@SuppressWarnings("serial")
class E2 extends E1 {
	
}