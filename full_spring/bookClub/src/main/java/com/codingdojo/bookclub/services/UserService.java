package com.codingdojo.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User findUser(Long id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		
		return null;
	}

	public User register(User newUser, BindingResult result) {
		// Reject if email is taken
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "Exists", "That email is already in use!");
		}
		
		// Reject if password doesn't match confirmation
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		
		// Return null if result has errors
		if (result.hasErrors()) {
			return null;
		}
		
		// Hash and set password, save user to database
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);;
		userRepo.save(newUser);
		
		return newUser;
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		// Find user in the DB by email
		// Reject if NOT present
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		User user;
		if (potentialUser.isEmpty()) {
			result.rejectValue("email", "Non-existent", "No such account with that email!");
			return null;
		}
		
		user = potentialUser.get();

		// Reject if BCrypt password match fails
		if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
		
		// Return null if result has errors
		if (result.hasErrors()) {
			return null;
		}
		
		// Otherwise return the user object
		return user;
	}

}