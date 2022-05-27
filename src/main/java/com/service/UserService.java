package com.service;

import java.util.List;

import com.exception.UserException;
import com.model.User;

public interface UserService {
	public abstract User createUser(User user) throws UserException;

	public abstract User readByUserIdAndPassword(int userId, String password) throws UserException;

	public abstract List<User> readUsers();

	public abstract User updateUser(User user) throws UserException;

	public abstract boolean deleteByUserId(int userId);
}
