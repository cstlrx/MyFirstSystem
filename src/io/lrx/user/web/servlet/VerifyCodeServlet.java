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
 * @time 2016-11-3����9:41:43
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
		// �õ���֤��ͼƬ
		BufferedImage image = vc.getImage();
		// ע�⣺!!!!!ֻ������ͼƬ�Ժ�������ı�������һֱΪ�գ�����һ��һֱ��ָ��Ĵ���ԭ��ԭ���ǽ��õ��ı����д���ŵ�������ͼƬ֮��
		// �����ı���session��Ϣ��,���Ժ��û�����Ľ�����бȽ�
		request.getSession().setAttribute("verifycode", vc.getText());
		// ��½ҳ��������֤��ͼƬ����ͼƬ��Ӧ��ȥ
		vc.output(image, response.getOutputStream());
	}

}
