package com.cognizant.policyproviderportal.dao;

import java.util.List;

import com.cognizant.policyproviderportal.dto.TicketDTO;

public interface TicketDAOInt {

	public long add(TicketDTO dto);
	
	public void delete(TicketDTO dto);
	
	public TicketDTO findBypk(long pk);
	
	public TicketDTO findBySubject(String subject);
	
	public void update(TicketDTO dto);
	
	public List<TicketDTO> list();
	
	public List<TicketDTO>list(int pageNo,int pageSize);
	
	public List<TicketDTO> search(TicketDTO dto);
	
	public List<TicketDTO> search(TicketDTO dto,int pageNo,int pageSize);
	
	
}
