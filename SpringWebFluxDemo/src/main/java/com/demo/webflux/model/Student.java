package com.demo.webflux.model;

import java.util.ArrayList;
import java.util.HashMap;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "Student")
public class Student {
	@Id
	@JsonIgnore
	private String id;

	private Integer rollNo;

	@NotNull(message = "Name is not null")
	private String name;

	@NotNull(message = "Scores can not be empty")
	@JsonProperty("scores")
	private ArrayList<HashMap<String, Object>> scores;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<HashMap<String, Object>> getScores() {
		return scores;
	}

	public void setScores(ArrayList<HashMap<String, Object>> scores) {
		this.scores = scores;
	}

/*	public Scores getScores() {
		return scores;
	}

	public void setScores(Scores scores) {
		this.scores = scores;
	}*/

	
	
}
