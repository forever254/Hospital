package Hospital.Service;

import java.util.ArrayList;

import Hospital.Dao.subjectDao;
import Hospital.pojo.Registration;
import Hospital.pojo.subject;

public class subjectService {
	subjectDao dao = new subjectDao();
	public ArrayList<subject> query(){
		return dao.query();
	}
}