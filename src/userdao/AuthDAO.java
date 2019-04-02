package userdao;

import java.sql.SQLException;

import bean.users.AuthBean;

public interface AuthDAO extends GenericDAO<AuthBean> {

	AuthBean getByEmail(String email) throws ClassNotFoundException,
			SQLException;

	AuthBean getByEmailAndPass(String email, String password)
			throws ClassNotFoundException, SQLException;
	
}
