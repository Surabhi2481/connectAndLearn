package com.surabhi.connectAndLearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surabhi.connectAndLearn.entities.User;
import com.surabhi.connectAndLearn.repos.UserRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User updateProfile(User user, User newUser) {
		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());
		user.setDateOfBirth(newUser.getDateOfBirth());
		user.setGender(newUser.getGender());
		user.setCountry(newUser.getCountry());
		user.setPhoneNumber(newUser.getPhoneNumber());
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}

	@Override
	public User fetchUser() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
