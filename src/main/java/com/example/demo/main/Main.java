package com.example.demo.main;

import com.example.demo.entity.FileData;
import com.example.demo.service.FileService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String args[]) throws SQLException, IOException {
        String url = "jdbc:oracle:thin:@192.168.1.49:1521:fin";
        String user = "FG_DEMO_IR";
        String password = "FG_DEMO_IR";
        String destination="D:\\Hari\\demo_projects\\destination\\testFile.xlsx";
        String destination2="D:\\Hari\\demo_projects\\destination\\testFile2.xlsx";
        String csvFilePath="D:\\Hari\\demo_projects\\destination\\testcsv.csv";
        
        
        FileService fileService = new FileService();
        List<FileData> fileDataList = fileService.getFileData(url, user, password);
        
        fileService.writeDataToXlsx(fileDataList,destination);
        
        fileService.getFileDataList(url,user,password,destination2);
        
        byte[] byteData=fileService.readFile(destination);
        System.out.println(byteData.toString());
        
        fileService.writeDataToCsv(byteData,csvFilePath);
        
        for (FileData fileData : fileDataList) {
            System.out.println(fileData.toString());
        }
    }
}
