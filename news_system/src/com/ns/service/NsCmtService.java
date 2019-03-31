package com.ns.service;

import com.ns.common.MyException;
import com.ns.common.MyFactory;
import com.ns.idao.INsCmtDao;
import com.ns.iservice.INsCmtService;
import com.ns.pojo.NsCmt;

public class NsCmtService implements INsCmtService {

	private INsCmtDao cmtDao = (INsCmtDao)MyFactory.getBean("cmtDao");
	
	@Override
	public void addCmt(NsCmt cmt) throws MyException{
		cmtDao.insert(cmt);
	}

	@Override
	public void editCmt(NsCmt cmt) throws MyException{
		cmtDao.update(cmt);
	}

	@Override
	public void deleteCmt(Integer cmtId) throws MyException{
		cmtDao.delete(cmtId);
	}

	@Override
	public NsCmt findCmtById(Integer cmtId) throws MyException{
		return cmtDao.selectById(cmtId);
	}

}
