package user89.dao;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import user89.pojo.MyLetsMeet;
import user89.pojo.UserRegister;



public class MyLetsMeetDao {
	
	
HibernateTemplate template;
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public void saveMeet(MyLetsMeet sr){
		
		template.save(sr);
	}
	
	public void updateMeet(MyLetsMeet sr){
		template.update(sr);
	}
	
	public void deleteMeet(MyLetsMeet sr){
		template.delete(sr);
	}
	
	public MyLetsMeet getMeet(String meetid) {
		MyLetsMeet sr=(MyLetsMeet)template.get(MyLetsMeet.class, meetid);
		   
		   return sr;
	
	}
	
	
	public ArrayList<MyLetsMeet> getListByCategory(String category)
	{
		ArrayList<MyLetsMeet> list1;
		
		DetachedCriteria cri=DetachedCriteria.forClass(MyLetsMeet.class);
		cri.add(Restrictions.eq("mcategory", category));
		list1=(ArrayList<MyLetsMeet>)template.findByCriteria(cri);
		return list1;
		
	}
	
	public ArrayList<MyLetsMeet> getListByLocation(String location)
	{
		ArrayList<MyLetsMeet> list1;
		
		DetachedCriteria cri=DetachedCriteria.forClass(MyLetsMeet.class);
		cri.add(Restrictions.eq("mlocationcity", location));
		list1=(ArrayList<MyLetsMeet>)template.findByCriteria(cri);
		return list1;
	}
	
	
	public ArrayList<MyLetsMeet> getMyEvents(String name)
	{
		ArrayList<MyLetsMeet> list1;
		
		DetachedCriteria cri=DetachedCriteria.forClass(MyLetsMeet.class);
		cri.add(Restrictions.eq("name", name));
		list1=(ArrayList<MyLetsMeet>)template.findByCriteria(cri);
		return list1;
	}
	public ArrayList<MyLetsMeet> getMyEventsmanycat(String name,String category)
	{
		ArrayList<MyLetsMeet> list1;
		
		DetachedCriteria cri=DetachedCriteria.forClass(MyLetsMeet.class);
		cri.add(Restrictions.eq("name", name));
		cri.add(Restrictions.eq("mcategory", category));
		list1=(ArrayList<MyLetsMeet>)template.findByCriteria(cri);
		return list1;
	}
	public ArrayList<MyLetsMeet> getMyEventsmanyloc(String name,String location)
	{
		ArrayList<MyLetsMeet> list1;
		
		DetachedCriteria cri=DetachedCriteria.forClass(MyLetsMeet.class);
		cri.add(Restrictions.eq("name", name));
		cri.add(Restrictions.eq("mlocationcity", location));
		list1=(ArrayList<MyLetsMeet>)template.findByCriteria(cri);
		return list1;
	}
	
	
	

}
