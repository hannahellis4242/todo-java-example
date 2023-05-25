package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controler {
	@Autowired
	private Repository repository;
    @GetMapping("/")
    List<Todo> all() {
        return repository.findAll();
    }
    @PostMapping("/todo")
    void add(@RequestBody Todo x){
    	repository.save(x);
    }
}
