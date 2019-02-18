package ppp;

import java.net.URL;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class Codec {

	// 全局数组
	private final static String[] strDigits = {"0", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
	private String shortStart = "http://tinyurl.com/";
	private Map<String, String> cache=new HashMap<String, String>();

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		try{
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			String result= byteToString(messageDigest.digest(longUrl.getBytes("UTF-8")));
			cache.put(result,longUrl);
			return shortStart+result;
		}catch (Exception e){
			return "";
		}
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl){
		try{
			String md5Str=new URL(shortUrl).getPath().replaceFirst("/","");
			return cache.get(md5Str);
		}catch (Exception e){
			return "";
		}
	}

	private static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
		}
		return sBuffer.toString();
	}

	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return strDigits[iD1] + strDigits[iD2];
	}
}
