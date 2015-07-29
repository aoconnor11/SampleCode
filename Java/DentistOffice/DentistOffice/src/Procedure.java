
public class Procedure {
	private int procNo;
	private String procName;
	private double procCost;
	
	 
	public Procedure(String procName, double procCost){
		this.procName = procName;
		this.procCost=procCost;
	}
	
	public Procedure(int procNo, String procName, double procCost){
		this.procNo = procNo;
		this.procName = procName;
		this.procCost=procCost;
	}
	 public void setProcNo(int procNo){
		 this.procNo = procNo;
	 }
	 public int getProcNo(){
		 
		 return procNo;
	 }
	 public void setProcName(String procName){
		 this.procName = procName;
	 }
	 public String getProcName(){
		 return procName;
	 }
	 public void setProcCost(double procCost){
		 this.procCost = procCost;
	 }
	 public double getProcCost(){
		 return procCost;
	 }
	 
	 public String toString(){
		 return "Procedure No: " + getProcNo() + "\nProcedure Name: " + getProcName() + 
		 "\nProcedure Cost: " + getProcCost() + " Euros.";
	 }
	 public void print(){
		 System.out.println(this.toString());
	 }
}
