package com.cognizant.policyproviderportal.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TERM_CONDITION")
@Getter
@Setter
public class TermAndConditionDTO extends BaseDTO {

	
	@Column(name="HEADIING",length = 225)
	private String heading;

	@Column(name="DESCRIPTION",length = 225)
	private String description;
	
	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return heading;
	}
	
}
