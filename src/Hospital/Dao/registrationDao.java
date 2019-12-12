package Hospital.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Hospital.common.DbUtil;
import Hospital.pojo.Check;
import Hospital.pojo.Doctor;
import Hospital.pojo.Patient;
import Hospital.pojo.Registration;
import Hospital.pojo.subject;

/**
*
*閹稿倸褰挎穱鈩冧紖鐞涒�昦o鐏烇拷
*@author lenovo
*2019-06-21
*
**/

public class registrationDao {
	/**
	 *  閹绘帒鍙嗛幐鍌氬娇娣団剝浼呴弫鐗堝祦
	 * @param registration
	 */
	public void insert(Registration registration) {
		Connection con =  DbUtil.getConnection();
		String sql = "insert into TBL_Gua values(seq_G_id.nextval,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, 0);
			pstmt.setInt(1, registration.getG_line());
			pstmt.setInt(2, registration.getPatient().getPid());
			pstmt.setString(3, registration.getP_IDCard());
			pstmt.setInt(4, registration.getCheck().getJid());
			pstmt.setInt(5, registration.getSub().getKid());
			pstmt.setInt(6, registration.getDoctor().getDid());
			pstmt.setString(7, registration.getG_time());
			pstmt.setDouble(8, registration.getG_total());
			pstmt.setString(9, registration.getRemarks());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 *   閸掔娀娅庨幐鍌氬娇娣団剝浼呴弫鐗堝祦
	 * @param Gid
	 */
	public void delete(Integer Gid) {
		Connection con = DbUtil.getConnection();
		String sql = "delete from TBL_Gua where G_id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,Gid);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 *  娣囶喗鏁奸幐鍌氬娇娣団剝浼呴弫鐗堝祦
	 * @param registration
	 */
	public void update(Registration registration) {
		Connection con = DbUtil.getConnection();
		String sql = "update TBL_Gua set  G_line = ? , P_idFK = ? , P_IDCard = ? , J_idFK = ? , K_idFK = ? ,D_idFK = ? ,G_time = ?,G_total = ? where G_id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, registration.getG_line());
			pstmt.setInt(2, registration.getPatient().getPid());
			pstmt.setString(3, registration.getP_IDCard());
			pstmt.setInt(4, registration.getCheck().getJid());
			pstmt.setInt(5, registration.getSub().getKid());
			pstmt.setInt(6, registration.getDoctor().getDid());
			pstmt.setString(7, registration.getG_time());
			pstmt.setDouble(8, registration.getG_total());
			pstmt.setInt(9, registration.getG_id());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 闁俺绻僫d閺屻儴顕楅幐鍌氬娇娣団剝浼�
	 * @param Gid
	 * @return Registration
	 */
	public Registration queryById(Integer Gid) {
		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_Gua where G_id = ?";
		Registration registration = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Gid);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				Patient patient = new Patient();
				patient.setPid(rs.getInt(3));
				String sqll = "select * from TBL_Patient where P_id = ?";
				PreparedStatement pstmtt = con.prepareStatement(sqll);
				pstmtt.setInt(1, rs.getInt(3));
				
				ResultSet rss = pstmtt.executeQuery();
				if(rss.next())
				{
				patient.setPname(rss.getString(2));
				patient.setPage(rss.getInt(3));
				patient.setPsex(rss.getString(4));
				patient.setPphone(rss.getString(5));
				}
				Check check = new Check();
				check.setJid(rs.getInt(5));
				subject subject = new subject();
				subject.setKid(rs.getInt(6));
				String sqlll = "select * from TBL_K where K_id = ?";
				PreparedStatement pstmttt = con.prepareStatement(sqlll);
				pstmttt.setInt(1, rs.getInt(6));
				
				ResultSet rsss = pstmttt.executeQuery();
				if(rsss.next())
				{
					subject.setKname(rsss.getString(2));
				}
				Doctor doctor = new Doctor();
				doctor.setDid(rs.getInt(7));
				String sqllll = "select * from TBL_Doctor where D_id = ?";
				PreparedStatement pstmtttt = con.prepareStatement(sqllll);
				pstmtttt.setInt(1, rs.getInt(7));
				
				ResultSet rssss = pstmtttt.executeQuery();
				if(rssss.next())
				{
					doctor.setDname(rssss.getString(2));
				}
				
				registration= new Registration(rs.getInt(1),0,patient, rs.getString(4), check, subject,doctor,rs.getString(8),rs.getDouble(9),rs.getString(10));
				
			}
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registration;
		
	}
	/**
	 *  閺屻儴顕楅幍锟介張澶嬪瘯閸欒渹淇婇幁锟�
	 * @return list
	 */
	public ArrayList<Registration> query() {
		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_Gua";
		Registration registration = null;
		ArrayList<Registration> list = new ArrayList<Registration>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				Patient patient = new Patient();
				patient.setPid(rs.getInt(3));
				Check check = new Check();
				check.setJid(rs.getInt(5));
				subject subject = new subject();
				subject.setKid(rs.getInt(6));
				Doctor doctor = new Doctor();
				doctor.setDid(rs.getInt(7));
				registration= new Registration(rs.getInt(1), rs.getInt(2),patient, rs.getString(4), check, subject,doctor,rs.getString(8),rs.getDouble(9),rs.getString(10));
				list.add(registration);
			}
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	//
	public Integer GetGidBypid (Integer pid) {
		Connection con = DbUtil.getConnection();
		String sql = "select G_id from TBL_Gua where P_idFK = ?";
		Integer gid = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,pid);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				gid = rs.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gid;
	}
	
	/**
	 *  淇敼鎸傚彿淇℃伅鏁版嵁(浠呬慨鏀规�婚鍜岃瘖鏂粨鏋�)
	 * @param registration
	 */
	public void updateMoney(Registration registration) {
		Connection con = DbUtil.getConnection();
		String sql = "update TBL_Gua set G_total = ?,G_remarks = ? where G_id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setDouble(1, registration.getG_total());
			pstmt.setString(2, registration.getRemarks());
			pstmt.setInt(3, registration.getG_id());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}


