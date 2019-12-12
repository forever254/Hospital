package Hospital.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Hospital.common.DbUtil;
import Hospital.pojo.Check;
import Hospital.pojo.Detail;
import Hospital.pojo.JDetail;
import Hospital.pojo.Medicine;
import Hospital.pojo.Registration;

public class jdetailDao {
	public void insert(JDetail detail) {
		Connection con = DbUtil.getConnection();
		
		String sql = "insert into TBL_JXY values(?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, detail.getReg().getG_id());
			pstmt.setInt(2, detail.getChe().getJid());
			pstmt.setString(3, detail.getRemarks());
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param Gid,Mid
	 */
	public void delete(Integer Gid,Integer Jid) {
		Connection con = DbUtil.getConnection();
		String sql = "delete from TBL_JXY where G_idFK=? and J_idFK=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Gid);
			pstmt.setInt(2, Jid);
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * @param detail
	 */
//	public void update(JDetail detail) {
//		Connection con = DbUtil.getConnection();
//		String sql = "update TBL_JXY set XY_num=?,XY_content=? where G_idFK=? and M_idFK=?";
//		try {
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, detail.getXynum());
//			pstmt.setString(2, detail.getXycontent());
//			pstmt.setInt(3, detail.getReg().getG_id());
//			pstmt.setInt(4, detail.getMed().getMid());
//			pstmt.executeUpdate();
//			pstmt.close();
//			con.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	/**
	 * 
	 * @param Gid,Mid
	 * @return detail
	 */
	public JDetail queryById(Integer Gid,Integer Jid) {
		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_JXY where G_idFK=? and J_idFK=?";
		JDetail detail = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Gid);
			pstmt.setInt(2, Jid);
			
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String sqll = "select J_name,J_price,J_remarke from TBL_J where  J_id=?";
				PreparedStatement pstmtt = con.prepareStatement(sqll);
				pstmtt.setInt(1, Jid);
				
				ResultSet rss = pstmtt.executeQuery();
				Check che = new Check();
				if(rss.next())
				{
					che.setJname(rss.getString(1));
					
					che.setJprice(rss.getDouble(2));
					
					che.setJremark(rss.getString(1));
				}
				Registration reg = new Registration();
				reg.setG_id(rs.getInt(1));
				che.setJid(rs.getInt(2));
				
				
				detail = new JDetail(reg, che,rs.getString(3));
				System.out.println(detail);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detail;
	}
	
	///////
	public ArrayList<JDetail> queryBygId(Integer Gid) {
		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_JXY where G_idFK=?";
		
		JDetail detail = null;
		
		ArrayList<JDetail> list = new ArrayList<JDetail>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Gid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String sqll = "select J_name,J_price from TBL_J where  J_id=?";
				PreparedStatement pstmtt = con.prepareStatement(sqll);
				pstmtt.setInt(1, rs.getInt(2));
				
				ResultSet rss = pstmtt.executeQuery();
				Check che = new Check();
				while(rss.next())
				{
					che.setJname(rss.getString(1));
					
					che.setJprice((double) rss.getFloat(2));
				}
				Registration reg = new Registration();
				reg.setG_id(rs.getInt(1));
				che.setJid(rs.getInt(2));
				
				detail = new JDetail(reg, che, rs.getString(3));
				list.add(detail);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(JDetail detail1 : list) {
			System.out.println(detail1);
		}
		return list;
	}
			
	//////
	/**
	 * 
	 * @return list
	 */
	public ArrayList<JDetail> query(){
		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_JXY";
		JDetail detail = null;
		ArrayList<JDetail> list = new ArrayList<JDetail>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Registration reg = new Registration();
				reg.setG_id(rs.getInt(1));
				Check che = new Check();
				che.setJid(rs.getInt(2));
				detail = new JDetail(reg, che, rs.getString(3));
				list.add(detail);
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
