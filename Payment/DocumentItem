package oop_kiosk_medihub;

public class DocumentItem {
	private String name;
	private String number;
	private String medicalReport;
	private String office;
	private String subject;
	private String disease;
	private String medicine;
	private String doses;
	private String fee;
	
	public String getName() {
		return name;
	}
	public void setName(String n) {
		this.name = n;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String num) {
		this.number = num;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String o) {
		this.office = o; // 진료실 A~H
	}
	public String getSubject() { //진료 과목 따로
		if (office == "A" || office == "B")
			subject = "내과";
		else if (office == "C" || office == "D")
			subject = "정형외과";
		else if (office == "E" || office == "F")
			subject = "피부과";
		else 
			subject = "정신의학과";
		return subject;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String d) {
		this.disease = d;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public String getDoses() {
		return doses;
	}
	public void setDoses(String doses) {
		this.doses = doses;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String f) {
		this.fee = f;
	}
	public String getMedicalReport() {
		return medicalReport;
	}
	public void setMedicalReport(String m) {
		if (m == "O") 
			this.medicalReport = "20000원";
	}
	public int getAmount() {
		String trimmedFee = fee.replace("원", "").trim();
		int intFee = Integer.parseInt(trimmedFee);
		int ReportPrice = 20000;
		if (medicalReport == "20000원") 
			return intFee + ReportPrice;
		return intFee;
		
	}
}
