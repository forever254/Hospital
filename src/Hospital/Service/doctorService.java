package Hospital.Service;

import java.util.ArrayList;

import Hospital.Dao.doctorDao;
import Hospital.pojo.Doctor;

/**
 * 医生管理服务
 * @author BayMax
 * 2019-06-21
 */

public class doctorService {

	doctorDao dao = new doctorDao();
	
	public void addDoctor(Doctor doctor) {
		dao.insert(doctor);
	}
	
	public void updateDoctor(Doctor doctor) {
		dao.update(doctor);
	}
	
	public void deleteDocotr(Integer dId) {
		dao.delete(dId);
	}
	
	public Doctor queryDoctorId(Integer dId) {
		return dao.queryById(dId);
	}
	
	public ArrayList<Doctor> queryDoctor(){
		return dao.query();
	}
}
