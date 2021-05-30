package com.surabhi.connectAndLearn.services;

import com.surabhi.connectAndLearn.entities.User;

public interface ProfileService {

	User updateProfile(User user, User newUser);

	User fetchUser();

}
