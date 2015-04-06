package cl.puntocontrol.hibernate.session;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionUtil {

	public static void closeSession(Session session) {
		try {
			if ((session != null) && (session.isOpen())) {
				session.close();
			}
		}
		catch (HibernateException he) {
		}
	}

	public static Session openSession()
		throws HibernateException {

		return getSessionFactory().openSession();
	}

	private static SessionFactory getSessionFactory()
	{
		if(_sessionFactory==null)
		{
			Configuration configuration = new Configuration();
			configuration=configuration.configure("resources/hibernate.cfg.xml");
			_sessionFactory = configuration.buildSessionFactory();
		}
		return _sessionFactory;
	}
	
	private HibernateSessionUtil() {
	}

	private static SessionFactory _sessionFactory;

}