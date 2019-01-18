package user89.pojo;

public class EventRequest {
	String requestid;
	String name;
	String meetid;
	String userapproved;
	String userconfirm;
	
	
	public EventRequest() {
	
	}
	
	public EventRequest(String requestid, String name, String meetid, String userapproved, String userconfirm) {
		super();
		this.requestid = requestid;
		this.name = name;
		this.meetid = meetid;
		this.userapproved = userapproved;
		this.userconfirm = userconfirm;
	}
	
	public String getRequestid() {
		return requestid;
	}
	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMeetid() {
		return meetid;
	}
	public void setMeetid(String meetid) {
		this.meetid = meetid;
	}
	public String getUserapproved() {
		return userapproved;
	}
	public void setUserapproved(String userapproved) {
		this.userapproved = userapproved;
	}
	public String getUserconfirm() {
		return userconfirm;
	}
	public void setUserconfirm(String userconfirm) {
		this.userconfirm = userconfirm;
	}
	
	

}
