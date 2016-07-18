package com.bw.oa.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.persistence.Entity;
import org.apache.log4j.Logger;

/**
 * description:常用工具类 date:20150428
 * 
 * @author BoildWater
 * 
 */
@Entity
public class BwUtil {
	private static Logger log = Logger.getLogger(BwUtil.class);

	/**
	 * description:生成一个GUID字符串，用作表的唯一主键
	 * 
	 * @return 返回一个去掉-的GUID字符串
	 */
	public static String getNewGuid() {
		return UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
	}

	/**
	 * 
	 * @param strOrig
	 *            需要md5加密的字符串
	 * @param charSet
	 *            字符串编码格式
	 * @return 加密后的md5字符串
	 */
	public synchronized static final String getMD5Str(String strOrig,
			String charSet) { // md5加密
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			if (charSet == null) {
				messageDigest.update(strOrig.getBytes());
			} else {
				messageDigest.update(strOrig.getBytes(charSet));
			}
		} catch (NoSuchAlgorithmException e) {
			log.error("md5 error:" + e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			log.error("md5 error:" + e.getMessage(), e);
		}

		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}
	
	private static SimpleDateFormat sdf = null ;	
	public static String getIPTimeRand(String ip){
		StringBuffer buf = new StringBuffer() ;
		if(ip != null){			
			String s[] = ip.replaceAll(":", "").split("\\.") ;
			for(int i=0;i<s.length;i++){
				buf.append(addZero(s[i],3)) ;
			}
		}
		buf.append(getTimeyyyyMMddHHmmssSSS()) ;
		Random r = new Random() ;
		for(int i=0;i<3;i++){
			buf.append(r.nextInt(10)) ;
		}
		return buf.toString() ;
	}
	public  static String getDateTime(){
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS") ;
		return sdf.format(new Date()) ;
	}
	public static  String getTimeyyyyMMddHHmmssSSS(){
		sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS") ;
		return sdf.format(new Date()) ;
	}
	public static  String getTimeyyyyMMdd(){
		sdf = new SimpleDateFormat("yyyyMMdd") ;
		return sdf.format(new Date()) ;
	}
	public static  String getTimeHHmmss(){
		sdf = new SimpleDateFormat("HH:mm:ss") ;
		return sdf.format(new Date()) ;
	}
	private static  String addZero(String str,int len){
		StringBuffer s = new StringBuffer() ;
		s.append(str) ;
		while(s.length() < len){
			s.insert(0,"0") ;
		}
		return s.toString() ;
	}
	public static boolean isEmptyString(String chkString ){
		if(chkString==null || "".equals(chkString)){
			return Boolean.TRUE;
		}else
			return Boolean.FALSE;
		
	}

}
