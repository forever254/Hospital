package Hospital.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Hospital.Service.prescriptionService;
import Hospital.pojo.Prescription;
/**
 * 获取药方表信息Controller层
 * @author Jession_LIU
 * 2019-06-23
 */
@WebServlet("/GetPrescriptionServlet")
public class GetPrescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		Integer G_id = Integer.parseInt(request.getParameter("G_id"));
		
		prescriptionService service = new prescriptionService();
		
		Prescription pre = service.querryByID(G_id);
		
		Gson gson = new Gson();
		
		String jsonStr = gson.toJson(pre);
		
		out.print(jsonStr);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}