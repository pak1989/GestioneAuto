package it.gestioneauto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import it.gestioneauto.model.Automobile;

@Component
public class AutomobileDAOImpl implements AutomobileDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Automobile> list() {
		return em.createQuery("from Automobile").getResultList();
	}

	@Override
	public Automobile get(long idInput) {
		Automobile result = (Automobile) em.find(Automobile.class, idInput);
		return result;
	}

	@Override
	public void update(Automobile automobileInstance) {
		automobileInstance = em.merge(automobileInstance);
	}

	@Override
	public void insert(Automobile automobileInstance) {
		em.persist(automobileInstance);
	}

	@Override
	public void delete(Automobile automobileInstance) {
		em.remove(em.merge(automobileInstance));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Automobile> findByExample(Automobile input) {
		Session session = (Session) em.getDelegate();
		
		@SuppressWarnings("serial")
		PropertySelector ps = new PropertySelector() {
			@Override
			public boolean include(Object object, String propertyName, Type type) {
				if (object == null)
					return false;
				// String
				if (object instanceof String)
					return StringUtils.isNotBlank((String) object);
				// Number
				if (object instanceof Integer)
					return ((Integer) object) != 0;
				return true;
			}
		};
		
		Example automobileExample = Example.create(input).setPropertySelector(ps);
		Criteria criteria = session.createCriteria(Automobile.class).add(automobileExample);
		return criteria.list();
	}

}
