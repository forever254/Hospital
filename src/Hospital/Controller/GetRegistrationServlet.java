package Hospital.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Hospital.pojo.Registration;
import Hospital.Service.registrationService;

/**
 * ��ȡ������ϢController��
 * @author Moline-x
 * 2019-06-18
 */
@WebServlet("/GetRegistrationServlet")
public class GetRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		int gid = Integer.parseInt(request.getParameter("G_id"));
		System.out.println(gid);
		registrationService service = new registrationService();
		
		
		Registration reg =service.queryRegistrationId(gid);
		
		
		Gson gson = new Gson();
		
		String jsonStr = gson.toJson(reg);
		
		out.print(jsonStr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
