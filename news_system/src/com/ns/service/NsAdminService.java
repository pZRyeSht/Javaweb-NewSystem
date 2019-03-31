package com.ns.service;

import java.util.List;

import com.ns.common.MyException;
import com.ns.common.MyFactory;
import com.ns.idao.INsAdminDao;
import com.ns.iservice.INsAdminService;
import com.ns.pojo.NsAdmin;

public class NsAdminService implements INsAdminService {
	private INsAdminDao adminDao = (INsAdminDao)MyFactory.getBean("adminDao");

	@Override
	public void addAdmin(NsAdmin Admin) throws MyException{
		adminDao.insert(Admin);
	}

	@Override
	public void editAdmin(NsAdmin Admin) throws MyException{
		adminDao.update(Admin);
	}

	@Override
	public void deleteAdmin(Integer AdminId) throws MyException{
		adminDao.delete(AdminId);
	}

	@Override
	public NsAdmin findAdminById(Integer AdminId)throws MyException{
		return adminDao.selectById(AdminId);
	}

	@Override
	public NsAdmin findAdminByNameAndPwd(String AdminName, String AdminPwd)throws MyException{
		return adminDao.selectOne(AdminName, AdminPwd);
	}

	@Override
	public List<NsAdmin> findAdmin(String AdminName, Integer pageNo, Integer pageSize)throws MyException{
		return null;
//		return adminDao.selectSome(AdminName,pageNo,pageSize);
	}

	@Override
	public List<NsAdmin> findAdminAll() throws MyException {
		// TODO Auto-generated method stub
		return adminDao.selectall();
	}

	@Override
	public int findCount()throws MyException{
		return adminDao.selectAllCount();
	}
	
}
