package Hospital.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital.Service.registrationService;

/**
 * Servlet implementation class GetGidByPid
 */
@WebServlet("/GetGidByPid")
public class GetGidByPid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();	
		Integer pidfk =Integer.parseInt(request.getParameter("P_idFK"));
		registrationService service = new registrationService();
		Integer gid = service.GetGidByPid(pidfk);
		
		
		out.print(gid);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
