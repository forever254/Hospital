package Hospital.Test;

import java.util.ArrayList;
//import java.sql.Date;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import Hospital.Dao.registrationDao;
import Hospital.pojo.Check;
import Hospital.pojo.Doctor;
import Hospital.pojo.Patient;
import Hospital.pojo.Registration;
import Hospital.pojo.subject;

public class TestRegistrationDao {
	registrationDao dao = new registrationDao();
	@Test
	public void testinsert()
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String gtime = sdf.format(date);
		
		Patient patient = new Patient();
		patient.setPid(21);
		Check check = new Check();
		check.setJid(312);
		subject subject = new subject();
		subject.setKid(101);
		Doctor doctor = new Doctor();
		doctor.setDid(500);
		Registration registration = new Registration(20,patient,"X",check,subject,doctor,gtime,123.1,"123");
		dao.insert(registration);
	
	}
	/*@Test
	public void testUpdate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String gtime = sdf.format(date);
		
		Patient patient = new Patient();
		patient.setPid(21);
		Check check = new Check();
		check.setJid(312);
		subject subject = new subject();
		subject.setKid(102);
		Doctor doctor = new Doctor();
		doctor.setDid(500);
		Registration registration = new Registration(10003,30, patient, "21070319546254321x", check, subject, doctor, gtime, 456.7);
		dao.update(registration);
	}*/
	
	/*@Test
	public void testDelete() {
		dao.delete(10001);
	}
	@Test
	public void testQueryById() {
		Registration reg = dao.queryById(10000);
		System.out.println(reg);
	}*/
	/*@Test
	public void testQuery() {
		ArrayList<Registration> list = dao.query();
		
		for(Registration reg : list) {
			System.out.println(reg);
		}
	}*/
}
