package io.lrx_servlet;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lrx
 * @time 2016-10-25����5:40:41
 */

public class UserClass {
	private UserClass() {
		User e = new User("lilili", "123456");
		userset.add(e);

		e = new User("wangwang", "123456");
		userset.add(e);

		e = new User("wang", "123456");
		userset.add(e);
	}

	private static class User {
		String username;
		String password;

		// String email;

		User() {
		};

		User(String u, String p) {
			username = u;
			password = p;
			// email = e;
		}
	}

	private static UserClass user = null; // ���ж����е�ʵ��

	private final static Set<User> userset = new HashSet<User>();// �����Ϣ��Set

	public static void add(String u, String p) {// ����³�Ա
		User newuser = new User(u, p);
		userset.add(newuser);
	}

	/*
	 * public boolean hasUser(String u,){ if(userset.) }
	 */
	public static UserClass getInstance() {
		if (user == null) {
			user = new UserClass();
		}
		return user;
	}

	public Set<User> getUserSet() {
		return userset;
	}

}
/*
 * ��Ϊû�п��ǲ��ң�ʹ����set���޷���ѯ Ϊ�˷�������û��Ƿ���ڣ�ʹ��map���ؼ��� ��username;
 */
/*
 * public class UserClass { private UserClass() { User e = new User("lilili",
 * "123456"); userset.add(e);
 * 
 * e = new User("wangwang", "123456"); userset.add(e);
 * 
 * e = new User("wang", "123456"); userset.add(e); }
 * 
 * private static class User { String username; String password;
 * 
 * // String email;
 * 
 * User() { };
 * 
 * User(String u, String p) { username = u; password = p; // email = e; } }
 * 
 * private static UserClass user = null; // ���ж����е�ʵ��
 * 
 * private final static Set<User> userset = new HashSet<User>();// �����Ϣ��Set
 * 
 * public static void add(String u, String p) {// ����³�Ա User newuser = new
 * User(u, p); userset.add(newuser); } public boolean hasUser(String u,){
 * if(userset.) } public static UserClass getInstance() { if (user == null) {
 * user = new UserClass(); } return user; }
 * 
 * public Set<User> getUserSet() { return userset; }
 * 
 * }
 */
// private HashSet<String> set = new HashSet<String>();