package Hospital.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital.Service.doctorService;
import Hospital.pojo.Doctor;
import Hospital.pojo.subject;

/**
 * 更新医生信息服务Controller层
 * @author BayMax
 * 2019-06-21
 */
@WebServlet("/UpdateDoctorServlet")
public class UpdateDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		
		Integer dId = Integer.parseInt(request.getParameter("D_id"));
		String dName = request.getParameter("D_name");
		String dSex = request.getParameter("D_sex");
		Integer dAge = Integer.parseInt(request.getParameter("D_age"));
		String dPhone = request.getParameter("D_phone");
		String dLevel = request.getParameter("D_level");
		Integer kid = Integer.parseInt(request.getParameter("K_idFK"));
		subject sub = new subject();
		sub.setKid(kid);
		String dExp = request.getParameter("D_exp");
		//封装医生实体类
		Doctor doctor = new Doctor(dId, dName, dSex, dAge, dPhone, dLevel, sub, dExp);
		
		//调用业务逻辑层
		doctorService service = new doctorService();
		service.updateDoctor(doctor);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}