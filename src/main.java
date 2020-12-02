import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bean.Advice;
import bean.Guke;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import net.sf.json.JSONArray;
import utils.WriteExcel;
import utils.WriteFile;
import utils.implement.GetListAdvice;
import utils.implement.GetListGuke;
import utils.implement.GetListNumGuke;
import utils.implement.ListToJsonAdvice;
import utils.implement.ListToJsonGuke;
import utils.implement.WriteExcelAdvice;
import utils.implement.WriteExcelGuke;

public class main {

	public static void main(String[] args) throws IOException, RowsExceededException, WriteException {
		// TODO Auto-generated method stub
//		String filename = "F:\\Others\\tishi.xlsx";
//		List<Advice> list = new ArrayList<Advice>();
//		GetListAdvice getlistAdvice = new GetListAdvice();
//		list = getlistAdvice.getList(filename);
//        JSONArray jsonArray = new JSONArray();
//        ListToJsonAdvice listToJsonAdvice = new ListToJsonAdvice();
//		jsonArray = listToJsonAdvice.getJson(list);
////        System.out.println(jsonArray.toString());
//		WriteFile writefile = new WriteFile();
//		writefile.writefile(jsonArray.toString(), "F:\\Others\\advice.txt");
		
//		ArrayList<String> list = new ArrayList<String>();
//	    list.add("A");
//        String[] titles = {"书名"};
//        WriteExcel write = new WriteExcel();
//        write.writeExcel("F:\\Others\\test01.xls", "匹配", titles, list);
		
		String filename = "F:\\Others\\2hang.xlsx";
		List<Guke> list = new ArrayList<Guke>();
		GetListGuke getlistGuke = new GetListGuke();
		list = getlistGuke.getList(filename);
		int num = new GetListNumGuke().getListNum(list);
		System.out.println(num);
		String[] titles = {"疾病","关系","属性"};
		WriteExcelGuke writeGuke = new WriteExcelGuke();
		writeGuke.writeExcel("F:\\Others\\test02.xls", "匹配", titles, list,num);
		
//		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i).toString());
//		}
//		JSONArray jsonArray = new JSONArray();
//		ListToJsonGuke listtojson = new ListToJsonGuke();
//		jsonArray = listtojson.getJson(list);
//		WriteFile writefile = new WriteFile();
//		writefile.writefile(list.toString(), "F:\\Others\\guke01.txt");
//		writefile.writefile(jsonArray.toString(), "F:\\Others\\guke.txt");
//		WriteExcelAdvice writeAdvice = new WriteExcelAdvice();
//        String[] title = {"疾病","信息","建议"};
//        String filename = "F:\\Others\\test01.xls";
//		String filename1 = "F:\\Others\\tishi.xlsx";
//		List<Advice> list = new ArrayList<Advice>();
//		GetListAdvice getlistAdvice = new GetListAdvice();
//		list = getlistAdvice.getList(filename1);
//		writeAdvice.writeByRow(filename, title, list);
	}

}
