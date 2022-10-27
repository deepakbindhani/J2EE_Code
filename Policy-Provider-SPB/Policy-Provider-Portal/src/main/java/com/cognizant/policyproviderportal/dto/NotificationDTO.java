package com.cognizant.policyproviderportal.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDTO {
	
	private String policyName;
	private Date renawalDate;
	private long policyId;
	private long buyPolicyId;
	
	public NotificationDTO(String policyName, Date renawalDate, long policyId, long buyPolicyId) {
		this.policyName = policyName;
		this.renawalDate = renawalDate;
		this.policyId = policyId;
		this.buyPolicyId = buyPolicyId;
	}
	
	
	

}
