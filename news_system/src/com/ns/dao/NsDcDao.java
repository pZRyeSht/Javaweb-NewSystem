package com.ns.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ns.common.MyException;
import com.ns.idao.INsDcDao;
import com.ns.pojo.NsDc;
import com.ns.pojo.NsDcCat;
import com.ns.util.JDBC_util;

public class NsDcDao implements INsDcDao {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	@Override
	public void insert(NsDc obj) {
		// TODO Auto-generated method stub
		String sql = "insert into dc(dc_name,cat_id) values(?,?)";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, obj.getDc_name());
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
	public void update(NsDc obj) {
		// TODO Auto-generated method stub
		String sql = "update dc set dc_name = ?,cat_id = ? where dc_id = ?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, obj.getDc_name());
			stmt.setInt(2, obj.getCat_id());
			stmt.setInt(3, obj.getDc_id());
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
		String sql = "delete from dc where dc_id = ?";
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
	public NsDc selectById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from dc where dc_id = ?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			NsDc dc = null;
			if(rs.next()){
				dc = new NsDc();
				dc.setDc_id(rs.getInt("dc_id"));
				dc.setDc_name(rs.getString("dc_name"));
				dc.setCat_id(rs.getInt("cat_id"));
			}
			return dc;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
		return null;
	}

	@Override
	public List<NsDc> selectall() {
		// TODO Auto-generated method stub
		List<NsDc> dcs = new ArrayList<NsDc>();
		String sql = "select * from dc";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			NsDc dc = null;
			while(rs.next()){
				dc = new NsDc();
				dc.setDc_id(rs.getInt("dc_id"));
				dc.setDc_name(rs.getString("dc_name"));
				dc.setCat_id(rs.getInt("cat_id"));
				dcs.add(dc);
			}
			return dcs;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
		return null;
	}

	@Override
	public List<NsDc> selectall(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		List<NsDc> dcs = new ArrayList<NsDc>();
		String sql = "select * from dc limit ?,?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, (pageNo-1)*pageSize);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			
			NsDc dc = null;
			while(rs.next()){
				dc = new NsDc();
				dc.setDc_id(rs.getInt("dc_id"));
				dc.setDc_name(rs.getString("dc_name"));
				dc.setCat_id(rs.getInt("cat_id"));
				dcs.add(dc);
			}
			return dcs;
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
		String sql = "select * from dc order by dc_id";
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

	@Override
	public List<NsDc> selectByCatId(Integer catId) throws MyException {
		// TODO Auto-generated method stub
		List<NsDc> list = new ArrayList<NsDc>();
		String sql = "SELECT * FROM dc WHERE cat_id = ?";
		NsDc dc = null;
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, catId);
			rs = stmt.executeQuery();
			while(rs.next()){
				dc = new NsDc();
				dc.setDc_id(rs.getInt("dc_id"));;
				dc.setDc_name(rs.getString("dc_name"));
				dc.setCat_id(rs.getInt("cat_id"));
				list.add(dc);
			}
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("查询详细分类错误");
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public List<NsDcCat> selectDcCat() throws MyException {
		// TODO Auto-generated method stub
		List<NsDcCat> list = new ArrayList<NsDcCat>();
		String sql = "SELECT A.dc_id,A.dc_name,B.cat_name FROM dc A,cat B WHERE A.cat_id = B.cat_id";
		NsDcCat dcCat = null;
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				dcCat = new NsDcCat();
				dcCat.setDc_id(rs.getInt("A.dc_id"));
				dcCat.setDc_name(rs.getString("A.dc_name"));
				dcCat.setCat_name(rs.getString("B.cat_name"));
				list.add(dcCat);
			}
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("连表查询新闻详细类别错误");
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

}
