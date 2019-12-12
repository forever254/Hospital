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

import Hospital.Service.laboratory_reportService;
import Hospital.pojo.Laboratory_Report;

/**
 * 查询检后报告 controller层
 * @author Hao
 * 2019-06-24
 */
@WebServlet("/QueryLaboratoryServlet")
public class QueryLaboratoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		
		//设置json格式
		response.setContentType("text/json;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		//业务对象
		laboratory_reportService service = new laboratory_reportService();
		//返回数据集合
		ArrayList<Laboratory_Report> list = service.queryLaboratory_Report();
		//把数据集合转换成json字符串
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);
		
		//响应json数据到前端
		out.print(jsonStr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}