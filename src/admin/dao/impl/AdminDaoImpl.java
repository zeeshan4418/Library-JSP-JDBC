package admin.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import userdao.UserDAO;
import utils.Database;
import admin.dao.AdminDAO;
import bean.bookbean.BookIssueBean;
import bean.users.UserBean;

public class AdminDaoImpl implements AdminDAO {

	private Database connection;

	public AdminDaoImpl() {
		connection = new Database();
	}

	@Override
	public int insert(UserBean c) throws ClassNotFoundException,
			SQLException {
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
	public List<UserBean> getAll() throws ClassNotFoundException,
			SQLException {
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
	public UserBean getById(int id) throws ClassNotFoundException,
			SQLException {
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
	public int update(UserBean c) throws ClassNotFoundException,
			SQLException {
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

}
