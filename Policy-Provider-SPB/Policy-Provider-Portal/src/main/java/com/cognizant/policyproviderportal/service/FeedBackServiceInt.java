package com.cognizant.policyproviderportal.service;

import java.util.List;

import com.cognizant.policyproviderportal.dto.FeedBackDTO;
import com.cognizant.policyproviderportal.exception.DuplicateRecordException;


public interface FeedBackServiceInt {

	public long add(FeedBackDTO dto) throws DuplicateRecordException;

	public void delete(FeedBackDTO dto);

	public FeedBackDTO findBypk(long pk);

	public FeedBackDTO findBySubject(String name);

	public void update(FeedBackDTO dto) throws DuplicateRecordException;

	public List<FeedBackDTO> list();

	public List<FeedBackDTO> list(int pageNo, int pageSize);

	public List<FeedBackDTO> search(FeedBackDTO dto);

	public List<FeedBackDTO> search(FeedBackDTO dto, int pageNo, int pageSize);





}
