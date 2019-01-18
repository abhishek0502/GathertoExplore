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

public class GetUserDetailsController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		
		String nameofuser=req.getParameter("btname");
		

		
		ApplicationContext app=new ClassPathXmlApplicationContext("Beans.xml");
		
		UserRegisterDao srdao=(UserRegisterDao)app.getBean("registerdao");
		
		
			
		UserRegister sr=srdao.getUser(nameofuser);
		//System.out.println(sr.getUsername());
		if(sr!=null)
		{
		
			
			HttpSession session=req.getSession();
			session.setAttribute("userdetails",sr);
			
			return new ModelAndView("UserDetails","msg","");
			
		
		}
		else{
			
			return new ModelAndView("UserDetails","msg","User Not Found");
			
		}
		
	
	}
}
