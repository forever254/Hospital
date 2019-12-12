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
 * 更新挂号信息表Controller层
 * @author lenovo
 * 2019-06-24
 */
@WebServlet("/UpdateRegistrationServlet")
public class UpdateRegistrationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer G_id = Integer.parseInt(request.getParameter("G_id"));
		Integer G_line = Integer.parseInt(request.getParameter("G_line"));
		Integer P_idFK = Integer.parseInt(request.getParameter("P_idFK"));
		String P_IDCard = request.getParameter("P_IDCard");
		Integer J_idFK = Integer.parseInt(request.getParameter("J_idFK"));
		Integer K_idFK = Integer.parseInt(request.getParameter("K_idFK"));
		Integer D_idFK = Integer.parseInt(request.getParameter("D_idFK"));
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String G_time = sdf.format(date);
		Double G_total = Double.parseDouble(request.getParameter("G_total"));
		String G_remark = request.getParameter("G_remark");
		Patient patient = new Patient();
		patient.setPid(P_idFK);
		Check check = new Check();
		check.setJid(J_idFK);
		subject subject = new subject();
		subject.setKid(K_idFK);
		Doctor doctor = new Doctor();
		doctor.setDid(D_idFK);
		Registration registration = new Registration(G_id,G_line, patient, P_IDCard, check, subject, doctor, G_time,G_total,G_remark);
	
		registrationService service = new registrationService();
		service.updateRegistration(registration);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}