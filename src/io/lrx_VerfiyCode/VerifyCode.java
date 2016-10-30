package io.lrx_VerfiyCode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author lrx
 * @time 2016-10-26下午9:54:21
 */
/*
 * 随机生成验证码
 */
public class VerifyCode {
	private final int w = 70;
	private final int h = 35;
	private final String codes = "1234567890abcdefghigklmnopqrstuvwxyz";
	private final String[] fontname = { "宋体", "楷体", "黑体", "微软雅黑" };
	private final Color bgcolor = new Color(255, 255, 255);
	private String text;
	private final Random rand = new Random();

	private Color getColor() {
		int r = rand.nextInt(155);
		int g = rand.nextInt(155);
		int b = rand.nextInt(155);

		return new Color(r, g, b);
	}

	private String getFont() {
		return fontname[rand.nextInt(fontname.length)];
	}

	private char getCode() {
		return codes.charAt(rand.nextInt(codes.length()));

	}

	public String getText() {

		return text;
	}

	public BufferedImage getImage() {
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_BGR);
		Graphics2D g = (Graphics2D) bi.getGraphics();// 得到绘制环境
		g.setColor(Color.white);// 设置环境白色
		g.fillRect(0, 0, w, h);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			int x = 3 + w / 4 * i;

			int y = h / 2;

			g.setColor(getColor());
			String code = getCode() + "";
			sb.append(code);
			g.drawString(code, x, y);
		}
		this.text = sb.toString();
		return bi;
	}

}
