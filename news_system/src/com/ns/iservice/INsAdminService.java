package com.ns.iservice;

import java.util.List;

import com.ns.common.MyException;
import com.ns.pojo.NsAdmin;

public interface INsAdminService {
	void addAdmin(NsAdmin Admin)throws MyException;
	void editAdmin(NsAdmin Admin)throws MyException;
	void deleteAdmin(Integer AdminId)throws MyException;
	NsAdmin findAdminById(Integer AdminId)throws MyException;
	NsAdmin findAdminByNameAndPwd(String AdminName, String AdminPwd)throws MyException;
	List<NsAdmin> findAdmin(String AdminName, Integer pageNo, Integer pageSize)throws MyException;
	List<NsAdmin> findAdminAll()throws MyException;
	int findCount()throws MyException;
}
