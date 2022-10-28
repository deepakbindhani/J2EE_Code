package com.capgemini.policymanagementsystem.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capgemini.policymanagementsystem.dao.AdminDaoInterface;
import com.capgemini.policymanagementsystem.dao.ProductDaoInterface;
import com.capgemini.policymanagementsystem.dao.UserDaoInterface;
import com.capgemini.policymanagementsystem.entity.PolicyData;
import com.capgemini.policymanagementsystem.entity.Product;
import com.capgemini.policymanagementsystem.entity.User;
import com.capgemini.policymanagementsystem.expection.AdminException;



/************************************************************************************
 * @author       Princy Pandey 
 * Description : It is a service class that provides the services for adding  
 *               and searching policy 
 * Version     : 1.0 
 * Created Date: 20-JAN-2021
 ************************************************************************************/

@Transactional
@Service
public class PolicyManagementSystemService implements PolicyManagementSystemServiceInterface {

	
	@Autowired
	 AdminDaoInterface adi;
	
	@Autowired
	 ProductDaoInterface pdi;
	
	
	
	@Override
	public boolean addPolicy(PolicyData policydata) throws AdminException{
		// TODO Auto-generated method stub

		Product p=pdi.getProduct(policydata.getProduct().getProductId());
		PolicyData obj=new PolicyData(
				policydata.getCustomerName(),
				policydata.getCustomerContact(),
				policydata.getCustomerEmail(),
				policydata.getCustomerDOB(),
				policydata.getCustomerAddressLine(),
				policydata.getCustomerAddressPinCode(),
				policydata.getCustomerAddressCity(),
				policydata.getCustomerAddressCountry(),p);
		
		if(adi.addPolicy(obj))
			return true;
		else
			throw new AdminException("Cannot add policy");
	}
	 
	public List<PolicyData> viewPolicyById(int policyNumber)
	{
		List<PolicyData> pd=adi.getPolicyById(policyNumber);
		if(pd!=null)
		{
			return adi.getPolicyById(policyNumber);
		}
		else
		{
			System.out.println("No Data Found");
		}
		return pd;
	}


	@Autowired
	 UserDaoInterface userDaoInterface;

	/************************************************************************************
	 * Method: 					viewUser 
	 * Description: 			To view user registered
	 * @param viewUser 			Display user's details
	 * @throws UserException 	It is raised due to user id not present.
	 ************************************************************************************/

	@Override
	public List<User> viewUser() throws AdminException {
		// TODO Auto-generated method stub
		if (userDaoInterface.getUser() == null)
			throw new AdminException("User Id does not exist for ");
		else
			return userDaoInterface.getUser();
	}

	/************************************************************************************
	 * Method: 					existsByMail 
	 * Description: 			To check existed user by mail
	 * @param existsByMail 		Checks users.
	 * @throws UserException 	It is raised due to mail id not present
	 ************************************************************************************/

	@Override
	public boolean existsByMail(String userMail) throws AdminException {
		// TODO Auto-generated method stub
		if (userDaoInterface.findMail(userMail) == false)
			throw new AdminException("userMail doesn't exist");
		else
			return (userDaoInterface.findMail(userMail));
	}

	/************************************************************************************
	 * Method: 					viewUserByMail 
	 * Description: 			To view user registered by using mail
	 * @param viewUserByMail 	Display user's details
	 ************************************************************************************/

	@Override
	public User viewUserByMail(String userMail) {
		// TODO Auto-generated method stub
		User user = userDaoInterface.getUserByMail(userMail);
		return user;
	}



	/************************************************************************************
	 * Method: 					validateLogin 
	 * Description:	 			To login user registered
	 * @param validateLogin 	Login user into the userpage.
	 ************************************************************************************/

	@Override
	public int validateLogin(String userMail, String userPassword) {
		return userDaoInterface.validateLogin(userMail, userPassword);
	}

	
	
	@Override
	public List<Product> viewProduct() throws AdminException{
		// TODO Auto-generated method stub
		 if(pdi.getProduct() == null)
			 throw new AdminException("Policy does not exist for ");
		 else
			 return pdi.getProduct();
	}

	@Override
	public List<PolicyData> viewPolicyData() throws AdminException {
		// TODO Auto-generated method stub
		if (adi.getPolicyData() == null)
			throw new AdminException("Policy does not exist for ");
		else
			return adi.getPolicyData();
	}

	@Override
	public PolicyData getSearchData(int policyNumber) throws AdminException {
		// TODO Auto-generated method stub
		PolicyData pd=adi.getSearchData(policyNumber);
		if(pd==null)
		{
			throw new AdminException("Policy Not Found");
		}
		else
		{
			return pd;
		}
	}

	

	

	

}
