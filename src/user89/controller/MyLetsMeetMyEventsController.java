package user89.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import user89.dao.MyLetsMeetDao;
import user89.pojo.MyLetsMeet;

public class MyLetsMeetMyEventsController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession ses = req.getSession(false);
		String name = (String) ses.getAttribute("uname");
		//String mcategory=req.getParameter("mcategory");
   ApplicationContext app=new ClassPathXmlApplicationContext("Beans.xml");
		
		MyLetsMeetDao srdao=(MyLetsMeetDao)app.getBean("myletsmeetdao");
		
		LocalDate localDate = LocalDate.now();
        System.out.println();
		
        
        
		ArrayList<MyLetsMeet> list = new ArrayList<MyLetsMeet>();
		list=(ArrayList<MyLetsMeet>) srdao.getMyEvents(name);
		
		
		for(MyLetsMeet p:list) 
		{
			//System.out.println(DateTimeFormatter.ofPattern("yyy-MM-dd").format(localDate)+" "+p.getMenddate());
			if(DateTimeFormatter.ofPattern("yyy-MM-dd").format(localDate).compareTo(p.getMenddate())>0){
		srdao.deleteMeet(p);
	
			}
			
			
		//System.out.println(s1.getProduct(sid));
		}
		HttpSession session=req.getSession();
		session.setAttribute("myevents", list);
		if(list.size()>0){
			String msg=" You have created "+list.size()+" Events";
		return new ModelAndView("ShowMyLetsMeet","msg",msg);
	
	}
		else{
			return new ModelAndView("ShowMyLetsMeet","msg","You Have not Created Any Events ");
		}
		}
}