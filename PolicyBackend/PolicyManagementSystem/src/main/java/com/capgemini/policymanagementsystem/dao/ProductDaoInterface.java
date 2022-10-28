package com.capgemini.policymanagementsystem.dao;

import java.util.List;

import com.capgemini.policymanagementsystem.entity.Product;
import com.capgemini.policymanagementsystem.expection.AdminException;

public interface ProductDaoInterface {

Product getProduct(int productId) throws AdminException;
	
	public List<Product> getProduct();
}
