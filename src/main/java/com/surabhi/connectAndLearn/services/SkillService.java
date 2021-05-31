package com.surabhi.connectAndLearn.services;

import java.util.List;

public interface SkillService {

	List<String> getSkillName(String term);

	List<String> fetchMySkills(Long id);

}
