package Hospital.Service;

import java.util.ArrayList;

import Hospital.Dao.checkDao;
import Hospital.pojo.Check;

public class checkService {
	checkDao dao = new checkDao();
	public ArrayList<Check> query(){
		return dao.query();
	}
}