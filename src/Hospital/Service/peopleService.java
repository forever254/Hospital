package Hospital.Service;

import Hospital.pojo.*;
import Hospital.Dao.*;

/*查询是否有此人service
 * suanan
 */

public class peopleService {
	PeopleDao dao =new PeopleDao();
	
	public People querypeople(String idcard) {
		return dao.slectpep(idcard);      //传IDcare，name数据到dao层；
	}
}
