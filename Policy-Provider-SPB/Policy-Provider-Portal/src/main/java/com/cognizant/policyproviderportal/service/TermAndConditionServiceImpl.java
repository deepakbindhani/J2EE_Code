package com.cognizant.policyproviderportal.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.policyproviderportal.dao.TermAndConditionDAOInt;
import com.cognizant.policyproviderportal.dto.TermAndConditionDTO;
import com.cognizant.policyproviderportal.exception.DuplicateRecordException;


@Service
public class TermAndConditionServiceImpl implements TermAndConditionServiceInt {

	private static Logger log = Logger.getLogger(TermAndConditionServiceImpl.class.getName());

	@Autowired
	private TermAndConditionDAOInt dao;

	@Autowired
	private JavaMailSenderImpl mailSender;

	@Override
	@Transactional
	public long add(TermAndConditionDTO dto) throws DuplicateRecordException {
		log.info("TermAndConditionServiceImpl Add method start");
		TermAndConditionDTO existDTO = dao.findByHeading(dto.getHeading());
		if (existDTO != null)
			throw new DuplicateRecordException("TermAndCondition Id Already Exist");
		long pk = dao.add(dto);
		log.info("TermAndConditionServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(TermAndConditionDTO dto) {
		log.info("TermAndConditionServiceImpl Delete method start");
		dao.delete(dto);
		log.info("TermAndConditionServiceImpl Delete method end");

	}

	@Override
	@Transactional
	public TermAndConditionDTO findBypk(long pk) {
		log.info("TermAndConditionServiceImpl findBypk method start");
		TermAndConditionDTO dto = dao.findBypk(pk);
		log.info("TermAndConditionServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public TermAndConditionDTO findByHeading(String heading) {
		log.info("TermAndConditionServiceImpl findByTermAndConditionName method start");
		TermAndConditionDTO dto = dao.findByHeading(heading);
		log.info("TermAndConditionServiceImpl findByTermAndConditionName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(TermAndConditionDTO dto) throws DuplicateRecordException {
		log.info("TermAndConditionServiceImpl update method start");
		TermAndConditionDTO existDTO = dao.findByHeading(dto.getHeading());
		if (existDTO != null && dto.getId() != existDTO.getId())
			throw new DuplicateRecordException("TermAndCondition Name Id Already Exist");
		dao.update(dto);
		log.info("TermAndConditionServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<TermAndConditionDTO> list() {
		log.info("TermAndConditionServiceImpl list method start");
		List<TermAndConditionDTO> list = dao.list();
		log.info("TermAndConditionServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<TermAndConditionDTO> list(int pageNo, int pageSize) {
		log.info("TermAndConditionServiceImpl list method start");
		List<TermAndConditionDTO> list = dao.list(pageNo, pageSize);
		log.info("TermAndConditionServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<TermAndConditionDTO> search(TermAndConditionDTO dto) {
		log.info("TermAndConditionServiceImpl search method start");
		List<TermAndConditionDTO> list = dao.search(dto);
		log.info("TermAndConditionServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<TermAndConditionDTO> search(TermAndConditionDTO dto, int pageNo, int pageSize) {
		log.info("TermAndConditionServiceImpl search method start");
		List<TermAndConditionDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("TermAndConditionServiceImpl search method end");
		return list;
	}

}
