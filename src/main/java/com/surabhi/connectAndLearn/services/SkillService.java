package com.surabhi.connectAndLearn.services;

import java.util.List;

import com.surabhi.connectAndLearn.entities.Skill;

public interface SkillService {

	List<String> getSkillName(String term);

	List<String> fetchMySkills(Long id);

	public Skill addCourse(String name, String description, Float fee, Long instructorId);
	
	public Skill updateCourse(Skill course);

}
