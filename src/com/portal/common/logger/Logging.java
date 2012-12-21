/*
 * Created on Jun 15, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.portal.common.logger;

/**
 * @author sg13705
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import java.io.IOException;

import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import com.portal.common.config.ApplicationConfig;
public class Logging 
{
  // static Logger logger = Logger.getLogger(Logging.class);
   public static Logger getLogger(String name) 
   {
   	setLogProperties();
    return Logger.getLogger(name);
   }
  
   private static void setLogProperties() 
   {

	Logger root = Logger.getRootLogger();
	Layout layout =
		new PatternLayout("%p [%t] - %d{DATE} - %c (%F:%L) - %m%n");
	RollingFileAppender appender = null;
	ApplicationConfig applicationconfig=ApplicationConfig.getInstance();
	String logFile = applicationconfig.getLoggerpath();
	try {
		appender = new RollingFileAppender(layout, logFile);
		appender.setMaximumFileSize(3 * 1024 * 1024);
		root.addAppender(new RollingFileAppender(layout, logFile));
		} catch (IOException e) {
		e.printStackTrace();
	}

   }
}
