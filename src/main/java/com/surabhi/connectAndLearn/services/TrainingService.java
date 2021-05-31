package com.surabhi.connectAndLearn.services;

import java.util.List;

import com.surabhi.connectAndLearn.dto.Trainee;

public interface TrainingService {

	List<Trainee> getTrainees(Long userId);

}
