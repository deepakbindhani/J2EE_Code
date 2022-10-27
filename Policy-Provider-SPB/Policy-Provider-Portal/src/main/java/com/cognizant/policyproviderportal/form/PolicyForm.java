package com.cognizant.policyproviderportal.form;

import javax.validation.constraints.NotEmpty;

import com.cognizant.policyproviderportal.dto.BaseDTO;
import com.cognizant.policyproviderportal.dto.PolicyDTO;
import com.cognizant.policyproviderportal.dto.UserDTO;
import com.cognizant.policyproviderportal.util.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PolicyForm extends BaseForm {

	@NotEmpty(message = "Name is required")
	private String name;
	
	@NotEmpty(message = "Price is required")
	private String price;
	
	@NotEmpty(message = "Duration is required")
	private String duration;
	
	@NotEmpty(message = "Rating is required")
	private String rating;
	
	@NotEmpty(message = "ROI  is required")
	private String roi;
	
	@NotEmpty(message = "Description is required")
	private String description;
	
	@NotEmpty(message = "Category is required")
	private String category;
	
	@NotEmpty(message = "Renewal Last Date is required")
	private String date;
	
	
	@Override
	public BaseDTO getDTO() {
		PolicyDTO bean=new PolicyDTO();
		bean.setId(id);
		bean.setCategory(category);
		bean.setName(name);
		bean.setPrice(price);
		bean.setDuration(duration);
		bean.setRating(rating);
		bean.setDate(DataUtility.getDate(date));
		bean.setRoi(roi);
		bean.setDescription(description);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}
	
	@Override
	public void populate(BaseDTO baseBean) {
		PolicyDTO bean=(PolicyDTO)baseBean;
		id=bean.getId();
		name=bean.getName();
		date=DataUtility.getDateString(bean.getDate());
		category=bean.getCategory();
		price=bean.getPrice();
		duration=bean.getDuration();
		rating=bean.getRating();
		roi=bean.getRoi();
		description=bean.getDescription();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}
}
