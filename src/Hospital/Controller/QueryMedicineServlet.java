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
 * ��ѯҩ��Controller��
 * @author Moline-x
 * 2019-07-02
 */
@WebServlet("/QueryMedicineServlet")
public class QueryMedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ���
		request.setCharacterEncoding("UTF-8");
				
		//����json��ʽ
		response.setContentType("text/json;charset=utf-8");
				
		PrintWriter out = response.getWriter();
		//ҵ�����
		medicineService service = new medicineService();
		//�������ݼ���
		ArrayList<Medicine> list = service.query();
		//�����ݼ���ת����json�ַ���
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);
				
		//��Ӧjson���ݵ�ǰ��
	    out.print(jsonStr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
