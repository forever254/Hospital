package Hospital.Service;

import java.util.ArrayList;

import Hospital.Dao.detailDao;
import Hospital.Dao.jdetailDao;
import Hospital.pojo.Detail;
import Hospital.pojo.JDetail;

public class jdetailService {
jdetailDao dao = new jdetailDao();
	
	public void addJDetail(JDetail detail) {
		dao.insert(detail);
	}
	public void deleteJDetail(Integer Gid,Integer Mid) {
		dao.delete(Gid, Mid);
	}
	public void updateJDetail(JDetail detail) {
//		dao.update(detail);
	}
	public JDetail querJDetailById(Integer Gid,Integer Jid) {
		return dao.queryById(Gid, Jid);
	}
	public ArrayList<JDetail> querJDetailBygId(Integer Gid) {
		return dao.queryBygId(Gid);
	}
	public ArrayList<JDetail>  queryJDetails(){
		return dao.query();
	}
}
