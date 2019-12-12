package Hospital.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital.Service.prescriptionService;
import Hospital.pojo.Prescription;
import Hospital.pojo.Registration;

/**
 * @author Jession_LIU
 *添加药方表接口
 *2019-06-23
 */


@WebServlet("/AddPrescriptionServlet")
public class AddPrescriptionServlet extends HttpServlet{
	/**
	 *SerialVersionUID，后面简称SUID，是当对象序列化的时候对象的一个标识（stamp on 在这里我也不太清楚翻译成什么好），SUID的值常为该对象的hascode。你可以使用工具serialver查看一个序列化对象的SUID。SUID用于控制对象的版本。你也可以在类文件中指定SUID。不指定SUID的结果就是当你添加或者更改类的域并已经序列化类的时候，类是不能再恢复了，因为新的SUID和之前的SUID不同了。Java的序列化过程依赖于正确的SUID来反序列化已经序列化的对象，如果SUID不匹配，那么就会抛 java.io.InvalidClassException 异常了。
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		
		//药方表的作用是：一个药方表可以查询多个药物明细表的内容，表的内容是G_id和总额
		//传的是G_id
		Integer G_id = Integer.parseInt(request.getParameter("G_id"));
		double total = Double.parseDouble(request.getParameter("total"));
		
//		Registration reg = new Registration(G_id,total);
		Registration reg = new Registration();
		reg.setG_id(G_id);
		Prescription pre = new Prescription(reg,total);
		
		prescriptionService preservice = new prescriptionService();
		preservice.addPrescription(pre);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}