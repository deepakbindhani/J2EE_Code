package com.capgemini.policymanagementsystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.policymanagementsystem.entity.PolicyData;
import com.capgemini.policymanagementsystem.entity.Product;
import com.capgemini.policymanagementsystem.entity.User;
import com.capgemini.policymanagementsystem.expection.AdminException;

public interface PolicyManagementSystemServiceInterface {

	public boolean addPolicy(PolicyData policydata) throws AdminException;
	
	List<User> viewUser() throws AdminException;
	
	User viewUserByMail(String userMail);
	
    boolean existsByMail(String userMail) throws AdminException;

	int validateLogin(String userMail, String userPassword);

	List<Product> viewProduct() throws AdminException;
	
	List<PolicyData> viewPolicyData() throws AdminException;

	PolicyData getSearchData(int policyNumber) throws AdminException;

	public List<PolicyData> viewPolicyById(int policyNumber);
	
}
