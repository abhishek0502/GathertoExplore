package user89.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import user89.pojo.UserRegister;
import user89.dao.UserRegisterDao;

public class UserRegisterController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String username=req.getParameter("rusername");
		String name=req.getParameter("rname");
		String email=req.getParameter("remail");
		String password=req.getParameter("rpassword");
         //System.out.println("abhishek");
		String cpassword=req.getParameter("rcpassword");
		String interests=req.getParameter("rinterests");
		String mobile=req.getParameter("rmobile");
		System.out.println(password+" "+cpassword);
		
		if(password.equals(cpassword))
		{
			System.out.println("abhishek");
		ApplicationContext app=new ClassPathXmlApplicationContext("Beans.xml");
		UserRegisterDao UserDao=(UserRegisterDao)app.getBean("registerdao");
		
		UserRegister userregister=new UserRegister(username,name,email,password,mobile,interests);
		UserDao.saveUser(userregister);
		
		return new ModelAndView("Login","msg","Successfully Registered");
		}
		else{
			return new ModelAndView("Register","msg","Password and confirm password must match");
		
	}
		}

}
