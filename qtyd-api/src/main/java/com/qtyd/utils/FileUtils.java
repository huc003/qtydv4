package com.qtyd.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public class FileUtils {
	
	private static final int BUFFERSIZE = 8196;
	private static final String CHARSETNAME = "UTF-8";
	
	public static String writeFile(String fileName, InputStream inputStream){

		if (inputStream == null) {
			return null;
		}

		File file = new File(fileName);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}

		OutputStream outputStream = null;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		MessageDigest md = null;
		try {
			byte[] buffer = new byte[BUFFERSIZE];
			int count = 0;
			outputStream = new FileOutputStream(file);

			bufferedInputStream = new BufferedInputStream(inputStream, BUFFERSIZE);
			bufferedOutputStream = new BufferedOutputStream(outputStream, BUFFERSIZE);
			md = MessageDigest.getInstance("MD5");

			while ((count = bufferedInputStream.read(buffer)) != -1) { // >0
				bufferedOutputStream.write(buffer, 0, count);
				md.update(buffer, 0, count);
			}

			buffer = null;
			bufferedOutputStream.flush();
			return StringUtils.byte2hex(md.digest());
		} catch (Exception e) {
			return null;
		} finally {
			closeStream(bufferedOutputStream);
			closeStream(outputStream);
			closeStream(bufferedInputStream);
			closeStream(inputStream);
		}
	}
	
	public static String readFile(InputStream is,Charset cs) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(is,cs));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while ((line = in.readLine()) != null) {
			buffer.append(line);
		}
		return buffer.toString();
	}
	
	public static void closeStream(OutputStream bufferedOutputStream) {

		if(bufferedOutputStream != null) {
			try {
				bufferedOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			bufferedOutputStream = null;
		}
	}
	
	public static void closeStream(InputStream bufferedOutputStream) {

		if(bufferedOutputStream != null) {
			try {
				bufferedOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			bufferedOutputStream = null;
		}
	}
	
	public static String generateContent(InputStream inputStream) {

		if (inputStream == null) {
			return null;
		}

		BufferedInputStream bufferedInputStream = null;

		StringBuffer content = new StringBuffer();

		try {
			byte[] buffer = new byte[BUFFERSIZE];
			int count = 0;

			bufferedInputStream = new BufferedInputStream(inputStream, BUFFERSIZE);

			while ((count = bufferedInputStream.read(buffer)) != -1) { // >0
				content.append(new String(buffer, 0, count, CHARSETNAME));
			}

			buffer = null;

			return content.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeStream(bufferedInputStream);
			closeStream(inputStream);
		}
	}
	
	public static long getFileLength(String filename) {

		File file = new File(filename);
		if (file.isFile() && file.exists()) {
			return file.length();
		}

		return 0L;
	}
	

	public static void deleteFile(String filePath){
		File file = new File(filePath);		
		if(file.exists()){
			file.delete();
		}
	}

	public static String readFileToString(String file) throws IOException {
		return readFileToString(file,Charset.forName(CHARSETNAME));
	}
	
    public static String readFileToString(String file, Charset cs) throws IOException {
    	InputStream in = new FileInputStream(file);
    	return readFile(in,cs);
    }
    
    public static void writeStringToFile(String str,String file){
    	ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes());
    	writeFile(file,stream);    	
    }
}
