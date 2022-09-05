package com.application.questions;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.application.quiz.Quiz;

@Entity 
@Table(name="question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sno;
	private String questionId;
	private String question_statement;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correctans;
	private int quizid;

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQuestion_statement() {
		return question_statement;
	}

	public void setQuestion_statement(String question_statement) {
		this.question_statement = question_statement;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectans() {
		return correctans;
	}

	public void setCorrectans(String correctans) {
		this.correctans = correctans;
	}
	
	public int getQuizid() {
		return quizid;
	}

	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}

	
	public Question() {
		super();
	}

	public Question(String questionId, String question_statement, String option1, String option2, String option3,
			String option4, String correctans, int quizid) {
		super();
		this.questionId = questionId;
		this.question_statement = question_statement;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctans = correctans;
		this.quizid = quizid;
	}
	
	
	
}
