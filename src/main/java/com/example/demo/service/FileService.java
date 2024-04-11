package com.example.demo.service;

import com.example.demo.entity.FileData;
import com.microsoft.schemas.office.visio.x2012.main.CellType;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;



import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileService {
	
	
	List<String> filedataHeader = new ArrayList<>();

    public List<FileData> getFileData(String url, String user, String password) {
       

        List<FileData> fileDataList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "select * from FG_FINTECH_UPLOAD";
            try (Statement st = connection.createStatement();
                 ResultSet rs = st.executeQuery(query)) {

                ResultSetMetaData rsMetaData = rs.getMetaData();
                int count = rsMetaData.getColumnCount();

                for (int i = 1; i <= count; i++) {
                    filedataHeader.add(rsMetaData.getColumnName(i));
                }

                while (rs.next()) {
                	FileData fileData = new FileData();
                    fileData.setId(rs.getString(filedataHeader.get(0)));
                    fileData.setReferanceId(rs.getString(filedataHeader.get(1)));
                    fileData.setTypeCode(rs.getString(filedataHeader.get(2)));
                    fileData.setSubTypeCode(rs.getString(filedataHeader.get(3)));
                    fileData.setActiveCode(rs.getString(filedataHeader.get(4)));
                    fileData.setStageCode(rs.getString(filedataHeader.get(5)));
                    fileData.setStatusCode(rs.getString(filedataHeader.get(6)));
                    fileData.setProcessId(rs.getString(filedataHeader.get(7)));
                    fileData.setCreatedOn(rs.getString(filedataHeader.get(8)));
                    fileData.setCreatedBy(rs.getInt(filedataHeader.get(9)));
                    fileData.setLastUpdatedOn(rs.getString(filedataHeader.get(10)));
                    fileData.setLastUpdatedBy(rs.getInt(filedataHeader.get(11)));
                    fileData.setLastAuthorisedOn(rs.getString(filedataHeader.get(12)));
                    fileData.setLastAuthorisedBy(rs.getInt(filedataHeader.get(13)));
                    fileData.setTemplate(rs.getClob(filedataHeader.get(14)));
                    fileData.setApplicationPartyCode(rs.getString(filedataHeader.get(15)));
                    fileData.setIssuingPartyCode(rs.getString(filedataHeader.get(16)));
                    fileData.setIsTemplate(rs.getInt(filedataHeader.get(17)));
                    fileData.setChannels(rs.getString(filedataHeader.get(18)));
                    fileData.setTransferStatus(rs.getString(filedataHeader.get(19)));
                    fileData.setLayoutTemplateId(rs.getInt(filedataHeader.get(20)));
                    fileData.setLayoutName(rs.getString(filedataHeader.get(21)));
                    fileData.setFileContent(rs.getBytes(filedataHeader.get(22)));
                    fileData.setUploadRefId(rs.getString(filedataHeader.get(23)));
                    fileData.setFileName(rs.getString(filedataHeader.get(24)));

                    fileDataList.add(fileData);
                    
                }
            }
        } catch (Exception e) {
          System.out.println(e);
        }
        return fileDataList;
    }

	public void writeDataToXlsx(List<FileData> fileDataList,String destination) {
		
		XSSFWorkbook workbook =new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("testSheet");
		
		XSSFRow rowHeader=sheet.createRow(0);
		for(int i =0;i<filedataHeader.size();i++) {
			Cell cell=rowHeader.createCell(i);
			cell.setCellValue(filedataHeader.get(i));
		}
		
		int rowNumber=1;
		for(FileData fileData:fileDataList) {
			XSSFRow row=sheet.createRow(rowNumber++);
			row.createCell(0).setCellValue(fileData.getId());
			row.createCell(1).setCellValue(fileData.getReferanceId());
			row.createCell(2).setCellValue(fileData.getTypeCode());
			row.createCell(3).setCellValue(fileData.getSubTypeCode());
			row.createCell(4).setCellValue(fileData.getActiveCode());
			row.createCell(5).setCellValue(fileData.getStageCode());
			row.createCell(6).setCellValue(fileData.getStatusCode());
			row.createCell(7).setCellValue(fileData.getProcessId());
			row.createCell(8).setCellValue(fileData.getCreatedOn());
			row.createCell(9).setCellValue(fileData.getCreatedBy());
			row.createCell(10).setCellValue(fileData.getLastUpdatedOn());
			row.createCell(11).setCellValue(fileData.getLastUpdatedBy());
			row.createCell(12).setCellValue(fileData.getLastAuthorisedOn());
			row.createCell(13).setCellValue(fileData.getLastAuthorisedBy());
			row.createCell(15).setCellValue(fileData.getApplicationPartyCode());
			row.createCell(16).setCellValue(fileData.getIssuingPartyCode());
			row.createCell(17).setCellValue(fileData.getIsTemplate());
			row.createCell(18).setCellValue(fileData.getChannels());
			row.createCell(19).setCellValue(fileData.getTransferStatus());
			row.createCell(20).setCellValue(fileData.getLayoutTemplateId());
			row.createCell(21).setCellValue(fileData.getLayoutName());
			row.createCell(23).setCellValue(fileData.getUploadRefId());
			row.createCell(24).setCellValue(fileData.getFileName());
			
		}
		
		
		try(FileOutputStream outPutFile=new FileOutputStream(destination);){
			workbook.write(outPutFile);
			System.out.println("File writen sucessfully");
		}
		catch(Exception e){
			System.out.print(e);
		}
		
	}

	public List<Map<String, Object>> getFileDataList(String url, String user, String password,String destination2) throws SQLException {
		
		
		List<Map<String, Object>> fileDataListMap = new ArrayList<>();
		XSSFWorkbook workbook =new XSSFWorkbook();
		XSSFSheet sheet2=workbook.createSheet("testSheet2");
		
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
        	 
            String query = "select * from FG_FINTECH_UPLOAD";
            try (Statement st = connection.createStatement();
                 ResultSet rs = st.executeQuery(query)) {
            	

                ResultSetMetaData rsMetaData = rs.getMetaData();
                int count = rsMetaData.getColumnCount();
               
              
            	   while(rs.next()) {
            		   Map<String,Object> mapValue=new HashMap<>();
            		   for(int i=1;i<=count;i++) {
            			   String columnName=rsMetaData.getColumnName(i);
            			   Object value=rs.getObject(i);
            			   mapValue.put(columnName, value);
            		   }
            		   fileDataListMap.add(mapValue);
            	   }
                System.out.println(fileDataListMap);
                System.out.println("got the listOfHashmap");
            }
       }
        
        XSSFRow rowHeader=sheet2.createRow(0);
		for(int i =0;i<filedataHeader.size();i++) {
			Cell cell=rowHeader.createCell(i);
			cell.setCellValue(filedataHeader.get(i));
		}
       int rowNumber=1;
       for(Map<String,Object> map:fileDataListMap) {
        	XSSFRow row=sheet2.createRow(rowNumber++);
        	int cellNumber=0;
        	for(Object value:map.values()) {
        		Cell cell=row.createCell(cellNumber++);
        		if(value instanceof String) {
        		cell.setCellValue((String)value);
        		}else if (value instanceof Integer) {
                    cell.setCellValue((Integer) value);
                } else if (value instanceof Long) {
                    cell.setCellValue((Double) value);
                } else if(value instanceof LocalDateTime) {
                	cell.setCellValue((String) value);
                }
        	}
        	
       }
       try(FileOutputStream outPutFile=new FileOutputStream(destination2);){
			workbook.write(outPutFile);
			System.out.println("TestFile2 writen sucessfully");
		}
		catch(Exception e){
			System.out.print(e);
		}
		return fileDataListMap;
		
		
	}
	//read as byte
	public byte[] readFile(String destination) {
		
		byte[] fileBytes = null ;
			try {
				fileBytes= Files.readAllBytes(Paths.get(destination));
	        } catch (Exception e) {
	            e.printStackTrace();}
			return fileBytes;
	}
	
	
	//write  csvfile 
	public void writeDataToCsv(byte[] byteData, String csvFilePath) throws IOException {
		
		ByteArrayInputStream inputStream=new ByteArrayInputStream(byteData);
		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=workbook.getSheetAt(0);
		StringBuilder csvData=new StringBuilder();
		
		
		 for(Row row:sheet) {
			 for(Cell cell:row) {
				 switch(cell.getCellType()) {
				 case STRING:
                     csvData.append(cell.getStringCellValue()).append(",");
                     break;
				 case NUMERIC:
                     csvData.append(cell.getNumericCellValue()).append(",");
                     break;
                  default:
                	  csvData.append(cell).append(","); 
                	  }	
				 }
			 csvData.append("\n");
		 }
		 
		 try (FileWriter writer = new FileWriter(csvFilePath)) {
             writer.write(csvData.toString());
         }catch(Exception e) {
        	 System.out.print(e);
         }
		 System.out.println("file writen in csv file");
		
	}
	
	
}
