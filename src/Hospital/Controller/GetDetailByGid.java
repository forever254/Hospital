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
import Hospital.pojo.Detail;

/**
 * 获取药方详细表信息Controller层
 * @author Moline-x
 * 2019-06-23
 */
@WebServlet("/GetDetailByGid")
public class GetDetailByGid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=utf-8");
				
		PrintWriter out = response.getWriter();
		
		Integer gidfk = Integer.parseInt(request.getParameter("G_idFK"));
		
		
		detailService service = new detailService();
		
		
		ArrayList<Detail> list = service.querDetailBygId(gidfk);
		
		
		Gson gson = new Gson();
		
		String jsonStr = gson.toJson(list);
		
		out.print(jsonStr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
