package dao;

import java.sql.SQLException;
import java.util.List;

import beans.BbsDTO;



public class BbsDAO {

	public int insert(String id, String msg) {


		String sql = "insert into  bbsdata " +
		"values(to_char(sysdate,'YYYYMMDDHH24MISS') , '" +
				id + "' , '" + msg + "')";

		return DataHandler.simpleUpdate(sql);
	}



	//本情報の取得メソッド
	public List<BbsDTO> select() {

		String sql = "select * from bbsdata order by upddate desc";


		try {
			return DataHandler.simpleFind(sql, new BbsMapping());
		} catch (SQLException e) {
		}
		return null;

	}

}