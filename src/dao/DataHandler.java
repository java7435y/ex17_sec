package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;



public class DataHandler  {

	public static Connection getConnection() {
		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myds");
			Connection con = ds.getConnection();

			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}


	/**
	 * 更新SQLを発行する
	 */
	public static int simpleUpdate(String sql){

	    System.out.println(sql);

	    Connection con = null;
	    Statement smt = null;
	    try{
	        con = DataHandler.getConnection();
	    	smt = con.createStatement();
	    	return smt.executeUpdate(sql);

	    } catch (SQLException e) {
	    	return 0;
	    }finally{
            if (smt != null) {
                try {smt.close();} catch (SQLException igonre) {}
            }
            if (con != null) {
                try {con.close();} catch (SQLException igonre) {}
            }
	    }
	}


	/**
	 * 検索SQLを発行して、結果をオブジェクトのListに入れて返す。
	 * ResultSetからListへの変換は、ResultSetBeanMappingが行う
	 */
	public static <T> List<T> simpleFind(String sql, ResultSetBeanMapping<T> mapping)
	throws SQLException{

		Connection con = null;
	    Statement smt = null;
	    try{
	        con = DataHandler.getConnection();
	        smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(sql);

	        List<T> list = new ArrayList<T>();
	        while(rs.next()) {

	            T bean = mapping.createFromResultSet(rs);

	            list.add(bean);
	        }

	        return list;

	    }finally{
	        if (smt != null) {
	            try {smt.close();} catch (SQLException igonre) {}
	        }
	        if (con != null) {
	            try {con.close();} catch (SQLException igonre) {}
	        }
	    }
	}



}
