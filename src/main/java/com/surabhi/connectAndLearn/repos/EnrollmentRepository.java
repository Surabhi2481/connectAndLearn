package com.surabhi.connectAndLearn.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surabhi.connectAndLearn.entities.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

}
