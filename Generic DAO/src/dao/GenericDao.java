package dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Root Entity Data Access Objects interface.
 * Provides definitions for all common Entity functions (CRUD functions).
 *
 * @param <E> generic Entity
 * @param <PK> Entity primary key
 * 
 * @author Ivan Zaitsau
 */
public interface GenericDao<E extends Entity<PK>, PK extends Serializable> {
	
	/**
	 * Make an entity instance managed and persistent
	 * @param entity
	 */
	PK create(E entity);
	
	/**
	 * Read entity by primary key.
	 * 
	 * @param primaryKey the Primary Key
	 * @return the found entity instance or null if the entity does not exist
	 */
	E read(PK primaryKey);
	
	/**
	 * Merge the state of the given entity into the current persistence context
	 * @param entity
	 */
	void update(E entity);
	
	/**
	 * Remove the entity instance
	 * @param entity
	 */
	void delete(E entity);
	
	/**
	 * Synchronize the persistence context to the underlying database
	 */
	void flush();
	
	/**
	 * Searches for entities with specific properties.<br>
	 * @param properties - a map from property names to values
	 * @return list of found entities
	 */
	List<E> find(Map<String, Object> properties);
	
	/**
	 * The function return the class of Entity implementation
	 * @return the Entity class
	 */
	Class<E> getEntityClass();
}
