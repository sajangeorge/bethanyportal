package com.portal.common.resource;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class PortalInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {
		String result = null;
		ActionSupport action = (ActionSupport) invocation.getAction();
		Map<String, Object> session = invocation.getInvocationContext()
				.getSession();
		Object user = session.get("UserObj");
		if (user == null) {
			action.addActionError("Please login with valid user");
			result = "loginerror";
			return result;
		} else {
			result = invocation.invoke();
			return result;
		}

	}
}
