package io.lrx.user.service;

import io.lrx.user.dao.UserDao;
import io.lrx.user.domain.User;

/**
 * @author lrx
 * @time 2016-10-30下午10:20:52
 */
public class UserService {
	private final UserDao userdao = new UserDao();

	/*
	 * 注册
	 */
	public void sign(User user) throws UserException {
		User _user = userdao.findByName(user.getUsername());
		if (_user != null)
			throw new UserException("用户名" + user.getUsername() + "已被注册");
		userdao.add(user);
	}

	/*
	 * 登陆 返回数据库中查到的user所有信息
	 */
	public User login(User user) throws UserException {

		// 查询数据库中是否有user
		User _user = userdao.findByName(user.getUsername());
		if (_user == null)
			throw new UserException("用户名" + user.getUsername() + "不存在");

		if (!(_user.getPassword().equals(user.getPassword()))) {
			throw new UserException("密码错误");
		}
		return _user;
	}

}
