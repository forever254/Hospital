package Hospital.Service;
/**
 * ҩ��������
 * @author Moline-x
 * 2019-07-02
 */

import java.util.ArrayList;

import Hospital.Dao.medicineDao;
import Hospital.pojo.Medicine;

public class medicineService {
	
	medicineDao dao = new medicineDao();
	
	public ArrayList<Medicine> query() {
		
		return dao.query();
	}

}
