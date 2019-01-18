package user89.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

public class ConfirmRequestController implements Controller{

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
		MyLetsMeetDao srdao=(MyLetsMeetDao)app.getBean("myletsmeetdao");
		String mid=sr.getMeetid();
		MyLetsMeet l=srdao.getMeet(mid);
	     NotificationsDao ndao=(NotificationsDao)app.getBean("usernotificationsdao");
		
		
		if(sr!=null )
		
		{	
			String apv=sr.getUserapproved();
			if(apv.equals("Approved")&&sr.getUserconfirm().equals("Not Confirmed"))
			{
			//String meetid=sr.getMeetid();
			sr.setUserconfirm("Confirmed");
			String nameto=l.getName();
			
			String msg="Request confirmed on meet id "+sr.getMeetid()+"by "+name+"";
			Notifications n=new Notifications(btname+name+"confirmrequest", nameto, name, msg,"true");
			ndao.saveNotification(n);
		  UserDao.updateRequest(sr);
		
		
		return new ModelAndView("AllSentRequests","msg","Request Confirmed");
		}
			else if(sr.getUserconfirm().equals("Confirmed")){
				return new ModelAndView("AllSentRequests","msg","You Have Already Confirmed This Request");
				
			}
			else 
			{
				return new ModelAndView("AllSentRequests","msg","Can't Confirm as Request has not been Approved by event creator");
				
			}
		}
		
		else 
		{
			return new ModelAndView("AllSentRequests","msg","Can't Confirm as Request has not been Approved by event creator");
			
		}
	
		}
	
}
