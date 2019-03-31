package com.ns.iservice;

import com.ns.common.MyException;
import com.ns.pojo.NsCmt;

public interface INsCmtService {
	void addCmt(NsCmt cmt)throws MyException;
	void editCmt(NsCmt cmt)throws MyException;
	void deleteCmt(Integer cmtId)throws MyException;
	NsCmt findCmtById(Integer cmtId)throws MyException;
}
