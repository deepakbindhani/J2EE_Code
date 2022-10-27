package com.cognizant.policyproviderportal.form;

import javax.validation.constraints.NotEmpty;

import com.cognizant.policyproviderportal.dto.BaseDTO;
import com.cognizant.policyproviderportal.dto.PolicyDTO;
import com.cognizant.policyproviderportal.dto.TermAndConditionDTO;
import com.cognizant.policyproviderportal.dto.UserDTO;
import com.cognizant.policyproviderportal.util.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TermAndConditionForm extends BaseForm {

	@NotEmpty(message = "Heading is required")
	private String heading;
		
	@NotEmpty(message = "Description is required")
	private String description;
	
	
	
	@Override
	public BaseDTO getDTO() {
		TermAndConditionDTO bean=new TermAndConditionDTO();
		bean.setId(id);
		bean.setHeading(heading);
		bean.setDescription(description);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}
	
	@Override
	public void populate(BaseDTO baseBean) {
		TermAndConditionDTO bean=(TermAndConditionDTO)baseBean;
		id=bean.getId();
		heading=bean.getHeading();
		description=bean.getDescription();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}
}
