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
import user89.dao.MyLetsMeetDao;
import user89.pojo.EventRequest;
import user89.pojo.MyLetsMeet;

public class RecievedRequestController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession ses = req.getSession(false);
		String name = (String) ses.getAttribute("uname");
		//String mcategory=req.getParameter("mcategory");
   ApplicationContext app=new ClassPathXmlApplicationContext("Beans.xml");
		
		MyLetsMeetDao srdao=(MyLetsMeetDao)app.getBean("myletsmeetdao");
		
		
		
		ArrayList<MyLetsMeet> list = new ArrayList<MyLetsMeet>();
		list=(ArrayList<MyLetsMeet>) srdao.getMyEvents(name);
		
		//System.out.println(s1.getProduct(sid));
		
		HttpSession session=req.getSession();
		session.setAttribute("myevents", list);
		if(list.size()>0){
			String msg=" You have created "+list.size()+" Events";
		return new ModelAndView("RREventsView","msg",msg);
	
	}
		else{
			return new ModelAndView("RREventsView","msg","You Have not Created Any Events ");
		}
		}
		
			
		
		
}

