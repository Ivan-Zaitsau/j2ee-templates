package dao;

import java.io.Serializable;

import dao.Entity;

/**
 * EntityDAO interface with methods common for all the entities.<br>
 * Ought to be used in case when the entity type is undefined, as a dispatcher, etc.
 * 
 * @author Ivan Zaitsau
 */
public interface EntityDao {

	<E extends Entity<PK>, PK extends Serializable> PK create(E entity);
	
	<E extends Entity<PK>, PK extends Serializable> E read(Class<E> entityClass, PK id);
	
	<E extends Entity<PK>, PK extends Serializable> E reload(Class<E> entityClass, PK id);
}
