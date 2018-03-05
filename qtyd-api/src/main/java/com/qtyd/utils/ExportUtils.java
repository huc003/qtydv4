package com.qtyd.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import com.qtyd.model.User;

/**
* @author huc E-mail:459382234@qq.com
* @version 创建时间：2018年3月1日 下午3:30:13
* 类说明
*/
public class ExportUtils {
	
	/***
	 * 创建sheet的第一行
	 * @param sheet
	 * @param strTitle
	 */
	private void createSheetTitle(HSSFSheet sheet,String strTitle){
		HSSFRow row = sheet.createRow(0);//创建表格的第一行
		sheet.setDefaultColumnWidth(4);
		HSSFCell cell = null;
		String[] strArray = strTitle.split(",");
		for (int i = 0; i < strArray.length; i++) {
			cell = row.createCell(i);//创建该行的第一列
			cell.setCellType(CellType.STRING);//CELL_TYPE_STRING
			cell.setCellValue(new HSSFRichTextString(strArray[i]));
		}
	}
	
	/**
	 * 创建一个excel
	 * @param userList
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	public void createExcelStream(HttpServletResponse response,List<User> userList,String sheetName,String title) throws IOException{
		//创建一个excel表格
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建一个表格Sheet
		HSSFSheet sheet = wb.createSheet(sheetName);
		//创建Sheet的第一行
		this.createSheetTitle(sheet, title);
		//设置sheet的主题内容
		this.createSheetBody(userList,sheet);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		wb.write(outputStream);
		byte[] ba = outputStream.toByteArray();
		InputStream is = new ByteArrayInputStream(ba);
		// 设置导出的编码格式，此处统一为UTF-8
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        // 设置导出文件的名称
        String filename = sheetName+".xls";
        response.setHeader("Content-Disposition","attachment;filename=" + new String(filename.getBytes("gb2312"), "ISO8859-1" ));
		ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            bos.flush();
        } catch (final IOException e) {
            System.out.println("数据导出列表导出异常！");
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
	}

	
	private void createSheetBody(List<User> userList, HSSFSheet sheet) {
		if (userList==null||userList.size()<1) {
			return;
		}
		//sheet第二行开始
		int rowNum = 1;
		HSSFCell cell = null;
		HSSFRow row = null;
		for (Iterator<User> iterator = userList.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			if(user==null){
				user = new User();
			}
			
			
			
			row = sheet.createRow(rowNum);
			int i = 0;
			cell = row.createCell(i++);
			cell.setCellType(CellType.STRING);
			cell.setCellValue(new HSSFRichTextString(rowNum + ""));
			
			cell = row.createCell(i++);
			cell.setCellType(CellType.STRING);
			cell.setCellValue(new HSSFRichTextString(user.getUsername()));
			
			cell = row.createCell(i++);
			cell.setCellType(CellType.STRING);
			cell.setCellValue(new HSSFRichTextString(user.getRealname()));
			
			cell = row.createCell(i++);
			cell.setCellType(CellType.STRING);
			cell.setCellValue(new HSSFRichTextString(user.getNickName()));
			
			cell = row.createCell(i++);
			cell.setCellType(CellType.STRING);
			cell.setCellValue(new HSSFRichTextString(user.getSex().toString()));
			
			cell = row.createCell(i++);
			cell.setCellType(CellType.STRING);
			cell.setCellValue(new HSSFRichTextString(user.getEmail()));
		}
		
	}
	
}
