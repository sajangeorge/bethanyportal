package com.portal.common.resource;

import com.portal.common.logger.MyLogger;

/*  
 *  @author - Sajan
 */
public interface PortalConstants
{

	//public static final Logging loggerr =  Logging.getLogger("BPFS");
	public static final MyLogger logger =
		(MyLogger) MyLogger.getLogger("LOGGER");
	
	public static final String ERROR_SQL_DAO = "SQL Error present in DAO ";
	public static final String ERROR_GENERAL_DAO = "General Exception present in DAO";
	public static final String ERROR_CLOSECONNECTION = "Error while closing connection";
	
	public static final String USER_LOGIN = "USERLOGINDAO";
	public static final String MEMBER_DAO = "MEMBERDAO";

	
}