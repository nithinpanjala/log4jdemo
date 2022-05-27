package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.exception.UserException;
import com.model.User;

public class UserDaoImpl implements UserDao {

	// collecction = database
	private static List<User> list = new ArrayList();

	@Override
	public User createUser(User user) throws UserException {
		list.add(user);
		return user;
	}

	@Override
	public User readByUserIdAndPassword(int userId, String password) throws UserException {
		User userTemp = null;
		for (User user : list) {
			if (user.getUserId() == userId && user.getPassword().equals(password)) {
				userTemp = user;
			}

		}
		if (userTemp != null) {
			return userTemp;
		} else {
			throw new UserException("No such user");
		}

	}

	@Override
	public List<User> readUsers() {

		return list;
	}

	@Override
	public User updateUser(User user) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteByUserId(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

}
