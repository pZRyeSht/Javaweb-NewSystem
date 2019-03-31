package com.ns.service;

import java.util.List;

import com.ns.common.MyException;
import com.ns.common.MyFactory;
import com.ns.idao.INsLinkDao;
import com.ns.iservice.INsLinkService;
import com.ns.pojo.NsLink;

public class NsLinkService implements INsLinkService {

	private INsLinkDao  linkDao = (INsLinkDao)MyFactory.getBean("linkDao");
	
	@Override
	public void addLink(NsLink link) throws MyException{
		linkDao.insert(link);
	}

	@Override
	public void editLink(NsLink link) throws MyException{
		linkDao.update(link);
	}

	@Override
	public void deleteLink(Integer linkId) throws MyException{
		linkDao.delete(linkId);
	}

	@Override
	public NsLink findLinkById(Integer linkId) throws MyException{
		return linkDao.selectById(linkId);
	}

	@Override
	public List<NsLink> findLinkAll() throws MyException {
		// TODO Auto-generated method stub
		return linkDao.selectall();
	}

	@Override
	public List<NsLink> findLinkAll(Integer pageNo, Integer pageSize) throws MyException {
		// TODO Auto-generated method stub
		return linkDao.selectall(pageNo, pageSize);
	}
	
}
