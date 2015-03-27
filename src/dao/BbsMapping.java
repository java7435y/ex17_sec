package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.BbsDTO;


public class BbsMapping implements ResultSetBeanMapping<BbsDTO> {

	public BbsDTO createFromResultSet(ResultSet rs)
	throws SQLException {

		BbsDTO bbs = new BbsDTO();
		bbs.setUsrid(rs.getString("usrid"));
		bbs.setUpdDate(rs.getString("upddate"));
		bbs.setMsg(rs.getString("msg"));

		return bbs;
	}

}
