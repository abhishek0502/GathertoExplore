package user89.dao;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import user89.pojo.EventRequest;
import user89.pojo.MyLetsMeet;
import user89.pojo.UserRegister;


public class EventRequestDao {

	HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
    public void saveUser(EventRequest sr){
		
		template.save(sr);
	}
public void deleteRequest(EventRequest sr){
		
		template.delete(sr);
	}

    public EventRequest getUser(String requestid) {
	   EventRequest sr=(EventRequest)template.get(EventRequest.class, requestid);
	   
	   return sr;

     }
    
    public void updateRequest(EventRequest sr){
		template.update(sr);
		
		
	}
     
	public ArrayList<EventRequest> getListOfRecieved(String meetid)
	{
		ArrayList<EventRequest> list1;
		
		DetachedCriteria cri=DetachedCriteria.forClass(EventRequest.class);
		cri.add(Restrictions.eq("meetid", meetid));
		list1=(ArrayList<EventRequest>)template.findByCriteria(cri);
		return list1;
	}

	public ArrayList<EventRequest> getListOfSent(String name)
	{
		ArrayList<EventRequest> list1;
		
		DetachedCriteria cri=DetachedCriteria.forClass(EventRequest.class);
		cri.add(Restrictions.eq("name", name));
		list1=(ArrayList<EventRequest>)template.findByCriteria(cri);
		return list1;
	}


}