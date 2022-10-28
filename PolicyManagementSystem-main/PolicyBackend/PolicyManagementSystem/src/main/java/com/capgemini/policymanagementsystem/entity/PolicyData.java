package com.capgemini.policymanagementsystem.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;




@Entity
@Table(name="POLICYDATA")
public class PolicyData {

	@Id
	@Column(name = "POLICY_NUMBER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int policyNumber;
	
	@Column(name = "CUSTOMER_NAME", length = 25)
	private String customerName;
	
	@Column(name = "CUSTOMER_CONTACT", length = 25)
    private long customerContact;
	
	@Column(name = "CUSTOMER_EMAIL", length = 25)
	private String customerEmail;
	
	@Column(name = "CUSTOMER_DOB", length = 25)
	private Date customerDOB;
	
	@Column(name = "CUSTOMER_ADDRESSLINE", length = 25)
	private String customerAddressLine;

	@Column(name = "CUSTOMER_ADDRESSPINCODE")
	private long customerAddressPinCode;
	
	@Column(name = "CUSTOMER_ADDRESSCITY", length = 25)
	private String customerAddressCity;
	
	@Column(name = "CUSTOMER_ADDRESSCOUNTRY", length = 25)
	private String customerAddressCountry;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "PRODUCT_ID", referencedColumnName ="product_id")
	private Product product;

	
	
	


	public int getPolicyNumber() {
		return policyNumber;
	}



	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public long getCustomerContact() {
		return customerContact;
	}



	public void setCustomerContact(long customerContact) {
		this.customerContact = customerContact;
	}



	public String getCustomerEmail() {
		return customerEmail;
	}



	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}



	public Date getCustomerDOB() {
		return customerDOB;
	}



	public void setCustomerDOB(Date customerDOB) {
		this.customerDOB = customerDOB;
	}



	public String getCustomerAddressLine() {
		return customerAddressLine;
	}



	public void setCustomerAddressLine(String customerAddressLine) {
		this.customerAddressLine = customerAddressLine;
	}



	public long getCustomerAddressPinCode() {
		return customerAddressPinCode;
	}



	public void setCustomerAddressPinCode(long customerAddressPinCode) {
		this.customerAddressPinCode = customerAddressPinCode;
	}



	public String getCustomerAddressCity() {
		return customerAddressCity;
	}



	public void setCustomerAddressCity(String customerAddressCity) {
		this.customerAddressCity = customerAddressCity;
	}



	public String getCustomerAddressCountry() {
		return customerAddressCountry;
	}



	public void setCustomerAddressCountry(String customerAddressCountry) {
		this.customerAddressCountry = customerAddressCountry;
	}
	


	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}




     public PolicyData() {}



	public PolicyData(String customerName, long customerContact,
			String customerEmail, Date customerDOB, String customerAddressLine, long customerAddressPinCode,
			String customerAddressCity, String customerAddressCountry , Product product) {
		
		super();
		this.customerName = customerName;
		this.customerContact = customerContact;
		this.customerEmail = customerEmail;
		this.customerDOB = customerDOB;
		this.customerAddressLine = customerAddressLine;
		this.customerAddressPinCode = customerAddressPinCode;
		this.customerAddressCity = customerAddressCity;
		this.customerAddressCountry = customerAddressCountry;
		this.product = product;
	}


	@Override
	public String toString() {
		return "PolicyData [policyNumber=" + policyNumber +  ", customerName="
				+ customerName + ", customerContact=" + customerContact + ", customerEmail=" + customerEmail
				+ ", customerDOB=" + customerDOB + ", customerAddressLine=" + customerAddressLine
				+ ", customerAddressPinCode=" + customerAddressPinCode + ", customerAddressCity=" + customerAddressCity
				+ ", customerAddressCountry=" + customerAddressCountry + ", product=" + product + "]";
	}




}
