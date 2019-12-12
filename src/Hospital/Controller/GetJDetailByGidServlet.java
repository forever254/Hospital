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

import Hospital.Service.detailService;
import Hospital.Service.jdetailService;
import Hospital.pojo.Detail;
import Hospital.pojo.JDetail;

/**
 * Servlet implementation class GetJDetailByGidServlet
 */
@WebServlet("/GetJDetailByGidServlet")
public class GetJDetailByGidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
				
		PrintWriter out = response.getWriter();
		
		Integer gidfk = Integer.parseInt(request.getParameter("G_idFK"));
		
		
		jdetailService service = new jdetailService();
		
		
		ArrayList<JDetail> list = service.querJDetailBygId(gidfk);
		
		
		Gson gson = new Gson();
		
		String jsonStr = gson.toJson(list);
		
		out.print(jsonStr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
