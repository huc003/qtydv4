package com.qtyd.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年2月28日 下午3:28:39
* 读取文件类
*/
public class ReadFromFileUtils {
	
	 /**
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     */
    public static void readFileByBytes(String fileName) {
        File file = new File(fileName);
        InputStream in = null;
        try {
            // 一次读一个字节
            in = new FileInputStream(file);
            int tempbyte;
            while ((tempbyte = in.read()) != -1) {
                System.out.write(tempbyte);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
       /* try {
            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
            // 一次读多个字节
            byte[] tempbytes = new byte[100];
            int byteread = 0;
            in = new FileInputStream(fileName);
            ReadFromFileUtils.showAvailableBytes(in);
            // 读入多个字节到字节数组中，byteread为一次读入的字节数
            while ((byteread = in.read(tempbytes)) != -1) {
                System.out.write(tempbytes, 0, byteread);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }*/
    }

    /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     */
    public static void readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*try {
            // 一次读多个字符
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            // 读入多个字符到字符数组中，charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1) {
                // 同样屏蔽掉\r不显示
                if ((charread == tempchars.length)
                        && (tempchars[tempchars.length - 1] != '\r')) {
                    System.out.print(tempchars);
                } else {
                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == '\r') {
                            continue;
                        } else {
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }*/
    }
    
    /**
     * 读取文件返回重要部分数据
     * @param fileName
     * @return
     */
    public static Set<String> readTxt(String fileName,String path){
    	Set<String> set = new HashSet<String>();
    	try{
    	    String encoding = "GBK";
    	    File file = new File(fileName);
    	    String lineinfo="";
    	    if(file.isFile()&&file.exists()){
	    	     InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
	    	     BufferedReader bufferReader = new BufferedReader(read);
	    	     while((lineinfo=bufferReader.readLine())!=null){
	    	    	 String[] s = lineinfo.split(";");
	    	    	 if(s.length>1&&s[1].contains("Action")){
	    	    		 s = s[1].split("-->");
	    	    		 set.add(s[1].replaceAll("Action|V100", "").replace("V200", "_v2").replace("V300", "_v3"));
//		    	    	 set.add(s[1].replace("Action", "").replace("V100", "").replace("V200", "").replace("V300", ""));
	    	    	 }
	    	     }
	    	     read.close();
    	    }
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	try {
    		isCreateNewFile(path);
    		//如果存在文件
    		//则直接往文件中追加字符串
	        FileWriter writer=new FileWriter(path,true);
	        for (String str : set) {  
	            System.out.println(str);  
	            writer.write(str+"\r\n");
	        }
	        writer.close();
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    	return set;
    }
    
    public static void writeTxt(String path){
    	try {
    		FileWriter writer=new FileWriter(path,true);
    		writer.write("sdadad\r\n");
    		writer.close(); // 最后记得关闭文件  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
    
	public static void isCreateNewFile(String path){
		try {
			File writename = new File(path);
			if (writename.exists()) {//判断文件目录的存在
				System.out.println("文件夹存在！");
				if(writename.isDirectory()){//判断文件的存在性      
					System.out.println("文件存在！");      
				}else{
					writename.createNewFile();
				}
			}else {
				System.out.println("文件夹不存在！");
				File file2=new File(writename.getParent());
				file2.mkdirs();
				System.out.println("创建文件夹成功！");
				if(writename.isDirectory()){      
					System.out.println("文件存在！");       
				}else{      
					writename.createNewFile();//创建文件 
					System.out.println("文件不存在，创建文件成功！"   );      
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("文件不存在，创建文件成功！"   );      
	}
    

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 随机读取文件内容
     */
    public static void readFileByRandomAccess(String fileName) {
        RandomAccessFile randomFile = null;
        try {
            System.out.println("随机读取一段文件内容：");
            // 打开一个随机访问文件流，按只读方式
            randomFile = new RandomAccessFile(fileName, "r");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 读文件的起始位置
            int beginIndex = (fileLength > 4) ? 4 : 0;
            // 将读文件的开始位置移到beginIndex位置。
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            // 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
            // 将一次读取的字节数赋给byteread
            while ((byteread = randomFile.read(bytes)) != -1) {
                System.out.write(bytes, 0, byteread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomFile != null) {
                try {
                    randomFile.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 显示输入流中还剩的字节数
     */
    private static void showAvailableBytes(InputStream in) {
        try {
            System.out.println("当前字节输入流中的字节数为:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * A方法追加文件：使用RandomAccessFile
     */
    public static void appendMethodA(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * B方法追加文件：使用FileWriter
     */
    public static void appendMethodB(String fileName, String content) {
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String fileName = "C:/temp/newTemp.txt";
        ReadFromFileUtils.readFileByBytes(fileName);
        ReadFromFileUtils.readFileByChars(fileName);
        ReadFromFileUtils.readFileByLines(fileName);
        ReadFromFileUtils.readFileByRandomAccess(fileName);
        
//        String fileName = "C:/temp/newTemp.txt";
        String content = "new append!";
        //按方法A追加文件
        ReadFromFileUtils.appendMethodA(fileName, content);
        ReadFromFileUtils.appendMethodA(fileName, "append end. \n");
        //显示文件内容
        ReadFromFileUtils.readFileByLines(fileName);
        //按方法B追加文件
        ReadFromFileUtils.appendMethodB(fileName, content);
        ReadFromFileUtils.appendMethodB(fileName, "append end. \n");
        //显示文件内容
        ReadFromFileUtils.readFileByLines(fileName);
    }
}

