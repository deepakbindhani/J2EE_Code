package com.capgemini.policymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.policymanagementsystem.entity.Product;
import com.capgemini.policymanagementsystem.expection.AdminException;

@Repository("productdao")
public class ProductDao implements ProductDaoInterface{

	@PersistenceContext
	 EntityManager em;
	
	@Override
	public Product getProduct(int productId) throws AdminException {
		// TODO Auto-generated method stub
		Product p= em.find(Product.class, productId);
		if(p==null)
			throw new AdminException("Policy Id doesnot exist"+ productId);
		return p;
		
	}
	
	@Override
	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		TypedQuery<Product> query = em.createQuery("from Product",Product.class);
		return query.getResultList();

		}
	
	
}
