import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;


public class Patient implements Serializable{
	private int patientNo;
	private String patientName;
	private String patientAdd;
	private String patientPhone;
	private ArrayList<History> p_history;
	private ArrayList<Invoice> p_Invoice;
	private HistoryList hList;
	private InvoiceList iList;
	
	public Patient(String patientName, String patientAdd, String patientPhone, int patientNo){
		this.patientName = patientName;
		this.patientAdd = patientAdd;
		this.patientPhone = patientPhone;
		this.patientNo = patientNo;
		hList = new HistoryList(200);
		iList = new InvoiceList(1000);
	}
	public Patient(){
		
	}

	public int getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(int patientNo) {
		this.patientNo = patientNo;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientAdd() {
		return patientAdd;
	}

	public void setPatientAdd(String patientAdd) {
		this.patientAdd = patientAdd;
	}

	public String getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}

	public ArrayList<History> getP_history() {
		return p_history;
	}

	public void setP_history(ArrayList<History> p_history) {
		this.p_history = p_history;
	}

	public ArrayList<Invoice> getP_Invoice() {
		return p_Invoice;
	}

	public void setP_Invoice(ArrayList<Invoice> invoice) {
		p_Invoice = invoice;
	}
	public HistoryList getHistoryList()
	  {
	    return hList;
	  }
	public InvoiceList getInvoiceList()
	  {
	    return iList;
	  }
	

	
	
	public void checkReminder(String date){
		
		String dateString = date;
		Date today = new Date();
        Calendar calendar1 = Calendar.getInstance(); 
        Calendar calendar2 = Calendar.getInstance();
        
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //convert date from String
		    Date appointDate = dateFormat.parse(dateString);
		    calendar1.setTime(today); 
	        calendar2.setTime(appointDate);
	        long milliseconds1 = calendar1.getTimeInMillis(); 
	        long milliseconds2 = calendar2.getTimeInMillis(); 
	        long diff = milliseconds2 - milliseconds1;
	        long diffDays = diff / (24 * 60 * 60 * 1000);
	        System.out.println("Time in days: " + diffDays + " days."); 
	    if(diffDays<=14){
	    	System.out.println("Please send out appointment reminder to patient " + getPatientName());
	    }
	    else{
	    	System.out.println("");
	    }
	        
			} 
		catch(ParseException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	public String toString(){
	return "Patient Name: " + getPatientName() + "\nPatient Address: " + getPatientAdd() +
	"\nPatient Phone Number: " + getPatientPhone();
	}
	public void print(){
		System.out.println(this.toString());
	}
	public void printHistory(){
		if (!(p_history == null)) {

			Date today = new Date();
		DateFormat	df = DateFormat.getDateInstance(DateFormat.FULL);
		     String  day = df.format(today);
			
			
			System.out.println("\nPatient History as at " + day + "\n");
			
			for (int i=0; i<p_history.size(); i++) 
			{
				p_history.get(i).print();
				if (i != p_history.size() - 1)
				{
					System.out.println("\n***\n");	
		
				}
			}
		}
		else{
			System.out.println("No patient history has been added for " + getPatientName());
	}
	}
	
	
	public void printInvoices(){
if (!(p_Invoice == null)) {

	Date today = new Date();
DateFormat	df = DateFormat.getDateInstance(DateFormat.FULL);
     String  day = df.format(today);
			System.out.println("\nPatient Invoices as at " + day + "\n");
			
			for (int i=0; i<p_Invoice.size(); i++) 
			{
				p_Invoice.get(i).print();
				if (i != p_Invoice.size() - 1)
				{
					System.out.println("\n***\n");	
		
				}
			}
		}
		else{
			System.out.println("No patient invoices have been added for " + getPatientName());
	}	
		
		
	}
}
