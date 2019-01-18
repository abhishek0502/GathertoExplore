package user89.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import user89.dao.UserRegisterDao;
import user89.pojo.UserRegister;


public class ForgerPasswordController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		String email=req.getParameter("femail");
		String username=req.getParameter("fusername");
		
		ApplicationContext app=new ClassPathXmlApplicationContext("Beans.xml");
		
		try{
			UserRegisterDao srdao=(UserRegisterDao)app.getBean("registerdao");
			
			
			
			UserRegister sr=srdao.getUser(username);
			
				
//				String r2=r.getName();
				HttpSession sess=req.getSession();
				sess.setAttribute("usernewpass",username);
//				
//				System.out.println("email is"+r.getEmail());
						
				/*HttpSession session=req.getSession();
				session.setAttribute("key", r2);
				*/
				if(email.equals(sr.getEmail()) && username.equals(sr.getUsername()))
				{
					return new ModelAndView("NewPassword");
				}
				String msg="Please Enter valid email id and name";
				return new ModelAndView("Login","msg",msg);

			}catch(Exception e)
			{
				String msg="Please Enter valid data";
				return new ModelAndView("Login","msg",msg);
			}
			
	}

}
