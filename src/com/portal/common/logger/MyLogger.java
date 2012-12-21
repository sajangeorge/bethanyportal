/*
 * Created on Jun 13, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.portal.common.logger;
import java.io.IOException;

import org.apache.log4j.Category;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.*;
import com.portal.common.config.ApplicationConfig;

/**
 * @author sg13705
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
   A simple example showing logger subclassing. 

   <p>See <b><a href="doc-files/MyLogger.java">source code</a></b>
   for more details.

   <p>See {@link MyLoggerTest} for a usage example.
   
 */
public class MyLogger extends Logger {

  // It's usually a good idea to add a dot suffix to the fully
  // qualified class name. This makes caller localization to work
  // properly even from classes that have almost the same fully
  // qualified class name as MyLogger, e.g. MyLoggerTest.
  static String FQCN = MyLogger.class.getName() + ".";

  // It's enough to instantiate a factory once and for all.
  private static MyLoggerFactory myFactory = new MyLoggerFactory();
  protected static MyLogger logger = null;
  /**
     Just calls the parent constuctor.
   */
  public MyLogger(String name) {
    super(name);
  }

 /* 
  public 
  void debug(Object message) {
    super.log(FQCN, Level.DEBUG, message, null);    
  }
*/
  /**
     This method overrides {@link Logger#getLogger} by supplying
     its own factory type as a parameter.
  */
	public static Category getInstance(String name) {
		if (logger == null) {
			System.out.println("Entered instance");
			logger = (MyLogger) Logger.getLogger(name, myFactory);
		}
		return logger;
	}
  public static Logger getLogger(String name) {
  	if (logger == null) {
  	setLogProperties();
  	}
    return Logger.getLogger(name,myFactory); 
  }

/*  public void trace(Object message) {
    super.log(FQCN, XLevel.TRACE, message, null); 
  }*/
  private static void setLogProperties() {
     
	Logger root = Logger.getRootLogger();
    root.setLevel(Level.INFO);
	Layout layout =
		new PatternLayout("%p [%t] - %d{DATE} - %c (%F:%L) - %m%n");
	Layout layoutconsole =
			new PatternLayout("%p - (%F:%L) - %m%n");
	//Layout layoutconsole =
		//new PatternLayout("%p [%t] - %m%n");
	ConsoleAppender appenderconsole = null;//This is to show output in the console
	RollingFileAppender appender = null;
	ApplicationConfig applicationconfig=ApplicationConfig.getInstance();
	String logFile = applicationconfig.getLoggerpath();
	//System.out.println("LOG FILE"+logFile);
	try {
		appender = new RollingFileAppender(layout, logFile);
		appenderconsole = new ConsoleAppender(layoutconsole);//This is to show output in the console
		appender.setMaxFileSize("1500KB");
		appender.setMaxBackupIndex(1);
		root.addAppender(appender);
		//root.addAppender(new RollingFileAppender(layout, logFile));//This is to insert to logfile
	    root.addAppender(appenderconsole);//This is to show output in the console
		} catch (IOException e) {
		e.printStackTrace();
	}
}
  
  
}



