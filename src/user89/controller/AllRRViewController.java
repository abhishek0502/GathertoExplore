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
import user89.pojo.MyLetsMeet;

public class AllRRViewController  implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		String btsend=req.getParameter("btsend");
		
		
		ApplicationContext app=new ClassPathXmlApplicationContext("Beans.xml");
		EventRequestDao UserDao=(EventRequestDao)app.getBean("eventrequestdao");
		
		
		ArrayList<EventRequest> list = new ArrayList<EventRequest>();
		list=UserDao.getListOfRecieved(btsend);
		
		HttpSession session=req.getSession();
		session.setAttribute("recreq", list);
		
		if(list.size()>0){
			String msg=" You have "+list.size()+" Requests";
		return new ModelAndView("AllRequestsOnEvent","msg",msg);
	
	}
		else{
			return new ModelAndView("AllRequestsOnEvent","msg","You Have no request on this Event");
		}
		}
		
		
		
		
		
	}

