package com.application.quiz;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.application.questions.Question;

@Entity
@Table(name="quiz")
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sno;
	private int quizId;
	private String quizname;

	
	public int getQuizId() {
		return quizId;
	}


	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}


	public String getQuizname() {
		return quizname;
	}


	public void setQuizname(String quizname) {
		this.quizname = quizname;
	}


	public Quiz(int quizId, String quizname) {
		super();
		this.quizId = quizId;
		this.quizname = quizname;
	}

	public Quiz() {
		super();
	}
	
	
}
