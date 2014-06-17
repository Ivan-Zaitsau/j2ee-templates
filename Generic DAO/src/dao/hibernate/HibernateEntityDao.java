package dao.hibernate;

import java.io.Serializable;

import dao.EntityDao;
import dao.Entity;

/**
 * Hibernate-based implementation of {@link EntityDao} interface.
 * Contains methods common for all Hibernate entities.<br>
 * 
 * Can be used in case when the entity type is undefined, as a dispatcher, etc.
 * 
 * @author Ivan Zaitsau
 */
public class HibernateEntityDao extends HibernateSessionFacadeAdapter implements EntityDao {

	@Override
	@SuppressWarnings("unchecked")
	public <E extends Entity<PK>, PK extends Serializable> PK create(E entity) {
		return (PK) getSession().save(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <E extends Entity<PK>, PK extends Serializable> E read(Class<E> entityClass, PK id) {
		return (E) getSession().get(entityClass, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <E extends Entity<PK>, PK extends Serializable> E reload(Class<E> entityClass, PK id) {
		E entity = (E) getSession().get(entityClass, id);
		getSession().evict(entity);
		getSession().refresh(entity);
		return entity;
	}

}
