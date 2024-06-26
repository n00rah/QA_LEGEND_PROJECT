package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtility 
{
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;
	public static String getStringData(int rownumber,int columnnumber, String sheetname) 
	{
		try
		{
		f= new FileInputStream("C:\\Users\\NOORA\\git\\QA_LEGEND_PROJECT\\QA_LEGEND_PROJECT\\src\\main\\resources\\TestData.xlsx");
		w=new XSSFWorkbook(f);
		sh=w.getSheet(sheetname);
		Row row=sh.getRow(rownumber);
		Cell cell=row.getCell(columnnumber);
		return cell.getStringCellValue();
		}
		catch(Exception e)
		{
			throw new RuntimeException("Excel Sheet not found");
		}
	}
	public static String getIntegerData(int rownumber,int columnnumber,String sheetname)
	{
		try
		{
		f=new FileInputStream("C:\\Users\\NOORA\\git\\QA_LEGEND_PROJECT\\QA_LEGEND_PROJECT\\src\\main\\resources\\TestData.xlsx");
		w=new XSSFWorkbook(f);
		sh=w.getSheet(sheetname);
		Row row=sh.getRow(rownumber);
		Cell cell=row.getCell(columnnumber);
		int x=(int)cell.getNumericCellValue();
		return String.valueOf(x);
		}
		catch(Exception e)
		{
			throw new RuntimeException("Excel Sheet not found");
		}
	}
}
