package com.example.lottery.service.business;

import java.util.List;
import java.util.stream.IntStream;

import com.example.lottery.service.LotteryService;
import com.example.random.service.RandomService;

public class StandardLotteryService implements LotteryService {
	private RandomService randomService;
	
	
	public void setRandomService(RandomService randomService) {
		this.randomService = randomService;
	}

	@Override
	public List<Integer> draw(int max, int size) {
		return IntStream.generate(() -> randomService.generate(1, max))
				        .distinct()
				        .limit(size)
				        .boxed()
				        .toList();
	}

}
