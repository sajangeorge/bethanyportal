package com.portal.common.config;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.*;
import javax.sql.DataSource;

//import com.jnj.consumerdurables.healthcare.common.resource.JnJConstants;


/**
 * @author Sajan
 *
 * This class is responsible for getting the Application config details.
 * this is responsible for loading the following
 * real path
 * dbqueries
 * loggerpath
 * datasource
 * xml mapping
 * errorlist path
 * table header path
 */

public class ApplicationConfig
{
	private static ApplicationConfig uniqueInstance = null;
	private String realpath = null;
	private String dbqueriespath = null;
	private String loggerpath = null;
	private String loggerproppath = null;
	private DataSource datasource = null;
	private String xmlmapping = null;
	private String errorlistpath = null;
	private String tableheaderpath = null;
	private Properties properties = null;
	

	public static ApplicationConfig getInstance()
	{
		if (uniqueInstance == null)
			uniqueInstance = new ApplicationConfig();
		return uniqueInstance;
	}

	public void setDataSource(DataSource dbcpdatasource)
	{
		this.datasource = dbcpdatasource;
	}

	public DataSource getDataSource()
	{
		return this.datasource;
	}

	public void setRealpath(String realpath)
	{
		this.realpath = realpath;
	}

	public String getRealPath()
	{
		return this.realpath;
	}

	/**
	 * @return Returns the dbqueriespath.
	 */
	public String getDbqueriespath()
	{
		return dbqueriespath;
	}
	/**
	 * @param dbqueriespath The dbqueriespath to set.
	 */
	public void setDbqueriespath(String dbqueriespath)
	{
		this.dbqueriespath = dbqueriespath;
	}
	/**
	 * @return Returns the loggerpath.
	 */
	public String getLoggerpath()
	{
		return loggerpath;
	}
	/**
	 * @param loggerpath The loggerpath to set.
	 */
	public void setLoggerpath(String loggerpath)
	{
		this.loggerpath = loggerpath;
	}
	/**
	 * @return Returns the loggerproppath.
	 */
	public String getLoggerproppath()
	{
		return loggerproppath;
	}
	/**
	 * @param loggerproppath The loggerproppath to set.
	 */
	public void setLoggerproppath(String loggerproppath)
	{
		this.loggerproppath = loggerproppath;
	}

	/**
	 * @return Returns the xmlmapping.
	 */
	public String getXmlmapping()
	{
		return xmlmapping;
	}
	/**
	 * @param xmlmapping The xmlmapping to set.
	 */
	public void setXmlmapping(String xmlmapping)
	{
		this.xmlmapping = xmlmapping;
	}
	/**
	 * @return Returns the errorlistpath.
	 */
	public String getErrorlistpath()
	{
		return errorlistpath;
	}
	/**
	 * @param errorlistpath The errorlistpath to set.
	 */
	public void setErrorlistpath(String errorlistpath)
	{
		this.errorlistpath = errorlistpath;
	}
	/**
	 * @return Returns the tableheaderpath.
	 */
	public String getTableheaderpath()
	{
		return tableheaderpath;
	}
	/**
	 * @param tableheaderpath The tableheaderpath to set.
	 */
	public void setTableheaderpath(String tableheaderpath)
	{
		this.tableheaderpath = tableheaderpath;
	}
	/**
	* This 	Method ApplicationConfig.java
	* @copyright   :
	* @author     :
	* @version    : 
	* @date        :    Jul 18, 2005
	*/
	public Properties getProperties()
	{
		return properties;
	}

	/**
	* This 	Method ApplicationConfig.java
	* @copyright   :
	* @author     :
	* @version    : 
	* @date        :    Jul 18, 2005
	*/
	public void setProperties(String connectionproppath)
	{
		/*try{
		properties = new Properties();		
	      this.properties.load(new FileInputStream(new File(connectionproppath)));		
		}catch(IOException e){
			JnJConstants.logger.error("Exception occured in applicationconfig = "+e.getMessage());
		}*/
		
	}
}
	