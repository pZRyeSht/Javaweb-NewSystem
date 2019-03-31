package com.ns.idao;

import java.util.List;

import com.ns.common.MyException;
import com.ns.pojo.NsDc;
import com.ns.pojo.NsDcCat;

public interface INsDcDao extends INsBaseDao<NsDc, Integer>{
	List<NsDc> selectByCatId(Integer catId)throws MyException;
	List<NsDcCat> selectDcCat()throws MyException;
}
