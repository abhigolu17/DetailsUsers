package com.users.details.Service;

import java.util.List;
import java.util.Optional;

import com.users.details.Model.User;

public interface UserService {

	public User saveUser(User user);
	public List<User> getUsers();
	public User updateUser(int roll, User user);
	public void deleteUser(Integer roll);
	public Optional<User> getOneUser(int roll);
//	public void loginUser(User user);
	String checkUser(String name, String password);
//	User findByNameAndPassword(String name, String password);
}
