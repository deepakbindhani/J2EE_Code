package com.cognizant.policyproviderportal.service;

import java.util.List;

import com.cognizant.policyproviderportal.dto.BuyPolicyDTO;
import com.cognizant.policyproviderportal.exception.DuplicateRecordException;


public interface BuyPolicyServiceInt {

	public long add(BuyPolicyDTO dto) throws DuplicateRecordException;

	public void delete(BuyPolicyDTO dto);

	public BuyPolicyDTO findBypk(long pk);

	public BuyPolicyDTO findByName(String name);
	
	public BuyPolicyDTO findByUserIdAndPolicyId(long uId,long pId);

	public void update(BuyPolicyDTO dto) throws DuplicateRecordException;

	public List<BuyPolicyDTO> list();

	public List<BuyPolicyDTO> list(int pageNo, int pageSize);

	public List<BuyPolicyDTO> search(BuyPolicyDTO dto);

	public List<BuyPolicyDTO> search(BuyPolicyDTO dto, int pageNo, int pageSize);





}
