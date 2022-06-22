package application;


public class UserInfoDTO {
	private String usernumber;
	private String userid;
	private String userpwd;
	private String username;
	private String userpn;
	private String usergender;
	
	public UserInfoDTO() {};	
	public UserInfoDTO(String usernumber, String userid, String userpwd, String username, String userpn, String usergender) {		
		this.userid = userid;		
		this.userpwd = userpwd;		
		this.username = username;		
		this.userpn = userpn;		
		this.usergender = usergender;		
		this.usernumber = usernumber;
		}
	
	public String getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpn() {
		return userpn;
	}
	public void setUserpn(String userpn) {
		this.userpn = userpn;
	}
	public String getUsergender() {
		return usergender;
	}
	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}
	
}
