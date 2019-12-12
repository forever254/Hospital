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
 * ����ҩ����ϸ����ϢController��
 * @author Moline-x
 * 2019-06-23
 */
@WebServlet("/UpdateDetailServlet")
public class UpdateDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ���
		request.setCharacterEncoding("UTF-8");
		
		Integer gidfk = Integer.parseInt(request.getParameter("G_idFK"));
		Registration reg = new Registration();
		reg.setG_id(gidfk);
		Integer midfk = Integer.parseInt(request.getParameter("M_idFK"));
		Medicine med = new Medicine();
		med.setMid(midfk);
		Integer xynum = Integer.parseInt(request.getParameter("XY_num"));
		String xycontent = request.getParameter("XY_content");
		//��װҩ����ϸ��ʵ����
		Detail detail = new Detail(reg, med, xynum, xycontent);
		
		//����ҵ���߼���
		detailService service = new detailService();
		service.updateDetail(detail);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
