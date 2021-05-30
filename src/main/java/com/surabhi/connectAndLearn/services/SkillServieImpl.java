package com.surabhi.connectAndLearn.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.surabhi.connectAndLearn.repos.SkillRepository;
import com.surabhi.connectAndLearn.repos.UserRepository;

public class SkillServieImpl implements SkillService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SkillRepository skillRepository;
	

}
