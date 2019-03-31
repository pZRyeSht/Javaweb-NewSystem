package com.ns.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ns.common.MyException;
import com.ns.idao.INsUserDao;
import com.ns.pojo.NsUser;
import com.ns.util.JDBC_util;

public class NsUserDao implements INsUserDao {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	@Override
	public void insert(NsUser obj) throws MyException{
		// TODO Auto-generated method stub
		String sql = "insert into user(user_name,user_rname,user_password,"
				+ "user_email,user_tel,user_datetime,user_right) values(?,?,?,?,?,?,?)";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, obj.getUser_name());
			stmt.setString(2, obj.getUser_rname());
			stmt.setString(3, obj.getUser_password());
			stmt.setString(4, obj.getUser_email());
			stmt.setString(5, obj.getUser_tel());
			stmt.setDate(6, obj.getUser_datetime());
			stmt.setInt(7, obj.getUser_right());
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MyException("添加用户错误");
		}finally {
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public void update(NsUser obj) throws MyException{
		// TODO Auto-generated method stub
		String sql = "update user set user_name = ? , user_rname = ?, "
		   		+ "user_password = ?, user_email = ?, user_tel = ?, user_datetime = ?, user_right = ? where user_id = ?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, obj.getUser_name());
			stmt.setString(2, obj.getUser_rname());
			stmt.setString(3, obj.getUser_password());
			stmt.setString(4, obj.getUser_email());
			stmt.setString(5, obj.getUser_tel());
			stmt.setDate(6, obj.getUser_datetime());
			stmt.setInt(7, obj.getUser_right());
			stmt.setInt(8, obj.getUser_id());
			stmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new MyException("修改用户错误");
			}finally {
				JDBC_util.close(stmt, conn, rs);
			}
	}

	@Override
	public void delete(Integer id) throws MyException{
		// TODO Auto-generated method stub
		String sql = "delete from user where user_id = ?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("删除用户错误");
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public NsUser selectById(Integer id) throws MyException{
		// TODO Auto-generated method stub
		String sql = "select * from user where user_id = ?";
		NsUser user = null;
		try{
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()){
				user = new NsUser();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_rname(rs.getString("user_rname"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_tel(rs.getString("user_tel"));
				user.setUser_datetime(rs.getDate("user_datetime"));
				user.setUser_right(rs.getInt("user_right"));
			}
			return user;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("查询用户错误");
		}finally {
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public List<NsUser> selectall() throws MyException{
		// TODO Auto-generated method stub
		List<NsUser> users = new ArrayList<NsUser>();
		String sql = "select * from user";
		try{
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			NsUser user;
			while(rs.next()){
				user = new NsUser();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_rname(rs.getString("user_rname"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_tel(rs.getString("user_tel"));
				user.setUser_datetime(rs.getDate("user_datetime"));
				user.setUser_right(rs.getInt("user_right"));
				
				users.add(user);
			}
			return users;
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("查询所有用户错误");
		}finally {
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public List<NsUser> selectall(Integer pageNo, Integer pageSize) throws MyException{
		// TODO Auto-generated method stub
		List<NsUser> users = new ArrayList<NsUser>();
		String sql = "select * from user limit ?,?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, (pageNo-1)*pageSize);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			
			NsUser user;
			while(rs.next()){
				user = new NsUser();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_rname(rs.getString("user_rname"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_tel(rs.getString("user_tel"));
				user.setUser_datetime(rs.getDate("user_datetime"));
				user.setUser_right(rs.getInt("user_right"));
				
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MyException("分页查询用户错误");
		}finally {
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public int selectAllCount() throws MyException{
		// TODO Auto-generated method stub
		String sql = "select * from user order by user_id";
		int i = 0;
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
				throw new MyException("查询所有用户错误");
			}finally{
				JDBC_util.close(stmt, conn, rs);
			}
	}

	public NsUser selectOne(String userName,String userPwd)throws MyException{
		String sql = "select * from user where user_name = ? and user_password = ?";
		NsUser user = null;
		try{
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);
			stmt.setString(2, userPwd);
			rs = stmt.executeQuery();
			if(rs.next()){
				user = new NsUser();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_rname(rs.getString("user_rname"));
				user.setUser_password(rs.getString("user_password"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_tel(rs.getString("user_tel"));
				user.setUser_datetime(rs.getDate("user_datetime"));
				user.setUser_right(rs.getInt("user_right"));
			}
			return user;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new MyException("查询用户登录错误");
		}finally {
			JDBC_util.close(stmt, conn, rs);
		}
	}
}
