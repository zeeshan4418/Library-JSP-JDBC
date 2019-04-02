package userdao;

import java.sql.SQLException;
import java.util.List;

import bean.bookbean.BookIssueBean;
import bean.users.UserBean;

public interface UserDAO extends GenericDAO<UserBean> {

	int requestBook(BookIssueBean i) throws ClassNotFoundException, SQLException;

	BookIssueBean getBookIssueRequestById(int id) throws ClassNotFoundException, SQLException;

	int removeRequestBook(int bookId, int userId) throws ClassNotFoundException, SQLException;

	BookIssueBean getBookIssueById(int id) throws ClassNotFoundException, SQLException;

	BookIssueBean getBookIssueRequestByBookId(int id, int approve) throws ClassNotFoundException, SQLException;
	
	BookIssueBean getBookIssueRequestByBookIdUserId(int id, int userId) throws ClassNotFoundException, SQLException;

	List<BookIssueBean> getBookIssueByUserId(int id) throws ClassNotFoundException, SQLException;

	int acceptBookRequest(int id, int userId) throws ClassNotFoundException, SQLException;

	int rejectedBookRequest(int id, int userId) throws ClassNotFoundException, SQLException;

	int getBookIssueLimit(int userId) throws ClassNotFoundException, SQLException;
	
}
