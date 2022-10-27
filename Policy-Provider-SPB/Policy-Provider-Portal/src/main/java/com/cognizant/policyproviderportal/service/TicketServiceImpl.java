package com.cognizant.policyproviderportal.service;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.policyproviderportal.dao.TicketDAOInt;
import com.cognizant.policyproviderportal.dto.TicketDTO;
import com.cognizant.policyproviderportal.exception.DuplicateRecordException;


@Service
public class TicketServiceImpl implements TicketServiceInt {
	private static Logger log = Logger.getLogger(TicketServiceImpl.class.getName());

	@Autowired
	private TicketDAOInt dao;

	@Autowired
	private JavaMailSenderImpl mailSender;

	@Override
	@Transactional
	public long add(TicketDTO dto) throws DuplicateRecordException {
		log.info("TicketServiceImpl Add method start");
	
		long pk = dao.add(dto);
		log.info("TicketServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(TicketDTO dto) {
		log.info("TicketServiceImpl Delete method start");
		dao.delete(dto);
		log.info("TicketServiceImpl Delete method end");

	}

	@Override
	@Transactional
	public TicketDTO findBypk(long pk) {
		log.info("TicketServiceImpl findBypk method start");
		TicketDTO dto = dao.findBypk(pk);
		log.info("TicketServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public TicketDTO findBySubject(String name) {
		log.info("TicketServiceImpl findByTicketName method start");
		TicketDTO dto = dao.findBySubject(name);
		log.info("TicketServiceImpl findByTicketName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(TicketDTO dto) throws DuplicateRecordException {
		log.info("TicketServiceImpl update method start");
		dao.update(dto);
		log.info("TicketServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<TicketDTO> list() {
		log.info("TicketServiceImpl list method start");
		List<TicketDTO> list = dao.list();
		log.info("TicketServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<TicketDTO> list(int pageNo, int pageSize) {
		log.info("TicketServiceImpl list method start");
		List<TicketDTO> list = dao.list(pageNo, pageSize);
		log.info("TicketServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<TicketDTO> search(TicketDTO dto) {
		log.info("TicketServiceImpl search method start");
		List<TicketDTO> list = dao.search(dto);
		log.info("TicketServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<TicketDTO> search(TicketDTO dto, int pageNo, int pageSize) {
		log.info("TicketServiceImpl search method start");
		List<TicketDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("TicketServiceImpl search method end");
		return list;
	}

}
