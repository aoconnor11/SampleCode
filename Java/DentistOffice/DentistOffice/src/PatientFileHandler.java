
import java.io.*;
import java.util.Date;

class PatientFileHandler
{
	public static void savePatients(PatientList listIn)
	{
		try{
			FileOutputStream patientFile = new FileOutputStream("PatientList.dat");
			DataOutputStream patientWriter = new DataOutputStream(patientFile);
			patientWriter.writeInt(listIn.getTotal());
			for(int i=1; i<=listIn.getTotal(); i++){
				patientWriter.writeInt(listIn.getPatient(i).getPatientNo());
				patientWriter.writeUTF(listIn.getPatient(i).getPatientName());
				patientWriter.writeUTF(listIn.getPatient(i).getPatientAdd());
				patientWriter.writeUTF(listIn.getPatient(i).getPatientPhone());
				patientWriter.writeInt(listIn.getPatient(i).getHistoryList().getTotal());
				patientWriter.writeInt(listIn.getPatient(i).getInvoiceList().getTotal());
				for(int j=1; j<=listIn.getPatient(i).getHistoryList().getTotal();j++){
					patientWriter.writeInt(listIn.getPatient(i).getHistoryList().getHistory(j).getHistID());
					patientWriter.writeUTF(listIn.getPatient(i).getHistoryList().getHistory(j).getConditionName());
					patientWriter.writeLong(listIn.getPatient(i).getHistoryList().getHistory(j).getDateOccurred().getTime());
					patientWriter.writeUTF(listIn.getPatient(i).getHistoryList().getHistory(j).getMedication());
					patientWriter.writeInt(listIn.getPatient(i).getHistoryList().getHistory(j).getPatID());
				}
				for(int k=1; k<=listIn.getPatient(i).getInvoiceList().getTotal(); k++){
					patientWriter.writeInt(listIn.getPatient(i).getInvoiceList().getInvoice(k).getProcedureList().getTotal());
					patientWriter.writeInt(listIn.getPatient(i).getInvoiceList().getInvoice(k).getInvoiceNo());
					patientWriter.writeDouble(listIn.getPatient(i).getInvoiceList().getInvoice(k).getInvoiceAmt());
					patientWriter.writeLong(listIn.getPatient(i).getInvoiceList().getInvoice(k).getInvoiceDate().getTime());
					patientWriter.writeBoolean(listIn.getPatient(i).getInvoiceList().getInvoice(k).isInvoicePaid());
				
					for(int p=1; p<=listIn.getPatient(i).getInvoiceList().getInvoice(k).getProcedureList().getTotal(); p++){
					patientWriter.writeInt(listIn.getPatient(i).getInvoiceList().getInvoice(k).getProcedureList().getProcedure(p).getProcNo());
					patientWriter.writeUTF(listIn.getPatient(i).getInvoiceList().getInvoice(k).getProcedureList().getProcedure(p).getProcName());
					patientWriter.writeDouble(listIn.getPatient(i).getInvoiceList().getInvoice(k).getProcedureList().getProcedure(p).getProcCost());
						
					}
				}				
			}
			patientWriter.flush();
			patientWriter.close();
		}
		 catch(IOException ioe)
         {
             System.out.println("Error writing file");
         }	
	}
	
	
	 public static void readPatients(PatientList listIn)
	    {

	        try
	        {
	               FileInputStream patientFile = new FileInputStream("PatientList.dat");
	               DataInputStream patientReader = new DataInputStream(patientFile);


	               int totPatients = 0;
	               int tempPatNo = 0;
	               String tempPatName = new String("");
	               String tempPatAdd = new String("");
	               String tempPatPhone = new String("");
	               
	               int totHistList = 0;
	               int totInvList = 0;
	               int tempHistID = 0;
	               String tempHistCond = new String("");
	               Long tempHistDate = null;
	               String tempHistMed = new String("");
	               int tempHistPatID = 0;
	               int totProcList = 0;
	               int tempInvNo = 0;
	               double tempInvAmt = 0.00;
	               Long tempInvDate = null;
	               boolean tempInvPaid;
	               int tempProcNo = 0;
	               String tempProcName = new String("");
	               double tempProcCost = 0.00;
	               Patient tempPatient = null;
	               History tempHistory = null;
	               Invoice tempInvoice = null;
	               Procedure tempProcedure = null;
	               
	               totPatients = patientReader.readInt();
	               for(int a = 1; a<=totPatients; a++){
	            	   tempPatNo = patientReader.readInt();
	            	   tempPatName = patientReader.readUTF();
	            	   tempPatAdd = patientReader.readUTF();
	            	   tempPatPhone = patientReader.readUTF();
	            	   tempPatient = new Patient(tempPatName, tempPatAdd, tempPatPhone, tempPatNo);
	            	   totHistList = patientReader.readInt();
	            	   totInvList = patientReader.readInt();
	            	   HistoryList tempHistList = tempPatient.getHistoryList();
	            	   for(int b=1; b<=totHistList; b++){
	            		   tempHistID = patientReader.readInt();
	    	               tempHistCond = patientReader.readUTF();
	    	               tempHistDate = patientReader.readLong();
	    	               tempHistMed = patientReader.readUTF();
	    	               tempHistPatID = patientReader.readInt();
	    	               Date d = new Date(tempHistDate);//convert long back to date again
	    	               tempHistory = new History(tempHistCond, d, tempHistMed, tempHistID, tempHistPatID);
	    	               tempHistList.add(tempHistory);
	            	   }
	            	   InvoiceList tempInvList = tempPatient.getInvoiceList();
	            	   for(int c=1; c<totInvList; c++){
	            		   totProcList = patientReader.readInt();
	            		   tempInvNo = patientReader.readInt();
	    	               tempInvAmt = patientReader.readDouble();
	    	               tempInvDate = patientReader.readLong();
	    	               tempInvPaid = patientReader.readBoolean();
	    	               Date e = new Date(tempInvDate);
	            		   tempInvoice = new Invoice(e, tempInvNo);
	            		   tempInvoice.setInvoiceAmt(tempInvAmt);
	            		   tempInvoice.setInvoicePaid(tempInvPaid);
	            		   ProcedureList plist = tempInvoice.getProcedureList();
	            		   for(int d=1; d<=totProcList;d++){
	            			   tempProcNo = patientReader.readInt();
	        	               tempProcName = patientReader.readUTF();
	        	               tempProcCost = patientReader.readDouble();
	        	               tempProcedure = new Procedure(tempProcNo, tempProcName, tempProcCost);
	        	               plist.add(tempProcedure);
	            		   }
	            		   tempInvList.add(tempInvoice);
	            	   }
	            	   listIn.add(tempPatient);
	               }

	                  patientReader.close();
	         }

	         catch(IOException ioe)
	         {
	            System.out.println("No records found");
	         }

	    }
	

}
