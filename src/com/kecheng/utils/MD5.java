package com.kecheng.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hengyang4 on 2018/6/15.
 */
public class MD5 {

	/**
	 * 使用md5进行加密
	 **/
	public static String EncodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// 确定计算方法
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64Encoder = new BASE64Encoder();
		// 加密后的字符串
		String newstr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
		return newstr;
	}

	/**
	 * 判断用户密码是否正确 用户输入的密码 @param newpwd 数据库中保存的密码 @param oldpwd
	 **/
	public boolean checkPassword(String newpwd, String oldpwd)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (EncodeByMd5(newpwd).equals(oldpwd))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		MD5 md5 = new MD5();
		String str = null;
		try {
			str = md5.EncodeByMd5("123456");
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(str);
	}
}
