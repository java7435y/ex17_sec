package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsrDAO {

	// ログインユーザ情報取得メソッド
	public String select(String id, String pass) {

		String res_id = null;

		String sql = "select * from usr where usrid = '" + id + "' and passwd = '" + pass + "'";

		System.out.println("sql=" + sql);

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		try {
			con = DataHandler.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);

			if (rs.next()) {
				// getString(1)　←　1番目の項目の値を取得
				res_id = rs.getString(1);
			} else {
				res_id = null;
			}

		} catch (SQLException e) {
			System.out.println("sqlErr=" + e);
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		return res_id;
	}

}