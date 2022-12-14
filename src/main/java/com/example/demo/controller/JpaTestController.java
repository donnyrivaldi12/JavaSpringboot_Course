package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@RestController
public class JpaTestController {

    @Autowired
    CustomerRepository repository;
    
    @GetMapping("/init")
    public void init() {
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));
    }

    @GetMapping("/all")
    public List<Customer> all() {
        return repository.findAll();
    }
    @GetMapping("/id")
    public Customer id(long id) {
        return repository.findById(id);
    }
    @GetMapping("/lastname")
    public List<Customer> lastName(String lastName) {
        return repository.findByLastName(lastName);
    }
}
