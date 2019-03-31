package com.ns.service;

import java.util.List;

import com.ns.common.MyException;
import com.ns.common.MyFactory;
import com.ns.idao.INsDcDao;
import com.ns.iservice.INsDcService;
import com.ns.pojo.NsDc;
import com.ns.pojo.NsDcCat;

public class NsDcService implements INsDcService {

	private INsDcDao dcDao = (INsDcDao)MyFactory.getBean("dcDao");
	
	@Override
	public void addDc(NsDc dc) throws MyException{
		// TODO Auto-generated method stub
		dcDao.insert(dc);
	}

	@Override
	public void editDc(NsDc dc) throws MyException{
		// TODO Auto-generated method stub
		dcDao.update(dc);
	}

	@Override
	public void deleteDc(Integer dcId) throws MyException{
		// TODO Auto-generated method stub
		dcDao.delete(dcId);
	}

	@Override
	public List<NsDc> findtall() throws MyException{
		// TODO Auto-generated method stub
		return dcDao.selectall();
	}

	@Override
	public NsDc findDcById(Integer id) throws MyException{
		// TODO Auto-generated method stub
		return dcDao.selectById(id);
	}

	@Override
	public List<NsDc> findDcByCatId(Integer catid) throws MyException {
		// TODO Auto-generated method stub
		return dcDao.selectByCatId(catid);
	}

	@Override
	public List<NsDcCat> findDcCat() throws MyException {
		// TODO Auto-generated method stub
		return dcDao.selectDcCat();
	}

	
}
