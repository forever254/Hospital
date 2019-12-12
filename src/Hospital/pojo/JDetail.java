package Hospital.pojo;

public class JDetail {
	private Registration reg;
	private Check che;
	private String remarks;
	
	
	public JDetail() {
		super();
	}
	public JDetail(Registration reg,Check che,String remarks) {
		this.reg=reg;
		this.che=che;
		this.remarks=remarks;
	}
	

	
	public Registration getReg() {
		return reg;
	}
	public void setReg(Registration reg) {
		this.reg = reg;
	}
	public Check getChe() {
		return che;
	}
	public void setChe(Check che) {
		this.che = che;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "JDetail [reg=" + reg + ", check=" + che + ", remarks=" + remarks + "]";
	}
}
