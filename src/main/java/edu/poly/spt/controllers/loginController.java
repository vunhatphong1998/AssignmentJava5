package edu.poly.spt.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.spt.services.loginService;

@Controller
public class loginController {

	@Autowired
	private loginService loginSV;
	
	@RequestMapping( value = "/login", method = RequestMethod.GET)
    public String checklogin(ModelMap model) {
    
        return "layouts/adminLogin";

    }
	
	
	@RequestMapping( value = "/checklogin", method = RequestMethod.POST)
    public String checklogin(ModelMap model, @RequestParam("username") String username, @RequestParam("pass") String pass , HttpSession session) {
       if (loginSV.checklogin(username, pass)) {
            System.out.print("Đăng nhập thành công");
            session.setAttribute("username", username);
            return "redirect:/home";
        } else {
            System.out.print("Đăng nhập thất bại");
            model.addAttribute("message","Bạn nhập sai thông tin đăng nhập");
        }
        return "layouts/adminLogin";

    }
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
			session.removeAttribute("username");
			return"redirect:/login";
	}
}
