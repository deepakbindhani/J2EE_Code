package com.cognizant.policyproviderportal.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cognizant.policyproviderportal.dto.PolicyDTO;


@Repository
public class PolicyDAOImpl implements PolicyDAOInt {

	private static Logger log = Logger.getLogger(PolicyDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(PolicyDTO dto) {
		log.info("PolicyDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("PolicyDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(PolicyDTO dto) {
		log.info("PolicyDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("PolicyDAOImpl Delete method End");

	}

	@Override
	public PolicyDTO findBypk(long pk) {
		log.info("PolicyDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		PolicyDTO dto = (PolicyDTO) session.get(PolicyDTO.class, pk);
		log.info("PolicyDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public PolicyDTO findByName(String name) {
		log.info("PolicyDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(PolicyDTO.class);
		criteria.add(Restrictions.eq("name", name));
		PolicyDTO dto = (PolicyDTO) criteria.uniqueResult();
		log.info("PolicyDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(PolicyDTO dto) {
		log.info("PolicyDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("PolicyDAOImpl update method End");
	}

	@Override
	public List<PolicyDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<PolicyDTO> list(int pageNo, int pageSize) {
		log.info("PolicyDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<PolicyDTO> query = session.createQuery("from PolicyDTO", PolicyDTO.class);
		List<PolicyDTO> list = query.getResultList();
		log.info("PolicyDAOImpl List method End");
		return list;
	}

	@Override
	public List<PolicyDTO> search(PolicyDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<PolicyDTO> search(PolicyDTO dto, int pageNo, int pageSize) {
		log.info("PolicyDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from PolicyDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				hql.append("and u.name like '%" + dto.getName() + "%'");
			}
			if (dto.getCategory() != null && dto.getCategory().length() > 0) {
				hql.append("and u.category like '%" + dto.getCategory() + "%'");
			}
			
			if (dto.getRoi() != null && dto.getRoi().length() > 0) {
				hql.append("and u.roi like '%" + dto.getRoi() + "%'");
			}
		}
		Query<PolicyDTO> query = session.createQuery(hql.toString(), PolicyDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<PolicyDTO> list = query.getResultList();
		log.info("PolicyDAOImpl Search method End");
		return list;
	}

	
}
