package com.portal.common.config;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.portal.common.resource.PortalConstants;

public class ApplicationServletContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) {
		String path;
		String dbqueriespath;
		String loggerpath;
		System.out.println("Entered Servlet Listener");
		ApplicationConfig applicationconfig = ApplicationConfig.getInstance();
        ServletContext sc = event.getServletContext();
        String queriesconfig = sc.getInitParameter("QueriesConfig");
        System.out.println(queriesconfig);
        path = sc.getInitParameter("QueriesConfig");
		dbqueriespath = sc.getRealPath(path);
		applicationconfig.setDbqueriespath(dbqueriespath);
		path = sc.getInitParameter("LogPath");
		loggerpath = sc.getRealPath(path);
		System.out.println(loggerpath);
		
		applicationconfig.setLoggerpath(loggerpath);
        PortalConstants.logger.info("Queries File " + loggerpath);
    }

    public void contextDestroyed(ServletContextEvent event) {
    	PortalConstants.logger.info("MyApplicationContextListener.contextInitialized stopped");
    }
}

