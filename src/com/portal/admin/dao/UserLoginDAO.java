package com.portal.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.portal.common.resource.PortalConstants;
import com.portal.common.logger.MyLogger;
import com.portal.common.exception.DAOException;
import com.portal.common.dao.BaseDao;
import com.portal.admin.interfaces.*;
import com.portal.user.bean.*;
import com.portal.common.util.PropertyUtil;

public class UserLoginDAO extends BaseDao implements UserLoginImpl {

	private static UserLoginDAO userloginDAO = new UserLoginDAO();
	static MyLogger logger = PortalConstants.logger;

	private UserLoginDAO() {

	}

	public static UserLoginDAO getInstance() {

		return userloginDAO;
	}

	public boolean validateUser(UserBean userbean) throws DAOException {
		boolean validateuser = false;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		try {

			PropertyUtil propertyutil = new PropertyUtil();
		    conn = super.getConnection();
			query = propertyutil.getQuery("query.user.login");
			logger.info("user id :" + userbean.getUserid());
			logger.info("password :" + userbean.getPassword());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userbean.getUserid());
			pstmt.setString(2, userbean.getPassword());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				logger.info("Entered :"
				 +rs.getString("firstname"));
				validateuser = true;
				return validateuser;
			}
			
		}catch (SQLException e){
			logger.error("SQL Exception : " +e.getMessage());
			throw new DAOException(PortalConstants.ERROR_SQL_DAO);
		}
		
		catch (Exception e) {
			logger.error("DAO Exception : " + e.getMessage());
			throw new DAOException(PortalConstants.ERROR_GENERAL_DAO);
		}finally
		{
			try
			{
			  super.closeResources(rs, pstmt, conn);
			}catch(SQLException e)
			{
				
				logger.error(PortalConstants.ERROR_CLOSECONNECTION + " : "+e.getMessage());
				throw new DAOException(PortalConstants.ERROR_CLOSECONNECTION);
			}
		}
		return validateuser;
	}

}
