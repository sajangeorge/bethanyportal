package com.portal.user.interfaces;

import com.portal.common.exception.DAOException;
import com.portal.user.bean.MemberBean;
public interface MemberIntf {
    public boolean addMember(MemberBean memberbean) throws DAOException;
}
