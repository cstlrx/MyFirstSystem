package io.lrx_VerfiyCode;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author lrx
 * @time 2016-10-26����9:16:08
 */
public class Demo {
	/*
	 * ��֤��demo
	 */
	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		/*
		 * 1.����ͼƬ������ 2.���ÿ�� 3.�õ����ƻ��� 4.����
		 */
		// BufferedImage bi = new BufferedImage(70, 35,
		// BufferedImage.TYPE_INT_BGR);
		// Graphics2D g = (Graphics2D) bi.getGraphics();// �õ����ƻ���
		// g.setColor(Color.white);// ���û�����ɫ
		// g.fillRect(0, 0, 70, 35);
		// g.setColor(Color.red);
		// g.drawString("helloWorld", 10, 10);//
		//
		// ImageIO.write(bi, "JPEG", new FileOutputStream("F:/xxx.jpg"));//���浽�ļ�
		VerifyCode vf = new VerifyCode();
		BufferedImage bi = vf.getImage();
		ImageIO.write(bi, "jpeg", new FileOutputStream("F:/xxx.jpg"));
		System.out.println(vf.getText());

	}
}
