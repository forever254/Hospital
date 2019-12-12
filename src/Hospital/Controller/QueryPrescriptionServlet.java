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

import Hospital.Service.prescriptionService;
import Hospital.pojo.Prescription;
/**
 * 查询药方表信息Controller层
 * @author Jession_LIU
 * 2019-06-23
 */

	@WebServlet("/QueryPrescriptionServlet")
	public class QueryPrescriptionServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/json;charset=utf-8");
			
			PrintWriter out = response.getWriter();
			
			prescriptionService service = new prescriptionService();
			
			ArrayList<Prescription> list = service.queryPrescription();
			
			Gson gson = new Gson();
			String jsonStr = gson.toJson(list);
			
			
			out.print(jsonStr);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

	}