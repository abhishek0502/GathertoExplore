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

public class UpdateProfileController implements Controller
{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//String username=req.getParameter("rusername");
		String name=req.getParameter("rname");
		String email=req.getParameter("remail");
		String password=req.getParameter("rpassword");
         //System.out.println("abhishek");
		String cpassword=req.getParameter("rcpassword");
		String interests=req.getParameter("rinterests");
		String mobile=req.getParameter("rmobile");
		
		HttpSession session=req.getSession(false);
		String username=(String)session.getAttribute("uname");
		

		
		ApplicationContext app=new ClassPathXmlApplicationContext("Beans.xml");
		
		UserRegisterDao srdao=(UserRegisterDao)app.getBean("registerdao");
		
		
			
		UserRegister sr=srdao.getUser(username);
		//System.out.println(sr.getUsername());
		if(sr!=null&&password.equals(cpassword))
				
			
		{
			
		    sr.setName(name);
		    sr.setInterests(interests);
		    sr.setEmail(email);
		    sr.setMobile(mobile);
		    sr.setPassword(password);
		   
			srdao.updateUser(sr);
			
			
			return new ModelAndView("UserDetails","msg","Profile Updated");
			
		}
     else{
			
			return new ModelAndView("UserDetails","msg","Password Doesn't match ");
			
		}
}}
