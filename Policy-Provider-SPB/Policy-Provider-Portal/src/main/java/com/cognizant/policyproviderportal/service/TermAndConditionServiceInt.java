package com.cognizant.policyproviderportal.service;

import java.util.List;

import com.cognizant.policyproviderportal.dto.TermAndConditionDTO;
import com.cognizant.policyproviderportal.exception.DuplicateRecordException;


public interface TermAndConditionServiceInt {

	public long add(TermAndConditionDTO dto) throws DuplicateRecordException;

	public void delete(TermAndConditionDTO dto);

	public TermAndConditionDTO findBypk(long pk);

	public TermAndConditionDTO findByHeading(String heading);

	public void update(TermAndConditionDTO dto) throws DuplicateRecordException;

	public List<TermAndConditionDTO> list();

	public List<TermAndConditionDTO> list(int pageNo, int pageSize);

	public List<TermAndConditionDTO> search(TermAndConditionDTO dto);

	public List<TermAndConditionDTO> search(TermAndConditionDTO dto, int pageNo, int pageSize);





}
