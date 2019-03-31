package com.ns.idao;

import com.ns.common.MyException;
import com.ns.pojo.NsAdmin;

public interface INsAdminDao extends INsBaseDao<NsAdmin, Integer>{
	NsAdmin selectOne(String AdminName,String AdminPwd)throws MyException;
}
