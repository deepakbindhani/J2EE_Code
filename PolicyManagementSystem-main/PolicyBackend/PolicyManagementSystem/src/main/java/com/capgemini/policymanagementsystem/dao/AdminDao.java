
package com.capgemini.policymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import org.springframework.stereotype.Repository;

import com.capgemini.policymanagementsystem.entity.PolicyData;
import com.capgemini.policymanagementsystem.entity.Product;
import com.capgemini.policymanagementsystem.expection.AdminException;


/************************************************************************************
 * @author     Princy Pandey 
 * Description It is a dao class that provides the methods
 *             for adding and searching policy 
 * Version     1.0 
 * Created     20-JAN-2021
 ************************************************************************************/

@Repository("admindao")
public class AdminDao implements AdminDaoInterface{

	
	@PersistenceContext
	 EntityManager em;
	 

	/************************************************************************************
	 * Method: addPolicy
	 * Description: To add policy in policies
	 * @param addPolicy Adding policy
	 * @returns Boolean true, if policy added otherwise
	 ************************************************************************************/
	
	@Override
	public boolean addPolicy(PolicyData policy) {
		// TODO Auto-generated method stub
		em.persist(policy);
		return true;
	}

	

	/************************************************************************************
	 * Method: 					getProduct 
	 * Description: 			To get user detail by Id.
	 * @param getUser 			Get users details by Id. 
	 ************************************************************************************/
	
	

	@Override
	public PolicyData getPolicyData(int policyNumber) throws AdminException {
		// TODO Auto-generated method stub
		PolicyData pd=em.find(PolicyData.class, policyNumber);
		if(pd==null)
			throw new AdminException("Policy Id doesnot exist"+ policyNumber);
		return pd;
	}
	
	public List<PolicyData> getPolicyById(int policyNumber)
	{
		Query query=em.createQuery("select l from PolicyData l where l.policyNumber=:id");
		query.setParameter("id",policyNumber);
		@SuppressWarnings("unchecked")
		List<PolicyData> list=query.getResultList();
		return list;
	}



	@Override
	public List<PolicyData> getPolicyData() {
		// TODO Auto-generated method stub
		TypedQuery<PolicyData> query = em.createQuery("from PolicyData", PolicyData.class);
		return query.getResultList();	
		}



	@Override
	public PolicyData getSearchData(int policyNumber) {
		// TODO Auto-generated method stub
		return em.find(PolicyData.class,policyNumber);
		
	}

	
	
	
	

	
	
}


