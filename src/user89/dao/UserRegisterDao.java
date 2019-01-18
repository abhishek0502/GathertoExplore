package user89.dao;


import org.springframework.orm.hibernate3.HibernateTemplate;

import user89.pojo.MyLetsMeet;
import user89.pojo.UserRegister;

public class UserRegisterDao {



	HibernateTemplate template;
	
	

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public void saveUser(UserRegister sr){
		
		template.save(sr);
	}

	public UserRegister getUser(String username) {
		   UserRegister sr=(UserRegister)template.get(UserRegister.class, username);
		   
		   return sr;
	
	}
	public void updateUser(UserRegister sr){
		template.update(sr);
	}
	
		

}
