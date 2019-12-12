package Hospital.Service;

import java.util.ArrayList;

import Hospital.Dao.prescriptionDao;
import Hospital.pojo.Prescription;

/**
 * 药方表管理Service层
 * @author Jession_LIU
 * 2019-06-23
 */
public class prescriptionService {

	prescriptionDao dao = new prescriptionDao();
	
	public void addPrescription(Prescription pre) {
		dao.insert(pre);
	}
	public void deletePrescription(int G_id) {
		dao.delete(G_id);
	}
	public void updatePrescription(Prescription pre) {
		dao.update(pre);
	}
	public Prescription querryByID(int G_id) {
		return dao.queryByGid(G_id);
	}
	public ArrayList<Prescription> queryPrescription(){
		return dao.query();
	}
}