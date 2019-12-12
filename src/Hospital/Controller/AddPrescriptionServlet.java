package Hospital.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hospital.Service.prescriptionService;
import Hospital.pojo.Prescription;
import Hospital.pojo.Registration;

/**
 * @author Jession_LIU
 *���ҩ����ӿ�
 *2019-06-23
 */


@WebServlet("/AddPrescriptionServlet")
public class AddPrescriptionServlet extends HttpServlet{
	/**
	 *SerialVersionUID��������SUID���ǵ��������л���ʱ������һ����ʶ��stamp on ��������Ҳ��̫��������ʲô�ã���SUID��ֵ��Ϊ�ö����hascode�������ʹ�ù���serialver�鿴һ�����л������SUID��SUID���ڿ��ƶ���İ汾����Ҳ���������ļ���ָ��SUID����ָ��SUID�Ľ�����ǵ�����ӻ��߸���������Ѿ����л����ʱ�����ǲ����ٻָ��ˣ���Ϊ�µ�SUID��֮ǰ��SUID��ͬ�ˡ�Java�����л�������������ȷ��SUID�������л��Ѿ����л��Ķ������SUID��ƥ�䣬��ô�ͻ��� java.io.InvalidClassException �쳣�ˡ�
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ����ʽ
		request.setCharacterEncoding("UTF-8");
		
		//ҩ����������ǣ�һ��ҩ������Բ�ѯ���ҩ����ϸ������ݣ����������G_id���ܶ�
		//������G_id
		Integer G_id = Integer.parseInt(request.getParameter("G_id"));
		double total = Double.parseDouble(request.getParameter("total"));
		
//		Registration reg = new Registration(G_id,total);
		Registration reg = new Registration();
		reg.setG_id(G_id);
		Prescription pre = new Prescription(reg,total);
		
		prescriptionService preservice = new prescriptionService();
		preservice.addPrescription(pre);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}