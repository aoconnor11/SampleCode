import java.io.Serializable;
import java.util.ArrayList;


public class PatientList  extends ObjectList implements Serializable{
	private ArrayList<Patient> patientList;

	
	
	public PatientList(int sizeIn){
		super(sizeIn);
	}


	public ArrayList<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(ArrayList<Patient> patientList) {
		this.patientList = patientList;
	}
	
	public int getSize(){
		int size = this.patientList.size();
		return size;
	}
	public String toString(){
		return "Patient List \n";
	}
	
	public Patient getPatient(int positionIn)
	 {   
	     if (positionIn<1 || positionIn>getTotal())//check for valid position
	     {
	        return null; // no object found at given position
	     }
	     else
	     {
	        // call inherited method and type cast
	        return (Patient) getItem(positionIn);
	     }   
	 }
	
	 public boolean removePatient(int idIn)
	 {
	     for(int i=1;i<=getTotal();i++)
	     {    
	            if(getPatient(i).getPatientNo()== idIn)
	            {
	                 remove(i);
	                 return true;
	            }
	     }
	     return false; 
	 }
	 
	 public Patient search(int idIn)
	 {
	     for(int i=1;i<=getTotal();i++)
	     {     
	            if(getPatient(i).getPatientNo() == idIn)
	            {
	                 return getPatient(i);
	            }
	     }
	     return null; // no patient found with given id number
	 }
	
	public void print(){
		System.out.println(this.toString());
		if (!(patientList == null)) {
			
			for (int i=0; i<patientList.size(); i++) 
			{
				patientList.get(i).print();
				
					if (i != patientList.size() - 1)
				{
					System.out.println("\n***\n");	
		
				}
			}
		}
		else{
			System.out.println("No patients have been added to the patient list");
		}
	}
}
