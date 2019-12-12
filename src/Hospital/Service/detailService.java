package Hospital.Service;

import java.util.ArrayList;

import Hospital.Dao.detailDao;
import Hospital.pojo.Detail;
/**
 * Ò©·½ÏêÏ¸±íService²ã
 * @author Moline-x
 * 2019-06-23
 */
public class detailService {
	detailDao dao = new detailDao();
	
	public void addDetail(Detail detail) {
		dao.insert(detail);
	}
	public void deleteDetail(Integer Gid,Integer Mid) {
		dao.delete(Gid, Mid);
	}
	public void updateDetail(Detail detail) {
		dao.update(detail);
	}
	public Detail querDetailById(Integer Gid,Integer Mid) {
		return dao.queryById(Gid, Mid);
	}
	public ArrayList<Detail> querDetailBygId(Integer Gid) {
		return dao.queryBygId(Gid);
	}
	public ArrayList<Detail>  queryDetails(){
		return dao.query();
	}
	

}
