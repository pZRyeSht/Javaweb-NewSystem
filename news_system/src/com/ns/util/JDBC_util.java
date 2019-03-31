package com.ns.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC_util {
	    //数据库的连接地址
		private static String url =null;
		//数据库账号
		private static String userName =null;
		//数据库密码
		private static String passWord =null;
		//数据库驱动
		private static String dirver =null;
		static{
			try {

				//创建一个properties类
				Properties prop = new  Properties();
				//构造一个输入流
				InputStream in;

				in = new  FileInputStream("D:\\作业\\JAVA_SCHOOL\\news_system\\src\\com\\ns\\util\\JDBC_info.properties");
				//加载文件
				prop.load(in);
				//读取文件
				url = prop.getProperty("url");
				userName = prop.getProperty("userName");
				passWord = prop.getProperty("passWord");
				dirver = prop.getProperty("dirver");
				Class.forName(dirver);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		/**
		 * 获取连接的方法
		 * 
		 */
		public static Connection getConnection(){
			try {
				Connection conn = DriverManager.getConnection(url,userName,passWord);
				return conn;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

		/**
		 * 释放资源的方法
		 */
		public static void close(Statement stmt,Connection conn){
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					System.out.println("stmt资源释放失败");
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("conn释放失败");
					e.printStackTrace();
				}
			}
		}


		/**
		 * 释放资源的方法
		 */
		public static void close(Statement stmt,Connection conn,ResultSet rs){
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					System.out.println("stmt资源释放失败");
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("conn释放失败");
					e.printStackTrace();
				}
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("rs释放失败");
					e.printStackTrace();
				}
			}
		}
		
		/**
		 * 添加、删除、修改
		 * @param sql
		 * @param parameters
		 * @return
		 */
		public static boolean executeUpdate(String sql,Object...parameters){
			boolean isFlag = false;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				for (int i=0; i<parameters.length; i++) {
					pstmt.setObject(i+1, parameters[i]);
				}
				if(pstmt.executeUpdate()>0){
					isFlag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt,conn,rs);
			}
			return isFlag;
		}
		
		/**
		 * 计数
		 * @param sql
		 * @return
		 */
		public static int countRows(String sql,Object...parameters){
			int num = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				for (int i=0; i<parameters.length; i++) {
					pstmt.setObject(i+1, parameters[i]);
				}
				rs = pstmt.executeQuery();
				if(rs.next()){
					num=rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt,conn,rs);
			}
			return num;
		}
		
		/**
		 * 判断该条件数据是否存在
		 * @param sql
		 * @param parameters
		 * @return
		 */
		public static boolean isExist(String sql,Object...parameters){
			boolean isFlag = false;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				for (int i=0; i<parameters.length; i++) {
					pstmt.setObject(i+1, parameters[i]);
				}
				rs = pstmt.executeQuery();
				if(rs.next()){
					isFlag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt,conn,rs);
			}
			return isFlag;
		}
		
		public static void main(String[] args) {
			
		}
}

