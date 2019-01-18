package user89.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SignOutController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//HttpSession session=req.getSession();
		HttpSession ses=req.getSession();
		ses.removeAttribute("uname");
        //session.invalidate(); 
        ses.invalidate();
        return new ModelAndView("Login","msg","Logged Out");
}
}