package user89.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import user89.dao.EventRequestDao;
import user89.pojo.EventRequest;

public class DeleteRequestController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		String btname=req.getParameter("btsend");
	
		
		ApplicationContext app=new ClassPathXmlApplicationContext("Beans.xml");
		EventRequestDao UserDao=(EventRequestDao)app.getBean("eventrequestdao");
		
		System.out.println(btname);
		EventRequest sr=UserDao.getUser(btname);
		
		if(sr!=null )
		
		{	
			String apv=sr.getUserconfirm();
			if(apv.equals("Not Confirmed"))
			{
			//String meetid=sr.getMeetid();
			
			
		
		
		
		UserDao.deleteRequest(sr);
		
		
		return new ModelAndView("AllSentRequests","msg","Request Deleted");
		}
			else{
				return new ModelAndView("AllSentRequests","msg","Can't Delete as You Have Already Confirmed the Event");
			}
		}
		
		else 
		{
			return new ModelAndView("AllSentRequests","msg","Not Found");
			
		}
	
		}
	
}
