package Hospital.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital.Service.doctorService;

/**
 * 医生离职服务Controller层
 * @author BayMax
 * 2019-06-21
 */
@WebServlet("/DeleteDoctorServlet")
public class DeleteDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置编码
		request.setCharacterEncoding("UTF-8");
		
		Integer dId = Integer.parseInt(request.getParameter("D_id"));
		
		doctorService service = new doctorService();
		service.deleteDocotr(dId);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}