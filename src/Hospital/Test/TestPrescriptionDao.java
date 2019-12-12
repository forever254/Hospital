package Hospital.Test;

import java.util.ArrayList;

import org.junit.Test;

import Hospital.Dao.prescriptionDao;
import Hospital.pojo.Prescription;
import Hospital.pojo.Registration;

public class TestPrescriptionDao {
prescriptionDao dao = new prescriptionDao();
	
//	@Test
//	public void testInsert() {
//		
//		Registration reg = new Registration();
//		reg.setG_id(101);
//		Prescription pre = new Prescription(reg,100.00);
//		dao.insert(pre);
//	}
	
//	@Test
//	public void testDelete() {
//		
//		int id = 101;
//		dao.delete(id);
//	}
	
//	@Test
//	public void testUpdate() {
//		
//		Registration reg = new Registration();
//		reg.setG_id(101);
//		Prescription pre = new Prescription(reg,99.00);
//		dao.update(pre);
//	}
//	@Test
//	public void testQueryByid() {
//		
//		int id = 101;
//		
//		Prescription pre = dao.queryByGid(id);
//		System.out.println(pre.getMoney());
//	}
@Test
public void testQuery() {
	
	ArrayList<Prescription> list=dao.query();
	
	for(Prescription pre : list) {
		System.out.println(pre.getReg().getG_id()+" "+pre.getMoney());
	}
	
}
}