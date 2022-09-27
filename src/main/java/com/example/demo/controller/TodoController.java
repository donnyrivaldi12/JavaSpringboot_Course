package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Todo;

@RestController
public class TodoController {

    @Autowired
    RestTemplate restTemplate;
    
    @GetMapping("/todo")
    Todo getTodo(){
        Todo todo = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", Todo.class);

        return todo;
    }
}
