package Hospital.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Hospital.common.DbUtil;
import Hospital.pojo.Prescription;
import Hospital.pojo.Registration;

/**
 * @author Jession_LIU
 *药方表的数据库操作，作用是收集所有的开药信息，以挂号单号划分区别
 *2019-06-23
 */

public class prescriptionDao {
	//插入数据到药方表
	public void insert(Prescription pre) {
		//数据库连接
		Connection con = DbUtil.getConnection();
		//插入语句
		String sql = "insert into TBL_KM values(?,?)";
		
		try {
			//预处理
			PreparedStatement pstmt = con.prepareStatement(sql);
			//填充数据
			pstmt.setInt(1, pre.getReg().getG_id());
			pstmt.setDouble(2, pre.getMoney());
			
			//关闭数据库连接
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//删除药方表里的数据
	public void delete(int id) {
		//数据库连接对象
		Connection con = DbUtil.getConnection();
		//删除语句
		String sql = "delete from TBL_KM where G_idFK = ?";
		
		try {
			//语句预处理
			PreparedStatement pstm = con.prepareStatement(sql);
			//填充数据
			pstm.setInt(1, id);

			//关闭数据库连接
			pstm.executeUpdate();
			pstm.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	///////修改药方表
	public void update(Prescription pre) {
		//数据库连接
		Connection con = DbUtil.getConnection();
		//修改语句
		String sql = "update TBL_KM set KM_total = ? where G_idFK = ?";
		/////预处理
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			
			////数据填充
			pstm.setDouble(1, pre.getMoney());
			pstm.setInt(2, pre.getReg().getG_id());
			
			//关闭数据库
			pstm.executeUpdate();
			pstm.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	////////////////查询药方表
	
	public Prescription queryByGid(int id) {
		Connection con = DbUtil.getConnection();
		Prescription pre = null;
		String sql = "select * from TBL_KM where G_idFK = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
		    ResultSet rs=pstm.executeQuery();
		    if(rs.next())
		    {		
		    	Registration Reg = new Registration();
		    	Reg.setG_id(rs.getInt(1));
		    	pre = new Prescription(Reg,rs.getInt(2));		    			    	
		    }
		    rs.close();
		    pstm.close();
		    con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pre;
				
	}
	
	//////获取所有数据
	public  ArrayList<Prescription> query() {
		Connection con = DbUtil.getConnection();
		String sql = "select * from TBL_KM";
		Prescription pre = null;
		ArrayList<Prescription> list = new ArrayList<Prescription>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				Registration Reg = new Registration();
		    	Reg.setG_id(rs.getInt(1));
		    	pre = new Prescription(Reg,rs.getInt(2));				
				list.add(pre);
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