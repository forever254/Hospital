package Hospital.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Hospital.common.DbUtil;
import Hospital.pojo.Detail;
import Hospital.pojo.Medicine;
import Hospital.pojo.Registration;

/**
 *  药方详细表Dao层
 * @author Moline-x
 * 2019-06-23
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class detailDao {
	/**
	 * 插入药方详细信息
	 * @param detail
	 */
	public void insert(Detail detail) {
		Connection con = DbUtil.getConnection();
		
		String sql = "insert into TBL_XY values(?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, detail.getReg().getG_id());
			pstmt.setInt(2, detail.getMed().getMid());
			pstmt.setInt(3, detail.getXynum());
			pstmt.setString(4, detail.getXycontent());
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除药方详细数据
	 * @param Gid,Mid
	 */
	public void delete(Integer Gid,Integer Mid) {
		Connection con = DbUtil.getConnection();
		String sql = "delete from TBL_XY where G_idFK=? and M_idFK=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Gid);
			pstmt.setInt(2, Mid);
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 修改药方详细表数据
	 * @param detail
	 */
	public void update(Detail detail) {
		Connection con = DbUtil.getConnection();
		String sql = "update TBL_XY set XY_num=?,XY_content=? where G_idFK=? and M_idFK=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, detail.getXynum());
			pstmt.setString(2, detail.getXycontent());
			pstmt.setInt(3, detail.getReg().getG_id());
			pstmt.setInt(4, detail.getMed().getMid());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 通过id查询药方详细信息
	 * @param Gid,Mid
	 * @return detail
	 */
	public Detail queryById(Integer Gid,Integer Mid) {
		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_XY where G_idFK=? and M_idFK=?";
		Detail detail = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Gid);
			pstmt.setInt(2, Mid);
			
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String sqll = "select M_name,M_price from TBL_medicine where  M_id=?";
				PreparedStatement pstmtt = con.prepareStatement(sqll);
				pstmtt.setInt(1, Mid);
				
				ResultSet rss = pstmtt.executeQuery();
				Medicine med = new Medicine();
				if(rss.next())
				{
					med.setMname(rss.getString(1));
					
					med.setMprice(rss.getFloat(2));
				}
				Registration reg = new Registration();
				reg.setG_id(rs.getInt(1));
				med.setMid(rs.getInt(2));
				
				
				detail = new Detail(reg, med, rs.getInt(3), rs.getString(4));
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
	public ArrayList<Detail> queryBygId(Integer Gid) {
		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_XY where G_idFK=?";
		
		Detail detail = null;
		
		ArrayList<Detail> list = new ArrayList<Detail>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Gid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String sqll = "select M_name,M_price from TBL_medicine where  M_id=?";
				PreparedStatement pstmtt = con.prepareStatement(sqll);
				pstmtt.setInt(1, rs.getInt(2));
				
				ResultSet rss = pstmtt.executeQuery();
				Medicine med = new Medicine();
				while(rss.next())
				{
					med.setMname(rss.getString(1));
					
					med.setMprice(rss.getFloat(2));
				}
				Registration reg = new Registration();
				reg.setG_id(rs.getInt(1));
				med.setMid(rs.getInt(2));
				
				detail = new Detail(reg, med, rs.getInt(3), rs.getString(4));
				list.add(detail);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(Detail detail1 : list) {
			System.out.println(detail1);
		}
		return list;
	}
			
	//////
	/**
	 * 查询所有药方详细表信息
	 * @return list
	 */
	public ArrayList<Detail> query(){
		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_XY";
		Detail detail = null;
		ArrayList<Detail> list = new ArrayList<Detail>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Registration reg = new Registration();
				reg.setG_id(rs.getInt(1));
				Medicine med = new Medicine();
				med.setMid(rs.getInt(2));
				detail = new Detail(reg, med, rs.getInt(3), rs.getString(4));
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
