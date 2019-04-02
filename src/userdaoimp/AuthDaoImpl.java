package userdaoimp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import userdao.AuthDAO;
import utils.Database;
import bean.users.AuthBean;

public class AuthDaoImpl implements AuthDAO {

	private Database connection;

	public AuthDaoImpl() {
		connection = new Database();
	}

	@Override
	public int insert(AuthBean c) throws ClassNotFoundException,
			SQLException {
		connection.open();
		String sql = "INSERT INTO login_credentials(user_id, email, password,status) VALUES(?,?,?,?)";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, c.getUserId());
		stmt.setString(2, c.getEmail());
		stmt.setString(3, c.getPassword());
		stmt.setString(4, c.getStatus());
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

	@Override
	public List<AuthBean> getAll() throws ClassNotFoundException,
			SQLException {
		List<AuthBean> authList = new ArrayList<>();
		connection.open();
		String sql = "SELECT * FROM login_credentials";
		connection.initStatement(sql);
		ResultSet rs = connection.executeQuery();
		while (rs.next()) {
			AuthBean c = new AuthBean();
			c.setId(rs.getInt("id"));
			c.setUserId(rs.getInt("user_id"));
			c.setEmail(rs.getString("email"));
			c.setPassword(rs.getString("password"));
			authList.add(c);

		}

		connection.close();
		return authList;

	}

	@Override
	public AuthBean getById(int id) throws ClassNotFoundException,
			SQLException {
		AuthBean c = null;
		connection.open();
		String sql = "SELECT * FROM login_credentials WHERE user_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = connection.executeQuery();
		while (rs.next()) {
			c = new AuthBean();
			c.setId(rs.getInt("id"));
			c.setUserId(rs.getInt("user_id"));
			c.setEmail(rs.getString("email"));
			c.setPassword(rs.getString("password"));
		}

		connection.close();
		return c;
	}
	
	@Override
	public AuthBean getByEmail(String email) throws ClassNotFoundException,
			SQLException {
		AuthBean c = null;
		connection.open();
		String sql = "SELECT * FROM login_credentials WHERE email=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setString(1, email);
		ResultSet rs = connection.executeQuery();
		
		while (rs.next()) {
			c = new AuthBean();
			c.setId(rs.getInt("id"));
			c.setUserId(rs.getInt("user_id"));
			c.setEmail(rs.getString("email"));
			c.setPassword(rs.getString("password"));
		}

		connection.close();
		return c;
	}
	
	@Override
	public AuthBean getByEmailAndPass(String email, String password) throws ClassNotFoundException,
			SQLException {
		AuthBean c = null;
		connection.open();
		String sql = "SELECT * FROM login_credentials WHERE email=? AND password=? AND Status=2";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setString(1, email);
		stmt.setString(2, password);
		ResultSet rs = connection.executeQuery();
		
		while (rs.next()) {
			c = new AuthBean();
			c.setId(rs.getInt("id"));
			c.setUserId(rs.getInt("user_id"));
			c.setEmail(rs.getString("email"));
			c.setPassword(rs.getString("password"));
		}

		connection.close();
		return c;
	}

	@Override
	public int update(AuthBean c) throws ClassNotFoundException,
			SQLException {
		connection.open();
		String sql = "UPDATE login_credentials SET email=?, password=? WHERE user_id=?";

		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setString(1, c.getEmail());
		stmt.setString(2, c.getPassword());
		stmt.setInt(4, c.getId());
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		connection.open();
		String sql = "DELETE FROM login_credentials WHERE user_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, id);
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}
	
	@Override
	public int softDelete(int id) throws ClassNotFoundException, SQLException {
		connection.open();
		String sql = "UPDATE login_credentials SET status=? WHERE user_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setString(1, "0");
		stmt.setInt(2, id);
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}
}
