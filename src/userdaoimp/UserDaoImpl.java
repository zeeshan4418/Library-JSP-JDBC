package userdaoimp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import userdao.UserDAO;
import utils.Database;
import bean.bookbean.BookIssueBean;
import bean.users.UserBean;

public class UserDaoImpl implements UserDAO {

	private Database connection;

	public UserDaoImpl() {
		connection = new Database();
	}

	@Override
	public int insert(UserBean c) throws ClassNotFoundException, SQLException {
		connection.open();
		String sql = "INSERT INTO users(role_id, first_name, last_name, status) VALUES(?,?,?,?)";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, c.getRoleId());
		stmt.setString(2, c.getFirstName());
		stmt.setString(3, c.getLastName());
		stmt.setString(4, c.getStatus());
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

	@Override
	public List<UserBean> getAll() throws ClassNotFoundException, SQLException {
		List<UserBean> usersList = new ArrayList<>();
		connection.open();
		String sql = "SELECT * FROM users";
		connection.initStatement(sql);
		ResultSet rs = connection.executeQuery();
		while (rs.next()) {
			UserBean c = new UserBean();
			c.setRoleId(rs.getInt("role_id"));
			c.setId(rs.getInt("user_id"));
			c.setFirstName(rs.getString("first_name"));
			c.setLastName(rs.getString("last_name"));
			c.setStatus(rs.getString("status"));
			usersList.add(c);

		}

		connection.close();
		return usersList;

	}

	@Override
	public UserBean getById(int id) throws ClassNotFoundException, SQLException {
		UserBean c = null;
		connection.open();
		String sql = "SELECT * FROM users WHERE user_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = connection.executeQuery();
		while (rs.next()) {
			c = new UserBean();
			c.setId(rs.getInt("user_id"));
			c.setRoleId(rs.getInt("role_id"));
			c.setFirstName(rs.getString("first_name"));
			c.setLastName(rs.getString("last_name"));
			c.setStatus(rs.getString("status"));
		}

		connection.close();
		return c;
	}

	@Override
	public int update(UserBean c) throws ClassNotFoundException, SQLException {
		connection.open();
		String sql = "UPDATE users SET role_id=?, first_name=?, last_name=?, status=? WHERE user_id=?";

		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, c.getRoleId());
		stmt.setString(2, c.getFirstName());
		stmt.setString(3, c.getLastName());
		stmt.setString(4, c.getStatus());
		stmt.setInt(5, c.getId());

		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		connection.open();
		String sql = "DELETE FROM users WHERE user_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, id);
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

