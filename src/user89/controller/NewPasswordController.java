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


public class NewPasswordController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		String newpass=req.getParameter("newpass");
		String newcpass=req.getParameter("newcpass");
		
ApplicationContext app=new ClassPathXmlApplicationContext("Beans.xml");
		
		try{
			UserRegisterDao srdao=(UserRegisterDao)app.getBean("registerdao");
			
			
			HttpSession sess=req.getSession(false);
			String username=(String) sess.getAttribute("usernewpass");
				
				UserRegister r=srdao.getUser(username);
				
				if(newpass.equals(newcpass))
				{
					
					r.setPassword(newpass);
					srdao.updateUser(r);
								
				return new ModelAndView("Login","msg","Sucessfully password changes");
				}
			}catch(Exception e)
			{
				String msg="Password and Confirm Password do not match";
				return new ModelAndView("Login","msg",msg);
			}
		return new ModelAndView("NewPassword","msg","Password and Confirm Password do not match");
			
	}

}
