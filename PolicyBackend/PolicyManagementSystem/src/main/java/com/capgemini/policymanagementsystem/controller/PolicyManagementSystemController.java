package com.capgemini.policymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.policymanagementsystem.entity.PolicyData;
import com.capgemini.policymanagementsystem.expection.AdminException;
import com.capgemini.policymanagementsystem.service.PolicyManagementSystemServiceInterface;



/************************************************************************************
 * @author Princy Pandey 
 * Description It is a controller class that process
 *         action for adding and searching policy
 * Version 1.0 
 * Created Date 20-JAN-2021
 ************************************************************************************/

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PolicyManagementSystemController {

	@Autowired
	private PolicyManagementSystemServiceInterface service;
	
	/************************************************************************************
	 * Method: getPolicy 
	 * Description: To get details of policy
	 * @param getPolicy Display policy details
	 * @throws AdminException 
	 * @mapping GetMapping Make HTTP request to get all policy
	 ************************************************************************************/

	@GetMapping("/getPolicy")
	public ResponseEntity<Object> getPolicy() throws AdminException {
		return new ResponseEntity<>(service.viewPolicyData(), HttpStatus.OK);
	}
	
	/************************************************************************************
	 * Method: addPolicy
	 * Description: To add details of policy
	 * 
	 * @param addPolicy Add policy details
	 * @mapping PostMapping Make HTTP request to post onto policy
	 * @throws  AdminException It is raised due to policy id not present
	 ************************************************************************************/

	@PostMapping("/addPolicy")
	public ResponseEntity<Object> addPolicy(@RequestBody PolicyData policydata) throws AdminException {

		try {
			service.addPolicy(policydata);
			return new ResponseEntity<>("Policy Added", HttpStatus.OK);
		} catch (DataIntegrityViolationException ex) {
			throw new AdminException("Policy already exists");
		}
	}
	
	/************************************************************************************
	 * Method: getProduct
	 * Description: To get details of product
	 * @param getProduct Display product details
	 * @throws AdminException 
	 * @mapping GetMapping Make HTTP request to get all product
	 ************************************************************************************/

	@GetMapping("/getProduct")
	public ResponseEntity<Object> getProduct() throws AdminException {
		return new ResponseEntity<>(service.viewProduct(), HttpStatus.OK);
	}
	
	
	
	/************************************************************************************
	 * Method: 				viewUsers 
	 * Description: 		To get details of user present
	 * @param viewUsers 	Display user details
	 * @mapping GetMapping 	Make HTTP request to get all user
	 ************************************************************************************/

	@GetMapping("/viewusers")
	public ResponseEntity<Object> viewUsers() throws AdminException {
		return new ResponseEntity<>(service.viewUser(), HttpStatus.OK);
	}

	/*******************************************************************************************
	 * Method: 					validateLogin 
	 * Description: 			To verify username and password.
	 * @param login 			Login the user into user/admin page according to the role.
	 * @mapping GetMapping 		Make HTTP request to get particular user.
	 ********************************************************************************************/

	@GetMapping("/login/{userMail}/{userPassword}")
	public int validateLogin(@PathVariable String userMail, @PathVariable String userPassword) {
		return service.validateLogin(userMail, userPassword);
	}
	
	
	@GetMapping("/searchpolicy/{policyId}")
	public PolicyData searchPolicy(@PathVariable int policyId) throws AdminException {
		PolicyData policyList=service.getSearchData(policyId);
		return policyList;
	}
	
	@GetMapping(value="/searchpolicybyid/{policyNumber}",produces= {"application/json"})
	public List<PolicyData> viewPolicyById(@PathVariable int policyNumber)
	{
	  return service.viewPolicyById(policyNumber);	
	}
	
	

	
}
