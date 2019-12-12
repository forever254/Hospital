package Hospital.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Hospital.Service.patientService;
import Hospital.Service.registrationService;
import Hospital.pojo.Patient;
import Hospital.pojo.Registration;

/**
 * ≤È—Øπ“∫≈–≈œ¢Controller≤„
 * @author lenovo
 * 2019-06-24
 */
@WebServlet("/QueryRegistrationServlet")
public class QueryRegistrationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		registrationService service = new registrationService();
	
		ArrayList<Registration> list = service.queryRegistration();
	
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);
		out.print(jsonStr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}