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
 *ҩ��������ݿ�������������ռ����еĿ�ҩ��Ϣ���ԹҺŵ��Ż�������
 *2019-06-23
 */

public class prescriptionDao {
	//�������ݵ�ҩ����
	public void insert(Prescription pre) {
		//���ݿ�����
		Connection con = DbUtil.getConnection();
		//�������
		String sql = "insert into TBL_KM values(?,?)";
		
		try {
			//Ԥ����
			PreparedStatement pstmt = con.prepareStatement(sql);
			//�������
			pstmt.setInt(1, pre.getReg().getG_id());
			pstmt.setDouble(2, pre.getMoney());
			
			//�ر����ݿ�����
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ɾ��ҩ�����������
	public void delete(int id) {
		//���ݿ����Ӷ���
		Connection con = DbUtil.getConnection();
		//ɾ�����
		String sql = "delete from TBL_KM where G_idFK = ?";
		
		try {
			//���Ԥ����
			PreparedStatement pstm = con.prepareStatement(sql);
			//�������
			pstm.setInt(1, id);

			//�ر����ݿ�����
			pstm.executeUpdate();
			pstm.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	///////�޸�ҩ����
	public void update(Prescription pre) {
		//���ݿ�����
		Connection con = DbUtil.getConnection();
		//�޸����
		String sql = "update TBL_KM set KM_total = ? where G_idFK = ?";
		/////Ԥ����
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			
			////�������
			pstm.setDouble(1, pre.getMoney());
			pstm.setInt(2, pre.getReg().getG_id());
			
			//�ر����ݿ�
			pstm.executeUpdate();
			pstm.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	////////////////��ѯҩ����
	
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
	
	//////��ȡ��������
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