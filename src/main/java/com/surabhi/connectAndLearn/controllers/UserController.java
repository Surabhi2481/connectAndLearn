package com.surabhi.connectAndLearn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.surabhi.connectAndLearn.entities.User;
import com.surabhi.connectAndLearn.repos.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/showReg")
	public String showRegistration() {
		return "login/register";
	}

	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		userRepository.save(user);
		return "login/login";
	}

}
