package bean.users;

public class CredentialsBean {

	private int id;
	private int userId;
	private int roleId;
	private String email;
	private String password;

	
	
	public CredentialsBean() {
		super();
	}


	public CredentialsBean(int userId, int roleId, String email, String password) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.email = email;
		this.password = password;
	}

	
	public CredentialsBean(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}



	public CredentialsBean(int id, int userId, int roleId, String email,
			String password) {
		super();
		this.id = id;
		this.userId = userId;
		this.roleId = roleId;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
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

}
