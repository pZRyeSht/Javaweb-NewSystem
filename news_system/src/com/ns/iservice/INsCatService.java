package com.ns.iservice;

import java.util.List;

import com.ns.common.MyException;
import com.ns.pojo.NsCat;

public interface INsCatService {
	void addCat(NsCat cat)throws MyException;
	void editCat(NsCat cat)throws MyException;
	void deleteCat(Integer catId)throws MyException;
	NsCat findCatById(Integer catId)throws MyException;
	List<NsCat> findCatAll() throws MyException;
}
