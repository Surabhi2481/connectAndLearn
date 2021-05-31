package com.surabhi.connectAndLearn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.surabhi.connectAndLearn.dto.Trainee;
import com.surabhi.connectAndLearn.entities.Skill;
import com.surabhi.connectAndLearn.repos.SkillRepository;
import com.surabhi.connectAndLearn.services.EnrollService;
import com.surabhi.connectAndLearn.services.TrainingService;

@Controller
public class EnrollmentController {

	@Autowired
	SkillRepository skillRepository;
	
	@Autowired
	EnrollService enrollService;
	
	@Autowired
	TrainingService trainingService;
	
	Long userId;

	@RequestMapping("/showEnroll")
	public String showEnroll(@RequestParam("skillId") Long skillId,@RequestParam("userId") Long userId, ModelMap modelMap) {
		Skill skill = skillRepository.findById(skillId).get();
		modelMap.addAttribute("skill", skill);
		return "enrollment/showEnroll";
	}
	
	@RequestMapping("/showCheckout")
	public String showCheckout(@RequestParam("skillId") Long skillId, ModelMap modelMap) {
		Skill skill = skillRepository.findById(skillId).get();
		modelMap.addAttribute("skill", skill);
		return "enrollment/payment";
	}

	@RequestMapping("/enroll")
	public String enroll(@RequestParam("skillId") Long skillId, @RequestParam("paymentGateway") String paymentGateway, ModelMap modelMap) {
		boolean isEnrolled = enrollService.enroll(paymentGateway, skillId, userId);
		if(isEnrolled) {
			return "enrollment/enrollmentSuccessful";
		}
		else {
			return "enrollment/enrollmentUnsuccessful";			
		}
	}
	
	@RequestMapping("/showTrainees")
	public String showTrainees(@RequestParam("userId") Long userId, ModelMap modelMap) {
		List<Trainee> trainees = trainingService.getTrainees(userId);
		modelMap.addAttribute("trainees", trainees);
		return "enrollment/showTrainees";
	}

	@RequestMapping("/setCompleted")
	public String setCompleted() {

		return "";
	}
}
