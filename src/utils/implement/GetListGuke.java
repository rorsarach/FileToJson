package utils.implement;

import java.io.IOException;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import bean.Advice;
import bean.Examination;
import bean.Guke;
import utils.GetList;

public class GetListGuke implements GetList{

	@Override
	public List getList(String filename) throws IOException {
		// TODO Auto-generated method stub

        File excel = new File(filename);
        String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！
		List<Guke> list = new ArrayList<Guke>();

        Workbook wb;
        //根据文件后缀（xls/xlsx）进行判断
        if ( "xls".equals(split[1]) || "csv".equals(split[1])){
            FileInputStream fiStream = new FileInputStream(excel);   //文件流对象
            wb = new HSSFWorkbook(fiStream);
        }else{
            wb = new XSSFWorkbook(new FileInputStream(excel));
        }

        //开始解析
        Sheet sheet = wb.getSheetAt(0);     //读取sheet 0

        int firstRowIndex = sheet.getFirstRowNum()+1;   //第一行是列名，所以不读
        int lastRowIndex = sheet.getLastRowNum();
        
    	ArrayList diffDiag = new ArrayList();
    	ArrayList symp = new ArrayList();
    	ArrayList chek = new ArrayList();
    	ArrayList indi = new ArrayList();
    	ArrayList body = new ArrayList();	
    	String disease = null;
    	String property = null;
    	String relationship = null;
    	    	
    	String[] thesplit = null;
    	boolean isSame = false;
    	boolean isEmpty = false;
    	Guke guke = new Guke();


        for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行

        	String more = null;
        	
            Row row = sheet.getRow(rIndex);
            if (row != null) {
//            	Model model = new Model();
            	Advice bean = new Advice();
                int firstCellIndex = row.getFirstCellNum();
                int lastCellIndex = row.getLastCellNum();
                
                if(rIndex == 1) {
                    for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列   
                    	Cell cell = row.getCell(cIndex);
                    	switch(cIndex){
                        case 1 :
                        	disease = cell.toString();
                        	break; 
                        case 3 :
                        	relationship = cell.toString();
//                        	System.out.print(rIndex+" "+relationship+" ");
                        	break;
                        case 4 :
                        	more = cell.toString();
//                        	System.out.println(more);
                        	break;
                    	}
                    	
                    }
                }
                else {
	                for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列   
	                	Cell cell = row.getCell(cIndex);
	                	if(cIndex==0 && !cell.toString().equals("")) {		//第一列不为空
	                		isEmpty = false;
	                	}
	                	if(cIndex==1 && cell.toString().equals(disease) && !cell.toString().equals("")) {
	                		isSame = true;
	                	}if(cIndex==1 && !(cell.toString().equals(disease))) {
	                		isSame = false;
	                		guke.setDisease(disease);
	                		guke.setSymptom(symp);
	                		guke.setChek(chek);
	                		guke.setIndi(indi);
	                		guke.setDiffDiag(diffDiag);
	                		guke.setBody(body);
	                		list.add(guke);
	                		guke = new Guke();
	                    	diffDiag = new ArrayList();
	                    	symp = new ArrayList();
	                    	chek = new ArrayList();
	                    	indi = new ArrayList();
	                    	body = new ArrayList();	
	                		disease = cell.toString();
	                	}
	                	if(cIndex==2) {
	                		property = cell.toString();
	                	}
	                	if(cIndex==3) {
	                		relationship = cell.toString();
//                        	System.out.print(rIndex+" "+relationship+" ");

	                	}
	                	if(cIndex==4) {
	                		more = cell.toString();
//                        	System.out.println(more);

	                	}
	                }
                }
                if(isEmpty == false) {
                    switch(relationship){
                	case "rawSymp_of_dise" :
                		guke.setRawSymp(more);
                		break;
                	case "symp_of_dise" :
            			thesplit = more.split(" "); 
            			for(String str:thesplit) {
            				symp.add(str);
            			}
            			break;
                	case "rawDiffDiag_of_dise" :
                		guke.setRawDiffDiag(more);
                		break;
                	case "diffDiag_of_dise" :
                		diffDiag.add(more);
                		break;
                	case "rawChek_of_dise" :
                		guke.setRawChek(more);
                		break;
                	case "chek_of_dise" :
            			thesplit = more.split(" "); 
            			for(String str:thesplit) {
            				chek.add(str);
            			}
            			break;
                	case "indi_of_dise" :
            			thesplit = more.split("['、','，',' ']"); 
            			for(String str:thesplit) {
            				indi.add(str);
            			}
            			break;
                	case "body_of_dise" :
            			thesplit = more.split(" "); 
            			for(String str:thesplit) {
            				body.add(str);
            			}
            			break;
                	case "sex_of_dise" :
                		guke.setSex(more);;
                		break;
                	case "defi_of_dise" : 
                		guke.setDefi(more);
                		break;
                	case "etio_of_dise" :
                		guke.setEtio(more);
                		break;
                	case "hist_of_dise" :
                		guke.setHist(more);
                		break;
                	case "diag_of_dise" :
                		guke.setDiag(more);
                		break;
                	case "emerCure_of_dise" :
                		guke.setEmerCure(more);
                		break;
                	case "postCure_of_dise" :
                		guke.setPostCure(more);
                		break;
                	case "prog_of_dise" :
                		guke.setProg(more);
                		break;
                	case "prev_of_dise" :
                		guke.setPrev(more);
                		break;
                	case "engl_of_dise" :
                		guke.setEngl(more);
                		break;  
                	default :
                		break;
                    }
                }
 
            }
        }
	return list;
	}
}
