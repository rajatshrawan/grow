package utilitypackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {
	public static File src;
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileOutputStream fos;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static String readData(String xlfile,String xlsheet,int row, int column) throws IOException {
	src=new File(xlfile);
	 fis=new FileInputStream(src);
	 wb=new XSSFWorkbook(fis);
	sh=wb.getSheet(xlsheet);
	DataFormatter df=new DataFormatter();
	String data=df.formatCellValue(sh.getRow(row).getCell(column));
	wb.close();
	fis.close();
	return data;
	
	}

	public static String writeData(String xlfile,String xlsheet,int row, int column,String data) throws IOException {
	src=new File(xlfile);
	 fis=new FileInputStream(src);
	 wb=new XSSFWorkbook(fis);
	sh=wb.getSheet(xlsheet);
	fos=new FileOutputStream(src);
	sh.createRow(row).createCell(column).setCellValue(data);
	wb.write(fos);
	wb.close();
	fis.close();
	fos.close();
	return data;
	
	}
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException 
	{
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlsheet);
		int rowcount=sh.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;		
	}
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlsheet);
		row=sh.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fis.close();
		return cellcount;
	}
}
