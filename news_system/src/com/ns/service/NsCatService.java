package com.ns.service;

import java.util.List;

import com.ns.common.MyException;
import com.ns.common.MyFactory;
import com.ns.idao.INsCatDao;

import com.ns.iservice.INsCatService;
import com.ns.pojo.NsCat;

public class NsCatService implements INsCatService {

	private INsCatDao catDao = (INsCatDao)MyFactory.getBean("catDao");

	@Override
	public void addCat(NsCat cat) throws MyException{
		catDao.insert(cat);
	}

	@Override
	public void editCat(NsCat cat) throws MyException{
		catDao.update(cat);
	}

	@Override
	public void deleteCat(Integer catId) throws MyException{
		catDao.delete(catId);
	}

	@Override
	public NsCat findCatById(Integer catId) throws MyException{
		return catDao.selectById(catId);
	}
	
	@Override
	public List<NsCat> findCatAll() throws MyException {
		// TODO Auto-generated method stub
		return catDao.selectall();
	}
}
