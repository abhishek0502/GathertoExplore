package user89.pojo;

public class Notifications {
	String nid;
	String nameto;
	String namefrom;
	String message;
	String status;
	
	public Notifications() {
		// TODO Auto-generated constructor stub
	}



	public Notifications(String nid, String nameto, String namefrom, String message, String status) {
		super();
		this.nid = nid;
		this.nameto = nameto;
		this.namefrom = namefrom;
		this.message = message;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getNameto() {
		return nameto;
	}

	public void setNameto(String nameto) {
		this.nameto = nameto;
	}

	public String getNamefrom() {
		return namefrom;
	}

	public void setNamefrom(String namefrom) {
		this.namefrom = namefrom;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
