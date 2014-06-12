package dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import dao.util.hibernate.HibernateHelper;

/**
 * 
 * @author Ivan Zaitsau
 */
public abstract class HibernateSessionFacadeAdapter {
	
	/**
	 * Obtains the current session.<br>
	 * The definition of what exactly "current" means controlled by the
	 * {@link org.hibernate.context.spi.CurrentSessionContext} impl configured for use.
	 * 
	 * @return The current session.
	 *
	 * @throws HibernateException Indicates an issue locating a suitable current session.
	 */
	protected Session getSession() {
        return HibernateHelper.getSession();
    }

}
