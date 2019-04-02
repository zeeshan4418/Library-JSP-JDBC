package bean.users;

public class UserBean {

	private int id;
	private String firstName;
	private String lastName;
	private int roleId;
	private String status;

	public UserBean() {

	}

	public UserBean(int roleId, String firstName, String lastName, String status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.roleId = roleId;
	}

	public UserBean(int id, int roleId, String firstName, String lastName,
			String status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.roleId = roleId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
