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
 * 更新药方信息表Controller层
 * @author Jession_LIU
 * 2019-06-23
 */

@WebServlet("/UpdatePrescriptionServlet")
public class UpdatePrescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		
		Integer G_id = Integer.parseInt(request.getParameter("G_id"));
		double total = Double.parseDouble(request.getParameter("total"));
		
		//Registration reg = new Registration(G_id,total);
		Registration reg = new Registration();
		reg.setG_id(G_id);
		Prescription pre = new Prescription(reg,total);
		
		prescriptionService preservice = new prescriptionService();
		preservice.updatePrescription(pre);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}