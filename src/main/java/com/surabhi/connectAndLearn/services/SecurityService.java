package com.surabhi.connectAndLearn.services;

import com.surabhi.connectAndLearn.entities.User;

public interface SecurityService {
	
	boolean login(String username, String password);

	void assignRoleToUser(User user);

}
