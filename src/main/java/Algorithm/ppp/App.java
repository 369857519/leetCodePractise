package Algorithm.ppp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Hello world!
 */
public class App {

	public static void main(String[] args){
		System.out.println(getBytesMD5("867306036797168".getBytes()));
	}
	/**
	 * 获取MD5加密字符串
	 * @param bytes
	 * @return
	 */
	public static String getBytesMD5(byte[] bytes) {
		if (bytes == null || bytes.length == 0) {
			return null;
		}
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
		md5.update(bytes, 0, bytes.length);
		byte[] digest = md5.digest();
		StringBuffer strBuf = new StringBuffer();
		for (int i = 0; i < digest.length; i++) {
			strBuf.append(byte2Hex(digest[i]));
		}
		return strBuf.toString();
	}
	private static String byte2Hex(byte b) {
		int value = (b & 0x7F) + (b < 0 ? 0x80 : 0);
		return (value < 0x10 ? "0" : "")
			+ Integer.toHexString(value).toLowerCase();
	}
}
