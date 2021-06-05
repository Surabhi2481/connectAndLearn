package com.surabhi.connectAndLearn.services;

import com.surabhi.connectAndLearn.entities.User;

public interface ProfileService {

	public User updateProfile(User user, User newUser);

	public User fetchUser();
	
	public User saveUser(User user);

	public void deleteUserById(Long id);

}
