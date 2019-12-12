package Hospital.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital.Service.laboratory_reportService;

/**
 * …æ≥˝ºÏ∫Û±®∏Ê controller≤„
 * @author Hao
 * 2019-06-24
 */
@WebServlet("/DeleteLaboratoryServlet")
public class DeleteLaboratoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//…Ë÷√±‡¬Î
		request.setCharacterEncoding("UTF-8");
		Integer bId = Integer.parseInt(request.getParameter("B_id"));
		laboratory_reportService service = new laboratory_reportService();
		service.deleteLaboratory_Report(bId);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}