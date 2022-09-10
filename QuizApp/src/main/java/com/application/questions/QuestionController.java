package com.application.questions;

import java.util.List;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.application.quiz.Quiz;
import com.application.quiz.QuizRepository;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class QuestionController {

	int c=0;
	@Autowired
	private QuestionRepository qRepo;
	
	@GetMapping("/addQuestion")
	public String adminQues()
	{
		return "<html>\n"
				+"<body>\n"
				+"<form action = \"/saveQues\">\n"
				+"<h3>Enter QuizId:</h3>\n"
				+"<br><br>\n"
				+"<input type=\"text\" name=\"quizid\">\n"
				+"<h3>Enter QuestionId:</h3>\n"
				+"<br><br>\n"
				+"<input type=\"text\" name=\"quesid\">\n"
				+"<h3>Enter Question:</h3>\n"
				+"<br><br>\n"
				+"<input type=\"text\" name=\"ques\">\n"
				+"<h3>Enter Option-1:</h3>\n"
				+"<br><br>\n"
				+"<input type=\"text\" name=\"option1\">\n"
				+"<h3>Enter Option-2:</h3>\n"
				+"<br><br>\n"
				+"<input type=\"text\" name=\"option2\">\n"
				+"<h3>Enter Option-3:</h3>\n"
				+"<br><br>\n"
				+"<input type=\"text\" name=\"option3\">\n"
				+"<h3>Enter Option-4:</h3>\n"
				+"<br><br>\n"
				+"<input type=\"text\" name=\"option4\">\n"
				+"<h3>Enter Correct Answer:</h3>\n"
				+"<br><br>\n"
				+"<input type=\"text\" name=\"crtans\">\n"
				+"<br><br>\n"
				+"<input type=\"submit\" value=\"Submit Question\">\n"
				+"</form>\n"
				+"</body>\n"
				+"</html>";
	}
	@GetMapping("/saveQues")
	public String saveQues(@RequestParam("quesid") String quesId,@RequestParam("ques") String ques,@RequestParam("option1") String option1,@RequestParam("option2") String option2,@RequestParam("option3") String option3,@RequestParam("option4") String option4,@RequestParam("crtans") String crtans,@RequestParam("quizid") int qid)
	{
		Question question = new Question(quesId,ques,option1,option2,option3,option4,crtans,qid);
		qRepo.save(question);
		return "<h1>Question Added Successfully</h1>";
	}
	
	@GetMapping("/quizchoice")
	public ModelAndView questions(@RequestParam("qchoice") int choice,Model m)
	{
		m.addAttribute("choice", choice);
		List<Question> q = qRepo.findAllByQuizid(choice);
		m.addAttribute("queslist",q);
		return new ModelAndView("questions");
	}
	
	@GetMapping("/check")
	public String check(@RequestParam("ans") String ans,@RequestParam("cqid") String cqid,Model m)
	{
		
		Question q = qRepo.findByQuestionId(cqid);
		if(q.getCorrectans().equals(ans))
		{
			c++;
		}
		m.addAttribute("score" , c);
		return "<html>\n"
				+"<body>\n"
				+"<form action=\"saveres\">\n"
				+"<h3>Confirm Submission</h3>"
				+"<input type=\"hidden\" name=\"score\" value=\"1\">\n"
				+"<input type=\"hidden\" name=\"name\" value=\"user1\">\n"
				+"<input type=\"hidden\" name=\"quizname\" value=\"Maths\">\n"
				+"<input type=\"submit\">\n"
				+"</form>\n"
				+"</body>\n"
				+"</html>";
	}
	@GetMapping("/admin/addQuestion")
	public String addQuestion(@RequestBody Question q)
	{
		qRepo.save(q);
		return "Question added successfully";
	}
	@GetMapping("/admin/deleteQuestion")
	public String deleteQuestion(@RequestBody String qid)
	{
		qRepo.deleteByQuestionId(qid);
		return "Question Deleted";
	}
	@GetMapping("/user/viewquestions/{quizid}")
	public List<Question> viewques(@PathVariable int quizid)
	{
		return qRepo.findAllByQuizid(quizid);
	}
}
