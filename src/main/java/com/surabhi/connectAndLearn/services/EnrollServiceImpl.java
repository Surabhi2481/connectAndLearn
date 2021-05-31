package com.surabhi.connectAndLearn.services;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surabhi.connectAndLearn.entities.Enrollment;
import com.surabhi.connectAndLearn.entities.Skill;
import com.surabhi.connectAndLearn.repos.EnrollmentRepository;
import com.surabhi.connectAndLearn.repos.SkillRepository;
import com.surabhi.connectAndLearn.util.PaymentUtility;

@Service
public class EnrollServiceImpl implements EnrollService {

	@Autowired
	SkillRepository skillRepository;

	@Autowired
	EnrollmentRepository enrollmentRepository;

	@Autowired
	PaymentUtility paymentUtility;

	@Transactional
	@Override
	public boolean enroll(String paymentGateway, Long skillId, Long userId) {
		Skill skill = skillRepository.findById(skillId).get();
		String paymentDetails = paymentUtility.doPayment(paymentGateway, skill.getFee());
		if(paymentDetails != null) {
			Enrollment enrollment = new Enrollment();
			enrollment.setSkillId(skill.getId());
			enrollment.setSkillName(skill.getName());
			enrollment.setUserId(userId);
			enrollment.setInstructorId(skill.getInstructorId());
			enrollment.setInstructorName(skill.getInstructorName());
			enrollment.setDateEnrolled(new Date());			
			enrollment.setPaymentDetails(paymentDetails);
			enrollment.setAcquired(false);
			enrollmentRepository.save(enrollment);
			return true;
		}
		return false;
	}
	
	public Long getInstructorId(Long enrollmentId) {
		Enrollment enrollment = enrollmentRepository.findById(enrollmentId).get();
		return enrollment.getInstructorId();
	}

}
