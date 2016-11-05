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
 * @time 2016-10-31����6:40:30
 */
/*
 * signservlet
 */
public class SignServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ���ñ��룬
		// �����û�����
		request.setCharacterEncoding("utf-8");// �����������
		response.setCharacterEncoding("utf-8");// ��Ӧ����

		// ��װ�����ݵ�user
		User user = new User();
		/*
		 * ��Ȼ�ǻ�ò���������Ԫ�أ�����ʵ���ǲ��˽�ѽ���� user.setUsername((String)
		 * request.getAttribute("username")); user.setPassword((String)
		 * request.getAttribute("password"));
		 */
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));

		// ����sign service����
		UserService userservice = new UserService();
		try {
			userservice.sign(user);
			response.getWriter().print("ע��ɹ�");
			// ����user����request ����ת������½ҳ��
			request.setAttribute("user", user);
			request.getRequestDispatcher("/logsign/login.jsp").forward(request,
					response);
			// response.sendRedirect("/logsign/login.jsp");
			// + "<a href = '" + request.getContextPath()
			// + "/logsign/login.jsp" + "'>�����¼</a>");
		} catch (UserException e) {

			request.setAttribute("msg", e.getMessage());
			// ����user����request ����ת��
			request.setAttribute("user", user);
			// System.out.println(e.getMessage());
			// ת��
			request.getRequestDispatcher("/logsign/signin.jsp").forward(
					request, response);
		}

	}

}
