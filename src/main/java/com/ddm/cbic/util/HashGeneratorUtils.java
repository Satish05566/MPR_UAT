package com.ddm.cbic.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGeneratorUtils {

	
	public HashGeneratorUtils() {
		 
    }
	
	@SuppressWarnings("unused")
	public String GenerateHashKey(String inputString) {
		
		String sha1Hash="";
		try {
            sha1Hash = HashGeneratorUtils.generateSHA1(inputString);
            System.out.println("SHA-1 Hash: " + sha1Hash);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return sha1Hash;
	}
	public static String generateSHA1(String message) throws Exception {
        return hashString(message, "SHA-1");
    }
	
	private static String hashString(String message, String algorithm)throws Exception {
 
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hashedBytes = digest.digest(message.getBytes("UTF-8"));
 
            return convertByteArrayToHexString(hashedBytes);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new Exception("Could not generate hash from String", ex);
        }
    }
	
	private static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayBytes.length; i++) {
            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }
	
}
