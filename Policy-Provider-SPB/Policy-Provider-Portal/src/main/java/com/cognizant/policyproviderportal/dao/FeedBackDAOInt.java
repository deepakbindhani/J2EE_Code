package com.cognizant.policyproviderportal.dao;

import java.util.List;

import com.cognizant.policyproviderportal.dto.FeedBackDTO;

public interface FeedBackDAOInt {

	public long add(FeedBackDTO dto);
	
	public void delete(FeedBackDTO dto);
	
	public FeedBackDTO findBypk(long pk);
	
	public FeedBackDTO findBySubject(String subject);
	
	public void update(FeedBackDTO dto);
	
	public List<FeedBackDTO> list();
	
	public List<FeedBackDTO>list(int pageNo,int pageSize);
	
	public List<FeedBackDTO> search(FeedBackDTO dto);
	
	public List<FeedBackDTO> search(FeedBackDTO dto,int pageNo,int pageSize);
	
	
}
