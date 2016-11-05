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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 创建实体user中
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 验证码
		String verifycode = request.getParameter("verifycode");

		// 封装到user对象中
		user.setUsername(username);
		user.setPassword(password);
		user.setVerifyCode(verifycode);

		// 得到session中保存的验证码
		String sessionverifycode = (String) request.getSession().getAttribute(
				"verifycode");

		// System.out.println(user.getVerifyCode());
		// System.out.println(sessionverifycode);
		// 用户输入的验证码与session中保存的验证码不同
		// 转发错误信息到登陆页面
		if (!sessionverifycode.equalsIgnoreCase(user.getVerifyCode())) {
			request.setAttribute("msg", "验证码错误");
			request.setAttribute("user", user);
			request.getRequestDispatcher("/logsign/login.jsp").forward(request,
					response);
			//
			return;
		}

		/*
		 * 下面的try catch 用于登录过程中的异常处理，即登陆错误时抛出异常
		 */
		UserService service = new UserService();
		try {
			// log方法是登录方法
			User _user = service.login(user);
			// 保存数据库中查到的用户信息到session中
			request.getSession().setAttribute("user", _user);
			// 重定向到success.jsp页面
			response.sendRedirect(request.getContextPath()
					+ "/logsign/success.jsp");
			// request.getRequestDispatcher("/logsign/success.jsp").forward(
			// request, response);
			/*
			 * 捕获到异常处理
			 */
		} catch (UserException e) {
			// 保存错误信息
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", user);
			// 转发到登录页面
			request.getRequestDispatcher("/logsign/login.jsp").forward(request,
					response);
		}
		/*
		 * 登陆成功，保存用户名到session
		 */
		// 下面的代码是初学servlet时
		/*
		 * if (checkLogin(username, password)) { // 登录成功 // 设置cookie 保存用户名
		 * Cookie cookie = new Cookie("uname", username); cookie.setMaxAge(60 *
		 * 60); response.addCookie(cookie);
		 * 
		 * HttpSession session = request.getSession();
		 * session.setAttribute("username", username); //
		 * req.getRequestDispatcher("/success.jsp").forward(req, //
		 * resp);//转发会将servlet路径显示在
		 * response.sendRedirect("/MyFirstSystem/logsign/success.jsp");//
		 * 重定向到成功页面 } else { // 登陆失败 // 保存出错信息到request中
		 * request.setAttribute("error", "登陆失败"); // 转发到login.jsp //
		 * resp.sendRedirect("/MyFirstSystem/logsign/login.jsp");//重定向两次请求导致信息丢失
		 * request.getRequestDispatcher("/logsign/login.jsp").forward(request,
		 * response);// 转发 }
		 */

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
