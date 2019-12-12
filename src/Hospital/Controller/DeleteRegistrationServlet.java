package Hospital.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital.Service.registrationService;

/**
 * É¾³ý¹ÒºÅÐÅÏ¢Controller²ã
 * @author lenovo
 * 2019-06-24
 */
@WebServlet("/DeleteRegistrationServlet")
public class DeleteRegistrationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String G_id = request.getParameter("G_id");
		registrationService service = new registrationService();
		service.deleteRegistration(Integer.parseInt(G_id));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}