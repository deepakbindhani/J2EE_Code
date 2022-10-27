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

import com.cognizant.policyproviderportal.dto.BuyPolicyDTO;


@Repository
public class BuyPolicyDAOImpl implements BuyPolicyDAOInt {

	private static Logger log = Logger.getLogger(BuyPolicyDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(BuyPolicyDTO dto) {
		log.info("BuyPolicyDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("BuyPolicyDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(BuyPolicyDTO dto) {
		log.info("BuyPolicyDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("BuyPolicyDAOImpl Delete method End");

	}

	@Override
	public BuyPolicyDTO findBypk(long pk) {
		log.info("BuyPolicyDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		BuyPolicyDTO dto = (BuyPolicyDTO) session.get(BuyPolicyDTO.class, pk);
		log.info("BuyPolicyDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public BuyPolicyDTO findByName(String name) {
		log.info("BuyPolicyDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(BuyPolicyDTO.class);
		criteria.add(Restrictions.eq("firstName",name));
		BuyPolicyDTO dto = (BuyPolicyDTO) criteria.uniqueResult();
		log.info("BuyPolicyDAOImpl FindByLogin method End");
		return dto;
	}
	
	@Override
	public BuyPolicyDTO findByUserIdAndPolicyId(long uId,long pId) {
		log.info("BuyPolicyDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(BuyPolicyDTO.class);
		criteria.add(Restrictions.eq("userId",uId));
		criteria.add(Restrictions.eq("poilicyId",pId));
		BuyPolicyDTO dto = (BuyPolicyDTO) criteria.uniqueResult();
		log.info("BuyPolicyDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(BuyPolicyDTO dto) {
		log.info("BuyPolicyDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("BuyPolicyDAOImpl update method End");
	}

	@Override
	public List<BuyPolicyDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<BuyPolicyDTO> list(int pageNo, int pageSize) {
		log.info("BuyPolicyDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<BuyPolicyDTO> query = session.createQuery("from BuyPolicyDTO", BuyPolicyDTO.class);
		List<BuyPolicyDTO> list = query.getResultList();
		log.info("BuyPolicyDAOImpl List method End");
		return list;
	}

	@Override
	public List<BuyPolicyDTO> search(BuyPolicyDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<BuyPolicyDTO> search(BuyPolicyDTO dto, int pageNo, int pageSize) {
		log.info("BuyPolicyDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from BuyPolicyDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getUserId() > 0) {
				hql.append("and u.userId = " + dto.getUserId());
			}
			if (dto.getPolicyName() != null && dto.getPolicyName().length() > 0) {
				hql.append("and u.policyName like '%" + dto.getPolicyName() + "%'");
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				hql.append("and u.firstName like '%" + dto.getFirstName() + "%'");
			}
		}
		Query<BuyPolicyDTO> query = session.createQuery(hql.toString(), BuyPolicyDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<BuyPolicyDTO> list = query.getResultList();
		log.info("BuyPolicyDAOImpl Search method End");
		return list;
	}

	
}
