package dao.factory;

import dao.EntityDao;

/**
 * The Factory for Data Access Objects Strategy (Abstract Factory Pattern).<br>
 * This factory produce Data Access Objects. See {@link HibernateDaoFactory} for example.
 *
 * @author Ivan Zaitsau
 */
public abstract class DaoFactory {

	public static final int HIBERNATE = 1;
	public static final int DEFAULT = HIBERNATE;
	
	private static DaoFactory HIBERNATE_DAO_FACTORY = new HibernateDaoFactory();

	/**
	 * This function produce default Data Access Objects Factory. For example <code>HibernateDaoFactory</code>.
	 * @return the default Data Access Objects Factory
	 */
	public static DaoFactory getInstance() {
		return getInstance(DEFAULT);
	}

	/**
	 * This function produce Data Access Objects Factory such as <code>HibernateDaoFactory</code>.
	 * @param factoryType the type of Data Access Objects implementation
	 * @return the Data Access Objects Factory of type <code>factoryType</code>
	 */
	public static DaoFactory getInstance(int factoryType) {
		switch (factoryType) {
		case HIBERNATE:
			return HIBERNATE_DAO_FACTORY;
		default:
			return null;
		}
	}
	
	/**
	 * @return <code>EntityDao</code> -  Data Access Object for <code>Entity</code> functions.
	 */
	public abstract EntityDao getEntityDao();

}
