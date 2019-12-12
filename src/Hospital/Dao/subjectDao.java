package Hospital.Dao;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Hospital.common.DbUtil;
import Hospital.pojo.Check;
import Hospital.pojo.Doctor;
import Hospital.pojo.Patient;
import Hospital.pojo.Prescription;
import Hospital.pojo.Registration;
import Hospital.pojo.subject;


/*
 * ø∆ “π‹¿ÌDao≤„
 * @author BayMax
 * 2019-06-20
 * */
public class subjectDao {
	
	public subject querySubjectById(int sid) {
		subject subject = null;
		String sql = "select * from tbl_k where k_id = ?";
		
		Connection con = DbUtil.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sid);
			ResultSet set = pstmt.executeQuery();
			if(set.next()) {
				subject = new subject();
				subject.setKid(set.getInt(1));
				subject.setKname(set.getString(2));
				subject.setKnum(set.getInt(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subject;
	}
	public  ArrayList<subject> query() {
		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_K";
		subject subject = null;
		ArrayList<subject> list = new ArrayList<subject>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {		
				subject = new subject(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));		    	
				list.add(subject);
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