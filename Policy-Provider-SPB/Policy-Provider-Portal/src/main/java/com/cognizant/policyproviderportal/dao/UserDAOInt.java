package com.cognizant.policyproviderportal.dao;

import java.util.List;

import com.cognizant.policyproviderportal.dto.UserDTO;



public interface UserDAOInt {

	public long add(UserDTO dto);
	
	public void delete(UserDTO dto);
	
	public UserDTO findBypk(long pk);
	
	public UserDTO findByUserName(String userName);
	
	public void update(UserDTO dto);
	
	public List<UserDTO> list();
	
	public List<UserDTO>list(int pageNo,int pageSize);
	
	public List<UserDTO> search(UserDTO dto);
	
	public List<UserDTO> search(UserDTO dto,int pageNo,int pageSize);
	
	public UserDTO authentication(UserDTO dto);
	
}
