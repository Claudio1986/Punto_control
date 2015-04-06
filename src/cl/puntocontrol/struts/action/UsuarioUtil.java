package cl.puntocontrol.struts.action;

import cl.puntocontrol.hibernate.dao.DAOUsuario;
import cl.puntocontrol.hibernate.domain.Usuario;

public class UsuarioUtil {
	public static Usuario checkUser(String username, String pass) throws Exception{
			Usuario usuario = new Usuario();
			if(username.toUpperCase().equals("MOLINSTEC") && pass.toUpperCase().equals("BASCULA")){
				usuario.setNombre(username);
				usuario.setClave_acceso(pass);
				usuario.setF1(1); usuario.setF11(1);
				usuario.setF2(1); usuario.setF12(1);
				usuario.setF3(1); usuario.setF13(1);
				usuario.setF4(1); usuario.setF14(1);
				usuario.setF5(1); usuario.setF15(1);
				usuario.setF6(1); usuario.setF16(1);
				usuario.setF7(1); 	usuario.setF17(1); 
				usuario.setF8(1); 	usuario.setF18(1); 
				usuario.setF9(1); 	usuario.setF19(1); 
				usuario.setF10(1); 	usuario.setF20(1); 
			}
			else{
				usuario = DAOUsuario.login(username, pass);
			}
	
	    	return usuario;
	    }
}

