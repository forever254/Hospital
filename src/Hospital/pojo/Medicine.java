package Hospital.pojo;

/**
 * 药物实体类
 * @author moline-x
 * 2019-06-18
 * **/
public class Medicine {
	private Integer mid;
	private String mname;
	private Integer mclass;
	private	Double mprice;
	private String mfunction;
	
	public Medicine() {
		super();
	}
	

	public Medicine(Integer mid, String mname, Integer mclass, Double mprice, String mfunction) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mclass = mclass;
		this.mprice = mprice;
		this.mfunction = mfunction;
	}


	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMfunction() {
		return mfunction;
	}

	public void setMfunction(String mfunction) {
		this.mfunction = mfunction;
	}

	public Integer getMclass() {
		return mclass;
	}

	public void setMclass(Integer mclass) {
		this.mclass = mclass;
	}

	public Double getMprice() {
		return mprice;
	}

	public void setMprice(double f) {
		this.mprice = f;
	}


	@Override
	public String toString() {
		return "Medicine [mid=" + mid + ", mname=" + mname + ", mclass=" + mclass + ", mprice=" + mprice
				+ ", mfunction=" + mfunction + "]";
	}
	
	
	
	
	
	

}
