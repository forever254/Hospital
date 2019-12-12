package Hospital.pojo;
/**
 * 挂号信息表实体类
 * @author lenovo
 * 2019-06-20
 */
import java.util.Date;
import java.text.SimpleDateFormat;

public class Registration {
	private Integer G_id;
	private Integer G_line;
	private Patient patient;//P_id;
	private String P_IDCard;
	private Check check;    //J_idFk;
	private subject sub;    //K_idFk;
	private Doctor doctor;  //D_idFk;
	private String G_time;
	private Double G_total;
	private String Remarks;//医生的诊断书
	
	public Registration() {
		super();
	}
	
//	public Registration(int id,double total) {
//		G_id = id;
//		G_total = total;
//	}
	
	public Registration(Integer gid,Check check,Patient pa,String remarks) {
		this.G_id=gid;
		this.check = check;
		this.patient=pa;
		this.Remarks=remarks;
	}
	public Registration(Integer g_id, Double g_total, String g_remark) {
		super();
		G_id = g_id;
		G_total = g_total;
		this.Remarks = g_remark;
	}
	public Registration(Integer g_line, Patient patient, String p_IDCard, Check check, subject sub, Doctor doctor,
			String g_time, Double g_total,String remarks) {
		super();
		G_line = g_line;//排队数
		this.patient = patient;//病人信息
		P_IDCard = p_IDCard;//病人身份证是
		this.check = check;
		this.sub = sub;
		this.doctor = doctor;
		G_time = g_time;
		G_total = g_total;
		this.Remarks=remarks;
	}

	public Registration(Integer g_id, Integer g_line, Patient patient, String p_IDCard, Check check, subject sub,
			Doctor doctor, String g_time, Double g_total,String remarks) {
		super();
		G_id = g_id;
		G_line = g_line;
		this.patient = patient;
		P_IDCard = p_IDCard;
		this.check = check;
		this.sub = sub;
		this.doctor = doctor;
		G_time = g_time;
		G_total = g_total;
		this.Remarks=remarks;
	}

	public Integer getG_id() {
		return G_id;
	}

	public void setG_id(Integer g_id) {
		G_id = g_id;
	}

	public Integer getG_line() {
		return G_line;
	}

	public void setG_line(Integer g_line) {
		G_line = g_line;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getP_IDCard() {
		return P_IDCard;
	}

	public void setP_IDCard(String p_IDCard) {
		P_IDCard = p_IDCard;
	}

	public Check getCheck() {
		return check;
	}

	public void setCheck(Check check) {
		this.check = check;
	}

	public subject getSub() {
		return sub;
	}

	public void setSub(subject sub) {
		this.sub = sub;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getG_time() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String gtime = sdf.format(date);
		return gtime;
	}

	public void setG_time(String g_time) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		g_time = sdf.format(date);
		G_time = g_time;
	}

	public Double getG_total() {
		return G_total;
	}

	public void setG_total(Double g_total) {
		G_total = g_total;
	}

	@Override
	public String toString() {
		return "Registration [G_id=" + G_id + ", G_line=" + G_line + ", patient=" + patient + ", P_IDCard=" + P_IDCard
				+ ", check=" + check + ", sub=" + sub + ", doctor=" + doctor + ", G_time=" + G_time + ", G_total="
				+ G_total + ", Remarks=" + Remarks + "]";
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	
	
	
	
	
}
