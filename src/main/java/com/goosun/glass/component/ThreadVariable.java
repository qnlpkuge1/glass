package com.goosun.glass.component;

import java.util.HashMap;
import java.util.Map;

import com.goosun.glass.domain.Session;
import com.goosun.glass.domain.User;

public class ThreadVariable {

	private static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
	public final static String LOGIN_SESSION_ID = "sid";
	public final static String LOGIN_USER_ID = "userId";
	
	public static void clearThreadVariable(){
		threadLocal.remove();
	}
	
	public static void setSession(Session session) {
		Map map = createMap(LOGIN_SESSION_ID,session);
		threadLocal.set(map);
	}

	private static Map createMap(String key,Object obj) {
		Map map = (Map)threadLocal.get();
		if(map==null){
			map=new HashMap();
		}
		map.put(key,obj);
		return map;
	}

	public static Session getSession() {
		Map map = (Map)threadLocal.get();
		if(map!=null){
			return (Session)map.get(LOGIN_SESSION_ID);
		}
		return null;
	}
	
	public static void setUser(User user) {
		Map map = createMap(LOGIN_USER_ID,user);
		threadLocal.set(map);
	}
	
	public static User getUser() {
		Map map = (Map)threadLocal.get();
		if(map!=null){
			return (User)map.get(LOGIN_USER_ID);
		}
		return null;
	}
	
}
