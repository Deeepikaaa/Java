package com.bdd.bddscenario.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bdd.bddscenario.entity.UserLoginEntity;

@Repository
public interface UserRepository extends JpaRepository<UserLoginEntity, Integer> {

	public Optional<UserLoginEntity> findById(Integer id);
	
	UserLoginEntity findByUserNameAndPassword(String userName, String password);
	
}
