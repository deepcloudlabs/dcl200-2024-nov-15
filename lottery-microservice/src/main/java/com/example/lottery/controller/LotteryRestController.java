package com.example.lottery.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.lottery.jfr.events.LotteryEvent;
import com.example.lottery.service.LotteryService;

@RestController
@RequestMapping("/numbers")
@RequestScope
@CrossOrigin
@Validated
public class LotteryRestController {
	private static final AtomicInteger counter = new AtomicInteger(0); 
	private final LotteryService lotteryService;

	public LotteryRestController(LotteryService lotteryService) {
		this.lotteryService = lotteryService;
	}

	@GetMapping(params = { "max", "size" })
	public List<Integer> getLotteryNumbers(@RequestParam int max, @RequestParam int size) {
		var begin = System.currentTimeMillis();
		var event = new LotteryEvent();
		event.begin();
		List<Integer> lotteryNumbers = lotteryService.draw(max, size);
		event.count = counter.getAndIncrement();
		var end = System.currentTimeMillis();
		event.interval = end- begin;
		event.end();
		event.commit();
		return lotteryNumbers;
	}
}
