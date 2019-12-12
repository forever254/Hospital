package Hospital.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Hospital.common.DbUtil;
import Hospital.pojo.Check;
import Hospital.pojo.Doctor;
import Hospital.pojo.Laboratory_Report;
import Hospital.pojo.Patient;
import Hospital.pojo.Registration;
import Hospital.pojo.subject;

/**
 * 检查后报告Dao层
 * 
 * @author Hao
 *2019-6-24
 */
public class laboratory_reportDao {
	/**
	 * 插入检后报告数据
	 */
	public void insert(Laboratory_Report laboratory_report) {
		Connection con = DbUtil.getConnection();
		String sql = "insert into TBL_B values(seq_B_id.nextval,?,?,?,?)";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, laboratory_report.getRegistration().getG_id());
			pstmt.setInt(2, laboratory_report.getPatient().getPid());
			pstmt.setInt(3, laboratory_report.getCheck().getJid());
			pstmt.setString(4, laboratory_report.getBcontent());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除检后报告数据
	 */
	public void delete(Integer bId) {

		Connection con = DbUtil.getConnection();
		String sql = "delete from TBL_B where B_id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bId);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询检后报告（通过id查询）
	 */
	public Laboratory_Report queryById(Integer bId) {

		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_B where b_id = ?";

		Laboratory_Report laboratory_report  = null;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bId);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Registration reg = new registrationDao().queryById(rs.getInt(2));
				Patient patient = new patientDao().queryById(rs.getInt(3));
				Check check = new checkDao().queryById(rs.getInt(4));

				laboratory_report = new Laboratory_Report(rs.getInt(1), reg,patient, check,rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return laboratory_report;
	}

	/**
	 * 查询所有检后报告
	 */
	
	public ArrayList<Laboratory_Report> query(){
		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_B order by B_id";
		Laboratory_Report laboratory_report  = null;
		ArrayList<Laboratory_Report> list = new ArrayList<Laboratory_Report>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Registration reg = new registrationDao().queryById(rs.getInt(2));
				Patient patient = new patientDao().queryById(rs.getInt(3));
				Check check = new checkDao().queryById(rs.getInt(4));

				laboratory_report = new Laboratory_Report(rs.getInt(1), reg,patient, check,rs.getString(5));
			
				list.add(laboratory_report); 
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