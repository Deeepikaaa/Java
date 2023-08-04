package com.bdd.bddscenario.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bdd.bddscenario.entity.UserLoginEntity;
import com.bdd.bddscenario.exceptions.UserNotFoundException;
import com.bdd.bddscenario.repositories.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository repo;
	ModelMapper mapper = new ModelMapper();

	public UserLoginEntity addUser(UserLoginEntity user) {
		System.out.println("adding user details in database");
		return repo.save(user);
	}

	public Boolean checkForValidity(String userName, String password) {
		UserLoginEntity dbDetails = repo.findByUserNameAndPassword(userName, password);
		if (dbDetails == null) {

			throw new UserNotFoundException("Invalid Username or password");
		}

		System.out.println(dbDetails);
		return true;

	}

}
