import java.io.Serializable;
import java.util.ArrayList;


public class InvoiceList extends ObjectList implements Serializable{
	private ArrayList<Invoice> invoiceList;


	
	public InvoiceList(int sizeIn){
		super(sizeIn);
	}

	public ArrayList<Invoice> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(ArrayList<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}
	
	public int getSize(){
		int size = this.invoiceList.size();
		return size;
	}
	public String toString(){
		return "Invoice List \n";
	}
	
	public Invoice getInvoice(int positionIn)
	 {   
	     if (positionIn<1 || positionIn>getTotal())//check for valid position
	     {
	        return null; // no object found at given position
	     }
	     else
	     {
	        // call inherited method and type cast
	        return (Invoice) getItem(positionIn);
	     }   
	 }
	
	 public boolean removeInvoice(int idIn)
	 {
	     for(int i=1;i<=getTotal();i++)
	     {   
	            if(getInvoice(i).getInvoiceNo()== idIn)
	            {
	                 remove(i);
	                 return true;
	            }
	     }
	     return false; 
	 }
	 
	 public Invoice search(int idIn)
	 {
	     for(int i=1;i<=getTotal();i++)
	     {     
	            if(getInvoice(i).getInvoiceNo() == idIn)
	            {
	                 return getInvoice(i);
	            }
	     }
	     return null; // no invoice found with given id number
	 }
	
	
}

