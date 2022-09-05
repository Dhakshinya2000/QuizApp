package com.application.questions;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface QuestionRepository extends CrudRepository<Question, Integer>{


	List<Question> findAllByQuizid(int quizid);

	Question findByQuestionId(String questionid);


}
