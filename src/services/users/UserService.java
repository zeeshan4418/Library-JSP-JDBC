package services.users;

import java.sql.SQLException;
import java.util.List;

import userdao.AuthDAO;
import userdao.RolesDAO;
import userdao.UserDAO;
import userdaoimp.AuthDaoImpl;
import userdaoimp.RoleDaoImpl;
import userdaoimp.UserDaoImpl;
import admin.dao.BookDAO;
import bean.bookbean.BookIssueBean;
import bean.users.AuthBean;
import bean.users.RolesBean;
import bean.users.UserBean;

public class UserService {

	private UserDAO userDAO = new UserDaoImpl();
	private AuthDAO authDAO = new AuthDaoImpl();
	private RolesDAO roleDAO = new RoleDaoImpl();

	public int insert(UserBean c) throws ClassNotFoundException, SQLException {
		return userDAO.insert(c);
	}

	public int update(UserBean c) throws ClassNotFoundException, SQLException {
		return userDAO.update(c);
	}

	public int delete(int id) throws ClassNotFoundException, SQLException {
		return userDAO.delete(id);
	}

	public int softDelete(int id) throws ClassNotFoundException, SQLException {
		return userDAO.softDelete(id);
	}

	public List<UserBean> getAll() throws ClassNotFoundException, SQLException {
		return userDAO.getAll();
	}

	public UserBean getById(int id) throws ClassNotFoundException, SQLException {
		return userDAO.getById(id);
	}

	public AuthBean getByEmail(String email) throws ClassNotFoundException, SQLException {
		return authDAO.getByEmail(email);
	}

	public RolesBean getByRoleId(int id) throws ClassNotFoundException, SQLException {
		return roleDAO.getById(id);
	}

	public AuthBean getByEmailAndPass(String email, String password) throws ClassNotFoundException, SQLException {
		return authDAO.getByEmailAndPass(email, password);
	}

	public int requestBook(BookIssueBean i) throws ClassNotFoundException, SQLException {
		return userDAO.requestBook(i);
	}

	public BookIssueBean getBookIssueRequestById(int id) throws ClassNotFoundException, SQLException {

		return userDAO.getBookIssueRequestById(id);
	}

	public BookIssueBean getBookIssueRequestByBookId(int id, int approve) throws ClassNotFoundException, SQLException {

		return userDAO.getBookIssueRequestByBookId(id, approve);
	}
	
	public BookIssueBean getBookIssueRequestByBookIdUserId(int id, int userId) throws ClassNotFoundException, SQLException {

		return userDAO.getBookIssueRequestByBookIdUserId(id, userId);
	}


	public int removeRequestBook(int bookId, int userId) throws ClassNotFoundException, SQLException {

		return userDAO.removeRequestBook(bookId, userId);
	}
	
	public int getBookIssueLimit(int userId) throws ClassNotFoundException, SQLException{
		
		return userDAO.getBookIssueLimit(userId);
	}
}
