package com.ns.idao;

import com.ns.common.MyException;
import com.ns.pojo.NsHuman;

public interface INsHumanDao extends INsBaseDao<NsHuman, Integer>{
	void updateNum(Integer id)throws MyException;
}
