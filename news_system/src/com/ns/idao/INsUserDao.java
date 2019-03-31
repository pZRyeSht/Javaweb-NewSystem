package com.ns.idao;

import com.ns.common.MyException;
import com.ns.pojo.NsUser;

public interface INsUserDao extends INsBaseDao<NsUser, Integer> {
	NsUser selectOne(String userName,String userPwd)throws MyException;
}
