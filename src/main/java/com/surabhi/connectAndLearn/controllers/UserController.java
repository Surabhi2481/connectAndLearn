package com.surabhi.connectAndLearn.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.surabhi.connectAndLearn.entities.User;
import com.surabhi.connectAndLearn.repos.EnrollmentRepository;
import com.surabhi.connectAndLearn.repos.SkillRepository;
import com.surabhi.connectAndLearn.repos.UserRepository;
import com.surabhi.connectAndLearn.services.ProfileService;
import com.surabhi.connectAndLearn.services.SecurityService;
import com.surabhi.connectAndLearn.services.SkillService;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SkillRepository skillRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	SkillService skillService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private SecurityService securityService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	private User user;
	
	@RequestMapping("/showReg")
	public String showRegistration() {
		return "login/register";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		securityService.assignRoleToUser(user);
		return "login/login";
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		return "login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
			boolean loginResponse = securityService.login(email, password);
			if (loginResponse) {
				User user = userRepository.findByEmail(email);
				this.user = user;
			List<String> trendingSkills = skillRepository.fetchTrendingSkills();
			modelMap.addAttribute("trendingSkills", trendingSkills);
			List<String> mySkills = skillService.fetchMySkills(user.getId());
			modelMap.addAttribute("mySkills", mySkills);
			modelMap.addAttribute("userId", user.getId());
			return "dashboard";
		} else {
			modelMap.addAttribute("msg", "Invalid username or password. Please try again");
		}
		return "login/login";
	}
	
	@RequestMapping("/showProfile")
	public String showInstructorProfile(ModelMap modelMap) {
		modelMap.addAttribute("userDetails", user);
		return "profile/showProfile";
	}

	@RequestMapping("/showEditProfile")
	public String showEditProfile(ModelMap modelMap) {
		modelMap.addAttribute("userDetails", user);
		return "profile/editProfile";
	}	

	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public String updateProfile(@ModelAttribute("user") User user1, ModelMap modelMap) {
		LOGGER.info(user1.toString());
		user = userRepository.findById(user1.getId()).get();
		User updateUser = profileService.updateProfile(user, user1);
		modelMap.addAttribute("userDetails", updateUser);

		return "profile/showProfile";
	}
	
	@RequestMapping("/showDeleteProfile")
	public String showDeleteProfile() {
		return "profile/deleteProfile";
	}

	@RequestMapping("/deleteProfile")
	public String deleteProfile() {
		userRepository.deleteById(user.getId());
		return "profile/deletedSuccessfully";
	}
	
	@RequestMapping("/showDashboard")
	public String showDashboard(ModelMap modelMap) {
		List<String> trendingSkills = skillRepository.fetchTrendingSkills();
		modelMap.addAttribute("trendingSkills", trendingSkills);
		List<String> mySkills = skillService.fetchMySkills(user.getId());
		modelMap.addAttribute("mySkills", mySkills);
		modelMap.addAttribute("userId", user.getId());
		return "dashboard";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "login/login";
	}

}
