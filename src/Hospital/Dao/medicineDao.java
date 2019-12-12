package Hospital.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Hospital.common.DbUtil;
import Hospital.pojo.Medicine;

/**
 *   药物管理Dao层
 * @author Moline-x
 * 2019-06-26
 */
public class medicineDao {
	/**
	 * 通过id查询药物信息
	 * @param medicine
	 */
	public Medicine queryById(Integer mid) {
		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_Medicine where M_id = ?";
		
		Medicine med = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mid);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				med = new Medicine(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return med;
	}
	/**
	 * 查询所有药物信息
	 */
	public ArrayList<Medicine> query() {
		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_Medicine order by M_id";
		
		ArrayList<Medicine> list = new ArrayList<Medicine>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Medicine med = new Medicine(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5));
				list.add(med);
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
