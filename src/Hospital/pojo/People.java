package Hospital.pojo;

/*
 *  @suanan
 */
public class People {
   private String idcard;
   private String Name;
   
   
   
public People(String idcard, String name) {
	super();
	this.idcard = idcard;
	Name = name;
}
public People() {  //source—>Generate Constructors from Superclass构造函数
	super();
	
}
public String getIdcard() {
	return idcard;
}
public void setIdcard(String idcard) {
	this.idcard = idcard;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
	

}
