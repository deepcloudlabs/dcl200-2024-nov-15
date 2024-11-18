package com.example.java17;

import java.util.List;

public class Exercise02 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		var animals = List.of(new Cat(), new Spider(), new Cat(), new Spider());
		for (var animal : animals) {
			if (animal instanceof Pet pet) { // guard
				// var pet = (Pet) animal; // safe!
				pet.play();
			}
			if (animal instanceof Cat cat) {

			} else if (animal instanceof Spider spider) {

			} else if (animal instanceof Fish fish) {

			}
			switch (animal) {
			case null -> {System.out.println("No animal");}
			case Cat cat when (cat.legs > 3) ->  { cat.walk();}
			case Spider spider when (spider.legs == 8) ->  { spider.bite();}
			case Fish fish when (fish.legs == 0) ->  { fish.swim();}
			default -> {
				// default behavior
			}
			}
		}

	}

}

class Animal {
	public int legs; 
}

interface Pet {
	default void play() {
	}
}

class Spider extends Animal {
	public void bite() {
	}
}

class Cat extends Animal implements Pet {
	public void walk() {
	}
}

class Fish extends Animal implements Pet {
	public void swim() {
	}
}