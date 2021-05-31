package com.surabhi.connectAndLearn.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.surabhi.connectAndLearn.entities.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

	List<Enrollment> findAllByUserId(Long id);

	@Query(value = "Select distinct e.skill_name from enrollment e where (e.user_id = ?1 and e.acquired) or (e.instructor_id = ?1)", nativeQuery = true)
	List<String> fetchMySkills(Long id);
	
	List<Enrollment> findAllByInstructorId(Long instructorId);

}
