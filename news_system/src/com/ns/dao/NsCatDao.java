package com.ns.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ns.idao.INsCatDao;
import com.ns.pojo.NsCat;
import com.ns.util.JDBC_util;

public class NsCatDao implements INsCatDao {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	@Override
	public void insert(NsCat obj) {
		// TODO Auto-generated method stub
		String sql = "insert into cat(cat_name) values(?)";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, obj.getCat_name());
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public void update(NsCat obj) {
		// TODO Auto-generated method stub
		String sql = "update cat set cat_name =? where cat_id = ?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, obj.getCat_name());
			stmt.setInt(2, obj.getCat_id());
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
		String sql = "delete from cat where cat_id = ?";
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
	public NsCat selectById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from cat where cat_id = ?";
		NsCat cat = null;
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				cat = new NsCat();
				cat.setCat_id(rs.getInt("cat_id"));
				cat.setCat_name(rs.getString("cat_name"));
			}
			return cat;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
		return null;
	}

	@Override
	public List<NsCat> selectall() {
		// TODO Auto-generated method stub
		String sql = "select * from cat";
		List<NsCat> cats = new ArrayList<NsCat>();
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			NsCat cat = null;
			while(rs.next()){
				cat = new NsCat();
				cat.setCat_id(rs.getInt("cat_id"));
				cat.setCat_name(rs.getString("cat_name"));
				cats.add(cat);
			}
			return cats;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
		return null;
	}

	@Override
	public List<NsCat> selectall(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from cat limit ?,?";
		List<NsCat> cats = new ArrayList<NsCat>();
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, (pageNo-1)*pageSize);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			
			NsCat cat = null;
			while(rs.next()){
				cat = new NsCat();
				cat.setCat_id(rs.getInt("cat_id"));
				cat.setCat_name(rs.getString("cat_name"));
				cats.add(cat);
			}
			return cats;
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
		String sql = "select * from cat order by cat_id";
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
