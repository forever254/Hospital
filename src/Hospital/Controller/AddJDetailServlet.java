package Hospital.Controller;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital.Service.detailService;
import Hospital.Service.jdetailService;
import Hospital.pojo.Check;
import Hospital.pojo.Detail;
import Hospital.pojo.JDetail;
import Hospital.pojo.Medicine;
import Hospital.pojo.Registration;

/**
 * Servlet implementation class AddJDetailServlet
 */
@WebServlet("/AddJDetailServlet")
public class AddJDetailServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		
		Integer gidfk = Integer.parseInt(request.getParameter("G_idFK"));
		Registration reg = new Registration();
		reg.setG_id(gidfk);
		Integer midfk = Integer.parseInt(request.getParameter("J_idFK"));
		Check che = new Check();
		che.setJid(midfk);
		
		//封装药方详细表实体类
		JDetail detail = new JDetail(reg, che,"0");
		
		//调用药方详细表逻辑层
		jdetailService service = new jdetailService();
		service.addJDetail(detail);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
