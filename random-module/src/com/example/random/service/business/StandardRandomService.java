package com.example.random.service.business;

import java.util.concurrent.ThreadLocalRandom;

import com.example.random.service.Qualifier;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomService;

@Qualifier(QualityLevel.FAST)
public class StandardRandomService implements RandomService {

	@Override
	public int generate(int min, int max) {
		System.err.println("StandardRandomService::generate");
		return ThreadLocalRandom.current().nextInt(min, max);
	}

}
