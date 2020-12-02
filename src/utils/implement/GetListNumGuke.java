package utils.implement;

import java.util.List;

import bean.Guke;
import utils.GetListNum;

public class GetListNumGuke implements GetListNum{
	public int getListNum(List<Guke> list) {
		int num = 0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getDefi()!=null) {
				num ++;
			}
			if(list.get(i).getRawSymp()!=null) {
				num ++;
			}
			if(list.get(i).getSymptom()!=null) {
				for(int j=0;j<list.get(i).getSymptom().size();j++) {
					if(list.get(i).getSymptom().get(j)!=null) {
						num++;
					}
				}
			}
		}
		return num;
	}
}
