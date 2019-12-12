package Hospital.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Hospital.common.DbUtil;
import Hospital.pojo.Check;
import Hospital.pojo.subject;

/**
 *   项目管理Dao层
 * @author Moline-x
 * 2019-06-26
 */
public class checkDao {
	/**
	 * 根据id查询项目信息
	 * @param Check
	 */
	public Check queryById(Integer jid) {
		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_J where J_id = ?";
		
		Check check = null;
		try {
			PreparedStatement  pstmt  = con.prepareStatement(sql);
			pstmt.setInt(1, jid);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				check = new Check(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));				
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	/**
	 * 查询所有项目信息
	 */
	public  ArrayList<Check> query() {
		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_J";
		Check check = null;
		ArrayList<Check> list = new ArrayList<Check>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {		
				check = new Check(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));		    	
				list.add(check);
			}
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}