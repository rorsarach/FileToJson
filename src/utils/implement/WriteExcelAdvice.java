package utils.implement;

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
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import utils.WriteExcel;

public class WriteExcelAdvice implements WriteExcel{
	

	public void writeByRow(String filename, String[] title, List<Advice> list) {
        File file = new File(filename);
        if(file.exists()){
            //如果文件存在就删除
        	file.delete();
        }
        try {
        	file.createNewFile();
            //创建工作簿
            WritableWorkbook workbookA = Workbook.createWorkbook(file);            
            //创建sheet
            WritableSheet sheetA = workbookA.createSheet("sheet1", 0);
            Label labelA = null;            
            //设置列名
            for (int i = 0; i < title.length; i++) {
                labelA = new Label(i,0,title[i]);
                sheetA.addCell(labelA);    
            }            
            //获取数据源
            for (int i = 1; i < 10; i++) {
                labelA = new Label(0,i,list.get(i).getDisease());
                sheetA.addCell(labelA);
                labelA = new Label(1,i,list.get(i).getInformation());
                sheetA.addCell(labelA);
            	String str = "";
                for(int j=0;j<list.get(i).getAdvice().size();j++) {
                	str += list.get(i).getAdvice().get(j).toString();
                }
                labelA = new Label(2,i,str);
                sheetA.addCell(labelA);
            }
            workbookA.write();    //写入数据        
            workbookA.close();  //关闭连接
            System.out.println("成功写入文件");

        } catch (Exception e) {
        	System.out.println("文件写入失败"+e);
        }

	}
}
