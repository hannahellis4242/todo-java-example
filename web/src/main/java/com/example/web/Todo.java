package com.example.web;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "todo")
public class Todo {
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Id
	private String id;
	@JsonProperty(value="text", required=true)
	private String text;
	@JsonProperty(value="user",required=true)
	private String username;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}