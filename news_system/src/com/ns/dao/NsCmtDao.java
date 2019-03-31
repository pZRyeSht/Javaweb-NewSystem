package com.ns.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ns.idao.INsCmtDao;
import com.ns.pojo.NsCmt;
import com.ns.util.JDBC_util;

public class NsCmtDao implements INsCmtDao {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	@Override
	public void insert(NsCmt obj) {
		// TODO Auto-generated method stub
		String sql = "insert into cmt(news_id,user_id,cmt_content,"
				+ "cmt_datetime) values(?,?,?,?)";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, obj.getNews_id());
			stmt.setInt(2, obj.getUser_id());
			stmt.setString(3, obj.getCmt_content());
			stmt.setDate(4, obj.getCmt_datetime());
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public void update(NsCmt obj) {
		// TODO Auto-generated method stub
		String sql = "update cmt set news_id = ?, user_id = ?, cmt_content = ?,"
				+ "cmt_datetime = ? where cmt_id = ?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, obj.getNews_id());
			stmt.setInt(2, obj.getUser_id());
			stmt.setString(3, obj.getCmt_content());
			stmt.setDate(4, obj.getCmt_datetime());
			stmt.setInt(5, obj.getCmt_id());
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from cmt where cmt_id = ?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public NsCmt selectById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from cmt where cmt_id = ?";
		NsCmt cmt = null;
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			if(rs.next()){
				cmt = new NsCmt();
				cmt.setCmt_id(rs.getInt("cmt_id"));
				cmt.setNews_id(rs.getInt("news_id"));
				cmt.setUser_id(rs.getInt("user_id"));
				cmt.setCmt_content(rs.getString("cmt_content"));
				cmt.setCmt_datetime(rs.getDate("cmt_datetime"));
			}
			return cmt;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
		return null;
	}

	@Override
	public List<NsCmt> selectall() {
		// TODO Auto-generated method stub
		List<NsCmt> cmts = new ArrayList<NsCmt>();
		String sql = "select * from cmt";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			NsCmt cmt;
			while(rs.next()){
				cmt = new NsCmt();
				cmt.setCmt_id(rs.getInt("cmt_id"));
				cmt.setNews_id(rs.getInt("news_id"));
				cmt.setUser_id(rs.getInt("user_id"));
				cmt.setCmt_content(rs.getString("cmt_content"));
				cmt.setCmt_datetime(rs.getDate("cmt_datetime"));
				cmts.add(cmt);
			}
			return cmts;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
		return null;
	}

	@Override
	public List<NsCmt> selectall(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		List<NsCmt> cmts = new ArrayList<NsCmt>();
		String sql = "select * from cmt limit ?,?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, (pageNo-1)*pageSize);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			
			NsCmt cmt;
			while(rs.next()){
				cmt = new NsCmt();
				cmt.setCmt_id(rs.getInt("cmt_id"));
				cmt.setNews_id(rs.getInt("news_id"));
				cmt.setUser_id(rs.getInt("user_id"));
				cmt.setCmt_content(rs.getString("cmt_content"));
				cmt.setCmt_datetime(rs.getDate("cmt_datetime"));
				cmts.add(cmt);
			}
			return cmts;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
		return null;
	}

	@Override
	public int selectAllCount() {
		// TODO Auto-generated method stub
		int i = 0;
		String sql = "select * from cmt order by cmt_id";
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
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
		return 0;
	}
}
