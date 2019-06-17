package com.epam.hackme.common;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.Base64Utils;

public class HackMeHelper {
	

public static String generateRandomString(int size) {
	return RandomStringUtils.random(size);
}

public static String convertPlainToCipher(String plainText) {
	return Base64Utils.encodeToString(plainText.getBytes());
}

}
