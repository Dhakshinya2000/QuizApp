package com.application.user;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/user")
	public String userDash()
	{
		return "<html>"
				+ "<head>\n"
				+"</head>\n"
				+"<body>\n"
				+"<h1>User Login</h1>\n"
				+"<form action=\"/userlogin\">\n"
				+"<h3>Enter User Name:</h3>\n"
				+"<input type=\"text\" name=\"username\">\n"
				+"<br><br>\n"
				+"<h3>Enter User Password:</h3>\n"
				+"<input type=\"text\" name=\"userpassword\">\n"
				+"<br><br>\n"
				+"<input type=\"submit\" value=\"Login\">\n"
				+"</form>\n"
				+"<br><br>\n"
				+"<a href=\"register\">Click here to register as New User</a>\n"
				+"</body>\n"
				+"</html>";
	}
	@GetMapping("/userlogin")
	public String userlogin(@RequestParam("username") String name, @RequestParam("userpassword") String password,Model m)
	{
		User u = userRepo.findByName(name);
 		if(u.getName().equals(name) && u.getPassword().equals(password))
 		{
 			m.addAttribute("username",u.getName());
 			
 		return "<html>\n"
				+ "<head>\n"
				+ "</head>\n"
				+ "<body>\n"
				+"<h1>Welcome</h1>\n"
				+"<a href=\"viewQuiz\">Click here to view Quizzes</a>\n"
				+"<br><br>\n"
				+"<a href=\"viewresult\">Click here to view Results</a>\n"
				+"</body>\n"
				+"</html>";
 		}
 		return "<html>\n"
 				+"<body>\n"
 				+"<h2>Invalid Login</h2>\n"
 				+"</body>\n"
 				+"</html>";
		
	}
	
	@GetMapping(value ={"/register","/addUser"})
	public String newuser()
	{
		return "<html>"
				+ "<head>\n"
				+"</head>\n"
				+"<body>\n"
				+"<h1>New User Registration</h1>\n"
				+"<form action=\"/save\">\n"
				+"<h3>Enter New User Name:</h3>\n"
				+"<input type=\"text\" name=\"username\">\n"
				+"<br><br>\n"
				+"<h3>Enter User Password:</h3>\n"
				+"<input type=\"text\" name=\"userpassword\">\n"
				+"<br><br>\n"
				+"<input type=\"submit\" value=\"Register\">\n"
				+"</form>\n"
				+"</body>\n"
				+"</html>";
	}
	
	@GetMapping("/save")
	public String saveUser(@RequestParam("username") String username,@RequestParam("userpassword") String userpassword)
	{
		User u = new User(username,userpassword);
		userRepo.save(u);
		return "<h1>User Added Successfully</h1>";
	}
}
