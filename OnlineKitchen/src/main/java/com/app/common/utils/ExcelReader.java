package com.app.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {

	public static List<MetaDataContent> getMetaData(String files) {
		ExcelReader reader = new ExcelReader();
		List<MetaDataContent> list = new ArrayList<MetaDataContent>();
		try	{
			FileInputStream file = new FileInputStream(new File("D:\\POONAM ZONE\\temp.xlsx"));
			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			MetaDataContent content=null;
			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int i=0;
			while (rowIterator.hasNext()) {
				if(i>=1) {
				content = new MetaDataContent();
				}
				Row row = rowIterator.next();
				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				int a=1;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if(i>=1) {
						reader.addObject(content,cell,a);
						a++;
					}
				}
				if(i>=1) {
					list.add(content);
				}
				i++;
			}
			file.close();
			System.out.println("=======> "+ list.size());
			for(MetaDataContent obj : list) {
				System.out.println("ID: " + obj.getUniqueId() +" | ENG: "+ obj.getEnglish_content() );
			}
			}
			catch (Exception e) {
			e.printStackTrace();
			} 
		return list;
		}
			
	public  MetaDataContent addObject(MetaDataContent content,Cell cell, int index)
	{
		if(index==1)
		{
			Double l= cell.getNumericCellValue();
			
			content.setUniqueId(Math.round(cell.getNumericCellValue()));
		}else if(index==2)
		{
			
			content.setEnglish_content(cell.getStringCellValue());
		}else if (index==3)
		{
			content.setHindi_content(cell.getStringCellValue());
		}
		
		return content;
		
	}
		
	
	
}
