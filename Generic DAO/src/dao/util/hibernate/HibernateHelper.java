package dao.util.hibernate;

/**
 * @author Ivan Zaitsau
 */
import java.util.Collection;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *  Produce the <code>SessionFactory</code>. Set up the <code>SessionFactory</code> if it doesn't exist.
 *  The <code>Configuration</code> and <code>SessionFactory</code> are immutable.
 */
public final class HibernateHelper {

    private static Configuration cfg;
    private static SessionFactory sessionFactory;

    /**
     * Produce the <code>SessionFactory</code>. Set up the <code>SessionFactory</code> if it doesn't exist.
     * 
     * @return immutable <code>SessionFactory</code>
     */
    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            configureSessionFactory();
        }

        return sessionFactory;
    }

    /**
     * Produce the <code>Configuration</code>. Set up the <code>Configuration</code> if it doesn't exist.
     * 
     * @return immutable <code>Configuration</code>
     */
    public synchronized static Configuration getConfiguration() {

        if (cfg == null) {
            cfg = new Configuration().configure();
        }
        
        return cfg;
    }
    
    /**
     * Returns current session associated with Hibernate working context.
     * Note: the current context is a thread. 
     * @return immutable <code>Session</code>
     */
    public static Session getSession() {
    	return getSessionFactory().getCurrentSession();
    }

    /**
     * Establish the <code>SessionFactory</code>.
     */
    private synchronized static void configureSessionFactory() {

		try {
			System.out.println(org.hibernate.Version.getVersionString());
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(getConfiguration().getProperties()).buildServiceRegistry();
			
			sessionFactory = getConfiguration().buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}

    }
    
    /**
     * Converts list to unique result (if applicable)
     * @param
     *     entities - list of entities
     * @return unique entity from the given list <br>or<br> null if list is empty 
     * @throws NonUniqueResultException if the given list contains two or more distinct elements
     */
    public static <E> E uniqueElement(Collection<E> entities) throws NonUniqueResultException {
		int size = entities.size();
		if (size == 0)
			return null;
		E first = entities.iterator().next();
		for (E entity : entities) {
			if (entity != first) {
				throw new NonUniqueResultException(size);
			}
		}
		return first;
	}

    private HibernateHelper() {}
}
