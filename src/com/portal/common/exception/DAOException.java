package com.portal.common.exception;

/**

 * @author sg13705

 *

 * TODO To change the template for this generated type comment go to

 * Window - Preferences - Java - Code Style - Code Templates

 */

public class DAOException extends Exception
{

	private Throwable thwStack;

	/**
	 * Constructor for DAOException.
	 * @param excp
	 */
	public DAOException(Exception excp)
	{
		super();
		setThwStack(excp);
	}

	public DAOException()
	{

		super();

	}

	public DAOException(String message)
	{
		super(message);
	}

	/**
	* This 	Method DAOException.java
	* @copyright   :
	* @author     :
	* @version    : 
	* @date        :    Jul 18, 2005
	*/
	public Throwable getThwStack()
	{
		return thwStack;
	}

	/**
	* This 	Method DAOException.java
	* @copyright   :
	* @author     :
	* @version    : 
	* @date        :    Jul 18, 2005
	*/
	public void setThwStack(Throwable throwable)
	{
		thwStack = throwable;
	}

}
