package com.surabhi.connectAndLearn.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surabhi.connectAndLearn.repos.EnrollmentRepository;
import com.surabhi.connectAndLearn.repos.SkillRepository;
import com.surabhi.connectAndLearn.repos.UserRepository;

@Service
public class SkillServieImpl implements SkillService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SkillRepository skillRepository;
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Override
	public List<String> getSkillName(String term) {
		 return skillRepository.getSkillName(term);
	}

	@Override
	public List<String> fetchMySkills(Long userId) {
		Set<String> skillSet = new HashSet<String>();
		List<String> mySkillsFromEnrollmentRepo = enrollmentRepository.fetchMySkills(userId);
		 for(String se : mySkillsFromEnrollmentRepo)
			 skillSet.add(se);
		 List<String> mySkillsFromSkillRepo = skillRepository.fetchMySkills(userId);
		 for(String ss : mySkillsFromSkillRepo)
			 skillSet.add(ss);
		 List<String> listOfSkills = new ArrayList<String>(skillSet);
		return listOfSkills;
	}
	

}
