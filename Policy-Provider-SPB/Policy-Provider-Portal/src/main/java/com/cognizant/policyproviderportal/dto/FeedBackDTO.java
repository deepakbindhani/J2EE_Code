package com.cognizant.policyproviderportal.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="FEED_BACK")
@Setter
@Getter
public class FeedBackDTO extends  BaseDTO {

	@Column(name="SUBJECT",length = 225)
	private String subject;
	@Column(name="MESSAGE",length = 225)
	private String message;

	
	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return message;
	}

}
