package io.lrx.user.web.servlet;

import io.lrx.user.domain.User;
import io.lrx.user.service.UserException;
import io.lrx.user.service.UserService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lrx
 * @time 2016-10-25����5:38:38
 */
public class LogServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// ����ʵ��user��
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// ��֤��
		String verifycode = request.getParameter("verifycode");

		// ��װ��user������
		user.setUsername(username);
		user.setPassword(password);
		user.setVerifyCode(verifycode);

		// �õ�session�б������֤��
		String sessionverifycode = (String) request.getSession().getAttribute(
				"verifycode");

		// System.out.println(user.getVerifyCode());
		// System.out.println(sessionverifycode);
		// �û��������֤����session�б������֤�벻ͬ
		// ת��������Ϣ����½ҳ��
		if (!sessionverifycode.equalsIgnoreCase(user.getVerifyCode())) {
			request.setAttribute("msg", "��֤�����");
			request.setAttribute("user", user);
			request.getRequestDispatcher("/logsign/login.jsp").forward(request,
					response);
			//
			return;
		}

		/*
		 * �����try catch ���ڵ�¼�����е��쳣��������½����ʱ�׳��쳣
		 */
		UserService service = new UserService();
		try {
			// log�����ǵ�¼����
			User _user = service.login(user);
			// �������ݿ��в鵽���û���Ϣ��session��
			request.getSession().setAttribute("user", _user);
			// �ض���success.jspҳ��
			response.sendRedirect(request.getContextPath()
					+ "/logsign/success.jsp");
			// request.getRequestDispatcher("/logsign/success.jsp").forward(
			// request, response);
			/*
			 * �����쳣����
			 */
		} catch (UserException e) {
			// ���������Ϣ
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", user);
			// ת������¼ҳ��
			request.getRequestDispatcher("/logsign/login.jsp").forward(request,
					response);
		}
		/*
		 * ��½�ɹ��������û�����session
		 */
		// ����Ĵ����ǳ�ѧservletʱ
		/*
		 * if (checkLogin(username, password)) { // ��¼�ɹ� // ����cookie �����û���
		 * Cookie cookie = new Cookie("uname", username); cookie.setMaxAge(60 *
		 * 60); response.addCookie(cookie);
		 * 
		 * HttpSession session = request.getSession();
		 * session.setAttribute("username", username); //
		 * req.getRequestDispatcher("/success.jsp").forward(req, //
		 * resp);//ת���Ὣservlet·����ʾ��
		 * response.sendRedirect("/MyFirstSystem/logsign/success.jsp");//
		 * �ض��򵽳ɹ�ҳ�� } else { // ��½ʧ�� // ���������Ϣ��request��
		 * request.setAttribute("error", "��½ʧ��"); // ת����login.jsp //
		 * resp.sendRedirect("/MyFirstSystem/logsign/login.jsp");//�ض���������������Ϣ��ʧ
		 * request.getRequestDispatcher("/logsign/login.jsp").forward(request,
		 * response);// ת�� }
		 */

	}

	/*
	 * ��֤��½�Ƿ�ɹ�
	 */
	protected boolean checkLogin(String username, String password) {
		boolean flag = false;
		// UserClass user = UserClass.getInstance();
		if (username != null && !("".equals(username)) && password != null
				&& !("".equals(password))) {
			// if(user.getUserSet());
			flag = true;
		}
		return flag;
	}

}
