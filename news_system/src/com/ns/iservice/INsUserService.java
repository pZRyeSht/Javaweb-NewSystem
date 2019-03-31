package com.ns.iservice;

import java.util.List;

import com.ns.common.MyException;
import com.ns.pojo.NsUser;

public interface INsUserService {
	void addUser(NsUser user)throws MyException;
	void editUser(NsUser user)throws MyException;
	void deleteUser(Integer userId)throws MyException;
	NsUser findUserById(Integer userId)throws MyException;
	NsUser findUserByNameAndPwd(String userName, String userPwd)throws MyException;
	List<NsUser> findUsers(String userName, Integer pageNo, Integer pageSize)throws MyException;
	List<NsUser> findUsersAll()throws MyException;
	int findCount()throws MyException;
}
