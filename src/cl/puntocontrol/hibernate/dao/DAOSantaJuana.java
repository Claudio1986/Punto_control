package cl.puntocontrol.hibernate.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import cl.puntocontrol.hibernate.domain.SantaJuana;
import cl.puntocontrol.hibernate.session.HibernateSessionUtil;



public class DAOSantaJuana 
{
	private static Log _log=LogFactory.getLog(DAOSantaJuana.class);
	
	public static void delete(String id_control) throws Exception {
		Session session = null;

		try {
			session = HibernateSessionUtil.openSession();
			session.beginTransaction();
			SantaJuana obj = (SantaJuana)session.get(
					SantaJuana.class, id_control);
			if (obj != null) {
				session.delete(obj);
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
	public static void add(SantaJuana objeto) throws Exception {
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
	public static SantaJuana get(String id_control) throws Exception {
		Session session = null;

		try {
			session = HibernateSessionUtil.openSession();
			session.beginTransaction();
			SantaJuana objeto = (SantaJuana)session.get(
					SantaJuana.class, id_control);
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
	public static List<SantaJuana> list(  String nombre_chofer
											,String patente
											,Date fechaDesde
											,Date fechaHasta
											,String rut_chofer
											,String rut_transportista
											,String guia_despacho
											,String nombre_control_detalle
											,String nombre_producto
											,String patente_carro
											,String codigo_producto
											,String nombre_especie
											,String id_control) throws Exception {
		Session session = null;
		try {
			session = HibernateSessionUtil.openSession();
			session.beginTransaction();
			Criteria criteria=session.createCriteria(SantaJuana.class);
			if(nombre_chofer.length()>0)criteria.add(Expression.like("nombre_chofer", nombre_chofer+"%"));
			if(patente.length()>0)criteria.add(Expression.like("patente", patente+"%"));
			if(fechaDesde!=null&&fechaHasta!=null)criteria.add(Expression.between("fecha", fechaDesde, fechaHasta));
			if(rut_chofer.length()>0)criteria.add(Expression.like("rut_chofer", rut_chofer+"%"));
			if(rut_transportista.length()>0)criteria.add(Expression.like("rut_transportista", rut_transportista+"%"));
			if(guia_despacho.length()>0)criteria.add(Expression.like("guia_despacho", guia_despacho+"%"));
			if(nombre_control_detalle.length()>0)criteria.add(Expression.like("nombre_control_detalle", nombre_control_detalle+"%"));
			if(nombre_producto.length()>0)criteria.add(Expression.like("nombre_producto", nombre_producto+"%"));
			if(patente_carro.length()>0)criteria.add(Expression.like("patente_carro", patente_carro+"%"));
			if(codigo_producto.length()>0)criteria.add(Expression.like("codigo_producto", codigo_producto+"%"));
			if(nombre_especie.length()>0)criteria.add(Expression.like("nombre_especie", nombre_especie+"%"));
			if(id_control.length()>0)criteria.add(Expression.like("id_control", id_control+"%"));
	        criteria.addOrder(Order.asc("fecha"));
	        criteria.addOrder(Order.asc("hora"));
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
	public static void update(SantaJuana objeto) throws Exception {
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
