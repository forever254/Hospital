package Hospital.Test;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import Hospital.Dao.detailDao;
import Hospital.pojo.Detail;
import Hospital.pojo.Medicine;
import Hospital.pojo.Registration;

public class TestDetailDao {
	detailDao dao = new detailDao();
	/*
	public void testinsert() {
		Registration reg = new Registration();
		reg.setG_id(10002);
		Medicine med = new Medicine();
		med.setMid(1211);
		Detail detail = new Detail(reg,med,33,"非常详细");
		dao.insert(detail);
	}*/
	@Test
	public void tetsUpdate() {
		Registration reg = new Registration();
		reg.setG_id(10002);
		Medicine med = new Medicine();
		med.setMid(1211);
		Detail detail = new Detail(reg, med, 23,"比较详细");
		dao.update(detail);
	}
	/*
	public void testDelete() {
		dao.delete(10002, 1210);
	}
	public void testQuertById() {
		Detail detail = dao.queryById(10002, 1210);
		System.out.println(detail);
	}
	
	public void testQuery() {
		ArrayList<Detail> list = dao.query();
		
		for(Detail detail : list) {
			System.out.println(detail);
		}
	}*/

}
