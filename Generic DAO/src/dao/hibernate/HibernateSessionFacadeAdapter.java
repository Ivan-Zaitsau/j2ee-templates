package dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import dao.util.hibernate.HibernateHelper;

/**
 * Contains facade methods related to Hibernate Session
 * 
 * @author Ivan Zaitsau
 */
public abstract class HibernateSessionFacadeAdapter {
	
	/**
	 * Obtains <i>current</i> Hibernate session.<br>
	 * The definition of what exactly "<i>current</i>" means is controlled by the
	 * {@link org.hibernate.context.spi.CurrentSessionContext} implementation configured for use.
	 * 
	 * @return current Hibernate session.
	 *
	 * @throws HibernateException Indicates an issue locating a suitable current session.
	 */
	protected Session getSession() {
        return HibernateHelper.getSession();
    }

}
