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
import user89.dao.UserRegisterDao;
import user89.pojo.EventRequest;
import user89.pojo.MyLetsMeet;
import user89.pojo.Notifications;
import user89.pojo.UserRegister;

public class SendRequestController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		String btsend=req.getParameter("btsend");
		HttpSession ses=req.getSession(false);
		String name=(String)ses.getAttribute("uname");
		System.out.println(btsend);
		
		ApplicationContext app=new ClassPathXmlApplicationContext("Beans.xml");
		EventRequestDao UserDao=(EventRequestDao)app.getBean("eventrequestdao");
		
		EventRequest sr=UserDao.getUser(btsend+name);
		MyLetsMeetDao srdao=(MyLetsMeetDao)app.getBean("myletsmeetdao");
		MyLetsMeet l=srdao.getMeet(btsend);
	     NotificationsDao ndao=(NotificationsDao)app.getBean("usernotificationsdao");
		
		
		if(sr==null&& l!=null)
		{
			
		
		EventRequest e=new EventRequest(btsend+name,name,btsend,"Not Approved","Not Confirmed");
		String nameto=l.getName();
		String msg="Request sended on your meet id "+btsend+"by "+name;
		Notifications n=new Notifications(btsend+name+"sendrequest", nameto, name, msg,"true");
		
		UserDao.saveUser(e);
		ndao.saveNotification(n);
		return new ModelAndView("SearchLetsMeet","msg","Request Sended");
		}
		
		else 
		{
			return new ModelAndView("SearchLetsMeet","msg","You Have Already Sended Your Request");
			
		}
	
}
}