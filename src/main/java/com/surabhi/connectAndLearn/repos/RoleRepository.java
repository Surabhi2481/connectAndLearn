package com.surabhi.connectAndLearn.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surabhi.connectAndLearn.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String string);

}
