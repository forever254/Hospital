package Hospital.Service;

import java.util.ArrayList;
import Hospital.Dao.laboratory_reportDao;
import Hospital.pojo.Laboratory_Report;

/**
 * 检后报告表Service层
 * @author Hao
 * 2019-06-24
 */

import java.util.ArrayList;

import Hospital.Dao.laboratory_reportDao;
import Hospital.pojo.Doctor;
import Hospital.pojo.Laboratory_Report;

public class laboratory_reportService {
	laboratory_reportDao dao = new laboratory_reportDao();
	public void addLaboratory_Report(Laboratory_Report laboratory_report) {
		dao.insert(laboratory_report);
	}
	
	public void deleteLaboratory_Report(Integer bId) {
		dao.delete(bId);
	}
	
	public Laboratory_Report queryLaboratory_ReportId(Integer bId) {
		return dao.queryById(bId);
	}
	public ArrayList<Laboratory_Report> queryLaboratory_Report(){
		return dao.query();
	}

}