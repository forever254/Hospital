package Hospital.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital.Service.detailService;
import Hospital.pojo.Detail;
import Hospital.pojo.Medicine;
import Hospital.pojo.Registration;

/**
 * 更新药方详细表信息Controller层
 * @author Moline-x
 * 2019-06-23
 */
@WebServlet("/UpdateDetailServlet")
public class UpdateDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		
		Integer gidfk = Integer.parseInt(request.getParameter("G_idFK"));
		Registration reg = new Registration();
		reg.setG_id(gidfk);
		Integer midfk = Integer.parseInt(request.getParameter("M_idFK"));
		Medicine med = new Medicine();
		med.setMid(midfk);
		Integer xynum = Integer.parseInt(request.getParameter("XY_num"));
		String xycontent = request.getParameter("XY_content");
		//封装药方详细表实体类
		Detail detail = new Detail(reg, med, xynum, xycontent);
		
		//调用业务逻辑层
		detailService service = new detailService();
		service.updateDetail(detail);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
