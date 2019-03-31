package com.ns.service;

import java.util.List;

import com.ns.common.MyException;
import com.ns.common.MyFactory;
import com.ns.idao.INsHumanDao;
import com.ns.iservice.INsHumanService;
import com.ns.pojo.NsHuman;

public class NsHumanService implements INsHumanService {

	private INsHumanDao humanDao = (INsHumanDao)MyFactory.getBean("humanDao");
	
	@Override
	public void addHuman(NsHuman human) throws MyException{
		humanDao.insert(human);
	}

	@Override
	public void editHuman(NsHuman human) throws MyException{
		humanDao.update(human);
	}

	@Override
	public void deleteHuman(Integer humanId) throws MyException{
		humanDao.delete(humanId);
	}

	@Override
	public NsHuman findHumanById(Integer humanId) throws MyException{
		return humanDao.selectById(humanId);
	}

	@Override
	public List<NsHuman> findHumanAll() throws MyException {
		// TODO Auto-generated method stub
		return humanDao.selectall();
	}

	@Override
	public void updateNum(Integer id) throws MyException {
		// TODO Auto-generated method stub
		humanDao.updateNum(id);
	}

}
