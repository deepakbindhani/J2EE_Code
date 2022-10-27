package com.cognizant.policyproviderportal.dao;

import java.util.List;

import com.cognizant.policyproviderportal.dto.BuyPolicyDTO;



public interface BuyPolicyDAOInt {

	public long add(BuyPolicyDTO dto);
	
	public void delete(BuyPolicyDTO dto);
	
	public BuyPolicyDTO findBypk(long pk);
	
	public BuyPolicyDTO findByUserIdAndPolicyId(long uId,long pId);
	
	public BuyPolicyDTO findByName(String name);
	
	public void update(BuyPolicyDTO dto);
	
	public List<BuyPolicyDTO> list();
	
	public List<BuyPolicyDTO>list(int pageNo,int pageSize);
	
	public List<BuyPolicyDTO> search(BuyPolicyDTO dto);
	
	public List<BuyPolicyDTO> search(BuyPolicyDTO dto,int pageNo,int pageSize);
	
	
}
