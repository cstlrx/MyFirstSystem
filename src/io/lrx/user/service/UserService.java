package io.lrx.user.service;

import io.lrx.user.dao.UserDao;
import io.lrx.user.domain.User;

/**
 * @author lrx
 * @time 2016-10-30����10:20:52
 */
public class UserService {
	private final UserDao userdao = new UserDao();

	/*
	 * ע��
	 */
	public void sign(User user) throws UserException {
		User _user = userdao.findByName(user.getUsername());
		if (_user != null)
			throw new UserException("�û���" + user.getUsername() + "�ѱ�ע��");
		userdao.add(user);
	}

	/*
	 * ��½ �������ݿ��в鵽��user������Ϣ
	 */
	public User login(User user) throws UserException {

		// ��ѯ���ݿ����Ƿ���user
		User _user = userdao.findByName(user.getUsername());
		if (_user == null)
			throw new UserException("�û���" + user.getUsername() + "������");

		if (!(_user.getPassword().equals(user.getPassword()))) {
			throw new UserException("�������");
		}
		return _user;
	}

}
