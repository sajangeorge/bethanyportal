package com.portal.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.portal.common.resource.PortalConstants;
import com.portal.common.logger.MyLogger;
import com.portal.common.exception.DAOException;
import com.portal.common.dao.BaseDao;
import com.portal.admin.dao.UserLoginDAO;
import com.portal.admin.interfaces.*;
import com.portal.user.interfaces.*;
import com.portal.user.bean.*;
import com.portal.common.util.PropertyUtil;
public class MemberDAO extends BaseDao implements MemberIntf  {

	private static MemberDAO memberdao= new MemberDAO();
	static MyLogger logger = PortalConstants.logger;

	private MemberDAO() {

	}

	public static MemberDAO getInstance() {

		return memberdao;
	}
	public boolean addMember(MemberBean memberbean) throws DAOException
	{
		boolean insertflag = false;
		Connection conn = null;
	    PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		try {

			PropertyUtil propertyutil = new PropertyUtil();
		    conn = super.getConnection();
			query = propertyutil.getQuery("query.user.insert");	
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,memberbean.getUserid());
			pstmt.setString(2,memberbean.getPassword());
			pstmt.setString(3,memberbean.getFirstname());
			pstmt.setString(4,memberbean.getLastname());
			pstmt.setString(5,memberbean.getAddress1());
			pstmt.setString(6,memberbean.getAddress2());
			pstmt.setString(7,memberbean.getCity());
			pstmt.setInt(8,memberbean.getPincode());
			pstmt.setString(9,memberbean.getState());
			pstmt.setString(10,memberbean.getCountry());
			pstmt.setString(11,memberbean.getContactno());
			pstmt.setString(12,memberbean.getEmailid());
			pstmt.setString(13,memberbean.getRole());
			pstmt.setString(14,memberbean.getPhotopath());
			pstmt.executeUpdate();
			insertflag =  true;
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
	   return insertflag;
	}
}
