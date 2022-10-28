package com.capgemini.policymanagementsystem.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.policymanagementsystem.entity.PolicyData;
import com.capgemini.policymanagementsystem.entity.Product;
import com.capgemini.policymanagementsystem.expection.AdminException;

public interface AdminDaoInterface {

	public boolean addPolicy(PolicyData policy);

	
	
	public List<PolicyData> getPolicyById(int policyNumber);
	
	PolicyData getPolicyData(int policyNumber) throws AdminException;
	
	public List<PolicyData> getPolicyData();

	public PolicyData getSearchData(int policyNumber);


}
