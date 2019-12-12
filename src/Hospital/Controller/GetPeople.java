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
import Hospital.Service.peopleService;
import Hospital.pojo.Doctor;
import Hospital.pojo.People;

/**是否存在此人controller层
 * Servlet implementation class GetPeople
 */
@WebServlet("/GetPeople")
public class GetPeople extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetPeople() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=utf-8");
			PrintWriter out = response.getWriter();	  //请求响应
			
			//
			String idcard = request.getParameter("P_IdCard");
			//String name = request.getParameter("P_name");
			
			peopleService service = new peopleService();
			
			People people = service.querypeople(idcard);
			
			Gson gson = new Gson();
			
			String jsonStr = gson.toJson(people);
			
			out.print(jsonStr);
			
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
