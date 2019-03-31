package com.ns.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ns.idao.INsLinkDao;
import com.ns.pojo.NsLink;
import com.ns.util.JDBC_util;

public class NsLinkDao implements INsLinkDao {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	@Override
	public void insert(NsLink obj) {
		// TODO Auto-generated method stub
		String sql = "insert into link(link_name,link_address,link_datetime) values(?,?,?)";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, obj.getLink_name());
			stmt.setString(2, obj.getLink_address());
			stmt.setDate(3, obj.getLink_datetime());
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
	}

	@Override
	public void update(NsLink obj) {
		// TODO Auto-generated method stub
		String sql = "update link set link_name = ?,link_address = ?,link_datetime = ? where link_id = ?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, obj.getLink_name());
			stmt.setString(2, obj.getLink_address());
			stmt.setDate(3, obj.getLink_datetime());
			stmt.setInt(4, obj.getLink_id());
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
		String sql = "delete from link where link_id = ?";
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
	public NsLink selectById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from link where link_id = ?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			NsLink link = null;
			if(rs.next()){
				link = new NsLink();
				link.setLink_id(rs.getInt("link_id"));
				link.setLink_name(rs.getString("link_name"));
				link.setLink_address(rs.getString("link_address"));
				link.setLink_datetime(rs.getDate("link_datetime"));
			}
			return link;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
		return null;
	}

	@Override
	public List<NsLink> selectall() {
		// TODO Auto-generated method stub
		List<NsLink> links = new ArrayList<NsLink>();
		String sql = "select * from link";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			NsLink link = null;
			while(rs.next()){
				link = new NsLink();
				link.setLink_id(rs.getInt("link_id"));
				link.setLink_name(rs.getString("link_name"));
				link.setLink_address(rs.getString("link_address"));
				link.setLink_datetime(rs.getDate("link_datetime"));
				links.add(link);
			}
			return links;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC_util.close(stmt, conn, rs);
		}
		return null;
	}

	@Override
	public List<NsLink> selectall(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		List<NsLink> links = new ArrayList<NsLink>();
		String sql = "select * from link limit ?,?";
		try {
			conn = JDBC_util.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, (pageNo-1)*pageSize);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			
			NsLink link = null;
			while(rs.next()){
				link = new NsLink();
				link.setLink_id(rs.getInt("link_id"));
				link.setLink_name(rs.getString("link_name"));
				link.setLink_address(rs.getString("link_address"));
				link.setLink_datetime(rs.getDate("link_datetime"));
				links.add(link);
			}
			return links;
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
		String sql = "select * from link order by link_id";
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
