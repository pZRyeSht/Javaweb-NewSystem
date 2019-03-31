package com.ns.iservice;

import java.util.List;

import com.ns.common.MyException;
import com.ns.pojo.NsNews;
import com.ns.pojo.NsNewsCatDc;
import com.ns.pojo.NsNewsDc;

public interface INsNewsService {
	void addNews(NsNews news)throws MyException;
	void editNews(NsNews news)throws MyException;
	void deleteNews(Integer newsId)throws MyException;
	NsNews findNewsById(Integer newsId)throws MyException;
	List<NsNews> findNewsAll()throws MyException;
	List<NsNewsDc> findNewsLike(NsNews news)throws MyException;
	List<NsNewsDc> findNewsByCatId(Integer catId)throws MyException;
	List<NsNewsDc> findNewsByDcId(Integer dcId)throws MyException;
	List<NsNewsDc> findNewsFrist()throws MyException;
	List<NsNewsCatDc> findNewsConAll()throws MyException;
}
