package com.epam.hackme.common;

import java.util.HashMap;
import java.util.Map;

public class CacheService {
	
private static Map<String, String> passwords=new HashMap<>();

public static Map<String, String> savePassword(String key, String value){
	passwords.put(key, value);
	return passwords;
}

public static String getPassword(String key) {
	return passwords.get(key);
}
}
