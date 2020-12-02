package utils.implement;

import utils.WriteExcel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import bean.Advice;
import bean.Guke;
import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import utils.WriteExcel;

public class WriteExcelGuke implements WriteExcel{
	   public void writeExcel(String outputUrl,String sheetName,String[] titlesArray,List<Guke> list,int Max) throws IOException, RowsExceededException, WriteException {
	        if (outputUrl == null || outputUrl.length() == 0) {
	            System.out.println(
	                    "Param(s) Error:outputUrl is required and the length of outputUrl is required greater than 0.");
	            return;
	        }
//	        int n = arrayList.length;
//	        if (titlesArray.length != n) {
//	            System.out.println("Param(s) Error:the titles' length is hoped to be equal to arrayList's length.");
//	            return;
//	        }
	        //创建Excel文件
	        File file = new File(outputUrl);
	        file.createNewFile();
	        //创建工作簿
	        WritableWorkbook workbook = Workbook.createWorkbook(file);
	        //创建sheet，设置名称为sheetName，默认Sheet1
	        if (sheetName == null || sheetName.length() == 0) {
	            sheetName = "Sheet1";
	        }
	        WritableSheet sheet = workbook.createSheet(sheetName, 0);
	        //设置titles
	        String[] titles = titlesArray;
	        //设置表头：列名和各种格式
	        for (int i = 0; i < titles.length; i++) {
	            WritableFont font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
	            CellView cellView = new CellView();
	            cellView.setAutosize(true); //设置自动大小  
	            sheet.setColumnView(i, cellView); //根据内容自动设置列宽  
	            WritableCellFormat format = new WritableCellFormat(font);
	            format.setAlignment(Alignment.CENTRE); //居中对齐
	            format.setBackground(Colour.YELLOW); //背景色
	            format.setBorder(Border.ALL, BorderLineStyle.THICK, Colour.BLACK);//边框
	            Label label = new Label(i, 0, titles[i], format);
	            sheet.addCell(label);
	        }
	        boolean haveDefi = false;
	        boolean haveSymp = false;
	        boolean haverawSymp = false;
	        boolean writeDefi = false;
	        boolean writeSymp = false;
	        boolean writerawSymp = false;

	        int Numdise = 0;
	        int Numsymp = 0;
	        //写入数据，并设置一些格式
	        for(int i=1;i<Max+1;i++) {
		        String rel = "";

		        int NumsympMax = list.get(Numdise).getSymptom().size();
	        	if( list.get(Numdise).getDefi()!= null && writeDefi == false ){
	        		haveDefi = true;
	        	}
	        	if( list.get(Numdise).getRawSymp() != null && writerawSymp == false ){
	        		haverawSymp = true;
	        	}
	        	if( (list.get(Numdise).getSymptom().size() != 0 ) && writeSymp == false){
	        		haveSymp = true;
	        	}

                WritableFont font = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.NO_BOLD);
                WritableCellFormat format = new WritableCellFormat(font);
                
	        	for(int j=0; j<titles.length;j++) {
	                if( j==0 && ( haveDefi == true || haverawSymp == true || haveSymp == true )) {
		                Label label = new Label(j, i, list.get(Numdise).getDisease(), format);
		                sheet.addCell(label);
	                }
	                if( j==1 && haveDefi==true ) {
	                	rel = "defi_of_dise";
		                Label label = new Label(j, i, rel, format);
		                sheet.addCell(label);
	                }
	                if( j==1 && haverawSymp==true && haveDefi==false) {
	                	rel = "rawSymp_of_dise";
		                Label label = new Label(j, i, rel, format);
		                sheet.addCell(label);
	                }
	                if( j==1 && haveSymp==true && haveDefi==false && haverawSymp==false ) {
	                	rel = "symp_of_dise";
		                Label label = new Label(j, i, rel, format);
		                sheet.addCell(label);
	                }
	                if( j==2 && rel=="defi_of_dise") {
		                Label label = new Label(j, i, list.get(Numdise).getDefi(), format);
		                sheet.addCell(label);
		                writeDefi = true;
		                haveDefi = false;
	                }
	                if( j==2 && rel=="rawSymp_of_dise") {
		                Label label = new Label(j, i, list.get(Numdise).getRawSymp(), format);
		                sheet.addCell(label);
		                writerawSymp = true;
		                haverawSymp = false;
	                }
	                if( j==2 && rel=="symp_of_dise") {
		                Label label = new Label(j, i, (String) list.get(Numdise).getSymptom().get(Numsymp), format);
		                sheet.addCell(label);
		                Numsymp++;
			        	if( Numsymp == NumsympMax ) {
			        		Numsymp = 0;
			                haveSymp = false;
			        	}
	                }
		        	if( haveDefi==false && haverawSymp==false && haveSymp == false ) {
		        		Numdise ++;
		                writeDefi = false;
		                writerawSymp = false;
		        		writeSymp = false;
		        	}
	        	}

	        }
	        
	        
	        
//	        for (int i = 0; i < n; i++) {
//	            for (int j = 0; j < arrayList[i].size(); j++) {
//	                //WritableFont.createFont("宋体")：设置字体为宋体
//	                //10：设置字体大小
//	                //WritableFont.BOLD:设置字体加粗（BOLD：加粗 NO_BOLD：不加粗）
//	                //false：设置非斜体
//	                //UnderlineStyle.NO_UNDERLINE：没有下划线
//	                WritableFont font = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.NO_BOLD);
//	                WritableCellFormat format = new WritableCellFormat(font);
//	                Label label = new Label(i, j + 1, arrayList[i].get(j), format);
//	                sheet.addCell(label);
//	            }
//	        }
	        
	        
	        workbook.write();
	        workbook.close();
	    }
}
