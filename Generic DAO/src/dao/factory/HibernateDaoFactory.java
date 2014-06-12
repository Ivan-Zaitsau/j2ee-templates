package dao.factory;

import dao.EntityDao;
import dao.hibernate.HibernateEntityDao;

/**
 * 
 * @author Ivan Zaitsau
 */
public class HibernateDaoFactory extends DaoFactory {

	private static EntityDao HIBERNATE_ENTITY_DAO = new HibernateEntityDao();
	
	@Override
	public EntityDao getEntityDao() {
		return HIBERNATE_ENTITY_DAO;
	}

}
