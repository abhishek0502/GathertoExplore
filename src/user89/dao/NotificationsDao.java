package user89.dao;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import user89.pojo.EventRequest;
import user89.pojo.Notifications;
import user89.pojo.UserRegister;

public class NotificationsDao {

	HibernateTemplate template;

	public HibernateTemplate getTemplate() {

		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public void saveNotification(Notifications sr) {

		template.save(sr);
	}

	public void deleteNotification(Notifications sr) {

		template.delete(sr);
	}
	
	public void updateUser(Notifications sr){
		template.update(sr);
		
	}

	public ArrayList<Notifications> getListOfNotifications(String name) {
		ArrayList<Notifications> list1;

		DetachedCriteria cri = DetachedCriteria.forClass(Notifications.class);
		cri.add(Restrictions.eq("nameto", name));
		list1 = (ArrayList<Notifications>) template.findByCriteria(cri);
		return list1;
	}

}
