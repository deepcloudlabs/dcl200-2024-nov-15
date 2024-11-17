package com.example.crm.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;

import com.example.crm.document.CustomerDocument;
import com.example.crm.event.CustomerAcquiredEvent;
import com.example.crm.event.CustomerReleasedEvent;
import com.example.crm.repository.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CrmReactiveService {
	private final CustomerRepository customerRepository;
	private final ReactiveKafkaProducerTemplate<String, String> reactiveKafkaProducerTemplate;
	private final ObjectMapper objectMapper;
	
	public CrmReactiveService(CustomerRepository customerRepository, ReactiveKafkaProducerTemplate<String, String> reactiveKafkaProducerTemplate, ObjectMapper objectMapper) {
		this.customerRepository = customerRepository;
		this.reactiveKafkaProducerTemplate = reactiveKafkaProducerTemplate;
		this.objectMapper = objectMapper;
	}

	public Mono<CustomerDocument> findCustomerByEmail(String email) {
		return customerRepository.findById(email);
	}

	public Flux<CustomerDocument> findAllByPage(int pageNo, int pageSize) {
		return customerRepository.findAll(PageRequest.of(pageNo, pageSize));
	}

	public Mono<CustomerDocument> acquireCustomer(CustomerDocument customer) {
		return customerRepository.insert(customer).doOnSuccess(e -> {
  		  try {
  			var event = new CustomerAcquiredEvent(customer.getEmail());
				var eventAsJson = objectMapper.writeValueAsString(event);
				reactiveKafkaProducerTemplate.send("crm-events", eventAsJson).subscribe();
			} catch (JsonProcessingException ex) {
				System.err.println("Error has occured while processing the event: %s".formatted(ex.getMessage()));
			}			
		});
	}

	public Mono<CustomerDocument> updateCustomer(String email, CustomerDocument customer) {
		return customerRepository.save(customer);
	}

	public Mono<CustomerDocument> releaseCustomer(String email) {
		return customerRepository.findById(email)
		                  .doOnSuccess( customer -> {
		                	  customerRepository.deleteById(customer.getEmail()).doOnSuccess((e) -> {
		                		  System.err.println("%s is deleted".formatted(customer));
		                		  try {
		                			var event = new CustomerReleasedEvent(email);
									var eventAsJson = objectMapper.writeValueAsString(event);
									reactiveKafkaProducerTemplate.send("crm-events", eventAsJson).subscribe();
								} catch (JsonProcessingException ex) {
									System.err.println("Error has occured while processing the event: %s".formatted(ex.getMessage()));
								}
		                	  }).doOnError(err -> System.err.println(err));
		                  });
	}

}
