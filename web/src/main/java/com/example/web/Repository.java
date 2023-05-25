package com.example.web;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Todo, String> {
    // Add custom query methods if needed
}