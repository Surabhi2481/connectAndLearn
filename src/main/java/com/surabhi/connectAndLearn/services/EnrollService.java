package com.surabhi.connectAndLearn.services;

public interface EnrollService {
	
	public boolean enroll(String paymentGateway, Long skillId, Long userId);

}
