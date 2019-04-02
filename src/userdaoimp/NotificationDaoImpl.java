package userdaoimp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.Database;
import admin.dao.NotificationsDAO;
import bean.users.NotificationBean;
import bean.users.UserBean;

public class NotificationDaoImpl implements NotificationsDAO {

	private Database connection;

	public NotificationDaoImpl() {
		connection = new Database();
	}

	@Override
	public List<NotificationBean> getAll() throws ClassNotFoundException, SQLException {
		
		List<NotificationBean> nList = new ArrayList<>();
		connection.open();
		String sql = "SELECT * FROM notifications";
		connection.initStatement(sql);
		ResultSet rs = connection.executeQuery();
		while (rs.next()) {
			NotificationBean n = new NotificationBean();
			n.setId(rs.getInt("n_id"));
			n.setUserId(rs.getInt("user_id"));
			n.setAgentId(rs.getInt("agent_id"));
			n.setMessage(rs.getString("message"));
			n.setDate(rs.getString("n_date_time"));
			n.setStatus(rs.getString("status"));
			nList.add(n);

		}

		connection.close();
		return nList;
	}

	@Override
	public NotificationBean getById(int id) throws ClassNotFoundException,
			SQLException {
		NotificationBean c = null;
		connection.open();
		String sql = "SELECT * FROM users WHERE user_id=?";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = connection.executeQuery();
		while (rs.next()) {
			c = new NotificationBean();
			/*c.setId(rs.getInt("user_id"));
			c.setRoleId(rs.getInt("role_id"));
			c.setFirstName(rs.getString("first_name"));
			c.setLastName(rs.getString("last_name"));
			c.setStatus(rs.getString("status"));*/
		}

		connection.close();
		return c;
	}

	@Override
	public int insert(NotificationBean t) throws ClassNotFoundException,
			SQLException {

		connection.open();
		String sql = "INSERT INTO notifications(user_id, agent_id, message, n_date_time, status) "
				+ "VALUES(?,?,?,?,?)";
		PreparedStatement stmt = connection.initStatement(sql);
		stmt.setInt(1, t.getUserId());
		stmt.setInt(2, t.getAgentId());
		stmt.setString(3, t.getMessage());
		stmt.setString(4, t.getDate());
		stmt.setString(5, t.getStatus());
		int result = connection.executeUpdate();
		connection.close();
		return result;
	}

	@Override
	public int update(NotificationBean t) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int softDelete(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
