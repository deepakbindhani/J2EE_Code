package com.cognizant.policyproviderportal.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="BUY_POLICY")
@Getter
@Setter
public class BuyPolicyDTO extends BaseDTO {

	@Column(name="POILICY_ID")
	private long poilicyId;
	@Column(name="POILICY_NAME",length = 225)
	private String policyName;
	@Column(name="ROI",length = 225)
	private String roi;
	@Column(name="DURATION",length = 225)
	private String duration;
	@Column(name="PRICE",length = 225)
	private String price;
	@Column(name="FIRST_NAME",length = 225)
	private String firstName;
	@Column(name="LAST_NAME",length = 225)
	private String lastName;
	@Column(name="EMAIL",length = 225)
	private String email;
	@Column(name="CONTACT_NO",length = 225)
	private String contactNo;
	@Column(name="DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column(name="RENEWAL_DATE")
	@Temporal(TemporalType.DATE)
	private Date renewalDate;
	@Column(name="BUY_DATE")
	@Temporal(TemporalType.DATE)
	private Date buyDate;
	@Column(name="USER_ID")
	private long userId;
	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
