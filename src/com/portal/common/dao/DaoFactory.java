package com.portal.common.dao;

import com.portal.admin.dao.*;
import com.portal.common.resource.PortalConstants;
import com.portal.user.dao.*;
import com.portal.dao.interfaces.*;

public final class DaoFactory {
	private DaoFactory() {
		super();
	}

	public static Baseinterface getDAO(String strDaoName) {
       
		if (PortalConstants.USER_LOGIN.equalsIgnoreCase(strDaoName)){
			return UserLoginDAO.getInstance();
		}
		if (PortalConstants.MEMBER_DAO.equalsIgnoreCase(strDaoName)){		
			return MemberDAO.getInstance();
		}
		
		return null;
	}
}
