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

public class UserLoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		
		String username=req.getParameter("username");
		String password=req.getParameter("password"); 

		
		ApplicationContext app=new ClassPathXmlApplicationContext("Beans.xml");
		
		UserRegisterDao srdao=(UserRegisterDao)app.getBean("registerdao");
		
		
			
		UserRegister sr=srdao.getUser(username);
		//System.out.println(sr.getUsername());
		if(sr!=null)
		{
		if(sr.getUsername().equals(username) && sr.getPassword().equals(password)){
			
			HttpSession session=req.getSession();
			session.setAttribute("uname",username);
			
			return new ModelAndView("Home","msg","Successfull Login");
			
		}
     else{
			
			return new ModelAndView("Login","msg","Invalid Details Try Again ");
			
		}
		}
		else{
			
			return new ModelAndView("Login","msg","Invalid Details Try Again ");
			
		}
		
	
	}

}
