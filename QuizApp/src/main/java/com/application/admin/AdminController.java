package com.application.admin;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AdminController {

	@Autowired
	private AdminRepository adminRepo;
	
	@GetMapping("/admin")
	public String adminDash()
	{
		return "<html>"
				+ "<head>\n"
				+"</head>\n"
				+"<body>\n"
				+"<h1>Login As Admin</h1>\n"
				+"<form action=\"/adminlogin\">\n"
				+"<h3>Enter Admin Name:</h3>\n"
				+"<input type=\"text\" name=\"adminname\">\n"
				+"<br><br>\n"
				+"<h3>Enter Admin Password:</h3>\n"
				+"<input type=\"text\" name=\"adminpassword\">\n"
				+"<br><br>\n"
				+"<input type=\"submit\" value=\"Login\">\n"
				+"</form>\n"
				+"</body>\n"
				+"</html>";
	}
	
	@GetMapping(value = "/adminlogin")
	public String adminlogin(@RequestParam("adminname") String name, @RequestParam("adminpassword") String password)
	{
		Admin ad = adminRepo.findByName(name);
		System.out.println(ad.getName());
 		if(ad.getName().equals(name) && ad.getPassword().equals(password))
 		{
 		return "<html>\n"
				+ "<head>\n"
				+ "</head>\n"
				+ "<body>\n"
				+"<h1>Admin Dashboard</h1>\n"
				+"<a href=\"addQuiz\">Add Quiz</a>\n"
				+"<br><br>\n"
				+"<a href=\"adminQues\">Add Question</a>\n"
				+"<br><br>\n"
				+"<a href=\"addUser\">Add User</a>\n"
				+"<br><br>\n"
				+"<a href=\"adminres\">View Results</a>\n"
				+"</body>\n"
				+"</html>";
 		}
 		return "<html>\n"
 				+"<body>\n"
 				+"<h2>Invalid Login</h2>\n"
 				+"</body>\n"
 				+"</html>";
		
	}
	@GetMapping(value = "/adminloginapi")
	public String adminloginapi(@RequestBody Admin a)
	{
		Admin ad = adminRepo.findByName(a.getName());
		if(ad.getName().equals(a.getName()) && ad.getPassword().equals(a.getPassword()))
		{
			
			String accessToken="Ad8cvBC/54ts3QbvL0f0EVmtw6/Jkhu712";
			return "accessToken: "+accessToken;
		}
		return "Invalid Login";
	}
	@GetMapping(value = "/showadmin/{adminname}/{adminpass}")
	public Admin adlogin(@PathVariable String adminname,@PathVariable String adminpass)
	{
		return adminRepo.findByName(adminname);
	}
	@GetMapping("/admin/logout")
	public String adlogout()
	{
		return "Admin Logged Out";
	}
}
