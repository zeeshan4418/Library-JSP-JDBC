package bean.bookbean;

public class BookBean {

	private int id;
	private String bookTitle;
	private String bookAuthor;
	private String bookPublisher;
	private String bookStatus;
	private String bookLink;
	private int totalCopies;
	private int availableCopies;
	
	public BookBean() {
		super();
	}


	public BookBean(String bookTitle, String bookAuthor, String bookPublisher,
			String bookStatus, String bookLink, int totalCopies,
			int availableCopies) {
		super();
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookStatus = bookStatus;
		this.bookLink = bookLink;
		this.totalCopies = totalCopies;
		this.availableCopies = availableCopies;
	}


	public BookBean(int id, String bookTitle, String bookAuthor,
			String bookPublisher, String bookStatus, String bookLink,
			int totalCopies, int availableCopies) {
		super();
		this.id = id;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookStatus = bookStatus;
		this.bookLink = bookLink;
		this.totalCopies = totalCopies;
		this.availableCopies = availableCopies;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBookTitle() {
		return bookTitle;
	}


	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}


	public String getBookPublisher() {
		return bookPublisher;
	}


	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}


	public String getBookStatus() {
		return bookStatus;
	}


	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}


	public String getBookLink() {
		return bookLink;
	}


	public void setBookLink(String bookLink) {
		this.bookLink = bookLink;
	}


	public int getTotalCopies() {
		return totalCopies;
	}


	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}


	public int getAvailableCopies() {
		return availableCopies;
	}


	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}


	@Override
	public String toString() {
		return "BookBean [id=" + id + ", bookTitle=" + bookTitle
				+ ", bookAuthor=" + bookAuthor + ", bookPublisher="
				+ bookPublisher + ", bookStatus=" + bookStatus + ", bookLink="
				+ bookLink + ", totalCopies=" + totalCopies
				+ ", availableCopies=" + availableCopies + "]";
	}
	
	
	
}
