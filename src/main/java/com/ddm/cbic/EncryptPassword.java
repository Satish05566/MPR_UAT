package com.ddm.cbic;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;



public class EncryptPassword {
	
	public String randomString() {
		
		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();

	    

		return randomUUIDString;

	}
	
	public String encryptPassword(String pwd)
			throws UnsupportedEncodingException, NoSuchAlgorithmException, IllegalBlockSizeException,
			BadPaddingException, NoSuchPaddingException, InvalidKeyException {
		
		String ramdomString = randomString().substring(0, 6);
		String key = "ddmnic@)!$" + ramdomString;
		
		MessageDigest md = MessageDigest.getInstance("md5");

		byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));

		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

		for (int j = 0, k = 16; j < 8;) {

			keyBytes[k++] = keyBytes[j++];

		}

		SecretKey secretKey = new SecretKeySpec(keyBytes, "DESede");

		Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");

		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		// pwd
		byte[] plainTextBytes = pwd.getBytes("utf-8");

		byte[] buf = cipher.doFinal(plainTextBytes);

		byte[] base64Bytes = Base64.getEncoder().encode(buf);

		String base64EncryptedString = new String(base64Bytes);
		

		return ramdomString + base64EncryptedString;

	}

}
