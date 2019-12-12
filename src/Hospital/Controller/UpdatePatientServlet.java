package Hospital.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital.pojo.Patient;
import Hospital.Service.patientService;

/**
 * 更新病人信息服务Controller层
 * @author Moline-x
 * 2019-06-18
 */
@WebServlet("/UpdatePatientServlet")
public class UpdatePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Integer pId = Integer.parseInt(request.getParameter("P_id"));
		String pName = request.getParameter("P_name");
		Integer pAge = Integer.parseInt(request.getParameter("P_age"));
		String pSex = request.getParameter("P_sex");
		String pPhone = request.getParameter("P_phone");
		
		//封装病人实体类
		Patient patient = new Patient(pId,pName, pAge, pSex, pPhone);
		
		//调用业务逻辑层
		patientService service = new patientService();
		service.updatePatient(patient);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
