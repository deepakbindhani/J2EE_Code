package com.cognizant.policyproviderportal.dao;

import java.util.List;

import com.cognizant.policyproviderportal.dto.TermAndConditionDTO;


public interface TermAndConditionDAOInt {

	public long add(TermAndConditionDTO dto);
	
	public void delete(TermAndConditionDTO dto);
	
	public TermAndConditionDTO findBypk(long pk);
	
	public TermAndConditionDTO findByHeading(String heading);
	
	public void update(TermAndConditionDTO dto);
	
	public List<TermAndConditionDTO> list();
	
	public List<TermAndConditionDTO>list(int pageNo,int pageSize);
	
	public List<TermAndConditionDTO> search(TermAndConditionDTO dto);
	
	public List<TermAndConditionDTO> search(TermAndConditionDTO dto,int pageNo,int pageSize);
	
	
}
