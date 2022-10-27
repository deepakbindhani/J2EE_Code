package com.cognizant.policyproviderportal.service;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.policyproviderportal.dao.BuyPolicyDAOInt;
import com.cognizant.policyproviderportal.dto.BuyPolicyDTO;
import com.cognizant.policyproviderportal.exception.DuplicateRecordException;


@Service
public class BuyPolicyServiceImpl implements BuyPolicyServiceInt {
	private static Logger log = Logger.getLogger(BuyPolicyServiceImpl.class.getName());

	@Autowired
	private BuyPolicyDAOInt dao;

	@Autowired
	private JavaMailSenderImpl mailSender;

	@Override
	@Transactional
	public long add(BuyPolicyDTO dto) throws DuplicateRecordException {
		log.info("BuyPolicyServiceImpl Add method start");
	
		long pk = dao.add(dto);
		log.info("BuyPolicyServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(BuyPolicyDTO dto) {
		log.info("BuyPolicyServiceImpl Delete method start");
		dao.delete(dto);
		log.info("BuyPolicyServiceImpl Delete method end");

	}

	@Override
	@Transactional
	public BuyPolicyDTO findBypk(long pk) {
		log.info("BuyPolicyServiceImpl findBypk method start");
		BuyPolicyDTO dto = dao.findBypk(pk);
		log.info("BuyPolicyServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public BuyPolicyDTO findByName(String name) {
		log.info("BuyPolicyServiceImpl findByBuyPolicyName method start");
		BuyPolicyDTO dto = dao.findByName(name);
		log.info("BuyPolicyServiceImpl findByBuyPolicyName method end");
		return dto;
	}
	
	@Override
	@Transactional
	public BuyPolicyDTO findByUserIdAndPolicyId(long uId,long pId) {
		log.info("BuyPolicyServiceImpl findByBuyPolicyName method start");
		BuyPolicyDTO dto = dao.findByUserIdAndPolicyId(uId, pId);
		log.info("BuyPolicyServiceImpl findByBuyPolicyName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(BuyPolicyDTO dto) throws DuplicateRecordException {
		log.info("BuyPolicyServiceImpl update method start");
		dao.update(dto);
		log.info("BuyPolicyServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<BuyPolicyDTO> list() {
		log.info("BuyPolicyServiceImpl list method start");
		List<BuyPolicyDTO> list = dao.list();
		log.info("BuyPolicyServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<BuyPolicyDTO> list(int pageNo, int pageSize) {
		log.info("BuyPolicyServiceImpl list method start");
		List<BuyPolicyDTO> list = dao.list(pageNo, pageSize);
		log.info("BuyPolicyServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<BuyPolicyDTO> search(BuyPolicyDTO dto) {
		log.info("BuyPolicyServiceImpl search method start");
		List<BuyPolicyDTO> list = dao.search(dto);
		log.info("BuyPolicyServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<BuyPolicyDTO> search(BuyPolicyDTO dto, int pageNo, int pageSize) {
		log.info("BuyPolicyServiceImpl search method start");
		List<BuyPolicyDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("BuyPolicyServiceImpl search method end");
		return list;
	}

}
