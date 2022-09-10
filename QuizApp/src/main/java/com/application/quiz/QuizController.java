package com.application.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class QuizController {

	@Autowired
	private QuizRepository quizRepo;
	
	@RequestMapping("/addQuiz")
	public String addQuiz()
	{
		return "<html>"
				+ "<head>\n"
				+"</head>\n"
				+"<body>\n"
				+"<h1>Create Quiz</h1>\n"
				+"<form action=\"/saveQuiz\">\n"
				+"<h3>Enter Quiz ID:</h3>\n"
				+"<input type=\"text\" name=\"quizid\">\n"
				+"<br><br>\n"
				+"<h3>Enter Quiz Name:</h3>\n"
				+"<input type=\"text\" name=\"quizname\">\n"
				+"<br><br>\n"
				+"<input type=\"submit\" value=\"Create Quiz\">\n"
				+"</form>\n"
				+"</body>\n"
				+"</html>";
	}
	
	@RequestMapping("/saveQuiz")
	public String saveQuiz(@RequestParam("quizid") int quizid,@RequestParam("quizname") String quizname,Model m)
	{
		Quiz q = new Quiz(quizid,quizname);
		quizRepo.save(q);
		m.addAttribute("quizid",quizid);
		return "<html>"
				+"<h2>Quiz Created Successfully</h2>"
				+"<br><br>"
				+"<a href=\"addQuestion\">To Add Questions</a>"
				+"<br><br>"
				+"<a href=\"/adminlogin\">Back to Admin Dashboard</a>"
				+"</html>";
				
	}
	@GetMapping("/admin/addQuiz")
	public String addQuiz(@RequestBody Quiz q)
	{
		quizRepo.save(q);
		return "Quiz Added Successfully";
	}
	@GetMapping("/admin/editQuiz")
	public String editQuiz(@RequestBody Quiz q)
	{
		quizRepo.save(q);
		return "Quiz Edited Successfully";
	}
	@GetMapping("/admin/deleteQuiz")
	public String deleteQuiz(@RequestBody Quiz q)
	{
		quizRepo.delete(q);
		return "Quiz Deleted Successfully";
	}
	@GetMapping("/user/viewQuiz")
	public Iterable<Quiz> userQuiz()
	{
		return quizRepo.findAll();
	}
	public ModelAndView viewQuiz(Model m)
	{
		Iterable<Quiz> qlist = quizRepo.findAll();
		m.addAttribute("qlist",qlist);
		return new ModelAndView("viewquiz");
	}
}
