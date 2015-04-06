package cl.puntocontrol.struts.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SalirAction extends Action {
	public ActionForward execute(
			ActionMapping mapping, ActionForm _form, HttpServletRequest request,
			HttpServletResponse response)
		throws Exception {
		try{
    		request.getSession().invalidate();
			return mapping.findForward("success");
		}catch(Exception ex){
			return mapping.findForward("error");
		}finally{
		}
	}
}