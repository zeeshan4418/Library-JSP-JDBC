package userdaoimp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import userdao.RolesDAO;
import utils.Database;
import bean.users.RolesBean;

public class RoleDaoImpl implements RolesDAO {

	private Database connection;

	public RoleDaoImpl() {
		connection = new Database();
	}

	@Override
	public int insert(RolesBean c) throws ClassNotFoundException,SQLException {
		connection.open();
		String sql = "INSERT INTO roles(role) VALUES(?)";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setString(1, c.getRole());
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

	@Override
	public List<RolesBean> getAll() throws ClassNotFoundException,SQLException {
		List<RolesBean> roleList = new ArrayList<>();
		connection.open();
		String sql = "SELECT * FROM roles";
		connection.initStatement(sql);
		ResultSet rs = connection.executeQuery();
		while (rs.next()) {
			RolesBean c = new RolesBean();
			c.setId(rs.getInt("role_id"));
			c.setRole(rs.getString("role"));
			roleList.add(c);

		}

		connection.close();
		return roleList;

	}

	@Override
	public RolesBean getById(int id) throws ClassNotFoundException, SQLException {
		
		RolesBean c = null;
		connection.open();
		String sql = "SELECT * FROM roles WHERE role_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = connection.executeQuery();
		while (rs.next()) {
			c = new RolesBean();
			c.setId(rs.getInt("role_id"));
			c.setRole(rs.getString("role"));
		}

		connection.close();
		return c;
	}

	@Override
	public int update(RolesBean c) throws ClassNotFoundException,
			SQLException {
		connection.open();
		String sql = "UPDATE roles SET role=? WHERE role_id=?";

		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setString(1, c.getRole());
		stmt.setInt(2, c.getId());
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		connection.open();
		String sql = "DELETE FROM roles WHERE role_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, id);
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}
	
	@Override
	public int softDelete(int id) throws ClassNotFoundException, SQLException {
		connection.open();
		String sql = "UPDATE role_id SET status=? WHERE user_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setString(1, "0");
		stmt.setInt(2, id);
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

}
