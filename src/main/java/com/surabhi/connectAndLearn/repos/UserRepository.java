package com.surabhi.connectAndLearn.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surabhi.connectAndLearn.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
