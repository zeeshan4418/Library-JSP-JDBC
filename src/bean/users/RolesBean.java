package bean.users;

public class RolesBean {

	private int id;
	private String role;

	
	
	public RolesBean() {
	
	}

	public RolesBean(String role) {
		super();
		this.role = role;
	}

	public RolesBean(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
