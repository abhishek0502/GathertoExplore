package user89.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import user89.dao.MyLetsMeetDao;
import user89.pojo.MyLetsMeet;
import user89.pojo.UserRegister;



public class MyLetsMeetController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String mmeetid=req.getParameter("mmeetid");
		String mname=req.getParameter("mname");
		String mlocationcity=req.getParameter("mlocationcity");
		String mlocationaddress=req.getParameter("mlocationaddress");
         System.out.println("abhishek");
		String mcategory=req.getParameter("mcategory");
		String mdescription=req.getParameter("mdescription");
		String mstartdate=req.getParameter("mstartdate");
		String mstarttime=req.getParameter("mstarttime");
		String menddate=req.getParameter("menddate");
		String mendtime=req.getParameter("mendtime");
	
		HttpSession ses=req.getSession(false);
		String name=(String)ses.getAttribute("uname");
		
		ApplicationContext app=new ClassPathXmlApplicationContext("Beans.xml");
		
		MyLetsMeetDao srdao=(MyLetsMeetDao)app.getBean("myletsmeetdao");
		
		MyLetsMeet mylets=new MyLetsMeet(mmeetid,mname,mlocationcity,mlocationaddress,mcategory,mdescription,mstartdate,mstarttime,menddate,mendtime,name);
		srdao.saveMeet(mylets);
		return new ModelAndView("CreateLetsMeet","msg","Event Successfully Created");
	
	}
}
