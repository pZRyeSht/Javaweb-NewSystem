package com.ns.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ns.common.MyException;
import com.ns.idao.INsNewsDao;
import com.ns.pojo.NsNews;
import com.ns.pojo.NsNewsCatDc;
import com.ns.pojo.NsNewsDc;
import com.ns.util.JDBC_util;

public class NsNewsDao implements INsNewsDao {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	@Override
	public void insert(NsNews obj) throws MyException{
		// TODO Auto-generated method stub
		String sql = "insert into news(news_title,news_content,news_datetime,news_firstshow,"
				+ "cat_id,dc_id) values(?,?,?,?,?,?)";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, obj.getNews_title());
			stmt.setString(2, obj.getNews_content());
			stmt.setDate(3, obj.getNews_datetime());
			stmt.setInt(4, obj.getNews_firstshow());
			stmt.setInt(5, obj.getCat_id());
			stmt.setInt(6, obj.getDc_id());
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("插入新闻错误");
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public void update(NsNews obj) throws MyException{
		// TODO Auto-generated method stub
		String sql = "update news set news_title = ?,news_content = ?,news_datetime = ?,news_firstshow = ?,"
				+ "cat_id = ?,dc_id = ? where news_id = ?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, obj.getNews_title());
			stmt.setString(2, obj.getNews_content());
			stmt.setDate(3, obj.getNews_datetime());
			stmt.setInt(4, obj.getNews_firstshow());
			stmt.setInt(5, obj.getCat_id());
			stmt.setInt(6, obj.getDc_id());
			stmt.setInt(7, obj.getNews_id());
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("修改新闻错误");
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public void delete(Integer id) throws MyException{
		// TODO Auto-generated method stub
		String sql = "delete from news where news_id = ?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("删除新闻错误");
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public NsNews selectById(Integer id) throws MyException{
		// TODO Auto-generated method stub
		String sql = "select * from news where news_id = ?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			NsNews news = null;
			if(rs.next()){
				news = new NsNews();
				news.setNews_id(rs.getInt("news_id"));
				news.setNews_title(rs.getString("news_title"));
				news.setNews_content(rs.getString("news_content"));
				news.setNews_datetime(rs.getDate("news_datetime"));
				news.setNews_firstshow(rs.getInt("news_firstshow"));
				news.setCat_id(rs.getInt("cat_id"));
				news.setDc_id(rs.getInt("dc_id"));
			}
			return news;
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("查询新闻错误");
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public List<NsNews> selectall() throws MyException{
		// TODO Auto-generated method stub
		List<NsNews> list = new ArrayList<NsNews>();
		String sql = "select * from news";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			System.out.println(rs);
			rs = stmt.executeQuery();
			System.out.println(rs);
			
			NsNews news = null;
			while(rs.next()){
				news = new NsNews();
				news.setNews_id(rs.getInt("news_id"));
				news.setNews_title(rs.getString("news_title"));
				news.setNews_content(rs.getString("news_content"));
				news.setNews_datetime(rs.getDate("news_datetime"));
				news.setNews_firstshow(rs.getInt("news_firstshow"));
				news.setCat_id(rs.getInt("cat_id"));
				news.setDc_id(rs.getInt("dc_id"));
				list.add(news);
			}
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("查询所有新闻错误");
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public List<NsNews> selectall(Integer pageNo, Integer pageSize) throws MyException{
		// TODO Auto-generated method stub
		List<NsNews> list = new ArrayList<>();
		String sql = "select * from news limit ?,?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, (pageNo-1)*pageSize);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			
			NsNews news = null;
			while(rs.next()){
				news = new NsNews();
				news.setNews_id(rs.getInt("news_id"));
				news.setNews_title(rs.getString("news_title"));
				news.setNews_content(rs.getString("news_content"));
				news.setNews_datetime(rs.getDate("news_datetime"));
				news.setNews_firstshow(rs.getInt("news_firstshow"));
				news.setCat_id(rs.getInt("cat_id"));
				news.setDc_id(rs.getInt("dc_id"));
				list.add(news);
			}
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("分页查询新闻错误");
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public int selectAllCount() throws MyException{
		// TODO Auto-generated method stub
		int i = 0;
		String sql = "select * from news order by news_id";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				++i;
			}
			return i;
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("统计新闻数错误");
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public List<NsNewsDc> selectLike(NsNews news) throws MyException {
		// TODO Auto-generated method stub
		List<NsNewsDc> list = new ArrayList<NsNewsDc>();
		String sql = "SELECT A.news_id,A.news_title,A.news_datetime,B.dc_name FROM news A,dc B WHERE A.dc_id = B.dc_id AND A.cat_id = ? And news_title like concat('%',?,'%')";
		NsNewsDc newsDc = null;
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, news.getCat_id());
			stmt.setString(2, news.getNews_title());
			rs = stmt.executeQuery();
			
			while(rs.next()){
				newsDc = new NsNewsDc();
				newsDc.setNews_id(rs.getInt("A.news_id"));
				newsDc.setNews_title(rs.getString("A.news_title"));
				newsDc.setNews_datetime(rs.getDate("A.news_datetime"));
				newsDc.setDc_name(rs.getString("B.dc_name"));
				list.add(newsDc);
			}
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("新闻模糊查询错误");
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public List<NsNewsDc> selectByCatId(Integer catId) throws MyException {
		// TODO Auto-generated method stub
		List<NsNewsDc> list = new ArrayList<NsNewsDc>();
		String sql = "SELECT A.news_id,A.news_title,A.news_datetime,B.dc_name FROM news A,dc B WHERE A.dc_id = B.dc_id AND A.cat_id = ?";
		NsNewsDc newsDc = null;
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, catId);
			rs = stmt.executeQuery();
			while(rs.next()){
				newsDc = new NsNewsDc();
				newsDc.setNews_id(rs.getInt("A.news_id"));
				newsDc.setNews_title(rs.getString("A.news_title"));
				newsDc.setNews_datetime(rs.getDate("A.news_datetime"));
				newsDc.setDc_name(rs.getString("B.dc_name"));
				list.add(newsDc);
			}
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("连表查询新闻分类错误");
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}
	
	@Override
	public List<NsNewsDc> selectByDcId(Integer dcId) throws MyException {
		List<NsNewsDc> list = new ArrayList<NsNewsDc>();
		String sql = "SELECT A.news_id,A.news_title,A.news_datetime,B.dc_name FROM news A,dc B WHERE A.dc_id = B.dc_id AND A.dc_id = ?";
		NsNewsDc newsDc = null;
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, dcId);
			rs = stmt.executeQuery();
			while(rs.next()){
				newsDc = new NsNewsDc();
				newsDc.setNews_id(rs.getInt("A.news_id"));
				newsDc.setNews_title(rs.getString("A.news_title"));
				newsDc.setNews_datetime(rs.getDate("A.news_datetime"));
				newsDc.setDc_name(rs.getString("B.dc_name"));
				list.add(newsDc);
			}
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("连表查询新闻分类错误");
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public List<NsNewsDc> selectFrist() throws MyException {
		// TODO Auto-generated method stub
		List<NsNewsDc> list = new ArrayList<NsNewsDc>();
		String sql = "SELECT A.news_id,A.news_title,A.news_datetime,B.dc_name FROM news A,dc B WHERE A.dc_id = B.dc_id AND news_firstshow = 1";
		NsNewsDc newsDc = null;
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				newsDc = new NsNewsDc();
				newsDc.setNews_id(rs.getInt("A.news_id"));
				newsDc.setNews_title(rs.getString("A.news_title"));
				newsDc.setNews_datetime(rs.getDate("A.news_datetime"));
				newsDc.setDc_name(rs.getString("B.dc_name"));
				list.add(newsDc);
			}
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("查询新闻首页错误");
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public List<NsNewsCatDc> selectConAll() throws MyException {
		// TODO Auto-generated method stub
		List<NsNewsCatDc> list = new ArrayList<NsNewsCatDc>();
		String sql = "SELECT a.news_id,a.news_title,b.cat_name,c.dc_name,a.news_datetime FROM news a,cat b,dc c WHERE a.cat_id = b.cat_id AND a.dc_id = c.dc_id";
		NsNewsCatDc newsCatDc = null;
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				newsCatDc = new NsNewsCatDc();
				newsCatDc.setNews_id(rs.getInt("news_id"));
				newsCatDc.setNews_title(rs.getString("news_title"));
				newsCatDc.setCat_name(rs.getString("cat_name"));
				newsCatDc.setDc_name(rs.getString("dc_name"));
				newsCatDc.setNews_datetime(rs.getDate("news_datetime"));
				list.add(newsCatDc);
			}
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("连表查询全部新闻错误");
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}


}
