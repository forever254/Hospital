package Hospital.pojo;
import Hospital.pojo.Patient;
/**
 * 检查后报告实体类
 * @author Kris
 * 2019-06-24
 */

public class Laboratory_Report {
	
	private Integer bid;
	private Registration registration;
	private Patient patient;
	private Check check;
	private String bcontent; 
	
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBcontent() {
		
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Registration getRegistration() {
		return registration;
	}
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	public Check getCheck() {
		return check;
	}
	public void setCheck(Check check) {
		this.check = check;
	}
	public Laboratory_Report() {
		super();
	}
	public Laboratory_Report(Integer bid, Registration registration, Patient patient, Check check, String bcontent) {
		super();
		this.bid = bid;
		this.registration = registration;
		this.patient = patient;
		this.check = check;
		this.bcontent = bcontent;
	}
	public Laboratory_Report(Registration registration, Patient patient, Check check, String bcontent) {
		super();
		this.registration = registration;
		this.patient = patient;
		this.check = check;
		this.bcontent = bcontent;
	}
	@Override
	public String toString() {
		return "Laboratory_Report [bid=" + bid + ", registration=" + registration + ", patient=" + patient + ", check="
				+ check + ", bcontent=" + bcontent + "]";
	}
	
}