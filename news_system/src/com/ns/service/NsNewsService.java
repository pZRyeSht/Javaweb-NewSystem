package com.ns.service;

import java.util.List;

import com.ns.common.MyException;
import com.ns.common.MyFactory;
import com.ns.idao.INsNewsDao;
import com.ns.iservice.INsNewsService;
import com.ns.pojo.NsNews;
import com.ns.pojo.NsNewsCatDc;
import com.ns.pojo.NsNewsDc;

public class NsNewsService implements INsNewsService {
	
	private INsNewsDao newsDao = (INsNewsDao)MyFactory.getBean("newsDao");
	
	@Override
	public void addNews(NsNews news) throws MyException{
		newsDao.insert(news);
	}

	@Override
	public void editNews(NsNews news) throws MyException{
		newsDao.update(news);
	}

	@Override
	public void deleteNews(Integer newsId) throws MyException{
		newsDao.delete(newsId);
	}

	@Override
	public NsNews findNewsById(Integer newsId) throws MyException{
		return newsDao.selectById(newsId);
	}

	@Override
	public List<NsNews> findNewsAll() throws MyException{
		return newsDao.selectall();
//		return userDao.selectSome(newsId);
	}

	@Override
	public List<NsNewsDc> findNewsLike(NsNews news) throws MyException {
		// TODO Auto-generated method stub
		return newsDao.selectLike(news);
	}

	@Override
	public List<NsNewsDc> findNewsByCatId(Integer catId) throws MyException {
		// TODO Auto-generated method stub
		return newsDao.selectByCatId(catId);
	}

	@Override
	public List<NsNewsDc> findNewsByDcId(Integer dcId) throws MyException {
		// TODO Auto-generated method stub
		return newsDao.selectByDcId(dcId);
	}
	
	@Override
	public List<NsNewsDc> findNewsFrist() throws MyException {
		// TODO Auto-generated method stub
		return newsDao.selectFrist();
	}

	@Override
	public List<NsNewsCatDc> findNewsConAll() throws MyException {
		// TODO Auto-generated method stub
		return newsDao.selectConAll();
	}


}
