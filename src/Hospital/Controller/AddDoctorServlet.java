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
  *����ҽ��Controller��
 * @author BayMax
 * 2019-06-21  
 */
@WebServlet("/AddDoctorServlet")
public class AddDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//���ñ���
		request.setCharacterEncoding("UTF-8");
		
		String dName = request.getParameter("D_name");
		String dSex = request.getParameter("D_sex");
		Integer dAge = Integer.parseInt(request.getParameter("D_age"));
		String dPhone = request.getParameter("D_phone");
		String dLevel = request.getParameter("D_level");
		Integer kid = Integer.parseInt(request.getParameter("K_idFK"));
		subject sub = new subject();
		sub.setKid(kid);
		String dExp = request.getParameter("D_exp");
		//��װҽ��ʵ����
		Doctor doctor = new Doctor(dName, dSex,dAge, dPhone, dLevel, sub, dExp);
		
		//����ҽ���߼���
		doctorService service = new doctorService();
		service.addDoctor(doctor);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}