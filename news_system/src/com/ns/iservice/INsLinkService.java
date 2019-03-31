package com.ns.iservice;

import java.util.List;

import com.ns.common.MyException;
import com.ns.pojo.NsLink;

public interface INsLinkService {
	void addLink(NsLink link)throws MyException;
	void editLink(NsLink link)throws MyException;
	void deleteLink(Integer linkId)throws MyException;
	NsLink findLinkById(Integer linkId)throws MyException;
	List<NsLink> findLinkAll()throws MyException;
	List<NsLink> findLinkAll(Integer pageNo, Integer pageSize)throws MyException;
}
