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

import com.cognizant.policyproviderportal.dto.TermAndConditionDTO;


@Repository
public class TermAndConditionDAOImpl implements TermAndConditionDAOInt {

	private static Logger log = Logger.getLogger(TermAndConditionDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(TermAndConditionDTO dto) {
		log.info("TermAndConditionDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("TermAndConditionDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(TermAndConditionDTO dto) {
		log.info("TermAndConditionDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("TermAndConditionDAOImpl Delete method End");

	}

	@Override
	public TermAndConditionDTO findBypk(long pk) {
		log.info("TermAndConditionDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		TermAndConditionDTO dto = (TermAndConditionDTO) session.get(TermAndConditionDTO.class, pk);
		log.info("TermAndConditionDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public TermAndConditionDTO findByHeading(String heading) {
		log.info("TermAndConditionDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(TermAndConditionDTO.class);
		criteria.add(Restrictions.eq("heading", heading));
		TermAndConditionDTO dto = (TermAndConditionDTO) criteria.uniqueResult();
		log.info("TermAndConditionDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(TermAndConditionDTO dto) {
		log.info("TermAndConditionDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("TermAndConditionDAOImpl update method End");
	}

	@Override
	public List<TermAndConditionDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<TermAndConditionDTO> list(int pageNo, int pageSize) {
		log.info("TermAndConditionDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<TermAndConditionDTO> query = session.createQuery("from TermAndConditionDTO", TermAndConditionDTO.class);
		List<TermAndConditionDTO> list = query.getResultList();
		log.info("TermAndConditionDAOImpl List method End");
		return list;
	}

	@Override
	public List<TermAndConditionDTO> search(TermAndConditionDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<TermAndConditionDTO> search(TermAndConditionDTO dto, int pageNo, int pageSize) {
		log.info("TermAndConditionDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from TermAndConditionDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getHeading() != null && dto.getHeading().length() > 0) {
				hql.append("and u.heading like '%" + dto.getHeading() + "%'");
			}
		}
		Query<TermAndConditionDTO> query = session.createQuery(hql.toString(), TermAndConditionDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<TermAndConditionDTO> list = query.getResultList();
		log.info("TermAndConditionDAOImpl Search method End");
		return list;
	}

	
}
