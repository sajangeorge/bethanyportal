/*
 * Created on Jun 13, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.portal.common.util;

/**
 * @author sg13705
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.portal.common.config.ApplicationConfig;
import com.portal.common.resource.PortalConstants;

public class PropertyUtil {
    
	public ApplicationConfig applicationconfig = ApplicationConfig.getInstance();
	public String getQuery(String key){
	    String query="";
		try{
			Properties properties=new Properties();
			FileInputStream io=new FileInputStream(applicationconfig.getDbqueriespath());
			properties.load(io);
		    query=properties.getProperty(key);
			io.close();
			PortalConstants.logger.info("Query :  " +query);
		}
		catch(IOException e){
			PortalConstants.logger.error("IO Exception"+e.getMessage());
		}
		catch(Exception e){
			PortalConstants.logger.error("General Exception"+e.getMessage());
		}
		return query;
	}
	
	public String getError(String key){
		String error="";
		try{
			Properties properties=new Properties();
			FileInputStream io=new FileInputStream(applicationconfig.getErrorlistpath());
			properties.load(io);
		    error=properties.getProperty(key);
			io.close();			
		}
		catch(IOException e){
			PortalConstants.logger.error("IO Exception"+e.getMessage());
		}
		catch(Exception e){
			PortalConstants.logger.error("General Exception"+e.getMessage());
		}
		return error;
		
	}
	
	
}
