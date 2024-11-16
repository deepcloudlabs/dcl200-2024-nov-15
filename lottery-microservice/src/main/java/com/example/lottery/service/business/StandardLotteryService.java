package com.example.lottery.service.business;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.example.lottery.service.LotteryService;

@Service
public class StandardLotteryService implements LotteryService {

	@Override
	public List<Integer> draw(int max, int size) {
		return ThreadLocalRandom.current().ints(1, max)
                .distinct()
                .limit(size)
                .sorted()
                .boxed()
                .toList();
	}

}
