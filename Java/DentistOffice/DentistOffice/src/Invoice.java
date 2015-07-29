import java.util.Date;
import java.util.ArrayList;
import java.text.DateFormat;

public class Invoice {
	private int invoiceNo;
	private double invoiceAmt;
	private Date invoiceDate;
	private boolean invoiceIsPaid = false;
	private ProcedureList pList;
	private static int counter = 0; 
	
	public Invoice(Date invoiceDate, int invoiceNo){
		this.invoiceNo = invoiceNo;
		this.invoiceDate = invoiceDate;
		pList = new ProcedureList(200);
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		
		this.invoiceNo = invoiceNo;
		
	}

	public double getInvoiceAmt() {
		return invoiceAmt;
	}

	public void setInvoiceAmt(double invoiceAmt)
	{	
		this.invoiceAmt = invoiceAmt;

		}

	
	
	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public boolean isInvoicePaid() {
		return invoiceIsPaid;
	}

	public void setInvoicePaid(boolean payStatus) {
		this.invoiceIsPaid = payStatus;
	}
	public void pay() {
		this.setInvoicePaid(true);
	}
	
	public ProcedureList getProcedureList() {
		return pList;
	}

	public void setProcedureList(ProcedureList procedureList) {
		this.pList = procedureList;
	}
	
	public String toString() {

	DateFormat	df = DateFormat.getDateInstance(DateFormat.FULL);
	     String  day = df.format(getInvoiceDate());
		
		return "Invoice No. " + this.invoiceNo +
				"\nDate: " + day + 
		"\nTotal(€): " + String.format("%.2f", this.invoiceAmt) + 
		"\nPaid? " + (this.invoiceIsPaid ? "Yes" : "No");
	}
	
	public void print() {
		
	}
}
