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
@Table(name="POLICY")
@Setter
@Getter
public class PolicyDTO extends BaseDTO {

	@Column(name="NAME",length = 225)
	private String name;
	@Column(name="PRICE",length = 225)
	private String price;
	@Column(name="DURATION",length = 225)
	private String duration;
	@Column(name="RATING",length = 225)
	private String rating;
	@Column(name="ROI",length = 225)
	private String roi;
	@Column(name="DESCRIPTION",length = 225)
	private String description;
	
	@Column(name="DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="CATEGORY",length = 225)
	private String category;

	@Override
	public String getKey() {
		return String.valueOf(id);
	}
	@Override
	public String getValue() {
		return name;
	}

}
