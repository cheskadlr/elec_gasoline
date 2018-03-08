package ust.greet.utility;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.*;

public class Security {
	
	public Security() {
		
	}

	public static void main(String[] args) {
		System.out.println("JDBC Driver: " + Security.encrypt("com.mysql.jdbc.Driver"));
		
		System.out.println("JDBC URL: " + Security.encrypt("jdbc:mysql://localhost:3306/delarosa-itelec4c-4itg"));
		
		System.out.println("dbUsername: " + Security.encrypt("root"));
		
		System.out.println("dbPassword: " + Security.encrypt(""));

	}
	
	private static byte[] key = {
			0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41, 0x53, 0x65, 0x63, 0x72, 0x65, 0x74, 0x4b, 0x65, 0x79
		};

		public static String encrypt(String strToEncrypt) {
			String encryptedString = null;
			try {
				Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
				final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
				cipher.init(Cipher.ENCRYPT_MODE, secretKey);
				encryptedString = Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes()));
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			return encryptedString;
		}

		public static String decrypt(String codeDecrypt){
			String decryptedString = null;
			try{
				Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
				final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
				cipher.init(Cipher.DECRYPT_MODE, secretKey);
				decryptedString = new String(cipher.doFinal(Base64.decodeBase64(codeDecrypt)));
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			return decryptedString;
		}

}
