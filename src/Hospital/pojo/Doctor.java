package Hospital.pojo;

import Hospital.pojo.subject;
/**
 * 医生实体类
 * @author BayMax
 * 2019-06-20
 */
public class Doctor {
	
	private Integer did;
	private String dname;
	private String dsex;
	private Integer dage;
	private String dphone;
	private String dlevel;
	private subject sub;
	private String dexp;
	
	public Doctor() {
		super();
	}

	public Doctor(Integer did, String dname, String dsex, Integer dage, String dphone, String dlevel, subject sub,
			String dexp) {
		super();
		this.did = did;
		this.dname = dname;
		this.dsex = dsex;
		this.dage = dage;
		this.dphone = dphone;
		this.dlevel = dlevel;
		this.sub = sub;
		this.dexp = dexp;
	}

	public Doctor(String dname, String dsex, Integer dage, String dphone, String dlevel, subject sub, String dexp) {
		super();
		this.dname = dname;
		this.dsex = dsex;
		this.dage = dage;
		this.dphone = dphone;
		this.dlevel = dlevel;
		this.sub = sub;
		this.dexp = dexp;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDsex() {
		return dsex;
	}

	public void setDsex(String dsex) {
		this.dsex = dsex;
	}

	public Integer getDage() {
		return dage;
	}

	public void setDage(Integer dage) {
		this.dage = dage;
	}

	public String getDphone() {
		return dphone;
	}

	public void setDphone(String dphone) {
		this.dphone = dphone;
	}

	public String getDlevel() {
		return dlevel;
	}

	public void setDlevel(String dlevel) {
		this.dlevel = dlevel;
	}

	public subject getSub() {
		return sub;
	}

	public void setSub(subject sub) {
		this.sub = sub;
	}

	public String getDexp() {
		return dexp;
	}

	public void setDexp(String dexp) {
		this.dexp = dexp;
	}

	@Override
	public String toString() {
		return "Doctor [did=" + did + ", dname=" + dname + ", dsex=" + dsex + ", dage=" + dage + ", dphone=" + dphone
				+ ", dlevel=" + dlevel + ", sub=" + sub + ", dexp=" + dexp + "]";
	}
	
	
	
		
}
