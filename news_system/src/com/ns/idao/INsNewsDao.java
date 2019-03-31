package com.ns.idao;

import java.util.List;

import com.ns.common.MyException;
import com.ns.pojo.NsNews;
import com.ns.pojo.NsNewsCatDc;
import com.ns.pojo.NsNewsDc;

public interface INsNewsDao extends INsBaseDao<NsNews, Integer>{
	List<NsNewsDc> selectLike(NsNews news)throws MyException;
	List<NsNewsDc> selectByCatId(Integer catId)throws MyException;
	List<NsNewsDc> selectByDcId(Integer dcId)throws MyException;
	List<NsNewsDc> selectFrist()throws MyException;
	List<NsNewsCatDc> selectConAll()throws MyException;
}
