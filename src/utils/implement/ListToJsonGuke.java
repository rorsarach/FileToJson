package utils.implement;

import java.util.ArrayList;
import java.util.List;

import bean.Guke;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ListToJsonGuke {
	public JSONArray getJson(List<Guke> list){
        JSONArray json = JSONArray.fromObject(list);  
        JSONArray jsonArray = new JSONArray();
        for(Guke guke : list){
        	JSONObject jsonObject = new JSONObject();
        	
        	jsonObject.put("disease",guke.getDisease());
        	jsonObject.put("rawSymp",guke.getRawSymp());
        	jsonObject.put("symptom",guke.getSymptom());
        	jsonObject.put("rawDiffDiag",guke.getRawDiffDiag());
        	jsonObject.put("rawChek",guke.getRawChek());
        	jsonObject.put("diffDiag",guke.getDiffDiag());     	
        	jsonObject.put("chek",guke.getChek());
        	jsonObject.put("indi",guke.getIndi());
        	jsonObject.put("body",guke.getBody());
        	jsonObject.put("sex",guke.getSex());
        	jsonObject.put("defi",guke.getDefi());
        	jsonObject.put("etio",guke.getEtio());
        	jsonObject.put("diag",guke.getDiag());
        	jsonObject.put("emerCure",guke.getEmerCure());
        	jsonObject.put("postCure",guke.getPostCure());
        	jsonObject.put("prog",guke.getProg());
        	jsonObject.put("prev",guke.getPrev());
        	jsonObject.put("engl",guke.getEngl());
        	jsonObject.put("hist",guke.getHist());

        	jsonArray.add(jsonObject);
        }
        return jsonArray;
	}
}
