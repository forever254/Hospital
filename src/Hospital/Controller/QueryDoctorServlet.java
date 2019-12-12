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

import Hospital.Service.doctorService;
import Hospital.pojo.Doctor;

/**
 * ��ѯҽ����ϢController��
 * @author BayMax
 * 2019-06-21
 */
@WebServlet("/QueryDoctorServlet")
public class QueryDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ���
		request.setCharacterEncoding("UTF-8");
		
		//����json��ʽ
		response.setContentType("text/json;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		//ҵ�����
		doctorService service = new doctorService();
		//�������ݼ���
		ArrayList<Doctor> list = service.queryDoctor();
		//�����ݼ���ת����json�ַ���
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);
		
		//��Ӧjson���ݵ�ǰ��
		out.print(jsonStr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
