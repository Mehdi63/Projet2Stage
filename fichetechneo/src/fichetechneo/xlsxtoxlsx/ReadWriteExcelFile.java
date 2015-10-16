package fichetechneo.xlsxtoxlsx;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadWriteExcelFile {
   
   private ReadWriteExcelFile() {
      }
   
   public static String[][] readXlsxFile(String xlsxfile) throws IOException{
      InputStream file = new FileInputStream(xlsxfile);
      @SuppressWarnings("resource")
      XSSFWorkbook workbook = new XSSFWorkbook(file);
      XSSFSheet sheet = workbook.getSheetAt(0);
      int numRows = sheet.getPhysicalNumberOfRows();
      @SuppressWarnings("rawtypes")
      Iterator singleRowIterator = sheet.iterator().next().iterator();
      int numCols = 0;
      while (singleRowIterator.hasNext()) {
         singleRowIterator.next();
         numCols++;
         }
      String[][] res = new String[numRows][numCols];
      Iterator<Row> rowIterator = sheet.iterator();
      int xssfRow = 0;
      while (rowIterator.hasNext()) {
         XSSFRow row = (XSSFRow) rowIterator.next();
         @SuppressWarnings("rawtypes")
         Iterator cells = row.iterator();
         int xssfCol = 0;
         DecimalFormat df = new DecimalFormat("#");
         df.setMaximumFractionDigits(0);
         while (cells.hasNext()) {
         XSSFCell cell = (XSSFCell) cells.next();
         if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
            res[xssfRow][xssfCol] = df.format(cell.getNumericCellValue());
            } else if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
            res[xssfRow][xssfCol] = cell.getStringCellValue();
            }
         xssfCol++;
         }
      xssfRow++;
      }
   file.close();
   return res;
   }
   
   public static void writeXlsxFile(String xlsxFile, String[][] cellule) throws IOException {
      String sheetName = "Sheet1";
      @SuppressWarnings("resource")
      XSSFWorkbook wb = new XSSFWorkbook();
      XSSFSheet sheet = wb.createSheet(sheetName) ;
      for (int r=0; r<cellule.length ; r++ ){
         XSSFRow row = sheet.createRow(r);
         for (int c=0; c<cellule[0].length; c++){
            XSSFCell cell = row.createCell(c);
            cell.setCellValue(cellule[r][c]);
         }
      }
      FileOutputStream fileOut = new FileOutputStream(xlsxFile);
      wb.write(fileOut);
      fileOut.flush();
      fileOut.close();
   }
}