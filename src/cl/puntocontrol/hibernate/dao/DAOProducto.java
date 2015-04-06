package cl.puntocontrol.hibernate.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import cl.puntocontrol.hibernate.domain.Producto;
import cl.puntocontrol.hibernate.session.HibernateSessionUtil;



public class DAOProducto 
{
	private static Log _log=LogFactory.getLog(DAOProducto.class);
	
	public static void delete(String prd_codigo) throws Exception {
		Session session = null;

		try {
			session = HibernateSessionUtil.openSession();
			session.beginTransaction();
			Producto producto = (Producto)session.get(
					Producto.class, prd_codigo);
			if (producto != null) {
				session.delete(producto);
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
	
	public static void add(Producto objeto) throws Exception {
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
	public static Producto get(String prd_codigo) throws Exception {
		Session session = null;

		try {
			session = HibernateSessionUtil.openSession();
			session.beginTransaction();
			Producto objeto = (Producto)session.get(
					Producto.class, prd_codigo);
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
	public static List<Producto> list(String prd_descripcion) throws Exception {
		Session session = null;
		try {
			session = HibernateSessionUtil.openSession();
			session.beginTransaction();
			Criteria criteria=session.createCriteria(Producto.class);
			if(prd_descripcion.length()>0)criteria.add(Expression.like("prd_descripcion", prd_descripcion+"%"));
	        criteria.addOrder(Order.desc("prd_codigo"));
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
	public static void update(Producto objeto) throws Exception {
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
