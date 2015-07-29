
import java.io.Serializable;
import java.util.ArrayList;


public class HistoryList extends ObjectList implements Serializable{
	
	private ArrayList<History> historyList;

	public HistoryList(int sizeIn){
		super(sizeIn);
	}

	public ArrayList<History> getHistoryList() {
		return historyList;
	}

	public void setHistoryList(ArrayList<History> historyList) {
		this.historyList = historyList;
	}
	
	public int getSize(){
		int size = this.historyList.size();
		return size;
	}
	public String toString(){
		return "History List \n";
	}
	
	public History getHistory(int positionIn)
	 {   
	     if (positionIn<1 || positionIn>getTotal())//check for valid position
	     {
	        return null; // no object found at given position
	     }
	     else
	     {
	        // call inherited method and type cast
	        return (History) getItem(positionIn);
	     }   
	 }
	
	 public boolean removeHistory(int idIn)
	 {
	     for(int i=1;i<=getTotal();i++)
	     {    
	            if(getHistory(i).getHistID()== idIn)
	            {
	                 remove(i);
	                 return true;
	            }
	     }
	     return false; 
	 }
	 
	 public History search(int idIn)
	 {
	     for(int i=1;i<=getTotal();i++)
	     {     
	            if(getHistory(i).getHistID() == idIn)
	            {
	                 return getHistory(i);
	            }
	     }
	     return null; // no history found with given id number
	 }
	
	public void print(){
		System.out.println(this.toString());
		if (!(historyList == null)) {
			
			for (int i=0; i<historyList.size(); i++) 
			{
				historyList.get(i).print();
				
					if (i != historyList.size() - 1)
				{
					System.out.println("\n***\n");	
		
				}
			}
		}
		else{
			System.out.println("No history has been added to the history list");
		}
	}
}
