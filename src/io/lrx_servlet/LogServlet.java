package io.lrx_servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// System.out.println(username + "aaa");
		/*
		 * ��½�ɹ��������û�����session
		 */
		if (checkLogin(username, password)) {
			// ��¼�ɹ�
			// ����cookie �����û���
			Cookie cookie = new Cookie("uname", username);
			cookie.setMaxAge(60 * 60);
			resp.addCookie(cookie);

			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			// req.getRequestDispatcher("/success.jsp").forward(req,
			// resp);//ת���Ὣservlet·����ʾ��
			resp.sendRedirect("/MyFirstSystem/logsign/success.jsp");// �ض��򵽳ɹ�ҳ��
		} else {
			// ��½ʧ��
			// ���������Ϣ��request��
			req.setAttribute("error", "��½ʧ��");
			// ת����login.jsp
			// resp.sendRedirect("/MyFirstSystem/logsign/login.jsp");//�ض���������������Ϣ��ʧ
			req.getRequestDispatcher("/logsign/login.jsp").forward(req, resp);// ת��
		}

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
