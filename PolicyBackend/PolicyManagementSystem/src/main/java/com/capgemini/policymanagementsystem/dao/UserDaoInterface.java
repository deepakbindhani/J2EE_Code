package com.capgemini.policymanagementsystem.dao;

import java.util.List;

import com.capgemini.policymanagementsystem.entity.User;
import com.capgemini.policymanagementsystem.expection.AdminException;





/***************** Interface of User Dao ********************/

public interface UserDaoInterface {
	public List<User> getUser();

	User getUser(String userId) throws AdminException;

	boolean findMail(String userMail);

	boolean checkUserByMail(String email);

	User getUserByMail(String email);

	public int validateLogin(String userMail, String userPassword);

	int validateSecretWord(String userMail, String secretWord);

	User viewUserByMail(String userMail);
}
