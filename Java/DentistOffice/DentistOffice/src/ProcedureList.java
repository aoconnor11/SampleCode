import java.io.Serializable;
import java.util.ArrayList;


public class ProcedureList extends ObjectList implements Serializable{
	private ArrayList<Procedure> procedureList;


	
	public ProcedureList(int sizeIn){
		super(sizeIn);
	}

	public ArrayList<Procedure> getProcedureList() {
		return procedureList;
	}

	public void setProcedureList(ArrayList<Procedure> procedureList) {
		this.procedureList = procedureList;
	}
	
	public int getSize(){
		int size = this.procedureList.size();
		return size;
	}
	

	public double calculateTotalPaid()
	 {
	     double totalPaid = 0; // initialize totalPaid
	     // loop through all payments
	     for (int i=1; i<= getTotal();i++)
	     {   // add current payment to running total
	         totalPaid = totalPaid + getProcedure(i).getProcCost();
	     }
	     return totalPaid;
	 }
	
	public String toString(){
		return "Patient List \n";
	}
	
	public Procedure getProcedure(int positionIn)
	 {   
	     if (positionIn<1 || positionIn>getTotal())//check for valid position
	     {
	        return null; // no object found at given position
	     }
	     else
	     {
	        // call inherited method and type cast
	        return (Procedure) getItem(positionIn);
	     }   
	 }
	
	 public boolean removeProcedure(int idIn)
	 {
	     for(int i=1;i<=getTotal();i++)
	     {    
	            if(getProcedure(i).getProcNo()== idIn)
	            {
	                 remove(i);
	                 return true;
	            }
	     }
	     return false; 
	 }
	 
	 public Procedure search(int idIn)
	 {
	     for(int i=1;i<=getTotal();i++)
	     {    
	            if(getProcedure(i).getProcNo() == idIn)
	            {
	                 return getProcedure(i);
	            }
	     }
	     return null; // no procedure found with given id number
	 }
	
	
}


