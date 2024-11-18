package com.example.java17;

public class Exercise01 {

	public static void main(String[] args) {
		// extends, implements

	}

}

sealed class Account permits CheckingAccount,KKMAccount,MyAccount {}
// final class CheckingAccount extends Account {}
final class CheckingAccount extends Account {}
final class KKMAccount extends Account {}
non-sealed class MyAccount extends Account {}

sealed interface Calculator permits ArithmeticCalculator,UnitCalculator {}
final class ArithmeticCalculator implements Calculator{}
final class UnitCalculator implements Calculator{}