package com.main;

import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.exception.UserException;
import com.model.User;

public class LoginApp {

	private static final Logger LOGGER = LogManager.getLogger(LoginApp.class);

	public static void main(String[] args) {

		System.out.println("Enter user id  :");
		Scanner scanner = new Scanner(System.in);
		int useId = scanner.nextInt();
		LOGGER.info("Entered user id : " + useId);

		System.out.println("Enter user name : ");
		String name = scanner.next();
		LOGGER.info("Entered user name : " + name);

		System.out.println("Enter password :");
		String pwd = scanner.next();
		LOGGER.info("Entered password  : " + pwd);
		User user = new User();
		user.setUserId(useId);
		user.setUserName(name);
		user.setPassword(pwd);
		// interface var = new Impl()
		UserDao userDao = new UserDaoImpl();
		try {
			User user2 = userDao.createUser(user);
			System.out.println("Welcome :" + user2.getUserName());
		} catch (UserException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}

		// list all the user
		List<User> allUser = userDao.readUsers();
		for (User user2 : allUser) {
			LOGGER.info(user2.getUserId());
			LOGGER.info(user2.getUserName());
			LOGGER.info(user2.getPassword());
		}

		try {
			System.out.println("Enter user id to login :");
			int searchId = scanner.nextInt();
			System.out.println("Enter password to login:");
			String userPwd = scanner.next();
			User receive = userDao.readByUserIdAndPassword(searchId, userPwd);
			System.out.println("Seach :" + receive.getUserName());
		} catch (UserException e) {
			LOGGER.error(e.getMessage());
		}
	}

}
