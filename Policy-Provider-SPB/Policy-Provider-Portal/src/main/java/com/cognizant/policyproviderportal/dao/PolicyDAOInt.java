package com.cognizant.policyproviderportal.dao;

import java.util.List;

import com.cognizant.policyproviderportal.dto.PolicyDTO;



public interface PolicyDAOInt {

	public long add(PolicyDTO dto);
	
	public void delete(PolicyDTO dto);
	
	public PolicyDTO findBypk(long pk);
	
	public PolicyDTO findByName(String Name);
	
	public void update(PolicyDTO dto);
	
	public List<PolicyDTO> list();
	
	public List<PolicyDTO>list(int pageNo,int pageSize);
	
	public List<PolicyDTO> search(PolicyDTO dto);
	
	public List<PolicyDTO> search(PolicyDTO dto,int pageNo,int pageSize);
	
	
}
