package com.application.result;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ResultController {
	@Autowired
	private ResultRepository resultRepo;
	@RequestMapping("/viewresult")
	public ModelAndView viewres(Model m)
	{
		String username = "xyz";
		List<Result> r = resultRepo.findByUsername(username);
		m.addAttribute("results", r);
		
		return new ModelAndView("result");
	}
	
	@RequestMapping("/adminres")
	public ModelAndView adminres(Model m)
	{
		Iterable<Result> r= resultRepo.findAll();
		m.addAttribute("results", r);
		
		return new ModelAndView("result");
	}
	
	@RequestMapping("/saveres")
	public ModelAndView saveres(@RequestParam("score") int score,@RequestParam("name") String user,@RequestParam("quizname") String quizname,Model m )
	{
		Result r = new Result(user,quizname,score);
		resultRepo.save(r);
		Iterable<Result> res= resultRepo.findAll();
		m.addAttribute("results", res);
		
		return new ModelAndView("result");
	}
	@GetMapping("/admin/showresult")
	public Iterable<Result> showresult()
	{
		return resultRepo.findAll();
	}
	@GetMapping("/user/saveresult")
	public String saveresuser()
	{
		return "Answer Submitted";
	}
	@GetMapping("/user/viewresult")
	public Iterable<Result> viewresult()
	{
		return resultRepo.findAll();
	}
}
