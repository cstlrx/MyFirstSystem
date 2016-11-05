package io.lrx.user.web.servlet;

import io.lrx_VerifyCode.VerifyCode;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lrx
 * @time 2016-11-3下午9:41:43
 */
public class VerifyCodeServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VerifyCode vc = new VerifyCode();

		// System.out.println(vc.getText());
		// String sessionverifycode = (String)
		// request.getSession().getAttribute(
		// "verifycode");
		// System.out.println(sessionverifycode);
		// 得到验证码图片
		BufferedImage image = vc.getImage();
		// 注意：!!!!!只有生成图片以后才能有文本，否则一直为空，出了一个一直空指针的错误，原来原因是将得到文本这行代码放到了生成图片之后
		// 保存文本到session信息中,可以和用户输入的结果进行比较
		request.getSession().setAttribute("verifycode", vc.getText());
		// 登陆页面请求验证码图片，把图片响应过去
		vc.output(image, response.getOutputStream());
	}

}
