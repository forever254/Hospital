package Hospital.pojo;

/**
 * @author Jession_LIU
 *ҩ��ʵ����
 *2019-06-23
 */
public class Prescription {
	//Registration�����ǹҺ���Ϣ,G_id��Ϊ����,��Һŵ����ҽ�����͹Һŵ���
	private Registration Reg ;
	
	private double money;//�ܼ۸�
	
	public Prescription() {
		super();
	}
	public Prescription(Registration Reg,double money) {
		this.Reg = Reg;
		this.money = money;
	}
	
	//get��set����
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