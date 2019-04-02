package bean.users;

public class AuthBean {

	private int id;
	private int userId;
	private String email;
	private String password;
	private String status;

	public AuthBean() {
		super();
	}

	public AuthBean(int userId, String email, String password, String status) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.status = status;
	}

	public AuthBean(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public AuthBean(int id, int userId, String email, String password, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
