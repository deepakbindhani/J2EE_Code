package com.cognizant.policyproviderportal.form;

import javax.validation.constraints.NotEmpty;

import com.cognizant.policyproviderportal.dto.BaseDTO;
import com.cognizant.policyproviderportal.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm extends BaseForm {

	@NotEmpty(message = "UserName is required")
	private String userName;
	@NotEmpty(message = "Password is required")
	private String password;
	

	@Override
	public BaseDTO getDTO() {
		UserDTO bean=new UserDTO();
		bean.setUserName(userName);
		bean.setPassword(password);
		return bean;
	}

	@Override
	public void populate(BaseDTO bdto) {
		UserDTO entity=(UserDTO) bdto;
		userName=entity.getUserName();
		password=entity.getPassword();
	}

}
