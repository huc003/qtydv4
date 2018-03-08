package com.qtyd.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

public class StringUtils {

	public static String encode(String str) {

		return encode(str, "UTF-8");
	}

	public static String decode(String str) {

		return decode(str, "UTF-8");
	}

	public static String nullToStrTrim(String str) {
		if (str == null) {
			str = "";
		}
		return str.trim();
	}

	public static int nullToIntZero(String str) {
		if (ValidatorUtils.isNull(str)) {
			str = "0";
		}
		return Integer.valueOf(str.trim(), 10);
	}

	public static String byte2hex(byte[] b) {

		String str = "";
		String stmp = "";

		int length = b.length;

		for (int n = 0; n < length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				str += "0";
			}
			str += stmp;
		}

		return str.toLowerCase();
	}

	public static String encode(String str, String enc) {

		String strEncode = "";

		try {
			if (str != null)
				strEncode = URLEncoder.encode(str, enc);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return strEncode;
	}

	public static String decode(String str, String enc) {

		String strDecode = "";

		try {
			if (str != null)
				strDecode = URLDecoder.decode(str, enc);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return strDecode;
	}

	public static String subString(String str, String begin, String end) {
		int t = str.indexOf(begin);
		String x = str.substring(t + begin.length());
		x = x.substring(0, x.indexOf(end));
		return x;
	}

	public static String arrayToString(Object[] object) {
		StringBuffer buffer = new StringBuffer("[");
		for (Object obj : object) {
			buffer.append(String.valueOf(obj)).append(",");
		}
		buffer.delete(buffer.length() - 1, buffer.length());
		buffer.append("]");
		return buffer.toString();
	}

	/**
	 * 列表转字符串
	 * @param object
	 * @param split
	 * @return
	 */
	public static String listToString(List<Object> object,String split) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < object.size(); i++) {
			buffer.append(String.valueOf(object.get(i)));
			if(i+1<object.size()){
				buffer.append(split);
			}
		}
		return buffer.toString();
	}
	/**
	 * 对指定字符串 分割,然后 英文逗号重组
	 * 
	 * @param value
	 *            字符串值
	 * @param split
	 *            分割方式
	 * @return
	 */
	public static String divisionAssemble(String value, String split) {
		if (ValidatorUtils.isEmpty(value)) {
			return null;
		}
		String[] splitArray = value.split(split);
		if (splitArray == null || splitArray.length <= 0) {
			return null;
		}
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < splitArray.length; i++) {
			if (!ValidatorUtils.isDigital(splitArray[i])) {
				return null;
			}
			result.append(splitArray[i]);
			if (i < splitArray.length - 1) {
				result.append(",");
			}
		}
		return result.toString();
	}
	
	/**
	*	String a = "kkk=999=00";
	*	String[] b = readright(a,"=");
	*	System.out.println(b[0]);
	*	System.out.println(b[1]);
	 * @param in
	 * @param delim
	 * @return
	 */
	public static String[] readright(String in ,String delim){
		int a = in.indexOf(delim);
		if(a>=0){
			return new String[]{in.substring(0, a),in.substring(a+delim.length())};
		}
		return new String[]{in,""};
	}
	
}
