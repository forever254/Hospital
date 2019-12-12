package Hospital.pojo;

/**
 * @author Jession_LIU
 *药方实体类
 *2019-06-23
 */
public class Prescription {
	//Registration对象是挂号信息,G_id作为主键,查挂号单里的医生名和挂号单号
	private Registration Reg ;
	
	private double money;//总价格
	
	public Prescription() {
		super();
	}
	public Prescription(Registration Reg,double money) {
		this.Reg = Reg;
		this.money = money;
	}
	
	//get和set方法
	public Registration getReg() {
		return Reg;
	}
	public void setReg(Registration reg) {
		Reg = reg;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
}