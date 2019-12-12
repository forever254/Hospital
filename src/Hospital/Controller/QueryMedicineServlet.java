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

import Hospital.Dao.medicineDao;
import Hospital.Service.doctorService;
import Hospital.Service.medicineService;
import Hospital.pojo.Doctor;
import Hospital.pojo.Medicine;

/**
 * 查询药物Controller层
 * @author Moline-x
 * 2019-07-02
 */
@WebServlet("/QueryMedicineServlet")
public class QueryMedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
				
		//设置json格式
		response.setContentType("text/json;charset=utf-8");
				
		PrintWriter out = response.getWriter();
		//业务对象
		medicineService service = new medicineService();
		//返回数据集合
		ArrayList<Medicine> list = service.query();
		//把数据集合转换成json字符串
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);
				
		//响应json数据到前端
	    out.print(jsonStr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
