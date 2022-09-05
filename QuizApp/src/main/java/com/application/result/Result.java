package com.application.result;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="result")
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String quizname;
	private int score;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getQuizname() {
		return quizname;
	}
	public void setQuizname(String quizname) {
		this.quizname = quizname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Result(String username, String quizname, int score) {
		super();
		this.username = username;
		this.quizname = quizname;
		this.score = score;
	}
	public Result() {
		super();
	}
	
	
}
