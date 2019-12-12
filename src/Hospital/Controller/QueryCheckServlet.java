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

import Hospital.Service.checkService;
import Hospital.Service.doctorService;
import Hospital.pojo.Check;
import Hospital.pojo.Doctor;

/**
 * Servlet implementation class QueryCheckServlet
 */
@WebServlet("/QueryCheckServlet")
public class QueryCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//设置json格式
		response.setContentType("text/json;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		//业务对象
		checkService service = new checkService();
		//返回数据集合
		ArrayList<Check> list = service.query();
		//把数据集合转换成json字符串
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);
		
		//响应json数据到前端
		out.print(jsonStr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}