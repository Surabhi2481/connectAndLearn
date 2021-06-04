package com.surabhi.connectAndLearn.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.surabhi.connectAndLearn.dto.Trainee;
import com.surabhi.connectAndLearn.entities.Enrollment;
import com.surabhi.connectAndLearn.entities.Skill;
import com.surabhi.connectAndLearn.entities.User;
import com.surabhi.connectAndLearn.repos.EnrollmentRepository;
import com.surabhi.connectAndLearn.repos.SkillRepository;
import com.surabhi.connectAndLearn.repos.UserRepository;
import com.surabhi.connectAndLearn.services.EnrollService;
import com.surabhi.connectAndLearn.services.ProfileService;
import com.surabhi.connectAndLearn.services.TrainingService;

@Controller
public class EnrollmentController {

	@Autowired
	SkillRepository skillRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Autowired
	EnrollService enrollService;
	
	@Autowired
	TrainingService trainingService;
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	UserRepository userRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(EnrollmentController.class);

	@RequestMapping("/showEnroll")
	public String showEnroll(@RequestParam("skillId") Long skillId, ModelMap modelMap) {
		User user = profileService.fetchUser();
		Skill skill = skillRepository.findById(skillId).get();
		modelMap.addAttribute("skill", skill);
		return "enrollment/showEnroll";
	}
	
	@RequestMapping("/showCheckout")
	public String showCheckout(@RequestParam("skillId") Long skillId, ModelMap modelMap) {
		Skill skill = skillRepository.findById(skillId).get();
		if(skill.getFee() == 0.0) {
			User user = profileService.fetchUser();
			String paymentGateway = "No payment";
			boolean isEnrolled = enrollService.enroll(paymentGateway, skillId, user.getId());
			if(isEnrolled) {
				return "redirect:/enrollmentSuccessful";
			}
			else {
				return "redirect:/enrollmentUnsuccessful";			
			}
		}
		modelMap.addAttribute("skill", skill);
		return "enrollment/payment";
	}

	@RequestMapping(value= "/enroll", method = RequestMethod.POST)
	public String enroll(@RequestParam("skillId") Long skillId, @RequestParam("paymentGateway") String paymentGateway, ModelMap modelMap) {
		User user = profileService.fetchUser();
		boolean isEnrolled = enrollService.enroll(paymentGateway, skillId, user.getId());
		if(isEnrolled) {
			return "redirect:/enrollmentSuccessful";
		}
		else {
			return "redirect:/enrollmentUnsuccessful";		
		}
	}
	
	@RequestMapping("/enrollmentSuccessful")
	public String enrollmentSuccessful(){
		return "enrollment/enrollmentSuccessful";
	}

	@RequestMapping("/enrollmentUnsuccessful")
	public String enrollmentUnsuccessful(){
		return "enrollment/enrollmentUnsuccessful";
	}
	
	@RequestMapping("/showTrainees")
	public String showTrainees(ModelMap modelMap) {
		User user = profileService.fetchUser();
		List<Trainee> trainees = trainingService.getTrainees(user.getId());
		modelMap.addAttribute("trainees", trainees);
		return "enrollment/showTrainees";
	}

	@RequestMapping(value = "/setCompleted", method = RequestMethod.POST)
	public String setCompleted(@RequestParam("enrollmentId") Long enrollmentId, ModelMap modelMap) {
		LOGGER.info("enroll id" + enrollmentId.toString());
		trainingService.markAsTrained(enrollmentId);
		Long instructorId = enrollService.getInstructorId(enrollmentId);
		List<Trainee> trainees = trainingService.getTrainees(instructorId);
		modelMap.addAttribute("trainees", trainees);
		return "enrollment/showTrainees";
	}
	
	@RequestMapping("/showEnrollments")
	public String showEnrollments(@RequestParam("userId") Long userId, ModelMap modelMap) {
		List<Enrollment> enrollments = enrollmentRepository.findAllByUserId(userId);
		modelMap.addAttribute("enrollments", enrollments);
		return "enrollment/enrollments";
	}
	
	@RequestMapping("/contactInstructor")
	public String contactInstructor(@RequestParam("enrollmentId") Long enrollmentId, ModelMap modelMap) {
		String instructorContact = enrollService.fetchInstructorContact(enrollmentId);
		modelMap.addAttribute("instructorContactDetails", instructorContact);
		return "enrollment/contactInstructor";
	}
}
