package com.abhinav.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.abhinav.bean.LoginBean;
import com.abhinav.bean.ResponseBean;
import com.abhinav.service.LoginService;

@Controller
public class LoginController {

	@GetMapping("/login")
	public ModelAndView loginRedirect() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");

		return mv;
	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("pass") String password) {

		LoginBean lb = new LoginBean();
		lb.setEmail(email);
		lb.setPass(password);

		LoginService ls = new LoginService();
		ResponseBean isLogin = ls.login(lb);

		ModelAndView mv = new ModelAndView();
		if (isLogin != null) {
			mv.setViewName("loginSuccessful");
			RedirectView redirectView = new RedirectView("/post", true);
			mv.setView(redirectView);
			mv.addObject("data", isLogin);
		} else {
			mv.setViewName("login");
			mv.addObject("error", "Wrong Credentials, Try Again!");
		}

		return mv;
	}
}
