package io.lrx.user.test;

import io.lrx.user.dao.UserDao;
import io.lrx.user.domain.User;

import org.junit.Test;

/**
 * @author lrx
 * @time 2016-11-3����11:32:50
 */
public class UserDaoTest {

	@Test
	public void testFindByname() {
		User user = new User();
		UserDao userdao = new UserDao();
		user = userdao.findByName("����");
		System.out.println(user);
	}

	@Test
	public void testAdd() {
		User user = new User();
		UserDao userdao = new UserDao();

		user.setUsername("����");
		user.setPassword("123");
		userdao.add(user);
	}

}
