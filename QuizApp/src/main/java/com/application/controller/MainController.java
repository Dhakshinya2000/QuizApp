package com.application.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MainController {

	@RequestMapping("/")
	public String homepage()
	{
		return "<html>"
				+ "<head>\n"
				+"</head>\n"
				+"<body>\n"
				+"<h1>Welcome To Quiz Portal</h1>\n"
				+"<a href=\"/admin\">Login as Admin</a>\n"
				+"<br><br>\n"
				+"<a href=\"/user\">Login as User</a>\n"
				+"<br><br>\n"
				+"</body>\n"
				+"</html>";
				
	}
}
