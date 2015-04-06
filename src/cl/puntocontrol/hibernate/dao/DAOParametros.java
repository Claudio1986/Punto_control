package cl.puntocontrol.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import cl.puntocontrol.hibernate.domain.Parametros;
import cl.puntocontrol.hibernate.session.HibernateSessionUtil;



public class DAOParametros 
{
	public static Parametros get() throws Exception {
		Session session = null;
		try {
			session = HibernateSessionUtil.openSession();
			session.beginTransaction();
			Criteria criteria=session.createCriteria(Parametros.class);
			List list = criteria.list();
			session.getTransaction().commit();
			return (Parametros) list.get(0);
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		finally {
			HibernateSessionUtil.closeSession(session);
		}
	}
	public static void update(Parametros objeto) throws Exception {
		Session session = null;

		try {
			session = HibernateSessionUtil.openSession();
			session.beginTransaction();
			session.update(objeto);
			session.flush();
			session.getTransaction().commit();
		}
		catch (Exception e) {
			session.getTransaction().rollback();
			throw new Exception(e);
		}
		finally {
			HibernateSessionUtil.closeSession(session);
		}
	}

}
