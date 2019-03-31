package com.ns.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ns.common.MyException;
import com.ns.idao.INsAdminDao;
import com.ns.pojo.NsAdmin;
import com.ns.util.JDBC_util;

public class NsAdminDao implements INsAdminDao{

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	@Override
	public void insert(NsAdmin obj)throws MyException{
		// TODO Auto-generated method stub
		String sql = "insert into admin(admin_name,admin_rname,admin_password,"
				+ "admin_datetime,admin_type,admin_right) values(?,?,?,?,?,?)";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,obj.getAdmin_name());
			stmt.setString(2,obj.getAdmin_rname());
			stmt.setString(3,obj.getAdmin_password());
			stmt.setDate(4,obj.getAdmin_datetime());
			stmt.setString(5,obj.getAdmin_type());
			stmt.setInt(6, obj.getAdmin_right());
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MyException("添加管理员错误");
		}finally {
			JDBC_util.close(stmt, conn, rs);
		}
		
	}

	@Override
	public void update(NsAdmin obj)throws MyException{
		// TODO Auto-generated method stub
		String sql = "update admin set admin_name = ?, admin_rname = ?, admin_password =?,"
				+ "admin_datetime =?, admin_type = ?, admin_right = ? where admin_id = ?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,obj.getAdmin_name());
			stmt.setString(2,obj.getAdmin_rname());
			stmt.setString(3,obj.getAdmin_password());
			stmt.setDate(4,obj.getAdmin_datetime());
			stmt.setString(5,obj.getAdmin_type());
			stmt.setInt(6, obj.getAdmin_right());
			stmt.setInt(7, obj.getAdmin_id());
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MyException("修改管理员错误");
		}finally {
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public void delete(Integer id)throws MyException{
		// TODO Auto-generated method stub
		String sql = "delete from admin where admin_id = ?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MyException("删除管理员错误");
		}finally {
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public NsAdmin selectById(Integer id)throws MyException{
		// TODO Auto-generated method stub
		String sql = "select * from admin where admin_id = ?";
		NsAdmin admin = null;
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()){
				admin = new NsAdmin();
				admin.setAdmin_id(rs.getInt("admin_id"));
				admin.setAdmin_name(rs.getString("admin_name"));
				admin.setAdmin_rname(rs.getString("admin_rname"));
				admin.setAdmin_password(rs.getString("admin_password"));
				admin.setAdmin_datetime(rs.getDate("admin_datetime"));
				admin.setAdmin_type(rs.getString("admin_type"));
				admin.setAdmin_right(rs.getInt("admin_right"));
			}
			return admin;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MyException("查询管理员错误");
		}finally {
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public List<NsAdmin> selectall()throws MyException{
		// TODO Auto-generated method stub
		List<NsAdmin> admins = new ArrayList<NsAdmin>();
		String sql = "select * from admin";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			NsAdmin admin;
			while(rs.next()){
				admin = new NsAdmin();
				admin.setAdmin_id(rs.getInt("admin_id"));
				admin.setAdmin_name(rs.getString("admin_name"));
				admin.setAdmin_rname(rs.getString("admin_rname"));
				admin.setAdmin_password(rs.getString("admin_password"));
				admin.setAdmin_datetime(rs.getDate("admin_datetime"));
				admin.setAdmin_type(rs.getString("admin_type"));
				admin.setAdmin_right(rs.getInt("admin_right"));
				admins.add(admin);
			}
			return admins;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MyException("查询所有管理员错误");
		}finally {
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public List<NsAdmin> selectall(Integer pageNo, Integer pageSize)throws MyException{
		// TODO Auto-generated method stub
		List<NsAdmin> admins = new ArrayList<NsAdmin>();
		String sql = "select * from admin limit ?,?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, (pageNo-1)*pageSize);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			
			NsAdmin admin;
			while(rs.next()){
				admin = new NsAdmin();
				admin.setAdmin_id(rs.getInt("admin_id"));
				admin.setAdmin_name(rs.getString("admin_name"));
				admin.setAdmin_rname(rs.getString("admin_rname"));
				admin.setAdmin_password(rs.getString("admin_password"));
				admin.setAdmin_datetime(rs.getDate("admin_datetime"));
				admin.setAdmin_type(rs.getString("admin_type"));
				admin.setAdmin_right(rs.getInt("admin_right"));
				admins.add(admin);
			}
			return admins;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MyException("页面查询管理员错误");
		}finally {
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public int selectAllCount()throws MyException{
		// TODO Auto-generated method stub
		int i = 0;
		String sql = "select * from admin order by admin_id";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				++i;
			}
			return i;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MyException("统计管理员错误");
		}finally {
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public NsAdmin selectOne(String AdminName, String AdminPwd) throws MyException {
		// TODO Auto-generated method stub
		String sql = "select * from admin where admin_name = ? and admin_password = ?";
		NsAdmin admin = null;
		try{
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, AdminName);
			stmt.setString(2, AdminPwd);
			rs = stmt.executeQuery();
			if(rs.next()){
				admin = new NsAdmin();
				admin.setAdmin_id(rs.getInt("admin_id"));
				admin.setAdmin_name(rs.getString("admin_name"));
				admin.setAdmin_rname(rs.getString("admin_rname"));
				admin.setAdmin_password(rs.getString("admin_password"));
				admin.setAdmin_datetime(rs.getDate("admin_datetime"));
				admin.setAdmin_type(rs.getString("admin_type"));
				admin.setAdmin_right(rs.getInt("admin_right"));
			}
			return admin;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("查询管理员登录错误");
		}finally {
			JDBC_util.close(stmt, conn, rs);
		}
	}
	
}
