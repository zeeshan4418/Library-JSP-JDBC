package bean.users;

public class NotificationBean {
	
	private int id;
	private int userId;
	private int agentId;
	private String message;
	private String Date;
	private String status;
	
	
	public NotificationBean() {
		super();
	}


	public NotificationBean(int id, int userId, int agentId, String message,
			String date, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.agentId = agentId;
		this.message = message;
		Date = date;
		this.status = status;
	}

	
	public NotificationBean(int userId, int agentId, String message,
			String date, String status) {
		super();
		this.userId = userId;
		this.agentId = agentId;
		this.message = message;
		Date = date;
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


	public int getAgentId() {
		return agentId;
	}


	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getDate() {
		return Date;
	}


	public void setDate(String date) {
		Date = date;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
