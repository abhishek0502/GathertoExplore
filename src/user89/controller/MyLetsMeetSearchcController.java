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

public class MyLetsMeetSearchcController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		
		
		String mcategory=req.getParameter("mcategory");
   ApplicationContext app=new ClassPathXmlApplicationContext("Beans.xml");
		
		MyLetsMeetDao srdao=(MyLetsMeetDao)app.getBean("myletsmeetdao");
		
		LocalDate localDate = LocalDate.now();
		
		ArrayList<MyLetsMeet> list = new ArrayList<MyLetsMeet>();
		list=(ArrayList<MyLetsMeet>)srdao.getListByCategory(mcategory);
		
		for(MyLetsMeet p:list) 
		{
			//System.out.println(DateTimeFormatter.ofPattern("yyy-MM-dd").format(localDate)+" "+p.getMenddate());
			if(DateTimeFormatter.ofPattern("yyy-MM-dd").format(localDate).compareTo(p.getMenddate())>0){
		srdao.deleteMeet(p);
	
			}
		}
		
		ArrayList<MyLetsMeet> list1 = new ArrayList<MyLetsMeet>();
		list1=(ArrayList<MyLetsMeet>)srdao.getListByCategory(mcategory);
		//System.out.println(s1.getProduct(sid));
		
		HttpSession session=req.getSession();
		session.setAttribute("listbycategory", list1);
		
		HttpSession ses = req.getSession(false);
		String name = (String) ses.getAttribute("uname");
		ArrayList<MyLetsMeet> listofmyevents = new ArrayList<MyLetsMeet>();
		listofmyevents=(ArrayList<MyLetsMeet>) srdao.getMyEventsmanycat(name, mcategory);
		
		
		if(list.size()>0){
			int size=list.size()-listofmyevents.size();
			String msg=""+size+" Search Result Found";
		return new ModelAndView("CategoryMeetView","msg",msg);
	
	}
		else{
			return new ModelAndView("CategoryMeetView","msg","No Result Found");
		
		}
		}
}
