package Hospital.pojo;

import Hospital.pojo.Registration;
import Hospital.pojo.Medicine;

/**
 * 药方详细表实体类
 * @author Moline-x
 * 2019-06-23
 */
public class Detail {
	private Registration reg;
	private Medicine med;
	private Integer xynum;
	private String xycontent;
	
	public Detail() {
		super();
	}

	public Detail(Registration reg, Medicine med, Integer xynum, String xycontent) {
		super();
		this.reg = reg;
		this.med = med;
		this.xynum = xynum;
		this.xycontent = xycontent;
	}

	public Registration getReg() {
		return reg;
	}

	public void setReg(Registration reg) {
		this.reg = reg;
	}

	public Medicine getMed() {
		return med;
	}

	public void setMed(Medicine med) {
		this.med = med;
	}

	public Integer getXynum() {
		return xynum;
	}

	public void setXynum(Integer xynum) {
		this.xynum = xynum;
	}

	public String getXycontent() {
		return xycontent;
	}

	public void setXycontent(String xycontent) {
		this.xycontent = xycontent;
	}

	@Override
	public String toString() {
		return "Detail [reg=" + reg + ", med=" + med + ", xynum=" + xynum + ", xycontent=" + xycontent + "]";
	}
	
	

}
