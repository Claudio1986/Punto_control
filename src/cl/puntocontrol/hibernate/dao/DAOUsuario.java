package cl.puntocontrol.hibernate.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import cl.puntocontrol.hibernate.domain.Transportista;
import cl.puntocontrol.hibernate.domain.Usuario;
import cl.puntocontrol.hibernate.session.HibernateSessionUtil;



public class DAOUsuario 
{
	private static Log _log=LogFactory.getLog(DAOUsuario.class);
	
	
	/* 
	 * Metodo que agrega un objeto a la base de datos. Agrega una tupla completa de la base de datos
	 * Similar a escribir "insert into tabla (a,b,c,d,e,f) values (u,v,w,x,y,z);"
	 * 
	 */
	public static void add(Usuario objeto) throws Exception {
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
	public static Usuario get(String nombre) throws Exception {
		Session session = null;

		try {
			session = HibernateSessionUtil.openSession();
			session.beginTransaction();
			Usuario objeto = (Usuario)session.get(
					Usuario.class, nombre);
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
	public static Usuario login(String nombre,String clave_acceso) throws Exception {
		Session session = null;
		try {
			session = HibernateSessionUtil.openSession();
			session.beginTransaction();
			Criteria criteria=session.createCriteria(Usuario.class);
			if(clave_acceso!=null&&nombre!=null){
				criteria.add(Expression.eq("nombre", nombre));
				criteria.add(Expression.eq("clave_acceso", clave_acceso));
			}

			List list = criteria.list();
			session.getTransaction().commit();
			if(null!=list && list.size()>0)
				return (Usuario) list.get(0);
			else{
				return null;
			}
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
	public static List<Usuario> list(String nombre) throws Exception {
		Session session = null;
		try {
			session = HibernateSessionUtil.openSession();
			session.beginTransaction();
			Criteria criteria=session.createCriteria(Usuario.class);
			if(nombre.length()>0)criteria.add(Expression.like("nombre", nombre+"%"));
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
	public static void update(Usuario objeto) throws Exception {
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
	
	public static void delete(String nombre) throws Exception {
		Session session = null;

		try {
			session = HibernateSessionUtil.openSession();
			session.beginTransaction();
			Usuario usuario = (Usuario)session.get(
					Usuario.class, nombre);
			if (usuario != null) {
				session.delete(usuario);
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


	

}
