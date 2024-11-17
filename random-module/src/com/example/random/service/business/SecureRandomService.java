package com.example.random.service.business;

import java.security.SecureRandom;

import com.example.random.service.Qualifier;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomService;

@Qualifier(QualityLevel.SECURE)
public class SecureRandomService implements RandomService {

	private SecureRandom random = new SecureRandom();

	@Override
	public int generate(int min, int max) {
		System.err.println("SecureRandomService::generate");
		return random.nextInt(min, max) ;
	}

}
