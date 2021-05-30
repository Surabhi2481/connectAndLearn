package com.surabhi.connectAndLearn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.surabhi.connectAndLearn.repos.SkillRepository;
import com.surabhi.connectAndLearn.repos.UserRepository;

public class SkillServieImpl implements SkillService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SkillRepository skillRepository;
	
	@Override
	public List<String> getSkillName(String term) {
		 return skillRepository.getSkillName(term);
	}
	

}
