package Hospital.Service;

import java.util.ArrayList;

import Hospital.Dao.registrationDao;
import Hospital.pojo.Registration;

/**
 *  挂号信息管理Service层
 * @author lenovo
 * 2019-06-21
 */
public class registrationService {
	registrationDao dao = new registrationDao();
	
	public void addRegistration(Registration registration) {
		dao.insert(registration);
	}
	public void deleteRegistration(Integer Gid) {
		dao.delete(Gid);
	}
	public void updateMoney(Registration  registration) {
		dao.updateMoney(registration);
	}
	public void updateRegistration(Registration registration) {
		dao.update(registration);	
	}
	public Registration queryRegistrationId(Integer Gid) {
		return dao.queryById(Gid);
	}
	public ArrayList<Registration> queryRegistration(){
		return dao.query();
	}
	public Integer GetGidByPid(Integer pid)
	{
		return dao.GetGidBypid(pid);
	}
}
