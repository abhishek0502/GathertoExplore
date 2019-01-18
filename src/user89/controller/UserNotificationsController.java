package user89.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import user89.dao.MyLetsMeetDao;
import user89.dao.NotificationsDao;
import user89.pojo.MyLetsMeet;
import user89.pojo.Notifications;

public class UserNotificationsController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession session = req.getSession(false);
		String name = (String) session.getAttribute("uname");
		//String mcategory=req.getParameter("mcategory");
   ApplicationContext app=new ClassPathXmlApplicationContext("Beans.xml");
		
		NotificationsDao srdao=(NotificationsDao)app.getBean("usernotificationsdao");
		
		
		
		ArrayList<Notifications> list = new ArrayList<Notifications>();
		list=(ArrayList<Notifications>) srdao.getListOfNotifications(name);
		
		//System.out.println(s1.getProduct(sid));
		
		//HttpSession session=req.getSession(false);
		//session.setAttribute("usernotifications", list);
		
		
		
		if(list.size()>0){
			
//			for(Notifications p:list) 
//		{
//			
//		      p.setStatus("false") ;
//
//			srdao.updateUser(p);
//		
//		}
			
			
			
			String msg=" "+list.size()+" Notifications";
		return new ModelAndView("UserNotifications","msg",msg);
	
	}
		else{
			return new ModelAndView("UserNotifications","msg","No Notifications ");
		}
		}
}
