import java.text.DateFormat;
import java.util.Date;


public class History {
	private int histID;
	private String conditionName;
	private Date dateOccurred;
	private String medication;
	private int patID;
	
	public History(String conditionName, Date dateOccurred, String medication, int ID, int patID){
		this.conditionName = conditionName;
		this.dateOccurred = dateOccurred;
		this.medication = medication;
		this.histID = ID;
		this.patID = patID;
	}

	public int getHistID() {
		return histID;
	}

	public void setHistID(int histID) {
		this.histID = histID;
	}
	
	

	public int getPatID() {
		return patID;
	}

	public void setPatID(int patID) {
		this.patID = patID;
	}

	public String getConditionName() {
		return conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	public Date getDateOccurred() {
		return dateOccurred;
	}

	public void setDateOccurred(Date dateOccurred) {
		this.dateOccurred = dateOccurred;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}
	public String toString(){
	DateFormat	df = DateFormat.getDateInstance(DateFormat.FULL);
	     String  day = df.format(getDateOccurred());
		
		return "History ID: " + getHistID() + "\nCondition Name: " + getConditionName() + 
		 "\nDate Occurred: " + day + "\nMedication: " + getMedication();
	}
	public void print(){
		System.out.println(toString());
	}

}
