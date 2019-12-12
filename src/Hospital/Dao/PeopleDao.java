package Hospital.Dao;
import Hospital.common.DbUtil;
import Hospital.pojo.Patient;
import Hospital.pojo.People;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*查询是否有此人
 * @suanan
 * 19/6/26
 */
public class PeopleDao {
	//查询
	
	public People slectpep(String pId) {
		Connection con = DbUtil.getConnection();
		//String sql = "select * from TBL_pep where P_idcard = ? AND p_name='?'";
		String sql = "select * from TBL_pep where P_idcard = ? ";
		
		People people=null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,pId);
			//pstmt.setString(2,pname);
			
			ResultSet rs = pstmt.executeQuery();//获取数据库结果集
			if(rs.next()) {
				people = new People(rs.getString(1),rs.getString(2));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return people;
	}
}
