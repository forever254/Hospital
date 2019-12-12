package Hospital.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital.Service.prescriptionService;
/**
 * É¾³ýÒ©·½±íController²ã
 * @author Jession_LIU
 * 2019-06-23
 */

@WebServlet("/DeletePrescriptionServlet")
public class DeletePrescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		Integer id = Integer.parseInt(request.getParameter("G_id"));
		
		prescriptionService preService = new prescriptionService();
		
		preService.deletePrescription(id);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}