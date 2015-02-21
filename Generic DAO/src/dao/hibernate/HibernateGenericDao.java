package dao.hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import dao.GenericDao;

/**
 * The Hibernate implementation for generic Data Access Objects.<br>
 * It contains implementation for common generic functions.
 * 
 * @author Ivan Zaitsau
 */
public abstract class HibernateGenericDao<E extends dao.Entity<PK>, PK extends Serializable> extends HibernateSessionFacadeAdapter implements GenericDao<E, PK> {

	@Override
	@SuppressWarnings("unchecked")
	public PK create(E entity) {
		return (PK) getSession().save(entity);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public E read(PK primaryKey) {
		return (E) getSession().get(getEntityClass(), primaryKey);
	}

	@Override
	public void update(E entity) {
		getSession().update(entity);
	}

	@Override
	public void delete(E entity) {
		getSession().delete(entity);		
	}

	@Override
	public void flush() {
		getSession().flush();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<E> find(Map<String, Object> properties) {
		Criteria criteria = getSession().createCriteria(getEntityClass());
		if (properties != null) {
			for (Entry<String, Object> entry : properties.entrySet()) {
				String propertyName = entry.getKey();
				Object value = entry.getValue();
				if (value == null) {
					criteria.add(Restrictions.isNull(propertyName));
				}
				else {
					criteria.add(Restrictions.eq(propertyName, value));
				}
			}			
		}
		return criteria.list();
	}
	
	/**
	 * Create {@link Criteria} instance for the default entity class
	 *
	 * @return Hibernate <tt>Criteria</tt> instance
	 */
	Criteria createCriteria() {
		return getSession().createCriteria(getEntityClass());
	}
}
