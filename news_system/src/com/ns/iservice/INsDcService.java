package com.ns.iservice;

import java.util.List;

import com.ns.common.MyException;
import com.ns.pojo.NsDc;
import com.ns.pojo.NsDcCat;

public interface INsDcService {
	void addDc(NsDc dc)throws MyException;
	void editDc(NsDc dc)throws MyException;
	void deleteDc(Integer dcId)throws MyException;
	List<NsDc> findtall()throws MyException;
	NsDc findDcById(Integer dcid)throws MyException;
	List<NsDc> findDcByCatId(Integer catid)throws MyException;
	List<NsDcCat> findDcCat()throws MyException;
}
