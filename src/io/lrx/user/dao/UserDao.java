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
 * @time 2016-10-30����10:13:09
 */
/*
 * ʹ��dom4j
 */
public class UserDao {
	// �����ļ�λ��
	private final String PATH = "F:/user.xml";

	public User findByName(String name) {
		/*
		 * �����ݿ��в�ѯ��Ϣ 1���õ�document 2����ѯ 3���Ƿ�鵽���鵽��װ��ʵ��User��
		 */
		User user = new User();
		try {
			// �õ�document
			Document document = new SAXReader().read(PATH);
			// �õ���ѯ���element
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
		// Ϊʲôһֱ����null��������Ϊ����д������Ϊ����ֵ��Ȼ��null
		return user;
	}

	/**
	 * ����û�
	 * 
	 * @param newuser
	 *            User�����
	 */
	public void add(User user) {
		/*
		 * 1���õ�document 2���õ�rootԪ�� 3��
		 */
		try {
			Document document = new SAXReader().read(PATH);
			// Element element =
			// document.selectSingleNode("//user[@username='"+name+"'");
			// �õ���Ԫ��
			Element root = document.getRootElement();
			// ͨ����������Ԫ��
			Element newelement = root.addElement("user");
			// �������
			newelement.addAttribute("username", user.getUsername());
			newelement.addAttribute("password", user.getPassword());
			// ����д��,�����ĵ�
			OutputFormat format = new OutputFormat("\t", true);// ����\t �Ƿ���
			// ���ԭ�еĻ�������
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
