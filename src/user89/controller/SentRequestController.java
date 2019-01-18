package user89.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import user89.dao.EventRequestDao;
import user89.pojo.EventRequest;

public class SentRequestController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		HttpSession ses=req.getSession(false);
		String name=(String)ses.getAttribute("uname");
		
		
		ApplicationContext app=new ClassPathXmlApplicationContext("Beans.xml");
		EventRequestDao UserDao=(EventRequestDao)app.getBean("eventrequestdao");
		
		
		ArrayList<EventRequest> list = new ArrayList<EventRequest>();
		list=UserDao.getListOfSent(name);
		
		HttpSession session=req.getSession();
		session.setAttribute("sentreq", list);
		
		if(list.size()>0){
			String msg=" You have sent "+list.size()+" Requests";
		return new ModelAndView("AllSentRequests","msg",msg);
	
	}
		else{
			return new ModelAndView("AllSentRequests","msg","You Have not sent request on any Event");
		}
		}
		

}
