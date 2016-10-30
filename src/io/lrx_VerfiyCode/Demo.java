package io.lrx_VerfiyCode;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author lrx
 * @time 2016-10-26下午9:16:08
 */
public class Demo {
	/*
	 * 验证码demo
	 */
	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		/*
		 * 1.创建图片缓冲区 2.设置宽高 3.得到绘制环境 4.保存
		 */
		// BufferedImage bi = new BufferedImage(70, 35,
		// BufferedImage.TYPE_INT_BGR);
		// Graphics2D g = (Graphics2D) bi.getGraphics();// 得到绘制环境
		// g.setColor(Color.white);// 设置环境白色
		// g.fillRect(0, 0, 70, 35);
		// g.setColor(Color.red);
		// g.drawString("helloWorld", 10, 10);//
		//
		// ImageIO.write(bi, "JPEG", new FileOutputStream("F:/xxx.jpg"));//保存到文件
		VerifyCode vf = new VerifyCode();
		BufferedImage bi = vf.getImage();
		ImageIO.write(bi, "jpeg", new FileOutputStream("F:/xxx.jpg"));
		System.out.println(vf.getText());

	}
}
