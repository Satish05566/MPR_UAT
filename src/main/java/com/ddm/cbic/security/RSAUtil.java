package com.ddm.cbic.security;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSAUtil {

	//public static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkWXVaWPIKNZK71nsfjyIF48HbxcKCozNuebeIJbxNVsK80S9CoHMvpgyE4TFPhfkeDsM6Sxsx+bbPkx8NaCGzeODVGiLE8uj719m7hSnGbH8pu8H0pq9XMu73fcm9NRQuHjJfoMqZxFNquKgkm/5pEBcqk1rq240+toebnsoCu71EC/L4u2ViGuTDwQiUMAwo0s4dnrJgthaog11Vi9dUzg8hWK/t9lK8m82OOF208ixg07reto8ksvZHOGDYHJ7KOZH3nbM24n1tUYAxoXe9atP8y2VLJy7x5WJLq0ofbzFfUg+PqRNzPY5tyUGNVYwgBPfvC399M53dU5OXi/cswIDAQAB"; // add key here
	//public static String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCRZdVpY8go1krvWex+PIgXjwdvFwoKjM255t4glvE1WwrzRL0Kgcy+mDIThMU+F+R4OwzpLGzH5ts+THw1oIbN44NUaIsTy6PvX2buFKcZsfym7wfSmr1cy7vd9yb01FC4eMl+gypnEU2q4qCSb/mkQFyqTWurbjT62h5ueygK7vUQL8vi7ZWIa5MPBCJQwDCjSzh2esmC2FqiDXVWL11TODyFYr+32UrybzY44XbTyLGDTut62jySy9kc4YNgcnso5kfedszbifW1RgDGhd71q0/zLZUsnLvHlYkurSh9vMV9SD4+pE3M9jm3JQY1VjCAE9+8Lf30znd1Tk5eL9yzAgMBAAECggEAaksfHF/VCX235IlB6fuIpmhqz9zw+0t6bqiHxR10E0SOmc+rv82qh7+uBDTxGXbQENFim+hdUjrEFyRFPdMwGb502TVgT0V1gF6nWfABRTiocsWWW3HCc9+BZUD02tGIfYPYEkQDsLumowHwz31K7Lgcxme5CeeUlbr1umEQogR3G64uflfL/Y3JngALUD9mCIRn4oskSmUVZXKnEOa3zh8C6A7ottKODcE8Qa8JGvlIb7VC75i1cLpmbxfFngpzxb/1K1e/TBSF+mlUj6GsNa2CDTiVpL1LYiA7YLCQyGrEheCCf88Vt8X51X19ISQzTk5tkNc9R/SvvOw3IljnIQKBgQDlOY9ID28AmQHxdAsKhonkOOXsUDWiqJiKQXt1ZZzpFzHxc3QzYDjVIlUUzB2qyW46Ig6VeH7r6rsPbwIx5u3NJEQk/0iRTB18v4EgF/LuNg3HdFaxFc0WuGqBy907yCl/fgNJ+RqkI/KdNyyrPsaY0MNLO8yyqZrLaOPq7PIP4wKBgQCiYZ6CoxwgHTM1np5xdAhS4aITHbMNa9LovrJS2QwFCYK0ggHdgJC1gK8W4LNui1vHUJe7Xwl/yXIWXNzEB4fSlLBE/1pKIzVBUN1DrSVmRW16PxoSf67n9FICrHVZTi4+ZqUVGUrnT6/8gpTNVlC7dIIr38IIZ/F8qq6/41n48QKBgD1pXF+78stAMusTYdniDZNdQww6uQPpE2UHAiKDpLQ2CKVdfyY8gz1mw1CdFt2otaVRdoLJE4f1DUSnQvlHmzI4oyEeW7zBnazMSbXldKopRSvImWk8JAQQSEiZ652WlLeZdRweZurOzrMcExWV7fMHCytezAqZseUJJvbLoFZtAoGACU5m8z294ulJgg0xL3di8r0TuNy+4koHsGcdeToPQkqlPwskaDlyEbTqU/lUz0UVYXrw90AfHz/AVh/EV0fHNP5oi8vGtPEHoFKuG67UsePQvmzXZbADqi+Kc7TGlPOyGslvNKJadJ9QirxBIvOLdPLccv9D849he6+cjErPYUECgYAOC+HUlLSFb++Fy5jvJfcmGsr2JFl49PSCEGhXv4vs11nMovmzVxtggZbS9KitV286apBIUIwfBd+OAJb0KJoDrpMdMjZ/9b/WE4jrx8q42UBBtRheNWKIVsuXSl2F3g5Uyu7iFdxGKEE2mHD0nqtd/Iryfncu8u7MR/OWct7Pxg=="; // add key here
	//	

	    public static PublicKey getPublicKey(String base64PublicKey){
	        PublicKey publicKey = null;
	        try{
	            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
	            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	            publicKey = keyFactory.generatePublic(keySpec);
	            return publicKey;
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        } catch (InvalidKeySpecException e) {
	            e.printStackTrace();
	        }
	        return publicKey;
	    }

	    public static PrivateKey getPrivateKey(String base64PrivateKey){
	        PrivateKey privateKey = null;
	        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey.getBytes()));
	        KeyFactory keyFactory = null;
	        try {
	            keyFactory = KeyFactory.getInstance("RSA");
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        try {
				if(keySpec!=null)
				{
	            privateKey = keyFactory.generatePrivate(keySpec);
				}
	        } catch (InvalidKeySpecException e) {
	            e.printStackTrace();
	        }
	        return privateKey;
	    }

	    public static byte[] encrypt(String data, String publicKey) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
	        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
	        return cipher.doFinal(data.getBytes());
	    }

	    public static String decrypt(byte[] data, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
	        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	        cipher.init(Cipher.DECRYPT_MODE, privateKey);
	        return new String(cipher.doFinal(data));
	    }

	    public static String decrypt(String data, String base64PrivateKey) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
	        return decrypt(Base64.getDecoder().decode(data.getBytes()), getPrivateKey(base64PrivateKey));
	    }

	    /*
	    public static void main(String[] args) throws IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, BadPaddingException {
	        try {
	        	 String encryptedString = Base64.getEncoder().encodeToString(encrypt("2010", publicKey));
	            System.out.println(encryptedString);
	            String decryptedString = RSAUtil.decrypt(encryptedString, privateKey);
	            System.out.println(decryptedString);
	        } catch (NoSuchAlgorithmException e) {
	            System.err.println(e.getMessage());
	        }

	    }
	    */
	}