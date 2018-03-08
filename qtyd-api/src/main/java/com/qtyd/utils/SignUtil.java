package com.qtyd.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;

/**
 * <p>
 * 签名工具类
 * </p>
 * 
 * @author wanghui
 * @version $Id: SignUtil.java, v 0.1 2014-6-17 下午4:26:06 wanghui Exp $
 */
public class SignUtil {
	/**
	 * 签名
	 * 
	 * @param content
	 *            签名内容
	 * @param signMsg
	 *            网关返回签名           
	 * @param signType
	 *            MD5/RSA
	 * @param signKey
	 *            密钥
	 * @param charset
	 *            字符集
	 * @return
	 * @throws Exception
	 */
	public static boolean Check_sign(String content,String signMsg,String signType, String signKey,String charset) throws Exception {
		if ("MD5".equalsIgnoreCase(signType)) {
			return MD5.verify(content, signMsg, signKey, charset);
		} else if ("RSA".equalsIgnoreCase(signType)) {
			return RSA.verify(content, signMsg,signKey,charset);
		}
		return false;
	}

	public static String sign(String content, String signType, String signKey,
			String charset) throws Exception {
		if ("MD5".equalsIgnoreCase(signType)) {
			return MD5.sign(content, signKey, charset);
		} else if ("RSA".equalsIgnoreCase(signType)) {
			return RSA.sign(content, signKey, charset);
		}
		return "";
	}
	
	public static void main(String[] args) throws Exception {
		//生成秘钥对
		Map<String, Object> keyMap = RSA.genKeyPair();
		//获得公私钥
		String publicKey = RSA.getPublicKey(keyMap);
		String privateKey = RSA.getPrivateKey(keyMap);
		
		System.out.println(publicKey);
		System.out.println(privateKey);
		
		Map<String, String> map2 = new LinkedHashMap<String, String>();
		map2.put("name", "zhangsan");
		map2.put("sex", "1");
	    String content = Tools.createLinkString(map2, false);
		System.out.println(content);
		
		//开发商户通过公钥加密数据，传输给对接公司
		String encryptByPublicKey = Base64.encodeBase64String((RSA.encryptByPublicKey(content.getBytes("utf-8"), publicKey)));
	    System.out.println("开发商户加密：" + encryptByPublicKey);
	        
	    //对接公司通过私钥解密数据，进行签名
	    byte[] decryptByPrivateKey = RSA.decryptByPrivateKey(Base64.decodeBase64(encryptByPublicKey),privateKey);
	    String string = new String(decryptByPrivateKey, "utf-8");
	    System.out.println("对接公司解密后：" + string);
	    
	    //对接公司将请求数据进行签名
		System.out.println("对接公司进行验签："+sign(string,"RSA",privateKey,"UTF-8"));
		String sign = sign(string,"RSA",privateKey,"UTF-8");
		map2 = new LinkedHashMap<String, String>();
		map2.put("sign", sign);
		map2.put("string", string);
//		String content2 = Tools.createLinkString(map2, false);
		String content2 = JSONUtils.toJson(map2);
		
		//签名之后再将数据进行私钥加密
		String encryptByPublicKey2 =Base64.encodeBase64String(RSA.encryptByPrivateKey(content2.getBytes("utf-8"), privateKey));
		System.out.println("对接公司私钥加密：" + encryptByPublicKey2);
		
		//再将私钥加密过的数据传输给开发商户，商户通过公钥解密出来
		String string2  = new String(RSA.decryptByPublicKey(Base64.decodeBase64(encryptByPublicKey2), publicKey));
		System.out.println("开发商户公钥解密数据:"+string2);
		
		map2 = GsonUtil.fronJson2Map(string2);
		
		//开发商户解密出数据后将签名数据进行验签
		System.out.println(Check_sign(map2.get("string"),map2.get("sign"),"RSA",publicKey,"UTF-8"));
	}

}
