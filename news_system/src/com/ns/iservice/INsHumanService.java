package com.ns.iservice;

import java.util.List;

import com.ns.common.MyException;
import com.ns.pojo.NsHuman;

public interface INsHumanService {
	void addHuman(NsHuman human)throws MyException;
	void editHuman(NsHuman human)throws MyException;
	void deleteHuman(Integer humanId)throws MyException;
	NsHuman findHumanById(Integer humanId)throws MyException;
	List<NsHuman> findHumanAll()throws MyException;
	void updateNum(Integer id)throws MyException;
}
