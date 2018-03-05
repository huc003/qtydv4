package com.qtyd.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年3月5日 下午1:29:52
* 类说明
*/
public class ExportExcelUtils {
	
	/**
	 * 创建表格第一行
	 * @param strTitle
	 * @param sheet
	 */
	public static void createSheetTitle(String strTitle,HSSFSheet sheet){
		HSSFRow row = sheet.createRow(0);//创建表格的第一行
		sheet.setDefaultColumnWidth(4);
		HSSFCell cell = null;
		String[] strArray = strTitle.split(",");
		for (int i = 0; i < strArray.length; i++) {
			cell = row.createCell(i);//创建该行的第一列
			cell.setCellType(CellType.STRING);//CELL_TYPE_STRING
			cell.setCellValue(new HSSFRichTextString(strArray[i]));
			
//			sheet.autoSizeColumn(i);
//          sheet.autoSizeColumn(i, true);
			sheet.setColumnWidth(i, strArray[i].getBytes().length*2*256);
		}   
	}
	
	/**
	 * 下载excel
	 * @param response
	 * @param list
	 * @param sheetName
	 * @param title
	 */
	public static void download(HttpServletResponse response,List<Object> list,String sheetName,String title){
		//创建一个excel表格
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一个表格Sheet
		HSSFSheet sheet = wb.createSheet(sheetName);
		//创建Sheet的第一行
		createSheetTitle(title,sheet);
		//设置sheet的主题内容
		createSheetBody(list,sheet);
        OutputStream out = null;    
        try {        
            out = response.getOutputStream();    
            String fileName = sheetName+".xls";// 文件名    
            response.setContentType("application/x-msdownload");    
            response.setHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode(fileName, "UTF-8"));    
            wb.write(out);    
        } catch (Exception e) {    
            e.printStackTrace();    
        } finally {      
            try {       
                out.close();      
            } catch (IOException e) {      
                e.printStackTrace();    
            }      
        }     
	}

	/**
	 * 创建表格内容
	 * @param list
	 * @param sheet
	 */
	private static void createSheetBody(List<Object> list, HSSFSheet sheet) {
		HSSFRow row = null;
        for (int i = 0; i < list.size(); i++)    
        {    
            row = sheet.createRow((int) i + 1);    
            Object stu = (Object) list.get(i);    
            try {
				Map<String, Object> map = ConversionUtils.objectToMap(stu);
				int n = 0;
				for(Entry<String, Object> entry : map.entrySet()){  
				    if(entry!=null&&entry.getValue()!=null){
				    	row.createCell(n).setCellValue(entry.getValue().toString());
				    	n++;
				    }
				} 
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
//          cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu.getBirth()));    
        }    
	}
	
}
