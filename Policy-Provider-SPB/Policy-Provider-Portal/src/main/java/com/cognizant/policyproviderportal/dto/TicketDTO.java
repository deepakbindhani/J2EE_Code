package com.cognizant.policyproviderportal.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TICKET")
@Setter
@Getter
public class TicketDTO extends BaseDTO {

	@Column(name="ISSUE",length = 225)
	private String issue;
	@Column(name="TICKET_ID")
	private long ticketId;
	@Column(name="MESSAGE",length = 225)
	private String message;
	@Column(name="STATUS",length = 225)
	private String status;
	@Column(name="COMMENT",length = 225)
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="USER",nullable = false)
	private UserDTO user;
	
	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return issue;
	}

}
