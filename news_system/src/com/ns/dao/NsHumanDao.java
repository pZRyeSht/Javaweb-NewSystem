package com.ns.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ns.common.MyException;
import com.ns.idao.INsHumanDao;
import com.ns.pojo.NsHuman;
import com.ns.util.JDBC_util;

public class NsHumanDao implements INsHumanDao {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	@Override
	public void insert(NsHuman obj) {
		// TODO Auto-generated method stub
		String sql = "insert into human(human_name,human_address,human_age,"
				+ "human_work,human_intr,human_num) values(?,?,?,?,?,?)";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, obj.getHuman_name());
			stmt.setString(2, obj.getHuman_address());
			stmt.setInt(3, obj.getHuman_age());
			stmt.setString(4, obj.getHuman_work());
			stmt.setString(5, obj.getHuman_intr());
			stmt.setInt(6, obj.getHuman_num());
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public void update(NsHuman obj) {
		// TODO Auto-generated method stub
		String sql = "update human set human_name = ?,human_address = ?,human_age = ?,"
				+ "human_work = ?,human_intr = ?,human_num = ? where human_id = ?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, obj.getHuman_name());
			stmt.setString(2, obj.getHuman_address());
			stmt.setInt(3, obj.getHuman_age());
			stmt.setString(4, obj.getHuman_work());
			stmt.setString(5, obj.getHuman_intr());
			stmt.setInt(6, obj.getHuman_num());
			stmt.setInt(7, obj.getHuman_id());
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
		String sql = "delete from human where human_id = ?";
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
	public NsHuman selectById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from human where human_id = ?";
		NsHuman human = null;
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				human = new NsHuman();
				human.setHuman_id(rs.getInt("human_id"));
				human.setHuman_name(rs.getString("human_name"));
				human.setHuman_address(rs.getString("human_address"));
				human.setHuman_age(rs.getInt("human_age"));
				human.setHuman_work(rs.getString("human_work"));
				human.setHuman_intr(rs.getString("human_intr"));
				human.setHuman_num(rs.getInt("human_num"));
			}
			return human;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
		return null;
	}

	@Override
	public List<NsHuman> selectall() {
		// TODO Auto-generated method stub
		List<NsHuman> humans = new ArrayList<NsHuman>();
		String sql = "select * from human";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			NsHuman human = null;
			while(rs.next()){
				human = new NsHuman();
				human.setHuman_id(rs.getInt("human_id"));
				human.setHuman_name(rs.getString("human_name"));
				human.setHuman_address(rs.getString("human_address"));
				human.setHuman_age(rs.getInt("human_age"));
				human.setHuman_work(rs.getString("human_work"));
				human.setHuman_intr(rs.getString("human_intr"));
				human.setHuman_num(rs.getInt("human_num"));
				humans.add(human);
			}
			return humans;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
		return null;
	}

	@Override
	public List<NsHuman> selectall(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		List<NsHuman> humans = new ArrayList<NsHuman>();
		String sql = "select * from human limit ?,?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, (pageNo-1)*pageSize);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			
			NsHuman human = null;
			while(rs.next()){
				human = new NsHuman();
				human.setHuman_id(rs.getInt("human_id"));
				human.setHuman_name(rs.getString("human_name"));
				human.setHuman_address(rs.getString("human_address"));
				human.setHuman_age(rs.getInt("human_age"));
				human.setHuman_work(rs.getString("human_work"));
				human.setHuman_intr(rs.getString("human_intr"));
				human.setHuman_num(rs.getInt("human_num"));
				humans.add(human);
			}
			return humans;
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
		String sql = "select * from human order by human_id";
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
	public void updateNum(Integer id) throws MyException {
		// TODO Auto-generated method stub
		String sql = "update human set human_num = human_num+1 where human_id = ?";
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

}
