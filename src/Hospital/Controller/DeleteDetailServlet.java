package Hospital.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital.Service.detailService;

/**
 * …æ≥˝“©∑ΩœÍœ∏±ÌController≤„
 * @author Moline-x
 * 2019-06-23
 */
@WebServlet("/DeleteDetailServlet")
public class DeleteDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//…Ë÷√±‡¬Î
		request.setCharacterEncoding("UTF-8");
				
		Integer gidfk = Integer.parseInt(request.getParameter("G_idFK"));
		Integer midfk = Integer.parseInt(request.getParameter("M_idFK"));
		
		detailService service = new detailService();
		service.deleteDetail(gidfk, midfk);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
