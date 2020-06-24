package edu.poly.spt.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {

	
	@RequestMapping("/home")
	public String list(ModelMap model, HttpSession session) {
	if(session.getAttribute("username")!=null) {
		return "layouts/adminHome";
	}
	return "layouts/adminLogin";
		
	}
}
