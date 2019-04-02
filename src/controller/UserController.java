package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import admin.services.AdminServices;
import bean.bookbean.BookIssueBean;
import bean.users.RolesBean;
import bean.users.UserBean;
import services.users.UserService;


@WebServlet(urlPatterns = { "/user/dashboard", "/user/book/*" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminServices adminService = new AdminServices();
	private UserService userService = new UserService();
    
    public UserController() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String page = SessionChk(req, res);
		if (page != null) {
			HttpSession session = req.getSession(false);
			RolesBean rb = (RolesBean) session.getAttribute("userRole");
			if (rb.getId() != 1) {
				res.sendRedirect(page);
			}
		}
		String action = req.getRequestURI();
		String parameter[] = action.split("/");
		switch (parameter[3]) {
		case "dashboard":
			break;
		case "book":
				
				if(parameter[4].equals("issue")) {
					int bookId = Integer.parseInt(parameter[5]);
					int agentId = 0;
					HttpSession session = req.getSession();
					UserBean ub= (UserBean) session.getAttribute("user");
					long millis=System.currentTimeMillis();  
			        String requestDate = new Date(millis).toString();
			        BookIssueBean ib = new BookIssueBean(ub.getId(), bookId, agentId, "Null", requestDate, "0", "0");
					try {
						int countlimit = userService.getBookIssueLimit(ub.getId());
						if(countlimit < 5){
							userService.requestBook(ib);
						}
						else{
							session.setAttribute("successMessage","You Have Already 5 Books Issued");
						}
							res.sendRedirect("/Library/user/Books.jsp");
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
				if(parameter[4].equals("remove")) {
					int bookId = Integer.parseInt(parameter[5]);
					HttpSession session = req.getSession(false);
					UserBean ub= (UserBean) session.getAttribute("user");
					int userId = ub.getId();
					try {
						userService.removeRequestBook(bookId,userId);
						res.sendRedirect("/Library/user/Books.jsp");
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
			break;                                                                             
		case "notification":
			
			break;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String SessionChk(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String page = null;
		HttpSession session = req.getSession(false);
		if (session.getAttribute("user") != null) {
			RolesBean rb = (RolesBean) session.getAttribute("userRole");
			int id = rb.getId();
			if (id == 2) {
				page = "/Library/agent/index.jsp";
			} else if (id == 1) {
				page = "/Library/admin/index.jsp";
			}
		}
		return page;
	}

}
