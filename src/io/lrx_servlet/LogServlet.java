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
 * @time 2016-10-25下午5:38:38
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
		 * 登陆成功，保存用户名到session
		 */
		if (checkLogin(username, password)) {
			// 登录成功
			// 设置cookie 保存用户名
			Cookie cookie = new Cookie("uname", username);
			cookie.setMaxAge(60 * 60);
			resp.addCookie(cookie);

			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			// req.getRequestDispatcher("/success.jsp").forward(req,
			// resp);//转发会将servlet路径显示在
			resp.sendRedirect("/MyFirstSystem/logsign/success.jsp");// 重定向到成功页面
		} else {
			// 登陆失败
			// 保存出错信息到request中
			req.setAttribute("error", "登陆失败");
			// 转发到login.jsp
			// resp.sendRedirect("/MyFirstSystem/logsign/login.jsp");//重定向两次请求导致信息丢失
			req.getRequestDispatcher("/logsign/login.jsp").forward(req, resp);// 转发
		}

	}

	/*
	 * 验证登陆是否成功
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