	@Override
	public int softDelete(int id) throws ClassNotFoundException, SQLException {
		connection.open();
		String sql = "UPDATE users SET status=? WHERE user_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setString(1, "0");
		stmt.setInt(2, id);
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

	@Override
	public int requestBook(BookIssueBean i) throws ClassNotFoundException, SQLException {
		connection.open();
		String sql = "INSERT INTO book_issue(user_id, book_id, approve_by, request_date, date_of_issue, is_return, status) "
				+ "VALUES(?,?,?,?,?,?,?)";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, i.getUserId());
		stmt.setInt(2, i.getBookId());
		stmt.setInt(3, i.getAgentId());
		stmt.setString(4, i.getRequestDate());
		stmt.setString(5, i.getDateOfIssue());
		stmt.setString(6, i.getIsReturn());
		stmt.setString(7, i.getStatus());
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

	@Override
	public BookIssueBean getBookIssueRequestById(int id) throws ClassNotFoundException, SQLException {
		BookIssueBean c = null;
		connection.open();
		String sql = "SELECT * FROM book_issue WHERE book_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = connection.executeQuery();
		while (rs.next()) {
			c = new BookIssueBean();
			c.setId(rs.getInt("b_issue_id"));
			c.setUserId(rs.getInt("user_id"));
			c.setBookId(rs.getInt("book_id"));
			c.setAgentId(rs.getInt("approve_by"));
			c.setRequestDate(rs.getString("request_date"));
			c.setDateOfIssue(rs.getString("date_of_issue"));
			c.setIsReturn(rs.getString("is_return"));
			c.setStatus(rs.getString("status"));
		}

		connection.close();
		return c;
	}

	@Override
	public BookIssueBean getBookIssueById(int id) throws ClassNotFoundException, SQLException {
		BookIssueBean c = null;
		connection.open();
		String sql = "SELECT * FROM book_issue WHERE b_issue_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = connection.executeQuery();
		while (rs.next()) {
			c = new BookIssueBean();
			c.setId(rs.getInt("b_issue_id"));
			c.setUserId(rs.getInt("user_id"));
			c.setBookId(rs.getInt("book_id"));
			c.setAgentId(rs.getInt("approve_by"));
			c.setRequestDate(rs.getString("request_date"));
			c.setDateOfIssue(rs.getString("date_of_issue"));
			c.setIsReturn(rs.getString("is_return"));
			c.setStatus(rs.getString("status"));
		}

		connection.close();
		return c;
	}

	@Override
	public BookIssueBean getBookIssueRequestByBookId(int id, int approve) throws ClassNotFoundException, SQLException {
		BookIssueBean c = null;
		connection.open();
		String sql;
		if(approve != 0){
			sql = "SELECT * FROM book_issue WHERE book_id=?";
		}
		else{
			sql = "SELECT * FROM book_issue WHERE book_id=? AND approve_by=0";
		}
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = connection.executeQuery();
		while (rs.next()) {
			c = new BookIssueBean();
			c.setId(rs.getInt("b_issue_id"));
			c.setUserId(rs.getInt("user_id"));
			c.setBookId(rs.getInt("book_id"));
			c.setAgentId(rs.getInt("approve_by"));
			c.setRequestDate(rs.getString("request_date"));
			c.setDateOfIssue(rs.getString("date_of_issue"));
			c.setIsReturn(rs.getString("is_return"));
			c.setStatus(rs.getString("status"));
		}

		connection.close();
		return c;
	}

	@Override
	public List<BookIssueBean> getBookIssueByUserId(int id) throws ClassNotFoundException, SQLException {
		BookIssueBean c = null;
		List<BookIssueBean> bookList = new ArrayList<>();
		connection.open();
		String sql = "SELECT * FROM book_issue WHERE user_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = connection.executeQuery();
		while (rs.next()) {
			c = new BookIssueBean();
			c.setId(rs.getInt("b_issue_id"));
			c.setUserId(rs.getInt("user_id"));
			c.setBookId(rs.getInt("book_id"));
			c.setAgentId(rs.getInt("approve_by"));
			c.setRequestDate(rs.getString("request_date"));
			c.setDateOfIssue(rs.getString("date_of_issue"));
			c.setIsReturn(rs.getString("is_return"));
			c.setStatus(rs.getString("status"));
			bookList.add(c);
		}

		connection.close();
		return bookList;
	}

	@Override
	public int removeRequestBook(int bookId, int userId) throws ClassNotFoundException, SQLException {
		
		connection.open();
		String sql = "DELETE FROM `book_issue` WHERE book_id=? AND user_id=? AND approve_by=0";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, bookId);
		stmt.setInt(2, userId);
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

	@Override
	public int acceptBookRequest(int id, int userId) throws ClassNotFoundException, SQLException {
		connection.open();
		String sql = "UPDATE book_issue SET status=?, approve_by=? WHERE b_issue_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setString(1, "1");
		stmt.setInt(2, userId);
		stmt.setInt(3, id);
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

	@Override
	public int rejectedBookRequest(int id, int userId) throws ClassNotFoundException, SQLException {
		connection.open();
		String sql = "UPDATE book_issue SET status=?, approve_by=? WHERE b_issue_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setString(1, "2");
		stmt.setInt(2, userId);
		stmt.setInt(3, id);
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}
	
	public int getBookIssueLimit(int userId) throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM book_issue where user_id="+userId;
		connection.open();
		Statement s = connection.initStatementRow();
		ResultSet rs = s.executeQuery(sql);
		rs.last();
	    int count = rs.getRow();
	    rs.beforeFirst();
	    connection.close();
	    return count;
	}
	
	@Override
	public BookIssueBean getBookIssueRequestByBookIdUserId(int id, int userId) throws ClassNotFoundException, SQLException {
		BookIssueBean c = null;
		connection.open();
		String sql;
		sql = "SELECT * FROM book_issue WHERE book_id=? AND user_id approve_by > 0";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = connection.executeQuery();
		while (rs.next()) {
			c = new BookIssueBean();
			c.setId(rs.getInt("b_issue_id"));
			c.setUserId(rs.getInt("user_id"));
			c.setBookId(rs.getInt("book_id"));
			c.setAgentId(rs.getInt("approve_by"));
			c.setRequestDate(rs.getString("request_date"));
			c.setDateOfIssue(rs.getString("date_of_issue"));
			c.setIsReturn(rs.getString("is_return"));
			c.setStatus(rs.getString("status"));
		}

		connection.close();
		return c;
	}

}
