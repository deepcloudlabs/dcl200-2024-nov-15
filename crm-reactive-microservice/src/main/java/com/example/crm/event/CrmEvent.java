package com.example.crm.event;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;


public abstract class CrmEvent {
	private final static AtomicInteger counter = new AtomicInteger(1);
	private final String email;
	private final String id = UUID.randomUUID().toString();
	private final CrmEventType eventType;
	private final LocalDateTime timestamp = LocalDateTime.now();
	private final int order = counter.getAndIncrement();

	public CrmEvent(String email, CrmEventType eventType) {
		this.email = email;
		this.eventType = eventType;
	}

	public String getId() {
		return id;
	}

	public CrmEventType getEventType() {
		return eventType;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public int getOrder() {
		return order;
	}

	public String getEmail() {
		return email;
	}


}
