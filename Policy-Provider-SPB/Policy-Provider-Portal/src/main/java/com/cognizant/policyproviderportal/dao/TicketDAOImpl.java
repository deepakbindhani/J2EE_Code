package com.cognizant.policyproviderportal.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.policyproviderportal.dto.TicketDTO;


@Repository
public class TicketDAOImpl implements TicketDAOInt {

	private static Logger log = Logger.getLogger(TicketDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(TicketDTO dto) {
		log.info("TicketDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("TicketDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(TicketDTO dto) {
		log.info("TicketDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("TicketDAOImpl Delete method End");

	}

	@Override
	public TicketDTO findBypk(long pk) {
		log.info("TicketDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		TicketDTO dto = (TicketDTO) session.get(TicketDTO.class, pk);
		log.info("TicketDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public TicketDTO findBySubject(String name) {
		log.info("TicketDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(TicketDTO.class);
		criteria.add(Restrictions.eq("issue",name));
		TicketDTO dto = (TicketDTO) criteria.uniqueResult();
		log.info("TicketDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(TicketDTO dto) {
		log.info("TicketDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("TicketDAOImpl update method End");
	}

	@Override
	public List<TicketDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<TicketDTO> list(int pageNo, int pageSize) {
		log.info("TicketDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<TicketDTO> query = session.createQuery("from TicketDTO", TicketDTO.class);
		List<TicketDTO> list = query.getResultList();
		log.info("TicketDAOImpl List method End");
		return list;
	}

	@Override
	public List<TicketDTO> search(TicketDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<TicketDTO> search(TicketDTO dto, int pageNo, int pageSize) {
		log.info("TicketDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from TicketDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getIssue() != null && dto.getIssue().length() > 0) {
				hql.append("and u.issue like '%" + dto.getIssue() + "%'");
			}
		}
		Query<TicketDTO> query = session.createQuery(hql.toString(), TicketDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<TicketDTO> list = query.getResultList();
		log.info("TicketDAOImpl Search method End");
		return list;
	}

	
}
