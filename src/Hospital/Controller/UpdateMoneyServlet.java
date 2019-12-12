package Hospital.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital.Service.registrationService;
import Hospital.pojo.Check;
import Hospital.pojo.Doctor;
import Hospital.pojo.Patient;
import Hospital.pojo.Registration;
import Hospital.pojo.subject;

/**
 * ���¹Һ���Ϣ��,������Ǯ�������Controller��
 * @author lenovo
 * 2019-06-24
 */
@WebServlet("/UpdateMoneyServlet")
public class UpdateMoneyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer G_id = Integer.parseInt(request.getParameter("G_idFK"));
		
		Double G_total = Double.parseDouble(request.getParameter("G_total"));
		String G_remark = request.getParameter("G_remarks");
		
		Registration registration = new Registration(G_id,G_total,G_remark);
	
		registrationService service = new registrationService();
		System.out.println("jj"+registration);
		service.updateMoney(registration);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}