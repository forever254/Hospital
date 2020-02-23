package Hospital.Test;

import java.util.ArrayList;

import javax.security.auth.Subject;

import org.junit.Test;

import Hospital.Dao.doctorDao;
import Hospital.Service.doctorService;
import Hospital.pojo.subject;
import Hospital.pojo.Doctor;

public class TestDoctorDao {
	
	doctorDao dao = new doctorDao();
	
	@Test
	public void testInsert() {
		subject sub = new subject();
		sub.setKid(101);
		Doctor doctor = new Doctor("��ά", "��", 34, "18742019564", "��ͨҽʦ", sub, "ҽ���߳���ҽ��");
//		dao.insert(doctor);
		doctorService service = new doctorService();
		System.out.println(doctor);
		service.addDoctor(doctor);
	}
	/*@Test
	public void testUpdate() {
		subject sub = new subject();
		sub.setKid(101);
		Doctor doctor = new Doctor(500, "��ά","��",34,"18742023425","��ͨҽʦ", sub,"ҽ���߳�������ҽʦ");
		dao.update(doctor);
	}*/
	/*@Test
	public void testDelete() {
		dao.delete(502);
	}
	@Test
	public void testQueryById() {
		Doctor doctor = dao.queryById(500);
		System.out.println(doctor);
	}
	@Test
	public void testQuery() {
		ArrayList<Doctor> list = dao.query();
		
		for(Doctor doctor : list) {
			System.out.println(doctor);
		}
	}*/

}
