package com.epam.hackme.common;

import java.util.HashMap;
import java.util.Map;

public class CacheService {
	
private static Map<String,Map<String, String>> passwords=new HashMap<>();

public static Map<String,Map<String, String>> savePassword(String key, String value,String userid){
	Map<String, String> userpassword=new HashMap<>();
	userpassword.put(key, value);
	passwords.put(userid,userpassword);
	return passwords;
}

public static String getPassword(String key,String userId) {
	return passwords.get(userId).get(key);
}
}
