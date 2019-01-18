package user89.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import user89.dao.EventRequestDao;
import user89.dao.MyLetsMeetDao;
import user89.dao.NotificationsDao;
import user89.pojo.EventRequest;
import user89.pojo.MyLetsMeet;
import user89.pojo.Notifications;


public class ApproveRequestController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		String btname=req.getParameter("btsend");
		HttpSession ses=req.getSession(false);
		String name=(String)ses.getAttribute("uname");
//		
		
		ApplicationContext app=new ClassPathXmlApplicationContext("Beans.xml");
		EventRequestDao UserDao=(EventRequestDao)app.getBean("eventrequestdao");
		
		System.out.println(btname);
		EventRequest sr=UserDao.getUser(btname);
		
		
	     NotificationsDao ndao=(NotificationsDao)app.getBean("usernotificationsdao");
		
		if(sr!=null)
		
		{	
			//String meetid=sr.getMeetid();
			sr.setUserapproved("Approved");
			String nameto=sr.getName();
			String msg="Request approved on meetid "+sr.getMeetid()+"by "+name;
			Notifications n=new Notifications(btname+name+"approverequest", nameto, name, msg,"true");
			
			
			ndao.saveNotification(n);
		
		
		
		UserDao.updateRequest(sr);
		
		
		return new ModelAndView("AllRequestsOnEvent","msg","Request Approved");
		}
		
		else 
		{
			return new ModelAndView("AllRequestsOnEvent","msg","You Have Already Approved This Request");
			
		}
	
		}
	
}
