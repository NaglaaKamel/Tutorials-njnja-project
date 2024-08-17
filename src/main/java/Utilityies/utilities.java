package Utilityies;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.oer.Switch;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class utilities {
    public static final  int Implicit_Wait_Time = 30;
    public static final int Page_Wait_Time   = 30;
    public static String generateEmailWithTimeStamp(){
        Date date = new Date();
        String timeStamp= date.toString().replace(" ","_").replace(":","_");
        return "naglaakamel"+timeStamp+"@gmail.com";
    }
    public static Object[][] getTestDatafromExcell(String sheetName){
        XSSFWorkbook workbook =null;
        File fis = new File(System.getProperty("user.dir")+"\\src\\main\\java\\excelldata\\data.xlsx");
       try {
           FileInputStream fisExcel = new FileInputStream(fis);
           workbook = new XSSFWorkbook(fisExcel);
       }catch(Throwable e){
           e.printStackTrace();
       }

        XSSFSheet sheet =workbook.getSheet(sheetName);
       int rows = sheet.getLastRowNum();
       int cols = sheet.getRow(0).getLastCellNum();
       Object [][] data = new Object [rows][cols];
       for(int i=0;i<rows;i++){

           XSSFRow row = sheet.getRow(i+1);
           for(int j=0;j<cols;j++){
               XSSFCell cell=row.getCell(j);
               CellType celltype = cell.getCellType();
               switch(celltype){
                   case STRING:
                       data[i][j]=cell.getStringCellValue();
                       break;
                   case NUMERIC:
                       data[i][j]=Integer.toString((int)cell.getNumericCellValue());
                       break;
                   case BOOLEAN:
                       data[i][j]=cell.getBooleanCellValue();
                       break;

               }
           }

       }
       return data;
    }
    public static String capturescreenshot(WebDriver driver,String testName){
        File SRCskreenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destinationscreenshotpath= System.getProperty("user.dir")+"\\Screenshotsfolder\\"+testName+".png";
        try {
            FileHandler.copy(SRCskreenshot,new File(destinationscreenshotpath));
        }catch(IOException e){
            e.printStackTrace();
        }
        return destinationscreenshotpath;

    }
}
