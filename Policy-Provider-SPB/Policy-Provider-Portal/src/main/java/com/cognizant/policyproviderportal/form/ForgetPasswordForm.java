package com.cognizant.policyproviderportal.form;


import javax.validation.constraints.NotEmpty;

import com.cognizant.policyproviderportal.dto.BaseDTO;
import com.cognizant.policyproviderportal.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ForgetPasswordForm extends BaseForm {

	@NotEmpty(message = "User Name is required")
	private String email;
	
	@Override
	public BaseDTO getDTO() {
		UserDTO dto = new UserDTO();
		dto.setEmailId(email);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		
	}

}
