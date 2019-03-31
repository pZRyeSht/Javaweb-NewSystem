package com.ns.service;

import java.util.List;

import com.ns.common.MyException;
import com.ns.common.MyFactory;
import com.ns.idao.INsUserDao;

import com.ns.iservice.INsUserService;
import com.ns.pojo.NsUser;

public class NsUserService implements INsUserService {
	private INsUserDao userDao = (INsUserDao)MyFactory.getBean("userDao");

	@Override
	public void addUser(NsUser user) throws MyException{
		userDao.insert(user);
		
	}

	@Override
	public void editUser(NsUser user) throws MyException{
		userDao.update(user);
		
	}

	@Override
	public void deleteUser(Integer userId) throws MyException{
		userDao.delete(userId);
		
	}

	@Override
	public NsUser findUserById(Integer userId) throws MyException{
		return userDao.selectById(userId);
//		return userDao.selectById(userId);
	}

	@Override
	public NsUser findUserByNameAndPwd(String userName, String userPwd) throws MyException{
		return userDao.selectOne(userName, userPwd);
//		return userDao.selectOne(userName,userPwd);
	}

	@Override
	public List<NsUser> findUsers(String userName, Integer pageNo, Integer pageSize) throws MyException{
		return null;
//		return userDao.selectSome(userName,pageNo,pageSize);
	}

	@Override
	public List<NsUser> findUsersAll() throws MyException {
		// TODO Auto-generated method stub
		return userDao.selectall();
	}

	@Override
	public int findCount() throws MyException{
		return userDao.selectAllCount();
//		return userDao.selectCount();
	}

}
