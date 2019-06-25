package com.epam.hackme.common;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.Base64Utils;

public class HackMeHelper {
	

public static String generateRandomString(int size) {
	return RandomStringUtils.random(size);
}

public static String convertPlainToCipher(String plainText) {
	return Base64Utils.encodeToString(plainText.getBytes());
}

public static String getCookieValue(HttpServletRequest request, String cookie) {
	
	return Arrays.stream(request.getCookies()).filter(c -> cookie.equals(c.getName())).map(Cookie::getValue).findAny().get();
	
}
}
