package com.example.crm.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.crm.document.CustomerDocument;
import com.example.crm.document.Phone;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveMongoRepository<CustomerDocument, String>{
	Flux<CustomerDocument>	findAllByAddressCountry(String country);
	Flux<CustomerDocument>	findAllByFullNameLastName(String lastName);
	Mono<CustomerDocument>  findOneBySms(Phone sms);
	@Query("{}")
	Flux<CustomerDocument> findAll(PageRequest page);
}
