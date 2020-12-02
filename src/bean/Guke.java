package bean;

import java.util.ArrayList;

public class Guke {
	String disease;
	String rawSymp;
	ArrayList symptom = new ArrayList();
	String rawDiffDiag;
	String rawChek;

	ArrayList diffDiag = new ArrayList();
	ArrayList chek = new ArrayList();
	ArrayList indi = new ArrayList();
	ArrayList body = new ArrayList();	
	String sex;
	String defi;
	String etio;
	String hist;
	String diag;
	String emerCure;
	String postCure;
	String prog;
	String prev;
	String engl;
	public String getRawChek() {
		return rawChek;
	}
	public void setRawChek(String rawChek) {
		this.rawChek = rawChek;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getRawSymp() {
		return rawSymp;
	}
	public void setRawSymp(String rawSymp) {
		this.rawSymp = rawSymp;
	}
	public ArrayList getSymptom() {
		return symptom;
	}
	public void setSymptom(ArrayList symptom) {
		this.symptom = symptom;
	}
	public String getRawDiffDiag() {
		return rawDiffDiag;
	}
	public void setRawDiffDiag(String rawDiffDiag) {
		this.rawDiffDiag = rawDiffDiag;
	}
	public ArrayList getDiffDiag() {
		return diffDiag;
	}
	public void setDiffDiag(ArrayList diffDiag) {
		this.diffDiag = diffDiag;
	}
	public ArrayList getChek() {
		return chek;
	}
	public void setChek(ArrayList chek) {
		this.chek = chek;
	}
	public ArrayList getIndi() {
		return indi;
	}
	public void setIndi(ArrayList indi) {
		this.indi = indi;
	}
	public ArrayList getBody() {
		return body;
	}
	public void setBody(ArrayList body) {
		this.body = body;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDefi() {
		return defi;
	}
	public void setDefi(String defi) {
		this.defi = defi;
	}
	public String getEtio() {
		return etio;
	}
	public void setEtio(String etio) {
		this.etio = etio;
	}
	public String getHist() {
		return hist;
	}
	public void setHist(String hist) {
		this.hist = hist;
	}
	public String getDiag() {
		return diag;
	}
	public void setDiag(String diag) {
		this.diag = diag;
	}
	public String getEmerCure() {
		return emerCure;
	}
	public void setEmerCure(String emerCure) {
		this.emerCure = emerCure;
	}
	public String getPostCure() {
		return postCure;
	}
	public void setPostCure(String postCure) {
		this.postCure = postCure;
	}
	public String getProg() {
		return prog;
	}
	public void setProg(String prog) {
		this.prog = prog;
	}
	public String getPrev() {
		return prev;
	}
	public void setPrev(String prev) {
		this.prev = prev;
	}
	public String getEngl() {
		return engl;
	}
	public void setEngl(String engl) {
		this.engl = engl;
	}
	@Override
	public String toString() {
		return "Guke [disease=" + disease + ", rawSymp=" + rawSymp + ", symptom=" + symptom + ", rawDiffDiag="
				+ rawDiffDiag + ", rawChek=" + rawChek + ", diffDiag=" + diffDiag + ", chek=" + chek + ", indi=" + indi
				+ ", body=" + body + ", sex=" + sex + ", defi=" + defi + ", etio=" + etio + ", hist=" + hist + ", diag="
				+ diag + ", emerCure=" + emerCure + ", postCure=" + postCure + ", prog=" + prog + ", prev=" + prev
				+ ", engl=" + engl + "]";
	}








}
