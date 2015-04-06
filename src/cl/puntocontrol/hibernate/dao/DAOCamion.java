package cl.puntocontrol.hibernate.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import cl.puntocontrol.hibernate.domain.Camion;
import cl.puntocontrol.hibernate.session.HibernateSessionUtil;



public class DAOCamion  
{
	private static Log _log=LogFactory.getLog(DAOCamion.class);
	
	public static void delete(String cam_patente) throws Exception {
		Session session = null;

		try {
			session = HibernateSessionUtil.openSession();
			session.beginTransaction();
			Camion camion = (Camion)session.get(
					Camion.class, cam_patente);
			if (camion != null) {
				session.delete(camion);
				session.flush();
			}
			session.getTransaction().commit();
		}
		catch (Exception e) {
			session.getTransaction().rollback();
		}
		finally {
			HibernateSessionUtil.closeSession(session);
		}
	}
	/* 
	 * Metodo que agrega un objeto a la base de datos. Agrega una tupla completa de la base de datos
	 * Similar a escribir "insert into tabla (a,b,c,d,e,f) values (u,v,w,x,y,z);"
	 * 
	 */
	public static void add(Camion objeto) throws Exception {
		Session session = null;
		try {
			session = HibernateSessionUtil.openSession();
			session.beginTransaction();
			session.save(objeto);
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
	
	/* 
	 * Método que trae un objeto completo, es decir, trae una tupla completa
	 * Similar a escribir "Select * from tabla where campo=XXX";
	 * 
	 */
	public static Camion get(String cam_patente) throws Exception {
		Session session = null;

		try {
			session = HibernateSessionUtil.openSession();
			session.beginTransaction();
			Camion objeto = (Camion)session.get(
					Camion.class, cam_patente);
			session.getTransaction().commit();
			return objeto;
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		finally {
			HibernateSessionUtil.closeSession(session);
		}
	}
	/* 
	 * Método que trae una lista de objetos completo, es decir, trae una lista de tuplas
	 * Similar a escribir "Select * from tabla where campo like XXX% and campos like YYY%";
	 * 
	 */
	public static List<Camion> list(String cam_patente) throws Exception {
		Session session = null;
		try {
			session = HibernateSessionUtil.openSession();
			session.beginTransaction();
			Criteria criteria=session.createCriteria(Camion.class);
			if(cam_patente.length()>0)criteria.add(Expression.like("cam_patente", cam_patente+"%"));
	        criteria.addOrder(Order.asc("cam_patente"));
			List list = criteria.list();
			session.getTransaction().commit();
			return list;
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		finally {
			HibernateSessionUtil.closeSession(session);
		}
	}
	
	/* 
	 * Metodo que actualiza un registro de la base de datos. Actualiza alguno de los campos de la tupla en la base de datos
	 * Similar a escribir "update tabla set rut=XXX, nombres=YYY etc;"
	 * 
	 */
	public static void update(Camion objeto) throws Exception {
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
