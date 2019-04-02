package admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import admin.dao.BookDAO;
import bean.bookbean.BookBean;
import bean.bookbean.BookIssueBean;
import utils.Database;

public class BookDaoImpl implements BookDAO {

	private Database connection;

	public BookDaoImpl() {
		connection = new Database();
	}

	@Override
	public int insert(BookBean c) throws ClassNotFoundException, SQLException {
		connection.open();
		String sql = "INSERT INTO books(book_title, book_author, book_publisher, available_copies, total_copies, book_link, status) "
				+ "VALUES(?,?,?,?,?,?,?)";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setString(1, c.getBookTitle());
		stmt.setString(2, c.getBookAuthor());
		stmt.setString(3, c.getBookPublisher());
		stmt.setInt(4, c.getAvailableCopies());
		stmt.setInt(5, c.getTotalCopies());
		stmt.setString(6, c.getBookLink());
		stmt.setString(7, c.getBookStatus());
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

	@Override
	public List<BookBean> getAll() throws ClassNotFoundException, SQLException {
		List<BookBean> bookList = new ArrayList<>();
		connection.open();
		String sql = "SELECT * FROM books";
		connection.initStatement(sql);
		ResultSet rs = connection.executeQuery();
		while (rs.next()) {
			BookBean c = new BookBean();
			c.setId(rs.getInt("book_id"));
			c.setBookTitle(rs.getString("book_title"));
			c.setBookAuthor(rs.getString("book_author"));
			c.setBookPublisher(rs.getString("book_publisher"));
			c.setAvailableCopies(rs.getInt("available_copies"));
			c.setTotalCopies(rs.getInt("total_copies"));
			c.setBookLink(rs.getString("book_link"));
			c.setBookStatus(rs.getString("status"));
			bookList.add(c);

		}

		connection.close();
		return bookList;

	}

	@Override
	public BookBean getById(int id) throws ClassNotFoundException, SQLException {
		BookBean c = null;
		connection.open();
		String sql = "SELECT * FROM books WHERE book_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = connection.executeQuery();
		while (rs.next()) {
			c = new BookBean();
			c.setId(rs.getInt("book_id"));
			c.setBookTitle(rs.getString("book_title"));
			c.setBookAuthor(rs.getString("book_author"));
			c.setBookPublisher(rs.getString("book_publisher"));
			c.setAvailableCopies(rs.getInt("available_copies"));
			c.setTotalCopies(rs.getInt("total_copies"));
			c.setBookLink(rs.getString("book_link"));
			c.setBookStatus(rs.getString("status"));
		}

		connection.close();
		return c;
	}

	@Override
	public int update(BookBean c) throws ClassNotFoundException, SQLException {
		connection.open();
		String sql = "UPDATE books SET book_title=?, book_author=?, book_publisher=?, available_copies=?, total_copies=?, book_link=?, status=? WHERE book_id=?";

		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setString(1, c.getBookTitle());
		stmt.setString(2, c.getBookAuthor());
		stmt.setString(3, c.getBookPublisher());
		stmt.setInt(4, c.getAvailableCopies());
		stmt.setInt(5, c.getTotalCopies());
		stmt.setString(6, c.getBookLink());
		stmt.setString(7, c.getBookStatus());
		stmt.setInt(8, c.getId());

		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		connection.open();
		String sql = "DELETE FROM books WHERE book_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, id);
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

	@Override
	public int softDelete(int id) throws ClassNotFoundException, SQLException {
		connection.open();
		String sql = "UPDATE books SET status=? WHERE book_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setString(1, "0");
		stmt.setInt(2, id);
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

	@Override
	public int enableBook(int id) throws ClassNotFoundException, SQLException {
		connection.open();
		String sql = "UPDATE books SET status=? WHERE book_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setString(1, "1");
		stmt.setInt(2, id);
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

	@Override
	public List<BookBean> searchBookByKeyWord(String keyWord)
			throws ClassNotFoundException, SQLException {
		List<BookBean> bookList = new ArrayList<>();
		connection.open();
		String sql = "SELECT * FROM `books` WHERE `book_title` LIKE '%"
				+ keyWord + "%' OR `book_author` LIKE '%"+keyWord
				+ "%' OR `book_publisher` LIKE '%" + keyWord + "%'";
		connection.initStatement(sql);
		ResultSet rs = connection.executeQuery();
		while (rs.next()) {
			BookBean c = new BookBean();
			c.setId(rs.getInt("book_id"));
			c.setBookTitle(rs.getString("book_title"));
			c.setBookAuthor(rs.getString("book_author"));
			c.setBookPublisher(rs.getString("book_publisher"));
			c.setAvailableCopies(rs.getInt("available_copies"));
			c.setTotalCopies(rs.getInt("total_copies"));
			c.setBookLink(rs.getString("book_link"));
			c.setBookStatus(rs.getString("status"));
			bookList.add(c);

		}

		connection.close();
		return bookList;
	}

	@Override
	public List<BookIssueBean> getAllBookRequests()
			throws ClassNotFoundException, SQLException {
		BookIssueBean c = null;
		List<BookIssueBean> bookList = new ArrayList<>();
		connection.open();
		String sql = "SELECT * FROM book_issue";
		PreparedStatement stmt = connection.initStatement(sql);
		// stmt.setInt(1, 0);
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

	public int getRequestCount() throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM book_issue where status=0";
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
	public int getAvailableCopies(int bookId) throws ClassNotFoundException, SQLException {
		
		String sql = "SELECT * FROM books_copies where status=1";
		connection.open();
		Statement s = connection.initStatementRow();
		ResultSet rs = s.executeQuery(sql);
		rs.last();
	    int count = rs.getRow();
	    rs.beforeFirst();
	    connection.close();
	    return count;
	}

	/*
	 * @Override public BookBean getAvailableCopies(int id) throws
	 * ClassNotFoundException, SQLException { BookBean c = null;
	 * connection.open(); String sql = "SELECT * FROM books WHERE book_id=?";
	 * PreparedStatement stmt = connection.initStatement(sql); stmt.setInt(1,
	 * id); ResultSet rs = connection.executeQuery(); while (rs.next()) { c =
	 * new BookBean(); c.setId(rs.getInt("book_id"));
	 * c.setBookTitle(rs.getString("book_title"));
	 * c.setBookAuthor(rs.getString("book_author"));
	 * c.setBookPublisher(rs.getString("book_publisher"));
	 * c.setAvailableCopies(rs.getInt("available_copies"));
	 * c.setTotalCopies(rs.getInt("total_copies"));
	 * c.setBookLink(rs.getString("book_link"));
	 * c.setBookStatus(rs.getString("status")); }
	 * 
	 * connection.close(); return c; }
	 */
}
