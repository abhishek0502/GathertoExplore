package user89.pojo;




public class UserRegister {
	
	
	String username;
	String name;
	String email;
	String password;
	String mobile;
	String interests;

	public UserRegister() {
		// TODO Auto-generated constructor stub
	}
		
	public UserRegister(String username, String name, String email, String password, String mobile, String interests) {
		super();
		this.username = username;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.interests = interests;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}
	
	
	
	
	
	

}
