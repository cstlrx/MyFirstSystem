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
 * @time 2016-10-31上午6:40:30
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
		// 设置编码，
		// 不设置会乱码
		request.setCharacterEncoding("utf-8");// 设置请求编码
		response.setCharacterEncoding("utf-8");// 响应编码

		// 封装表单数据到user
		User user = new User();
		/*
		 * 竟然是获得参数而不是元素，这里实在是不了解呀还是 user.setUsername((String)
		 * request.getAttribute("username")); user.setPassword((String)
		 * request.getAttribute("password"));
		 */
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));

		// 调用sign service方法
		UserService userservice = new UserService();
		try {
			userservice.sign(user);
			response.getWriter().print("注册成功");
			// 保存user对象到request 域中转发到登陆页面
			request.setAttribute("user", user);
			request.getRequestDispatcher("/logsign/login.jsp").forward(request,
					response);
			// response.sendRedirect("/logsign/login.jsp");
			// + "<a href = '" + request.getContextPath()
			// + "/logsign/login.jsp" + "'>点击登录</a>");
		} catch (UserException e) {

			request.setAttribute("msg", e.getMessage());
			// 保存user对象到request 域中转发
			request.setAttribute("user", user);
			// System.out.println(e.getMessage());
			// 转发
			request.getRequestDispatcher("/logsign/signin.jsp").forward(
					request, response);
		}

	}

}
