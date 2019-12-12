package Hospital.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital.Service.laboratory_reportService;
import Hospital.pojo.Check;
import Hospital.pojo.Laboratory_Report;
import Hospital.pojo.Patient;
import Hospital.pojo.Registration;

/**
 * 新增检后报告controller层
 * @author Hao
 *2019-6-24
 */
@WebServlet("/AddLaboratory")
public class AddLaboratoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		Integer gidfk = Integer.parseInt(request.getParameter("G_idFK"));
		Registration reg = new Registration();
		reg.setG_id(gidfk);
		Integer pidfk = Integer.parseInt(request.getParameter("P_idFK"));
		Patient patient = new Patient();
		patient.setPid(pidfk);
		Integer jidfk = Integer.parseInt(request.getParameter("J_idFK"));
		Check check = new Check();
		check.setJid(jidfk);
		String bcontent = request.getParameter("B_content");
		
		Laboratory_Report lab = new Laboratory_Report(reg,patient,check,bcontent);
		laboratory_reportService service = new laboratory_reportService();
		service.addLaboratory_Report(lab);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}