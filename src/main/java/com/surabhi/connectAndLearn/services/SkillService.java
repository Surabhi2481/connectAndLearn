package com.surabhi.connectAndLearn.services;

import java.util.List;

import com.surabhi.connectAndLearn.entities.Skill;

public interface SkillService {

	public List<String> getSkillName(String term);

	public List<String> fetchMySkills(Long id);

	public Skill addCourse(String name, String description, Float fee, Long instructorId);
	
	public Skill updateCourse(Skill course);
	
	public void rateCourse(Long ratingStars, Long skillId, Long enrollmentId);
	
	public List<String> fetchTrendingSkills();

	public List<Skill> findAllSkillsByName(String skillName);

	public List<Skill> findAllSkillsByInstructorId(Long instructorId);

	public Skill findSkillById(Long skillId);

	public void deleteSkillById(Long skillId);

}
