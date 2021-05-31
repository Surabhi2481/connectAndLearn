package com.surabhi.connectAndLearn.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.surabhi.connectAndLearn.entities.Skill;
import com.surabhi.connectAndLearn.repos.SkillRepository;
import com.surabhi.connectAndLearn.services.ProfileService;
import com.surabhi.connectAndLearn.services.SkillService;

@Controller
public class SkillController {
	
	@Autowired
	SkillRepository skillRepository;
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	SkillService skillService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/showSkillDetails")
	public String showSkillDetails(@RequestParam("skillName") String skillName, @RequestParam("userId") Long userId,
			ModelMap modelMap) {
		List<Skill> allSkills = skillRepository.findAllByName(skillName);
		for(Skill s : allSkills)
			LOGGER.info(s.toString());
		modelMap.addAttribute("allSkills", allSkills);
		modelMap.addAttribute("userId", userId);
		return "skill/skillDetails";
	}
	
	@RequestMapping("/showLearn")
	public String showLearn() {
		return "skill/searchHobby";
	}

	@RequestMapping(value = "/autocomplete")
	@ResponseBody
	public List<String> autoName(@RequestParam(value = "term", required = false, defaultValue = "") String term) {
		List<String> skillNames = skillService.getSkillName(term);
		return skillNames;
	}

}
