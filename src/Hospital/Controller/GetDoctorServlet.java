package Hospital.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Hospital.Service.doctorService;
import Hospital.pojo.Doctor;

/**
 * 获取医生信息Controller层
 * @author BayMax
 * 2019-06-21
 */
@WebServlet("/GetDoctorServlet")
public class GetDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		Integer dId = Integer.parseInt(request.getParameter("dId"));
		
		doctorService service = new doctorService();
		
		Doctor doctor = service.queryDoctorId(dId);
		
		Gson gson = new Gson();
		
		String jsonStr = gson.toJson(doctor);
		
		out.print(jsonStr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
