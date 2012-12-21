package com.portal.user.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import com.portal.common.logger.MyLogger;
import com.portal.common.resource.PortalConstants;
import com.portal.user.bean.UserBean;
import com.portal.admin.interfaces.UserLoginImpl;

import com.portal.common.dao.DaoFactory;
import com.portal.common.exception.DAOException;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;
	private static final long serialVersionUID = 1L;
	static MyLogger logger = PortalConstants.logger;
	public String execute() {
		boolean logged = false;
		logger.info("Entered action");
		UserBean userbean = new UserBean();
		userbean.setPassword(password);
		userbean.setUserid(username);
		UserLoginImpl userloginimpl = (UserLoginImpl) DaoFactory
				.getDAO("USERLOGINDAO");
		try {
			logged = userloginimpl.validateUser(userbean);
			if (logged == true)
			{
				Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("UserObj",userbean);
				addActionMessage ("Valid User !!!");
				return "success";
			}
			else {
				addActionError("Invalid Username/Password");
				return "error";
			}
		} catch (DAOException e) {
			addActionError("DAO Exception " + e.getMessage());
			PortalConstants.logger.error("DAO Exception " + e.getMessage());
			return "systemerror";

		} catch (Exception e) {
			addActionError("Error" + e.getMessage());
			PortalConstants.logger.error("Error" + e.getMessage());
			return "systemerror";
		}
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
