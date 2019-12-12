package Hospital.Test;

import org.junit.jupiter.api.Test;

import Hospital.Dao.laboratory_reportDao;
import Hospital.pojo.Check;
import Hospital.pojo.Laboratory_Report;
import Hospital.pojo.Patient;
import Hospital.pojo.Registration;

public class TestLaboratoryDao {
	laboratory_reportDao dao = new laboratory_reportDao();
	@Test
	public void insertTest() {
		Patient patient = new Patient();
		patient.setPid(21);
		Registration reg = new Registration();
		reg.setG_id(10002);
		Check check = new Check();
		check.setJid(311);
		Laboratory_Report lab = new Laboratory_Report(reg,patient,check,"病人呈现轻微过敏反应" );
		dao.insert(lab);
	}

}
