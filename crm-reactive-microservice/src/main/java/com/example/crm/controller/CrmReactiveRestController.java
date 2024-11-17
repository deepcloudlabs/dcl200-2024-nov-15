package com.example.crm.controller;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crm.document.CustomerDocument;
import com.example.crm.service.CrmReactiveService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RestController
@RequestMapping("/customers")
@Validated
@CrossOrigin
public class CrmReactiveRestController {
	private final CrmReactiveService crmService;
	
	public CrmReactiveRestController(CrmReactiveService crmService) {
		this.crmService = crmService;
	}

	@GetMapping("{email}")
	public Mono<CustomerDocument> findCustomerByEmail(@PathVariable String email) {
		return crmService.findCustomerByEmail(email);
	}

	@GetMapping(params = {"pageNo", "pageSize"})
	public Flux<CustomerDocument> findCustomers(@RequestParam int pageNo,@RequestParam int pageSize) {
		return crmService.findAllByPage(pageNo,pageSize);
	}
	
	@PostMapping
	public Mono<CustomerDocument> acquireCustomer(@RequestBody CustomerDocument customer){
		return crmService.acquireCustomer(customer);
	}
	
	@PutMapping("{email}")
	public Mono<CustomerDocument> updateCustomer(@PathVariable String email,@RequestBody CustomerDocument customer){
		return crmService.updateCustomer(email,customer);
	}
	
	@DeleteMapping("{email}")
	public Mono<CustomerDocument> releaseCustomer(@PathVariable String email){
		return crmService.releaseCustomer(email);
	}
}
