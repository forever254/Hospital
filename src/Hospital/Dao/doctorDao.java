package Hospital.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Hospital.common.DbUtil;
import Hospital.pojo.Doctor;
import Hospital.pojo.subject;

/**
 * 医生管理dao层
 * 
 * @author BayMax
 * 2019-06-20
 */
public class doctorDao {
	/**
	 * 插入医生数据
	 */
	public void insert(Doctor doctor) {
		Connection con = DbUtil.getConnection();
		String sql = "insert into TBL_Doctor values(seq_D_id.nextval,?,?,?,?,?,?,?)";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, doctor.getDname());
			pstmt.setString(2, doctor.getDsex());
			pstmt.setInt(3, doctor.getDage());
			pstmt.setString(4, doctor.getDphone());
			pstmt.setString(5, doctor.getDlevel());
			pstmt.setInt(6, doctor.getSub().getKid());
			pstmt.setString(7, doctor.getDexp());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改医生数据
	 */
	public void update(Doctor doctor) {

		Connection con = DbUtil.getConnection();
		String sql = "update TBL_Doctor set D_name = ?,D_sex = ?,D_age = ?,D_phone = ?,D_level = ?,K_idFK = ?,D_exp= ? where D_id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, doctor.getDname());
			pstmt.setString(2, doctor.getDsex());
			pstmt.setInt(3, doctor.getDage());
			pstmt.setString(4, doctor.getDphone());
			pstmt.setString(5, doctor.getDlevel());
			pstmt.setInt(6, doctor.getSub().getKid());
			pstmt.setString(7, doctor.getDexp());
			pstmt.setInt(8, doctor.getDid());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 删除医生数据
	 */

	public void delete(Integer dId) {

		Connection con = DbUtil.getConnection();
		String sql = "delete from TBL_Doctor where D_id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dId);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过id查询医生数据
	 */
	public Doctor queryById(Integer dId) {

		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_Doctor where D_id = ?";

		Doctor doctor = null;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dId);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {

				subject subject = new subjectDao().querySubjectById(rs.getInt(7));

				doctor = new Doctor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5), 
						rs.getString(6), subject,rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctor;
	}

	/*public Map<String, Object> queryById1(Integer sid) {

		Map<String, Object> map = null;
		String sql = "SELECT d.*,t.k_name FROM tbl_doctor d, tbl_k k WHERE d.`K_idFk` = k.`K_id`";

		Connection con = DbUtil.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sid);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				map = new HashMap<>();
				map.put("d_id", rs.getInt(1));
				map.put("d_name", rs.getString(2));
				map.put("d_sex", rs.getString(3));
				map.put("d_exp", rs.getString(4));
				map.put("d_age", rs.getInt(5));
				map.put("d_phone", rs.getString(6));
				map.put("d_level", rs.getString(7));
				map.put("k_idFK", rs.getInt(9));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}*/

	/**
	 * 查询所有医生信息
	 */
	public ArrayList<Doctor> query(){
		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_Doctor order by D_id";
		
		ArrayList<Doctor> list = new ArrayList<Doctor>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				subject subject = new subjectDao().querySubjectById(rs.getInt(7));
				
				Doctor doctor = new Doctor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5), 
						rs.getString(6), subject,rs.getString(8));
				list.add(doctor); 
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
