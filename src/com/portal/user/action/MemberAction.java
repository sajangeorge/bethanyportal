package com.portal.user.action;

import com.portal.common.logger.MyLogger;
import com.portal.common.resource.PortalConstants;
import com.portal.user.bean.MemberBean;
import com.portal.user.interfaces.MemberIntf;
import com.portal.common.dao.DaoFactory;
import com.portal.common.exception.DAOException;
import com.opensymphony.xwork2.ActionSupport;

public class MemberAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	static MyLogger logger = PortalConstants.logger;
    private MemberBean memberbean;
	
	@Override
	public String execute() throws Exception {
		
		boolean insertflag = false;
		//call Service class to store personBean's state in database
		logger.info(memberbean.getFirstname());
		try{
		MemberIntf memberimpl = (MemberIntf)DaoFactory.getDAO("MEMBERDAO");
		 insertflag = memberimpl.addMember(memberbean);
		 if (insertflag==true)
		 {
		   addActionMessage("UserInserted!!!");	 
		   return "success";
		 } 
		 else
			 return "error";
		} catch (DAOException e) {
			addActionError(e.getMessage());
			logger.error("DAO Exception " + e.getMessage());
			return "systemerror";

		} catch (Exception e) {
			addActionError(e.getMessage());
			logger.error("Error" + e.getMessage());
			return "systemerror";
		}
	}

	public MemberBean getMemberbean() {
		return memberbean;
	}

	public void setMemberbean(MemberBean memberbean) {
		this.memberbean = memberbean;
	}
	
}
