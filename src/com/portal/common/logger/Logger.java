
package com.portal.common.logger;



public class Logger {

	private MyLogger logger = null;

	public Logger() { // instantiate the logger for datalayer
		logger = (MyLogger) MyLogger.getInstance(Logger.class.getName());
	}
	
	/**
		 * @param message
		 */
		public void debug(Object message) {
			logger.debug(message);
		}

		/**
		 * @param message
		 */
		public void info(Object message) {
			logger.info(message);
		}

		/**
		 * @param message
		 */
		public void warn(Object message) {
			logger.warn(message);
		}

		/**
		 * @param message
		 */
		public void error(Object message) {
			logger.error(message);
		}

		/**
		 * @param message
		 * @param throwable
		 */
		public void error(Object message, Throwable throwable) {
			logger.error(message, throwable);
		}

		/**
		 * @param message
		 */
		public void fatal(Object message) {
			logger.fatal(message);
		}

		/**
		 * @param message
		 * @param throwable
		 */
		public void fatal(Object message, Throwable throwable) {
			logger.fatal(message, throwable);
		}

}

