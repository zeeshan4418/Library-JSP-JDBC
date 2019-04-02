package bean.bookbean;

public class BookIssueBean {
	
	private int id;
	private int userId;
	private int bookId;
	private int agentId;
	private String dateOfIssue;
	private String requestDate;
	private String isReturn;
	private String status;
	
	
	public BookIssueBean() {
		super();
	}
	public BookIssueBean(int userId, int bookId, int agentId, String dateOfIssue, String requestDate, String isReturn,
			String status) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.agentId = agentId;
		this.dateOfIssue = dateOfIssue;
		this.requestDate = requestDate;
		this.isReturn = isReturn;
		this.status = status;
	}
	public BookIssueBean(int id, int userId, int bookId, int agentId, String dateOfIssue, String requestDate,
			String isReturn, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.bookId = bookId;
		this.agentId = agentId;
		this.dateOfIssue = dateOfIssue;
		this.requestDate = requestDate;
		this.isReturn = isReturn;
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
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public String getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getIsReturn() {
		return isReturn;
	}
	public void setIsReturn(String isReturn) {
		this.isReturn = isReturn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
		
}
