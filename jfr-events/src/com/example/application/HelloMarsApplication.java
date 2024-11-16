package com.example.application;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import jdk.jfr.Event;
import jdk.jfr.Category;
import jdk.jfr.Label;
import jdk.jfr.Description;
import jdk.jfr.Name;
import jdk.jfr.Enabled;

public class HelloMarsApplication {

	public static void main(String[] args) {
		var event = new LotteryEvent();
		event.begin();
		ThreadLocalRandom.current().ints(1, 60)
		                           .distinct()
		                           .limit(6)
		                           .sorted()
		                           .boxed()
		                           .toList()
		                           .forEach(System.out::println);
		event.end();
		event.commit();
	}

}

@Enabled
@Category("Business Event")
@Description("This is a business event")
@Label("Business Event")
@Name("com.example.LotteryEvent")
class LotteryEvent extends Event {
	String id = UUID.randomUUID().toString();
	String message;
}