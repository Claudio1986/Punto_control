package cl.puntocontrol.struts.action;

import cl.puntocontrol.hibernate.dao.DAOContulmo;
import cl.puntocontrol.hibernate.dao.DAOEscuadron;
import cl.puntocontrol.hibernate.dao.DAOSantaJuana;
import cl.puntocontrol.hibernate.domain.Contulmo;
import cl.puntocontrol.hibernate.domain.Escuadron;
import cl.puntocontrol.hibernate.domain.Punto_Control;
import cl.puntocontrol.hibernate.domain.SantaJuana;

public class ControlUtil {
	public static void modificar(Punto_Control pc) throws Exception{
		
		if(pc.getNombre_control_detalle().toUpperCase().equals("CONTULMO")){
			Contulmo contulmo = DAOContulmo.get(pc.getId_control());
			contulmo.setPatente(pc.getPatente());
    		contulmo.setPatente_carro(pc.getPatente_carro());
    		contulmo.setGuia_despacho(pc.getGuia_despacho());
    		contulmo.setRut_chofer(pc.getRut_chofer());
    		contulmo.setNombre_chofer(pc.getNombre_chofer());
        	contulmo.setNombre_transportista(pc.getNombre_transportista());
    		contulmo.setRut_transportista(pc.getRut_transportista());
    		contulmo.setCodigo_sap(pc.getCodigo_sap());
        	contulmo.setId_especie(pc.getId_especie());
    		contulmo.setNombre_especie(pc.getNombre_especie());
    		contulmo.setNombre_producto(pc.getNombre_producto());
    		contulmo.setCodigo_producto(pc.getCodigo_producto());
    		contulmo.setObservacion(pc.getObs_modificacion());
    		contulmo.setObs_modificacion(pc.getObs_modificacion());
    		contulmo.setUsuario(pc.getUsuario());
    		DAOContulmo.update(contulmo);
    	}
		if(pc.getNombre_control_detalle().toUpperCase().equals("ESCUADRON")){
			Escuadron escuadron = DAOEscuadron.get(pc.getId_control());
			escuadron.setPatente(pc.getPatente());
			escuadron.setPatente_carro(pc.getPatente_carro());
			escuadron.setGuia_despacho(pc.getGuia_despacho());
			escuadron.setRut_chofer(pc.getRut_chofer());
    		escuadron.setNombre_chofer(pc.getNombre_chofer());
        	escuadron.setNombre_transportista(pc.getNombre_transportista());
    		escuadron.setRut_transportista(pc.getRut_transportista());
    		escuadron.setCodigo_sap(pc.getCodigo_sap());
        	escuadron.setId_especie(pc.getId_especie());
    		escuadron.setNombre_especie(pc.getNombre_especie());
    		escuadron.setNombre_producto(pc.getNombre_producto());
    		escuadron.setCodigo_producto(pc.getCodigo_producto());
    		escuadron.setObservacion(pc.getObs_modificacion());
    		escuadron.setObs_modificacion(pc.getObs_modificacion());
    		escuadron.setUsuario(pc.getUsuario());
    		DAOEscuadron.update(escuadron);

		}
		if(pc.getNombre_control_detalle().toUpperCase().equals("SANTAJUANA")){
			SantaJuana santajuana = DAOSantaJuana.get(pc.getId_control());
			santajuana.setPatente(pc.getPatente());
    		santajuana.setPatente_carro(pc.getPatente_carro());
    		santajuana.setGuia_despacho(pc.getGuia_despacho());
    		santajuana.setRut_chofer(pc.getRut_chofer());
    		santajuana.setNombre_chofer(pc.getNombre_chofer());
        	santajuana.setNombre_transportista(pc.getNombre_transportista());
    		santajuana.setRut_transportista(pc.getRut_transportista());
    		santajuana.setCodigo_sap(pc.getCodigo_sap());
        	santajuana.setId_especie(pc.getId_especie());
    		santajuana.setNombre_especie(pc.getNombre_especie());
    		santajuana.setNombre_producto(pc.getNombre_producto());
    		santajuana.setCodigo_producto(pc.getCodigo_producto());
    		santajuana.setObservacion(pc.getObs_modificacion());
    		santajuana.setObs_modificacion(pc.getObs_modificacion());
    		santajuana.setUsuario(pc.getUsuario());
    		DAOSantaJuana.update(santajuana);
		}
	}
}

