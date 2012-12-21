package com.portal.common.dao;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

import com.portal.common.config.ApplicationConfig;
import com.portal.common.logger.MyLogger;
import com.portal.common.resource.PortalConstants;
import com.portal.dao.interfaces.Baseinterface;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BaseDao implements Baseinterface {
	private static BaseDao uniqueInstance = null;
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/bethany";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "guest123";
	public static DataSource dataSource = null;
	static MyLogger logger = PortalConstants.logger;
	public static final int maxconnections = 1;

	private GenericObjectPool connectionPool = null;

	public DataSource setUp() throws Exception {

		//
		// Load JDBC Driver class.
		//
		Class.forName(BaseDao.DRIVER).newInstance();

		//
		// Creates an instance of GenericObjectPool that holds our
		// pool of connections object.
		//
		connectionPool = new GenericObjectPool();
		connectionPool.setMaxActive(maxconnections);

		//
		// Creates a connection factory object which will be use by
		// the pool to create the connection object. We passes the
		// JDBC url info, username and password.
		//
		ConnectionFactory cf = new DriverManagerConnectionFactory(BaseDao.URL,
				BaseDao.USERNAME, BaseDao.PASSWORD);

		//
		// Creates a PoolableConnectionFactory that will wraps the
		// connection object created by the ConnectionFactory to add
		// object pooling functionality.
		//
		PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf,
				connectionPool, null, null, false, true);
		return new PoolingDataSource(connectionPool);
	}

	public GenericObjectPool getConnectionPool() {
		return connectionPool;
	}

	public Connection getConnection() throws Exception {
		int maxactiveconnection;
		int numactiveconnection;
		if (dataSource == null) {
			dataSource = this.setUp();
		}
		maxactiveconnection = getConnectionPool().getMaxActive();
		numactiveconnection = getConnectionPool().getNumActive();
		if ((numactiveconnection >= maxactiveconnection)
				&& (numactiveconnection > 0)) {
			throw new Exception("Exceeded connections in Connection Pool");
		}
		Connection conn = null;
		try {
			conn = dataSource.getConnection();

		} catch (Exception e) {
			PortalConstants.logger
					.error("Error in Connection" + e.getMessage());
		}
		return conn;
	}

	public void closeResources(ResultSet rset, Statement stmt, Connection conn)
			throws SQLException {
		if (rset != null) {
			rset.close();
		}

		if (stmt != null) {
			stmt.close();
		}

		if (conn != null) {
			conn.close();
		}
		this.printStatus();

	}

	private void printStatus() {
		PortalConstants.logger.info("Max   : "
				+ getConnectionPool().getMaxActive() + "; " + "Active: "
				+ getConnectionPool().getNumActive() + "; " + "Idle  : "
				+ getConnectionPool().getNumIdle());
	}
}
