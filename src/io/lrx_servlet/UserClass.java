package io.lrx_servlet;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lrx
 * @time 2016-10-25下午5:40:41
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

	private static UserClass user = null; // 所有对象共有的实例

	private final static Set<User> userset = new HashSet<User>();// 存放信息的Set

	public static void add(String u, String p) {// 添加新成员
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
 * 因为没有考虑查找，使用了set，无法查询 为了方便查找用户是否存在，使用map，关键词 ：username;
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
 * private static UserClass user = null; // 所有对象共有的实例
 * 
 * private final static Set<User> userset = new HashSet<User>();// 存放信息的Set
 * 
 * public static void add(String u, String p) {// 添加新成员 User newuser = new
 * User(u, p); userset.add(newuser); } public boolean hasUser(String u,){
 * if(userset.) } public static UserClass getInstance() { if (user == null) {
 * user = new UserClass(); } return user; }
 * 
 * public Set<User> getUserSet() { return userset; }
 * 
 * }
 */
// private HashSet<String> set = new HashSet<String>();