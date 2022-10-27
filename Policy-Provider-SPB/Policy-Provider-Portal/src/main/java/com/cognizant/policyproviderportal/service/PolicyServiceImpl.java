package com.cognizant.policyproviderportal.service;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.policyproviderportal.dao.PolicyDAOInt;
import com.cognizant.policyproviderportal.dto.PolicyDTO;
import com.cognizant.policyproviderportal.exception.DuplicateRecordException;
import com.cognizant.policyproviderportal.util.EmailBuilder;

@Service
public class PolicyServiceImpl implements PolicyServiceInt {

	private static Logger log = Logger.getLogger(PolicyServiceImpl.class.getName());

	@Autowired
	private PolicyDAOInt dao;

	@Autowired
	private JavaMailSenderImpl mailSender;

	@Override
	@Transactional
	public long add(PolicyDTO dto) throws DuplicateRecordException {
		log.info("PolicyServiceImpl Add method start");
		PolicyDTO existDTO = dao.findByName(dto.getName());
		if (existDTO != null)
			throw new DuplicateRecordException("Policy Id Already Exist");
		long pk = dao.add(dto);
		log.info("PolicyServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(PolicyDTO dto) {
		log.info("PolicyServiceImpl Delete method start");
		dao.delete(dto);
		log.info("PolicyServiceImpl Delete method end");

	}

	@Override
	@Transactional
	public PolicyDTO findBypk(long pk) {
		log.info("PolicyServiceImpl findBypk method start");
		PolicyDTO dto = dao.findBypk(pk);
		log.info("PolicyServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public PolicyDTO findByName(String name) {
		log.info("PolicyServiceImpl findByPolicyName method start");
		PolicyDTO dto = dao.findByName(name);
		log.info("PolicyServiceImpl findByPolicyName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(PolicyDTO dto) throws DuplicateRecordException {
		log.info("PolicyServiceImpl update method start");
		PolicyDTO existDTO = dao.findByName(dto.getName());
		if (existDTO != null && dto.getId() != existDTO.getId())
			throw new DuplicateRecordException("Policy Name Id Already Exist");
		dao.update(dto);
		log.info("PolicyServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<PolicyDTO> list() {
		log.info("PolicyServiceImpl list method start");
		List<PolicyDTO> list = dao.list();
		log.info("PolicyServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<PolicyDTO> list(int pageNo, int pageSize) {
		log.info("PolicyServiceImpl list method start");
		List<PolicyDTO> list = dao.list(pageNo, pageSize);
		log.info("PolicyServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<PolicyDTO> search(PolicyDTO dto) {
		log.info("PolicyServiceImpl search method start");
		List<PolicyDTO> list = dao.search(dto);
		log.info("PolicyServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<PolicyDTO> search(PolicyDTO dto, int pageNo, int pageSize) {
		log.info("PolicyServiceImpl search method start");
		List<PolicyDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("PolicyServiceImpl search method end");
		return list;
	}

	


}
