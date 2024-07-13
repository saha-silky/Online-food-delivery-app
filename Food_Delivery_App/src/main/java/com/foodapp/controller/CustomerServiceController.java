package com.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.foodapp.exceptions.CustomerException;
import com.foodapp.model.Customer;
import com.foodapp.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerServiceController {
	
	@Autowired
	CustomerService customerService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws CustomerException{
		 Customer newCustomer = customerService.addCustomer(customer);
		 return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws CustomerException{
		 Customer updatedCustomer = customerService.updateCustomer(customer);
		 return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/remove/{customerId}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable("customerId") Integer customerId) throws CustomerException{
		 Customer removedCustomer = customerService.removeCustomerById(customerId);
		 return new ResponseEntity<Customer>(removedCustomer, HttpStatus.OK);
	}
	
	
	@GetMapping("/view/{customerId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("customerId") Integer customerId) throws CustomerException{
		 Customer customer = customerService.viewCustomer(customerId);
		 return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

}
