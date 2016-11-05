package io.lrx.user.dao;

import io.lrx.user.domain.User;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @author lrx
 * @time 2016-10-30下午10:13:09
 */
/*
 * 使用dom4j
 */
public class UserDao {
	// 数据文件位置
	private final String PATH = "F:/user.xml";

	public User findByName(String name) {
		/*
		 * 在数据库中查询信息 1、得到document 2、查询 3、是否查到，查到封装到实体User中
		 */
		User user = new User();
		try {
			// 得到document
			Document document = new SAXReader().read(PATH);
			// 得到查询后的element
			Element ele = (Element) document
					.selectSingleNode("/users/user[@username='" + name + "']");
			if (ele == null) {
				return null;
			}

			String username = ele.attributeValue("username");
			String password = ele.attributeValue("password");
			user.setUsername(username);
			user.setPassword(password);
			// System.out.println("hello");
		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
		// 为什么一直返回null，不是因为代码写错，是因为返回值竟然是null
		return user;
	}

	/**
	 * 添加用户
	 * 
	 * @param newuser
	 *            User类对象
	 */
	public void add(User user) {
		/*
		 * 1、得到document 2、得到root元素 3、
		 */
		try {
			Document document = new SAXReader().read(PATH);
			// Element element =
			// document.selectSingleNode("//user[@username='"+name+"'");
			// 得到根元素
			Element root = document.getRootElement();
			// 通过根创建新元素
			Element newelement = root.addElement("user");
			// 添加属性
			newelement.addAttribute("username", user.getUsername());
			newelement.addAttribute("password", user.getPassword());
			// 重新写入,保存文档
			OutputFormat format = new OutputFormat("\t", true);// 缩进\t 是否换行
			// 清除原有的换行缩进
			format.setTrimText(true);

			try {
				XMLWriter writer = new XMLWriter(new OutputStreamWriter(
						new FileOutputStream(PATH), "UTF-8"), format);
				writer.write(document);
				writer.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		} catch (Exception e) {

			throw new RuntimeException(e);
		}

	}
}
