package com.example.lottery.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.Qualifier;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomService;

public class LotteryApplication {

	public static void main(String[] args) {
		var lotteryService = new StandardLotteryService();
		getRandomService().ifPresent(lotteryService::setRandomService);
		
		lotteryService.draw(60, 6, 10)
		              .forEach(System.out::println);
	}

	private static Optional<RandomService> getRandomService() {
		var services = ServiceLoader.load(RandomService.class);
		try {
			var props = new Properties();
			props.load(new FileInputStream(new File("src","application.properties")));
			var qualityLevel = QualityLevel.valueOf(props.getProperty("random.service"));
			for (var service : services) {
				var clazz = service.getClass();
				if (clazz.isAnnotationPresent(Qualifier.class)) {
					var qualifier = clazz.getAnnotation(Qualifier.class);
					if (qualifier.value() == qualityLevel)
						return Optional.of(service);
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return Optional.empty();
	}

}
