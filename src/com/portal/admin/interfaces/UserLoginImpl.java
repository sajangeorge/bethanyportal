package com.portal.admin.interfaces;

import com.portal.common.exception.DAOException;
import com.portal.user.bean.UserBean;

public interface UserLoginImpl {

	public boolean validateUser(UserBean userbean) throws DAOException;
}
