import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.border.*;




/** GUI for the Dentist Office application
    @author Anita O Connor R00093256
    @version December 2012
 */
public class App extends JFrame
{
	
	
	// the attributes
	private PatientList list;
	private PatientList temp;
	private PatientList temp1;
	private PatientList temp3;
	private PatientList temp4;
	private Set<Integer> set1 = new TreeSet<Integer>();
	private Set<Integer> set2 = new TreeSet<Integer>();
	private Set<Integer> set3 = new TreeSet<Integer>();
	private Set<Integer> set4 = new TreeSet<Integer>();
	private  JButton addButton = new JButton("  Add Patient  ");
	private  JButton displayButton = new JButton("  Display Patients  ");
	private  JButton editButton = new JButton("  Edit Patient  ");
	private  JButton removeButton = new JButton("  Remove Patient  ");
	private  JTextField patientIDField = new JTextField(6);
	private  JTextField nameField = new JTextField(10);
	private  JTextField addressField = new JTextField(20);
	private  JTextField phoneField = new JTextField(10);
	private  JButton reportsButton = new JButton("  Reports  ");
	private  JButton quitButton = new JButton("  Quit  ");
	private  JButton saveAndQuitButton = new JButton("  Save and Quit  ");
	private  JTextArea displayArea1 = new JTextArea(7,50);
	private  JTextArea displayArea2 = new JTextArea(7,50);
	private  JTextArea displayArea3 = new JTextArea(7,50);
	private  JTextField patientIDField2 = new JTextField(6);
	private  JTextField historyIDField = new JTextField(6);
	private  JTextField conditionField = new JTextField(8);
	private  JTextField conditionDateField = new JTextField(12);
	private JTextField medicationField = new JTextField(8);
	private JButton addHistoryButton = new JButton("  Add History  ");
	private  JButton listButton = new JButton("  List History  ");
	private  JButton removeHistButton = new JButton("  Remove History  ");
	private  JButton editHistButton = new JButton("  Edit History  ");
	private  JTextField patientIDField3 = new JTextField(6);
	private  JTextField invoiceIDField = new JTextField(6);
	private  JTextField invoiceDateField = new JTextField(12);
	private  JTextField paidField = new JTextField(6);
	private JButton addInvoiceButton = new JButton("  Add Invoice  ");
	private  JButton listInvoiceButton = new JButton("  List Invoices  ");
	private JButton editInvoiceButton = new JButton("  Edit Date  ");
	private  JButton removeInvoiceButton = new JButton("  Remove Invoices  ");
	private  JButton invoiceDetailsButton = new JButton("  Add Procedure  ");
	private JTextField invoiceID2Field = new JTextField(6);
	private JTextField procField = new JTextField(7);
	private JTextField patIDField = new JTextField(6);
	private JTextArea displayArea4 = new JTextArea(7,50);
	private JTextArea displayArea5 = new JTextArea(7,50);
	private JButton addProcButton = new JButton("  Add Procedure  ");
	private JButton displayProcButton = new JButton("  Display ");
	private JButton deleteProcButton = new JButton("  Delete Procedure  ");
	private Procedure proc1 = new Procedure(1, "Filling", 70.00);
	private Procedure proc2 = new Procedure(2, "Scale and Polish", 40.00);
	private Procedure proc3 = new Procedure(3, "Examination & Diagnosis", 40.00);
	private Procedure proc4 = new Procedure(4, "Prescription", 30.00);
	private Procedure proc5 = new Procedure(5, "Gum Treatment", 190.00);
	private Procedure proc6 = new Procedure(6, "X-Rays", 20.00);
	private Procedure proc7 = new Procedure(7, "Routine Extraction", 70.00);
	private Procedure proc8 = new Procedure(8, "Surgical Extraction", 100.00);
	private Procedure proc9 = new Procedure(9, "Acrylic Dentures", 500.00);
	private Procedure proc10 = new Procedure(10, "Metal Dentures", 800.00);
	private Procedure proc11 = new Procedure(11, "Crown", 750.00);
	private Procedure proc12 = new Procedure(12, "Core/Post Preparation", 100.00);
	private Procedure proc13 = new Procedure(13, "Fissure Sealants", 25.00);
	private JButton payButton = new JButton("  Pay  ");
	private JLabel title3 = new JLabel("  From  "); 
	private JLabel title4 = new JLabel("  To  ");
	private JLabel title5 = new JLabel("  From  "); 
	private JLabel title6 = new JLabel("  To  ");
	private JTextField startDate = new JTextField(8);//For first report
	private JTextField endDate = new JTextField(8);
	private JTextField startDate2 = new JTextField(8);//For fourth report
	private JTextField endDate2 = new JTextField(8);
	private JTextField procReport = new JTextField(8);
	private JTextArea displayArea6 = new JTextArea(7,50);
	private JTextArea displayArea7 = new JTextArea(7,50);
	private JTextArea displayArea8 = new JTextArea(7,50);
	private JTextArea displayArea9 = new JTextArea(7,50);
	private JButton report1Button = new JButton("  Run Report  ");
	private JButton report2Button = new JButton("  Run Report  ");
	private JButton report3Button = new JButton("  Run Report  ");
	private JButton report4Button = new JButton("  Run Report  ");


	//the constructor
	public App(String choice)
	{
		       
		if(choice=="no"||choice=="file"){
		list = new PatientList(300); 
		}
		
		temp = new PatientList(300);
		temp1 = new PatientList(300);
		temp3 = new PatientList(300);
		temp4 = new PatientList(300);
		
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		if(choice=="no"){//no data received from a file or database
			setTitle("Dentist Application - No Save");
		
		}
		else if(choice=="file"){//data read in from file
			setTitle("Dentist Application - Save to File"); 
			
		}
		else{//data read in from database
			setTitle("Dentist Application - Save in Database");
		
		}
		setSize(600, 700);
		setLocation(400,100);


		getContentPane().setBackground(new Color(95, 158, 160));
		BevelBorder raisedBevel = new BevelBorder(BevelBorder.RAISED);
		getContentPane().add(patientIDField);

		patientIDField.setBorder(new TitledBorder("Patient ID"));

		//add patient fields
		getContentPane().add(nameField);
		nameField.setBorder(new TitledBorder("Name"));
		getContentPane().add(addressField);
		addressField.setBorder(new TitledBorder("Address"));
		getContentPane().add(phoneField);
		phoneField.setBorder(new TitledBorder("Phone"));

		//add patient buttons
		getContentPane().add(addButton);
		addButton.setBackground(new Color(143, 188, 143));
		addButton.setBorder(raisedBevel);
		getContentPane().add(displayButton);
		displayButton.setBorder(raisedBevel);
		displayButton.setBackground(new Color(143, 188, 143));
		getContentPane().add(editButton);
		editButton.setBackground(new Color(143, 188, 143));
		editButton.setBorder(raisedBevel);
		getContentPane().add(removeButton);
		removeButton.setBackground(new Color(143, 188, 143));
		removeButton.setBorder(raisedBevel);
		getContentPane().add(reportsButton);
		reportsButton.setBackground(new Color(143, 188, 143));
		reportsButton.setBorder(raisedBevel);
		getContentPane().add(quitButton);
		quitButton.setBackground(new Color(143, 188, 143));
		quitButton.setBorder(raisedBevel);
		getContentPane().add(saveAndQuitButton);
		saveAndQuitButton.setBackground(new Color(143, 188, 143));
		saveAndQuitButton.setBorder(raisedBevel);
		
		displayArea1.setBorder
		(new TitledBorder(new LineBorder(new Color(95, 158, 160)),
				"Patients",TitledBorder.CENTER,TitledBorder.TOP));

		JScrollPane p1 = new JScrollPane(displayArea1);
		getContentPane().add(p1);

		//add history fields
		getContentPane().add(patientIDField2);
		patientIDField2.setBorder(new TitledBorder("Patient ID"));
		getContentPane().add(historyIDField);
		historyIDField.setBorder(new TitledBorder("History ID"));
		getContentPane().add(conditionField);
		conditionField.setBorder(new TitledBorder("Condition"));
		getContentPane().add(conditionDateField);
		conditionDateField.setBorder(new TitledBorder("Date (YYYY-MM-DD)"));
		getContentPane().add(medicationField);
		medicationField.setBorder(new TitledBorder("Medication"));
		
		//add history buttons
		getContentPane().add(addHistoryButton);
		addHistoryButton.setBackground(new Color(143, 188, 143));
		addHistoryButton.setBorder(raisedBevel);
		getContentPane().add(listButton);
		listButton.setBorder(raisedBevel);
		listButton.setBackground(new Color(143, 188, 143));
		getContentPane().add(editHistButton);
		editHistButton.setBackground(new Color(143, 188, 143));
		editHistButton.setBorder(raisedBevel);
		getContentPane().add(removeHistButton);
		removeHistButton.setBackground(new Color(143, 188, 143));
		removeHistButton.setBorder(raisedBevel);
		displayArea2.setBorder
		(new TitledBorder(new LineBorder(new Color(95, 158, 160)),
				"Patient History",TitledBorder.CENTER,TitledBorder.TOP));
		
		
		JScrollPane p2 = new JScrollPane(displayArea2);
		getContentPane().add(p2);
		getContentPane().add(patientIDField3);
		//add Invoice fields
		patientIDField3.setBorder(new TitledBorder("Patient ID"));
		getContentPane().add(invoiceIDField);
		invoiceIDField.setBorder(new TitledBorder("Invoice ID"));
		getContentPane().add(invoiceDateField);
		invoiceDateField.setBorder(new TitledBorder("Date (YYYY-MM-DD)"));
		getContentPane().add(paidField);
		paidField.setBorder(new TitledBorder("Pay"));
		//add pay button
		getContentPane().add(payButton);
		payButton.setBackground(new Color(143, 188, 143));
		payButton.setBorder(raisedBevel);
		displayArea3.setBorder
		(new TitledBorder(new LineBorder(new Color(95, 158, 160)),
				"Invoices",TitledBorder.CENTER,TitledBorder.TOP));
		JScrollPane p3 = new JScrollPane(displayArea3);
		getContentPane().add(p3);
		//add Invoice buttons
		getContentPane().add(addInvoiceButton);
		addInvoiceButton.setBorder(raisedBevel);
		addInvoiceButton.setBackground(new Color(143, 188, 143));
		getContentPane().add(listInvoiceButton);
		listInvoiceButton.setBorder(raisedBevel);
		listInvoiceButton.setBackground(new Color(143, 188, 143));
		getContentPane().add(editInvoiceButton);
		editInvoiceButton.setBorder(raisedBevel);
		editInvoiceButton.setBackground(new Color(143, 188, 143));
		getContentPane().add(removeInvoiceButton);
		removeInvoiceButton.setBorder(raisedBevel);
		removeInvoiceButton.setBackground(new Color(143, 188, 143));
		getContentPane().add(invoiceDetailsButton);
		invoiceDetailsButton.setBorder(raisedBevel);
		invoiceDetailsButton.setBackground(new Color(143, 188, 143));



		//listeners for non-database version of application
		if(choice=="no"||choice=="file"){
		addButton.addActionListener(new AddListener());     //add Patient
		displayButton.addActionListener(new DisplayListener());//display Patient
		addHistoryButton.addActionListener(new AddHistListener());//add History
		listButton.addActionListener(new ListListener());//list History
		removeButton.addActionListener(new RemoveListener());//remove patient
		
		saveAndQuitButton.addActionListener(new SaveAndQuitListener());//save and quit
		
		reportsButton.addActionListener(new ReportsListener());//link to reports page
		quitButton.addActionListener(new QuitListener());//quit without saving
		editButton.addActionListener(new EditListener());//edit patient
		
		addInvoiceButton.addActionListener(new AddInvoice());//add invoice
		listInvoiceButton.addActionListener(new ListInvoice());//list invoice
		invoiceDetailsButton.addActionListener(new Details());//invoice details
		
		removeHistButton.addActionListener(new RemoveHistListener());//remove history
		editHistButton.addActionListener(new EditHistListener());//edit history
		
		removeInvoiceButton.addActionListener(new RemoveInvoiceListener());//remove history
		editInvoiceButton.addActionListener(new EditInvoiceListener());//edit history 
		payButton.addActionListener(new PayListener());//pay invoice
		}
		
		//listners for database version of application
	if(choice=="database"){
		addButton.addActionListener(new AddListenerdb());     //add Patient
		displayButton.addActionListener(new DisplayListenerdb());//display Patient
		addHistoryButton.addActionListener(new AddHistListenerdb());//add History 
		listButton.addActionListener(new ListListenerdb());//list History 
		removeButton.addActionListener(new RemoveListenerdb());//remove patient
		
		saveAndQuitButton.addActionListener(new SaveAndQuitListenerdb());//save and quit
		
		reportsButton.addActionListener(new ReportsListenerdb());//link to reports page
		quitButton.addActionListener(new QuitListenerdb());//quit without saving 
		editButton.addActionListener(new EditListenerdb());//edit patient
		
		addInvoiceButton.addActionListener(new AddInvoicedb());//add invoice
		listInvoiceButton.addActionListener(new ListInvoicedb());//list invoice
		invoiceDetailsButton.addActionListener(new Detailsdb());//invoice details
		
		removeHistButton.addActionListener(new RemoveHistListenerdb());//remove history 
		editHistButton.addActionListener(new EditHistListenerdb());//edit history 
		
		removeInvoiceButton.addActionListener(new RemoveInvoiceListenerdb());//remove invoice
		editInvoiceButton.addActionListener(new EditInvoiceListenerdb());//edit invoice
		payButton.addActionListener(new PayListenerdb());//pay invoice
	}
			
			
			if(choice=="file"){//read from file
				PatientFileHandler.readPatients(list);
			}
		
		// make GUI visible	
		setVisible(true);
		
}

	

	
	
//the event handlers - database

class PayListenerdb implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {	
		double oldamt = 0;
		double procamt = 0;
		double updateAmount = 0;
		double change = 0;
		String patientID = patientIDField3.getText();
		String invID = invoiceIDField.getText();
		String paidEntered = paidField.getText();
		if(patientID.length()==0 || invID.length()==0 || paidEntered.length()==0)
		{
			displayArea3.setText
			("Patient id, invoice id and amount to be paid must be entered");
		}
		else
		{  
			int id = Integer.parseInt(invID);
			 double payamt = Double.valueOf(paidEntered).doubleValue();
			 try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");
			PreparedStatement statement = con.prepareStatement("Select invoiceAmt from inv where invoiceID = ?");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();	
			while (result.next()) {
			oldamt = result.getDouble("invoiceAmt");
			System.out.println(oldamt);
				}	
			
			updateAmount = (oldamt-payamt);
			if(updateAmount==0){
				PreparedStatement statement1 = con.prepareStatement
				("update inv set invoiceAmt = ?, invoiceIsPaid = 1 where invoiceID = ?");
				statement1.setDouble(1, updateAmount);
				statement1.setInt(2, id);
				statement1.executeUpdate();
				double displayamt = round2(payamt);
				displayArea3.setText("Invoice id: " 
						+ invID 
						+ " successfully paid €" + displayamt);	
			}
			 else if(updateAmount>0){
				 PreparedStatement statement2 = con.prepareStatement
					("update inv set invoiceAmt = ? where invoiceID = ?");
					statement2.setDouble(1, updateAmount);
					statement2.setInt(2, id);
					statement2.executeUpdate();
					double displayamt = round2(payamt);
					displayArea3.setText("Invoice id: " 
							+ invID 
							+ " successfully paid €" + displayamt);		 
			 }
			 else if(updateAmount<0){
				 PreparedStatement statement3 = con.prepareStatement
					("update inv set invoiceAmt = 0,  invoiceIsPaid = 1 where invoiceID = ?");
					statement3.setInt(1, id);
					statement3.executeUpdate();
					change = (payamt-oldamt);
					double displayamt = round2(payamt);
					displayArea3.setText("Invoice id: " 
							+ invID 
							+ " successfully paid €" + displayamt + " with €" +  change + " change");		 
				 
			 }	
			patientIDField3.setText("");
			invoiceIDField.setText("");
			paidField.setText("");
			 }
			 catch(SQLException e){
					e.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
	}	
}





class Detailsdb implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent event){
		if( event.getSource() instanceof JButton ){
			detailsFramedb();
		}
	}
}




class RemoveInvoiceListenerdb implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent event) {
		String patientID = patientIDField3.getText();
		String invID = invoiceIDField.getText();
		if(patientID.length()==0||invID.length()==0)
		{
			displayArea3.setText("Patient number and invoice ID must be entered");
		}
		else
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");
				int id = Integer.parseInt(invID);
				PreparedStatement statement = con.prepareStatement
				("delete from inv where invoiceID = ?");
				statement.setInt(1, id);
				statement.executeUpdate();
				
				PreparedStatement statement2 = con.prepareStatement
				("delete from invoiceprocs where invoiceID = ?");
				statement2.setInt(1, id);
				statement2.executeUpdate();
				
				invoiceIDField.setText("");
				patientIDField3.setText("");
				displayArea3.setText("Invoice removed from database");
				 con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
				}
		}
	}
	
}

class EditInvoiceListenerdb implements ActionListener{
@Override
public void actionPerformed(ActionEvent event) 
{
	String patientID = patientIDField3.getText();
	String invID = invoiceIDField.getText();
	String dateEntered = invoiceDateField.getText();
	if(patientID.length()==0 || invID.length()==0 || dateEntered.length()==0)
	{
		displayArea3.setText
		("Patient id, invoice id and invoice date must be entered");
	}

	else
	{  
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");
			int patid = Integer.parseInt(patientID);
			int id = Integer.parseInt(invID);
			DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date parsedUtilDate;
			parsedUtilDate = formater.parse(dateEntered);
			java.sql.Date sqlDate= new java.sql.Date(parsedUtilDate.getTime());
			
			PreparedStatement statement = con.prepareStatement
			("update inv set invoiceDate = ? where invoiceID = ?");

			statement.setDate(1, sqlDate);
			statement.setInt(2, id);
			statement.executeUpdate();
			patientIDField3.setText("");
			invoiceIDField.setText("");
			invoiceDateField.setText("");
			displayArea3.setText("Invoice id: " 
					+ invID 
					+ " successfully edited");
			 con.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			} 
	}
}
}

class ListInvoicedb implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent event){	
		String patEntered = patientIDField3.getText();
		if(patEntered.length()==0)
		{
			displayArea3.setText("Patient ID must be entered");
		}
		else
		{  				
				try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");
			int id = Integer.parseInt(patEntered);
			PreparedStatement statement = con.prepareStatement("Select * from inv where patientID = ?");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			
			displayArea3.setText
			("ID" + "\t" + "Amount (to be paid)" + "\t" + "Date"+"\t" + "Paid"+"\n");
			
			while (result.next()) {
			double amount = result.getDouble("invoiceAmt");
			boolean paid = result.getBoolean("invoiceIsPaid");
			java.sql.Date date = result.getDate("invoiceDate");

			displayArea3.append("" + id 
					+ "\t"  + amount  + "\t\t"  + date+"\t"  + paid +"\n");
			System.out.println("id: " + id + " paid: " + paid + " cost: " + amount + date);
				}
			
			 con.close();
			 
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}

			
		}
	}
}

class AddInvoicedb implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent event){

		String patientID = patientIDField3.getText();
		String dateEntered = invoiceDateField.getText();
		if(patientID.length()==0 || dateEntered.length()==0)
		{
			displayArea3.setText
			("Patient id and invoice date must be entered");
		}
		else
		{
			try{
				int patID = Integer.parseInt(patientID);
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date parsedUtilDate;
				parsedUtilDate = formater.parse(dateEntered);//format date
				java.sql.Date sqlDate= new java.sql.Date(parsedUtilDate.getTime());//sql date
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");
				PreparedStatement statement = con.prepareStatement
				("insert into inv (invoiceDate, patientID) values(?,?)");
				
				statement.setDate(1, sqlDate);
				statement.setInt(2, patID);
				statement.executeUpdate();
				patientIDField3.setText("");
				invoiceDateField.setText("");
				displayArea3.setText("Invoice added");
				
				 con.close();
			}
			catch(ParseException e){
				e.printStackTrace();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}	
		}
	}      
}



class EditListenerdb implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		String patientID = patientIDField.getText();
		String addressEntered = addressField.getText();
		String phoneEntered = phoneField.getText();
		String nameEntered = nameField.getText();
		int id = Integer.parseInt(patientID);
		if(nameEntered.length()==0 || addressEntered.length()==0 || phoneEntered.length()==0 || patientID.length()==0)
		{
			displayArea1.setText
			("Patient name, address, phone number and ID must be entered");
		}

		else
		{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");

				PreparedStatement statement = con.prepareStatement
("update patient set patientName = ?, patientAddress=?, patientPhone = ? where patientID = ?");

				statement.setString(1, nameEntered);
				statement.setString(2, addressEntered);
				statement.setString(3, phoneEntered);
				statement.setInt(4, id);
				statement.executeUpdate();
				nameField.setText("");
				addressField.setText("");
				phoneField.setText("");
				patientIDField.setText("");
				displayArea1.setText("Patient " 
						+ nameEntered 
						+ " successfully edited");
				
				 con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
				}		
		}
	}
}

class AddListenerdb implements ActionListener 
{
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		String addressEntered = addressField.getText();
		String phoneEntered = phoneField.getText();
		String nameEntered = nameField.getText();
		if(nameEntered.length()==0 || addressEntered.length()==0 || phoneEntered.length()==0)
		{
			displayArea1.setText
			("Patient name, address and phone number must be entered");
		} 
		else
		{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");

				PreparedStatement statement = con.prepareStatement
				("insert into patient(patientName, patientAddress, patientPhone) values(?,?,?)");

				statement.setString(1, nameEntered);
				statement.setString(2, addressEntered);
				statement.setString(3, phoneEntered);
				statement.executeUpdate();
				nameField.setText("");
				addressField.setText("");
				phoneField.setText("");
				patientIDField.setText("");
				displayArea1.setText("Patient " 
						+ nameEntered 
						+ " successfully added");
				
				 con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
				}		
		}
	}
}      


class DisplayListenerdb implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent event) {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");

			PreparedStatement statement = con.prepareStatement("Select * from patient");
			ResultSet result = statement.executeQuery();
			displayArea1.setText("ID:" + "\t" + "Name" + "\n");	
			while (result.next()) {
			int id=	  result.getInt("patientID");
			String name = result.getString("patientName");
			String address = result.getString("patientAddress");
			displayArea1.append(id + "\t" + name + "\n");
			System.out.println("id: " + id + " title: " + name + " cost: " + address);
				}
			
			 con.close();
			 
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}
				
			
		}
}

class RemoveListenerdb implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent event) {
		String idEntered = patientIDField.getText();
		int id = Integer.parseInt(idEntered);
		if(idEntered.length()==0)
		{
			displayArea1.setText("Patient number must be entered");
		}
		else
		{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");

				PreparedStatement statement = con.prepareStatement
("delete from patient where patientID = ?");
				statement.setInt(1, id);
				statement.executeUpdate();
				nameField.setText("");
				addressField.setText("");
				phoneField.setText("");
				patientIDField.setText("");
				displayArea1.setText("Patient successfully deleted");
				
				 con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
				}
		
		}
	}
}      

class AddHistListenerdb implements ActionListener 
{
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		String patientID = patientIDField2.getText();
		String condEntered = conditionField.getText();
		String dateEntered = conditionDateField.getText();
		String medEntered = medicationField.getText();
		
		if(patientID.length()==0 || condEntered.length()==0 || dateEntered.length()==0 || medEntered.length()==0)
		{
			displayArea2.setText
			("Patient id, condition, date and medication must be entered");
		}
		else
		{	   
			
			try{
				int patID = Integer.parseInt(patientID);
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date parsedUtilDate;
				parsedUtilDate = formater.parse(dateEntered);//format date
				java.sql.Date sqlDate= new java.sql.Date(parsedUtilDate.getTime());//sql date
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");
				PreparedStatement statement = con.prepareStatement
				("insert into history(conditionName, dateOccurred, medication, patientID) values(?,?,?,?)");

				statement.setString(1, condEntered);
				statement.setDate(2, sqlDate);
				statement.setString(3, medEntered);
				statement.setInt(4, patID);
				statement.executeUpdate();
				patientIDField2.setText("");
				conditionField.setText("");
				conditionDateField.setText("");
				medicationField.setText("");
				displayArea2.setText("History " 
						+ condEntered 
						+ " added");
				
				 con.close();
			}
			catch(ParseException e){
				e.printStackTrace();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		}
	}      
}

      

	class RemoveHistListenerdb implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			String patientID = patientIDField2.getText();
			String histID = historyIDField.getText();
			if(patientID.length()==0||histID.length()==0)
			{
				displayArea2.setText("Patient number and history ID must be entered");
			}
			else{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");
				int id = Integer.parseInt(histID);
				PreparedStatement statement = con.prepareStatement
				("delete from history where histID = ?");
				statement.setInt(1, id);
				statement.executeUpdate();
				historyIDField.setText("");
				patientIDField2.setText("");
				displayArea2.setText("History successfully deleted");
				
				 con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}   
	
	
	
	
	class EditHistListenerdb implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			String patientID = patientIDField2.getText();
			String histID = historyIDField.getText();
			String condEntered = conditionField.getText();
			String dateEntered = conditionDateField.getText();
			String medEntered = medicationField.getText();
			if(patientID.length()==0 || condEntered.length()==0 || dateEntered.length()==0 || medEntered.length()==0 || histID.length()==0)
			{
				displayArea2.setText
				("Patient id, history id, condition, date and medication must be entered");
			}

			else
			{  
				try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");
				int id = Integer.parseInt(histID);
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date parsedUtilDate;
				parsedUtilDate = formater.parse(dateEntered);
				java.sql.Date sqlDate= new java.sql.Date(parsedUtilDate.getTime());
				PreparedStatement statement = con.prepareStatement
("update history set conditionName = ?, dateOccurred=?, medication = ? where historyID = ?");

				statement.setString(1, condEntered);
				statement.setDate(2, sqlDate);
				statement.setString(3, medEntered);
				statement.setInt(4, id);
				statement.executeUpdate();
				conditionField.setText("");
				conditionDateField.setText("");
				medicationField.setText("");
				patientIDField2.setText("");
				displayArea2.setText("History id " 
						+ histID 
						+ " successfully edited");
				
				 con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
				} 
			}
		}
	}
	
	
	class ListListenerdb implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			String patEntered = patientIDField2.getText();
			
			if(patEntered.length()==0)
			{
				displayArea2.setText("Patient ID must be entered");
			}
				else
				{  				
					try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");
				int id = Integer.parseInt(patEntered);
				PreparedStatement statement = con.prepareStatement("Select * from history where patientID = ?");
				statement.setInt(1, id);
				ResultSet result = statement.executeQuery();
				
				displayArea2.setText("Patient ID" + "\t" + "Condition" + "\t" + "Date"+"\t" + "Medication"+"\n");	
				while (result.next()) {
				String name = result.getString("conditionName");
				java.sql.Date date = result.getDate("dateOccurred");
				String medication = result.getString("medication");

				displayArea2.append("" + id 
						+ "\t"  + name  + "\t"  + date+"\t"  + medication +"\n");
				System.out.println("id: " + id + " title: " + name + " cost: " + medication + date);
					}
				
				 con.close();
				 
				}
				catch(SQLException e){
					e.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
	}      

      
	class SaveAndQuitListenerdb implements ActionListener {//objects already saved in database so just exit
		@Override
		public void actionPerformed(ActionEvent event) {
	            System.exit(0);
		}
	} 

	class ReportsListenerdb implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			reportsFramedb();
		}
	}      

	class QuitListenerdb implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			System.exit(0); 
		}
	}      


	public void reportsFramedb(){
		JFrame frame = new JFrame("report frame!" );
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setTitle("Reports");
		frame.setSize(600, 780);
		frame.setLocation(500,150);
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		title5.setOpaque(false);
		title6.setOpaque(false);
		BevelBorder raisedBevel = new BevelBorder(BevelBorder.RAISED);
		
		frame.getContentPane().add(title3);
		frame.getContentPane().add(startDate);
		startDate.setBorder(new TitledBorder("YYYY-MM-DD"));
		frame.getContentPane().add(title4);
		frame.getContentPane().add(endDate);
		endDate.setBorder(new TitledBorder("YYYY-MM-DD"));
	
		frame.getContentPane().add(report1Button);
		report1Button.setBackground(new Color(143, 188, 143));
		report1Button.setBorder(raisedBevel);
		displayArea6.setBorder
		(new TitledBorder(new LineBorder(new Color(95, 158, 160)),
				"List of patients",TitledBorder.CENTER,TitledBorder.TOP));
		JScrollPane p1 = new JScrollPane(displayArea6);
		frame.getContentPane().add(p1);

		frame.getContentPane().add(report2Button);
		report2Button.setBackground(new Color(143, 188, 143));
		report2Button.setBorder(raisedBevel);
		displayArea7.setBorder
		(new TitledBorder(new LineBorder(new Color(95, 158, 160)),
				"List of unpaid patients",TitledBorder.CENTER,TitledBorder.TOP));
		JScrollPane p2 = new JScrollPane(displayArea7);
		frame.getContentPane().add(p2); 

		frame.getContentPane().add(report3Button);
		report3Button.setBackground(new Color(143, 188, 143));
		report3Button.setBorder(raisedBevel);
		displayArea8.setBorder
		(new TitledBorder(new LineBorder(new Color(95, 158, 160)),
				"List of paid patients",TitledBorder.CENTER,TitledBorder.TOP));
		JScrollPane p3 = new JScrollPane(displayArea8);
		frame.getContentPane().add(p3);

		frame.getContentPane().add(title5);
		frame.getContentPane().add(startDate2);
		startDate2.setBorder(new TitledBorder("YYYY-MM-DD"));
		frame.getContentPane().add(title6);
		frame.getContentPane().add(endDate2);
		endDate2.setBorder(new TitledBorder("YYYY-MM-DD"));
		frame.getContentPane().add(procReport);
		procReport.setBorder(new TitledBorder("Procedure ID"));
		frame.getContentPane().add(report4Button);
		report4Button.setBackground(new Color(143, 188, 143));
		report4Button.setBorder(raisedBevel);
		displayArea9.setBorder
		(new TitledBorder(new LineBorder(new Color(95, 158, 160)),
				"List of patients by procedure",TitledBorder.CENTER,TitledBorder.TOP));
		JScrollPane p4 = new JScrollPane(displayArea9);
		frame.getContentPane().add(p4);
		frame.setVisible( true );

		report1Button.addActionListener(new Report1Listenerdb()); 
		report2Button.addActionListener(new Report2Listenerdb());
		report3Button.addActionListener(new Report3Listenerdb());
		report4Button.addActionListener(new Report4Listenerdb());

}
	
	class Report1Listenerdb implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			String startDateEntered = startDate.getText();
			String endDateEntered = endDate.getText();
			if(startDateEntered.length()==0 || endDateEntered.length()==0)
			{
				displayArea6.setText
				("Start date and end date must be entered");
			}
			DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			try{
				java.util.Date startDate = formater.parse(startDateEntered);
				java.util.Date endDate = formater.parse(endDateEntered);
				java.sql.Date sqlstartDate= new java.sql.Date(startDate.getTime());
				java.sql.Date sqlendDate= new java.sql.Date(endDate.getTime());
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");

				PreparedStatement statement = con.prepareStatement
("select * from patient where patientID IN(select patientID from inv where invoiceDate between ? AND ?)");
				statement.setDate(1, sqlstartDate);
				statement.setDate(2, sqlendDate);
				ResultSet result = statement.executeQuery();
				
				displayArea6.setText("ID:" + "\t" + "Name" + "\n");	
				while (result.next()) {
				int id=	  result.getInt("patientID");
				String name = result.getString("patientName");
				String address = result.getString("patientAddress");
				displayArea6.append(id + "\t" + name + "\n");
					}
				
				 con.close();
				 
				}
				catch(SQLException e){
					e.printStackTrace();
				}
				catch (ParseException e) {
					e.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
				}
		}
	}


	
	class Report2Listenerdb implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {  
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");

				PreparedStatement statement = con.prepareStatement
("select p.patientID, p.patientName, sum(i.invoiceAmt) as mySum from patient p, inv i where p.patientID = i.patientID AND i.invoiceIsPaid = 0 group by i.patientID");
				ResultSet result = statement.executeQuery();
				displayArea7.setText("ID:" + "\t" + "Name" + "\t"+"Cost"+"\n");	
				while (result.next()) {
				int id=	  result.getInt("p.patientID");
				String name = result.getString("p.patientName");
				double tot = result.getDouble("mySum");
				displayArea7.append(id + "\t" + name + "\t" +"€"+tot+ "\n");
					}
				
				PreparedStatement statement2 = con.prepareStatement
				("select sum(invoiceAmt) as total from inv");
				ResultSet result2 = statement2.executeQuery();	
				while (result2.next()) {
				double total= result2.getDouble("total");	
				displayArea7.append("\nTotal: "+"\t" + "\t" +"€"+total+ "\n");		
				}
				 con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
				}		
		}
	}
	
	
	
	class Report3Listenerdb implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");

				PreparedStatement statement = con.prepareStatement
("select p.patientID, p.patientName from patient p, inv i where p.patientID = i.patientID AND i.invoiceIsPaid = 1 group by i.invoiceIsPaid");
				ResultSet result = statement.executeQuery();
				displayArea8.setText("ID:" + "\t" + "Name" +"\n");	
				while (result.next()) {
				int id=	  result.getInt("p.patientID");
				String name = result.getString("p.patientName");
				displayArea8.append(id + "\t" + name +"\n");
					}
				 con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
				}				
		}
	}

	
	class Report4Listenerdb implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			String startDateEntered = startDate2.getText();
			String endDateEntered = endDate2.getText();
			String procID = procReport.getText();
			if(startDateEntered.length()==0 || endDateEntered.length()==0||procID.length()==0)
			{
				displayArea9.setText
				("Start date, end date and procedure ID must be entered");
			}  
			DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			int prID = Integer.parseInt(procID);
			try{
				java.util.Date startDate = formater.parse(startDateEntered);
				java.util.Date endDate = formater.parse(endDateEntered);
				java.sql.Date sqlstartDate= new java.sql.Date(startDate.getTime());
				java.sql.Date sqlendDate= new java.sql.Date(endDate.getTime());
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");

				PreparedStatement statement = con.prepareStatement
("select * from patient where patientID IN(select patientID from inv where invoiceDate between ? AND ? AND invoiceID IN(select invoiceID from invoiceprocs where procedureID = ?))");
				statement.setDate(1, sqlstartDate);
				statement.setDate(2, sqlendDate);
				statement.setInt(3, prID);
				ResultSet result = statement.executeQuery();
				
				displayArea9.setText("ID:" + "\t" + "Name" + "\n");	
				while (result.next()) {
				int id=	  result.getInt("patientID");
				String name = result.getString("patientName");
				displayArea9.append(id + "\t" + name + "\n");
					}
				 con.close();	 
				}
				catch(SQLException e){
					e.printStackTrace();
				}
				catch (ParseException e) {
					e.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
				}			
		}
		
	}
	
	
	
	public void detailsFramedb(){
		JFrame frame = new JFrame("Procedures Frame" );
	
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setTitle("Invoice Procedures");
		frame.setSize(600, 400);
		frame.setLocation(500,150);
		frame.getContentPane().setBackground(new Color(95, 158, 160));

		BevelBorder raisedBevel = new BevelBorder(BevelBorder.RAISED);
		displayArea4.setBorder
		(new TitledBorder(new LineBorder(new Color(95, 158, 160)),
				"List of All Procedures",TitledBorder.CENTER,TitledBorder.TOP));

		JScrollPane p1 = new JScrollPane(displayArea4);
		frame.getContentPane().add(p1);
		frame.getContentPane().add(patIDField);
		patIDField.setBorder(new TitledBorder("Patient ID"));
		frame.getContentPane().add(invoiceID2Field);
		invoiceID2Field.setBorder(new TitledBorder("Invoice ID"));
		frame.getContentPane().add(procField);
		procField.setBorder(new TitledBorder("Procedure ID"));
		frame.getContentPane().add(addProcButton);
		addProcButton.setBackground(new Color(143, 188, 143));
		addProcButton.setBorder(raisedBevel);
		frame.getContentPane().add(displayProcButton);
		displayProcButton.setBackground(new Color(143, 188, 143));
		displayProcButton.setBorder(raisedBevel);
		frame.getContentPane().add(deleteProcButton);
		deleteProcButton.setBackground(new Color(143, 188, 143));
		deleteProcButton.setBorder(raisedBevel);
		displayArea5.setBorder
		(new TitledBorder(new LineBorder(new Color(95, 158, 160)),
				"Invoice Procedures",TitledBorder.CENTER,TitledBorder.TOP));
	
		JScrollPane p2 = new JScrollPane(displayArea5);
		frame.getContentPane().add(p2);

		frame.setVisible( true );
		
		
		displayArea4.setText("ID:" + "\t" + "Name" + "\t\t" + "Cost" + "\n" );
		displayArea4.append(proc1.getProcNo() + "\t" + proc1.getProcName()+ "\t\t" + proc1.getProcCost()+ "\n");
		displayArea4.append(proc2.getProcNo() + "\t" + proc2.getProcName()+ "\t" + proc2.getProcCost()+ "\n");
		displayArea4.append(proc3.getProcNo() + "\t" + proc3.getProcName()+ "\t" + proc3.getProcCost()+ "\n");
		displayArea4.append(proc4.getProcNo() + "\t" + proc4.getProcName()+ "\t\t" + proc4.getProcCost()+ "\n");
		displayArea4.append(proc5.getProcNo() + "\t" + proc5.getProcName()+ "\t\t" + proc5.getProcCost()+ "\n");
		displayArea4.append(proc6.getProcNo() + "\t" + proc6.getProcName()+ "\t\t" + proc6.getProcCost()+ "\n");
		displayArea4.append(proc7.getProcNo() + "\t" + proc7.getProcName()+ "\t" + proc7.getProcCost()+ "\n");
		displayArea4.append(proc8.getProcNo() + "\t" + proc8.getProcName()+ "\t" + proc8.getProcCost()+ "\n");
		displayArea4.append(proc9.getProcNo() + "\t" + proc9.getProcName()+ "\t" + proc9.getProcCost()+ "\n");
		displayArea4.append(proc10.getProcNo() + "\t" + proc10.getProcName()+ "\t\t" + proc10.getProcCost()+ "\n");
		displayArea4.append(proc11.getProcNo() + "\t" + proc11.getProcName()+ "\t\t" + proc11.getProcCost()+ "\n");
		displayArea4.append(proc12.getProcNo() + "\t" + proc12.getProcName()+ "\t" + proc12.getProcCost()+ "\n");
		displayArea4.append(proc13.getProcNo() + "\t" + proc13.getProcName()+ "\t" + proc13.getProcCost());
		
		// listeners added to buttons
		addProcButton.addActionListener(new AddProcListenerdb()); 
		displayProcButton.addActionListener(new DisplayProcListenerdb());
		deleteProcButton.addActionListener(new DeleteProcListenerdb());
	
		//   }
}

class AddProcListenerdb implements ActionListener{

@Override
public void actionPerformed(ActionEvent event) {
	double oldamt = 0;
	double procamt = 0;
	String patientID = patIDField.getText();
	String procID = procField.getText();
	String invoiceID = invoiceID2Field.getText();
	if(patientID.length()==0 || procID.length()==0 || patientID.length()==0)
	{
		displayArea5.setText
		("Patient id, invoice id and procedure id must be entered");
	}
	try{
		int prID = Integer.parseInt(procID);
		int id = Integer.parseInt(invoiceID);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");
		PreparedStatement statement = con.prepareStatement
		("insert into invoiceprocs(invoiceID, procedureID) values(?,?)");
		statement.setInt(1, id);
		statement.setInt(2, prID);
		statement.executeUpdate();
		
		PreparedStatement statement2 = con.prepareStatement("Select invoiceAmt from inv where invoiceID = ?");
		statement2.setInt(1, id);
		ResultSet result = statement2.executeQuery();	
		while (result.next()) {
		oldamt = result.getDouble("invoiceAmt");
		System.out.println(oldamt);
			}
		
			PreparedStatement statement3 = con.prepareStatement("Select procCost from proc where procedureID = ?");
		statement3.setInt(1, prID);
		ResultSet result2 = statement3.executeQuery();	
		while (result2.next()) {
		procamt = result2.getDouble(1);
		System.out.println(procamt);
			}
		double newamt = (oldamt+procamt);
		
		PreparedStatement statement4 = con.prepareStatement
		("update inv set invoiceAmt = ? where invoiceID = ?");
		statement4.setDouble(1, newamt);
		statement4.setInt(2, id);
		statement4.executeUpdate();
		patIDField.setText("");
		procField.setText("");
		invoiceID2Field.setText("");
		displayArea5.setText("Procedure added");
		
		 con.close();
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	catch(Exception e){
		e.printStackTrace();
	}					
}
}

class DisplayProcListenerdb implements ActionListener{

@Override
public void actionPerformed(ActionEvent event) {
	String patEntered = patIDField.getText();
	String invEntered = invoiceID2Field.getText();
	if(patEntered.length()==0||invEntered.length()==0)
	{
		displayArea5.setText("Patient ID and Invoice ID must be entered");
	}
	else
	{
		int id = Integer.parseInt(invEntered);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");
			PreparedStatement statement = con.prepareStatement
			("Select * from proc where procedureID IN (Select procedureID from invoiceprocs where invoiceID = ?)");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			
			displayArea5.setText
			("ID" + "\t" + "Procedure Name" + "\t\t" + "Cost"+"\n");
			while (result.next()) {
			String name = result.getString("procName");
			double cost = result.getDouble("procCost");
			int prID = result.getInt("procedureID");
			displayArea5.append("" + prID
					+ "\t"  + name  + "\t\t"  + cost+"\n");
			System.out.println("id: " + id + " title: " + name + " cost: " + cost);
				}
			 con.close();
			 
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
	}
}



class DeleteProcListenerdb implements ActionListener{

@Override
public void actionPerformed(ActionEvent event) {
	double oldamt = 0;
	double procamt = 0;
	String patientID = patIDField.getText();
	String invID = invoiceID2Field.getText();
	String procID = procField.getText();

	if(patientID.length()==0||invID.length()==0||procID.length()==0)
	{
		displayArea5.setText("Patient number, invoice ID and procedure ID must be entered");
	}
	else
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dentist","root","");
			int prid = Integer.parseInt(procID);
			int id = Integer.parseInt(invID);
			PreparedStatement statement = con.prepareStatement
			("delete from invoiceprocs where invoiceID = ? and procedureID = ?");
			statement.setInt(1, id);
			statement.setInt(2, prid);
			statement.executeUpdate();
			
			PreparedStatement statement2 = con.prepareStatement("Select invoiceAmt from inv where invoiceID = ?");
			statement2.setInt(1, id);
			ResultSet result = statement2.executeQuery();	
			while (result.next()) {
			oldamt = result.getDouble("invoiceAmt");
			System.out.println(oldamt);
				}
			
			PreparedStatement statement3 = con.prepareStatement("Select procCost from proc where procedureID = ?");
			statement3.setInt(1, prid);
			ResultSet result2 = statement3.executeQuery();	
			while (result2.next()) {
			procamt = result2.getDouble(1);
			System.out.println(procamt);
				}
			double newamt = (oldamt-procamt);
			
			PreparedStatement statement4 = con.prepareStatement
			("update inv set invoiceAmt = ? where invoiceID = ?");
			statement4.setDouble(1, newamt);
			statement4.setInt(2, id);
			statement4.executeUpdate();
			
			patIDField.setText("");
			invoiceID2Field.setText("");
			procField.setText("");
			displayArea5.setText("Procedure " + Integer.parseInt(procID) + " removed from invoice "
					+ Integer.parseInt(invID));
			
			 con.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
}
}		



	














	
	// the event handlers - save to file & no save

	class PayListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
				
			String patientID = patientIDField3.getText();
			String invID = invoiceIDField.getText();
			String paidEntered = paidField.getText();
			Double change = 0.00;
			if(patientID.length()==0 || invID.length()==0 || paidEntered.length()==0)
			{
				displayArea3.setText
				("Patient id, invoice id and amount to be paid must be entered");
			}

			else
			{  Patient p = list.search(Integer.parseInt(patientID));
			InvoiceList l = p.getInvoiceList();
			Invoice inv = l.search(Integer.parseInt(invID));
			   double invamt = inv.getInvoiceAmt();
			   double payamt = Double.valueOf(paidEntered).doubleValue();
			   double updateAmount = (invamt-payamt);
			   if(updateAmount==0){
				   inv.setInvoicePaid(true);
				   inv.setInvoiceAmt(updateAmount);
			   }
			   else if(updateAmount>0){
				   inv.setInvoiceAmt(updateAmount);
			   }
			   else if(updateAmount<0){
				   inv.setInvoicePaid(true);
				   inv.setInvoiceAmt(0);
				   change = (payamt-invamt);
			   }

			   double displayamt = round2(payamt);
				patientIDField3.setText("");
				invoiceIDField.setText("");
				paidField.setText("");
				if(updateAmount<0){
					displayArea3.setText("Invoice id: " 
							+ invID 
							+ " successfully paid €" + displayamt + " with €" +  change + " change");
				}
				else{
				displayArea3.setText("Invoice id: " 
						+ invID 
						+ " successfully paid €" + displayamt );
				}
				}
		}	
	}
	
	
	private static double round2(double num) {
		 double result = num * 100;
		 result = Math.round(result);
		 result = result / 100;
		 return result;
		 }
	
	
	
	class Details implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){
			if( event.getSource() instanceof JButton ){
				detailsFrame();
			}
		}
	}
	
	

	
	class RemoveInvoiceListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			String patientID = patientIDField3.getText();
			String invID = invoiceIDField.getText();
			Patient p = list.search(Integer.parseInt(patientID));
			InvoiceList l = p.getInvoiceList();
			Invoice inv = l.search(Integer.parseInt(invID));
			if(patientID.length()==0||invID.length()==0)
			{
				displayArea3.setText("Patient number and invoice ID must be entered");
			}
			else if(list.search(Integer.parseInt(patientID)) == null)
			{
				displayArea3.setText
				("Patient number " + patientID + " does not exist");
			}
			else if(l.search(Integer.parseInt(invID)) == null){
				displayArea3.setText
				("invoice id " + invID + " does not exist");
			}
			else
			{
				l.removeInvoice(Integer.parseInt(invID));
				displayArea3.setText("Invoice removed from list "
						+ Integer.parseInt(invID));
			}
		}
		
	}

class EditInvoiceListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		String patientID = patientIDField3.getText();
		String invID = invoiceIDField.getText();
		String dateEntered = invoiceDateField.getText();
		if(patientID.length()==0 || invID.length()==0 || dateEntered.length()==0)
		{
			displayArea3.setText
			("Patient id, invoice id and invoice date must be entered");
		}

		else
		{  Patient p = list.search(Integer.parseInt(patientID));
		InvoiceList l = p.getInvoiceList();
		Invoice inv = l.search(Integer.parseInt(invID));
		    DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");   
			java.util.Date parsedUtilDate;
			try {
				parsedUtilDate = formater.parse(dateEntered);
				inv.setInvoiceDate(parsedUtilDate);
			
			patientIDField3.setText("");
			invoiceIDField.setText("");
			invoiceDateField.setText("");
			displayArea3.setText("Invoice id: " 
					+ invID 
					+ " successfully edited" + l.getTotal());
			}
			catch (ParseException e) {
				
				e.printStackTrace();
			}  
		}
	}
}

	class ListInvoice implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){	
			int i;
			String patEntered = patientIDField3.getText();
			if(patEntered.length()==0)
			{
				displayArea3.setText("Patient ID must be entered");
			}
			else if(list.search(Integer.parseInt(patEntered)) == null)
			{
				displayArea3.setText("Patient List is empty");
			}
			else
			{
				Patient p = list.search(Integer.parseInt(patEntered));
				InvoiceList l = p.getInvoiceList();
				HistoryList h = p.getHistoryList();
				if(p.getInvoiceList().getTotal() == 0)
				{
					displayArea3.setText
					("No invoices have been added for this patient");
				}
				else
				{  
					NumberFormat nf = NumberFormat.getCurrencyInstance();
					String s;
					displayArea3.setText
					("ID" + "\t" + "Amount (to be paid)" + "\t" + "Date"+"\t" + "Paid"+"\n");
					for(i = 1; i <= l.getTotal(); i++)
					{
						double amount;
						Invoice inv = l.getInvoice(i);
						int psize = inv.getProcedureList().getTotal();
						amount = inv.getInvoiceAmt();
						
						int id = l.getInvoice(i).getInvoiceNo();
						if(psize==0){
							amount=0;
						}
						Date date = l.getInvoice(i).getInvoiceDate();
						boolean paid = l.getInvoice(i).isInvoicePaid();
						DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
						String d1 = formater.format(date);
						displayArea3.append("" + id 
								+ "\t"  + amount  + "\t\t"  + d1+"\t"  + paid +"\n");
					}
				}
			}
		}
	}

	class AddInvoice implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event){
	
			String patientID = patientIDField3.getText();
			String dateEntered = invoiceDateField.getText();
			if(patientID.length()==0 || dateEntered.length()==0)
			{
				displayArea3.setText
				("Patient id and invoice date must be entered");
			}
			Patient p = list.search(Integer.parseInt(patientID));
			InvoiceList l = p.getInvoiceList();
			if(p.getInvoiceList().getTotal()==0)
			{
				int patID = Integer.parseInt(patientID);
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");   
				java.util.Date parsedUtilDate;
				try{
					parsedUtilDate = formater.parse(dateEntered);
					int inID = (l.getTotal()+1);
					Invoice in = new Invoice(parsedUtilDate, inID);
					l.add(in);
					patientIDField3.setText("");
					invoiceDateField.setText("");
					displayArea3.setText("Invoice added" + l.getTotal() + inID);
				}
				catch(ParseException e){
					e.printStackTrace();
				}
			}
			else
			{
				int patID = Integer.parseInt(patientID);
				int size = l.getTotal();
				Invoice i1 = l.getInvoice(size);
				int oldID = i1.getInvoiceNo();
				int id = (oldID+1);
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");   
				java.util.Date parsedUtilDate;
				try{
					parsedUtilDate = formater.parse(dateEntered);
					Invoice in = new Invoice(parsedUtilDate, id);
					l.add(in);
					patientIDField3.setText("");
					invoiceDateField.setText("");
					displayArea3.setText("Invoice added" + l.getTotal() + oldID);
				}
				catch(ParseException e){
					e.printStackTrace();
				}
			}
		}      
			
}
	


	class EditListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			String patientID = patientIDField.getText();
			String addressEntered = addressField.getText();
			String phoneEntered = phoneField.getText();
			String nameEntered = nameField.getText();
			if(nameEntered.length()==0 || addressEntered.length()==0 || phoneEntered.length()==0 || patientID.length()==0)
			{
				displayArea1.setText
				("Patient name, address, phone number and ID must be entered");
			}

			else
			{
				int id = Integer.parseInt(patientID);
				Patient p = list.search(id);
				p.setPatientName(nameEntered);
				p.setPatientAdd(addressEntered);
				p.setPatientPhone(phoneEntered);
				nameField.setText("");
				addressField.setText("");
				phoneField.setText("");
				patientIDField.setText("");
				displayArea1.setText("Patient " 
						+ nameEntered 
						+ " successfully edited" + list.getTotal());
			}
		}
	}

	class AddListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			String patientID = patientIDField.getText();
			String addressEntered = addressField.getText();
			String phoneEntered = phoneField.getText();
			String nameEntered = nameField.getText();
			if(nameEntered.length()==0 || addressEntered.length()==0 || phoneEntered.length()==0)
			{
				displayArea1.setText
				("Patient name, address and phone number must be entered");
			}
			else if(list.getTotal()==0)
			{
				Patient p = new Patient(nameEntered, addressEntered, phoneEntered, list.getTotal()+1);
				p.setPatientNo(list.getTotal()+1);
				list.add(p);
				nameField.setText("");
				addressField.setText("");
				phoneField.setText("");
				displayArea1.setText("Patient " 
						+ nameEntered 
						+ " added" + list.getTotal());
			}   

			else
			{
				int size = list.getTotal();
				Patient f = list.getPatient(size);
				int oldID = f.getPatientNo();
				int id = (oldID+1);
				Patient p = new Patient(nameEntered, addressEntered, phoneEntered, id);
				p.setPatientNo(oldID+1);
				list.add(p);
				nameField.setText("");
				addressField.setText("");
				phoneField.setText("");
				patientIDField.setText("");
				displayArea1.setText("Patient " 
						+ nameEntered 
						+ " successfully added" + list.getTotal());
			}
		}
	}      


	class DisplayListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			int i;
			if(list.isEmpty())
			{
				displayArea1.setText("No patients have been added");
			}
			else
			{
				displayArea1.setText("ID:" + "\t" + "Name" + "\n");
				for(i= 1; i <= list.getTotal(); i++)
				{
					displayArea1.append(list.getPatient(i).getPatientNo()
							+ "\t" 
							+ list.getPatient(i).getPatientName() + "\n");
				}
			}
		}
	}      

	class RemoveListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			String idEntered = patientIDField.getText();
			if(idEntered.length()==0)
			{
				displayArea1.setText("Patient number must be entered");
			}
			else if(list.search(Integer.parseInt(idEntered)) == null)
			{
				displayArea1.setText
				("Patient number " + idEntered + " does not exist");
			}
			else
			{
				list.removePatient(Integer.parseInt(idEntered));
				displayArea1.setText("Patient removed from list "
						+ Integer.parseInt(idEntered));
			}
		}
	}      

	class AddHistListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			String patientID = patientIDField2.getText();
			String condEntered = conditionField.getText();
			String dateEntered = conditionDateField.getText();
			String medEntered = medicationField.getText();
			if(patientID.length()==0 || condEntered.length()==0 || dateEntered.length()==0 || medEntered.length()==0)
			{
				displayArea2.setText
				("Patient id, condition, date and medication must be entered");
			}
			Patient p = list.search(Integer.parseInt(patientID));
			HistoryList h = p.getHistoryList();
			if(p.getHistoryList().getTotal()==0)
			{
				int patID = Integer.parseInt(patientID);
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");   
				java.util.Date parsedUtilDate;
				try{
					parsedUtilDate = formater.parse(dateEntered);
					History hNew  = new History(condEntered, parsedUtilDate, medEntered, h.getTotal()+1, patID);
					h.add(hNew);
					patientIDField2.setText("");
					conditionField.setText("");
					conditionDateField.setText("");
					medicationField.setText("");
					displayArea2.setText("History " 
							+ condEntered 
							+ " added" + h.getTotal());
				}
				catch(ParseException e){
					e.printStackTrace();
				}
			}


			else
			{
				int patID = Integer.parseInt(patientID);
				int size = h.getTotal();
				History f1 = h.getHistory(size);
				int oldID = f1.getHistID();
				int id = (oldID+1);
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");   
				java.util.Date parsedUtilDate;
				try{
					parsedUtilDate = formater.parse(dateEntered);
					History hNew  = new History(condEntered, parsedUtilDate, medEntered, id, patID);
					h.add(hNew);
					patientIDField2.setText("");
					conditionField.setText("");
					conditionDateField.setText("");
					medicationField.setText("");
					displayArea2.setText("History " 
							+ condEntered 
							+ " added" + h.getTotal());
				}
				catch(ParseException e){
					e.printStackTrace();
				}
			}
		}      
	}
  

		class RemoveHistListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent event) {
				String patientID = patientIDField2.getText();
				String histID = historyIDField.getText();
				Patient p = list.search(Integer.parseInt(patientID));
			    HistoryList h = p.getHistoryList();
			    History h1 = h.search(Integer.parseInt(histID));
				if(patientID.length()==0||histID.length()==0)
				{
					displayArea2.setText("Patient number and history ID must be entered");
				}
				else if(list.search(Integer.parseInt(patientID)) == null)
				{
					displayArea2.setText
					("Patient number " + patientID + " does not exist");
				}
				else if(h.search(Integer.parseInt(histID)) == null){
					displayArea2.setText
					("History id " + histID + " does not exist");
				}
				else
				{
					h.removeHistory(Integer.parseInt(histID));
					displayArea2.setText("History removed from list "
							+ Integer.parseInt(histID));
				}
			}
		}   
		
		class EditHistListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent event) 
			{
				String patientID = patientIDField2.getText();
				String histID = historyIDField.getText();
				String condEntered = conditionField.getText();
				String dateEntered = conditionDateField.getText();
				String medEntered = medicationField.getText();
				if(patientID.length()==0 || condEntered.length()==0 || dateEntered.length()==0 || medEntered.length()==0 || histID.length()==0)
				{
					displayArea2.setText
					("Patient id, history id, condition, date and medication must be entered");
				}

				else
				{  Patient p = list.search(Integer.parseInt(patientID));
				    HistoryList h = p.getHistoryList();
				    History h1 = h.search(Integer.parseInt(histID));
				    h1.setConditionName(condEntered);
				    h1.setMedication(medEntered);
				    DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");   
					java.util.Date parsedUtilDate;
					try {
						parsedUtilDate = formater.parse(dateEntered);
						h1.setDateOccurred(parsedUtilDate);
					
					nameField.setText("");
					addressField.setText("");
					phoneField.setText("");
					patientIDField.setText("");
					displayArea2.setText("History id: " 
							+ histID 
							+ " successfully edited" + list.getTotal());
					}
					catch (ParseException e) {
						
						e.printStackTrace();
					}  
				}
			}
		}
		
		
		class ListListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent event) {
			
				
				int i;
				String patEntered = patientIDField2.getText();
				if(patEntered.length()==0)
				{
					displayArea2.setText("Patient ID must be entered");
				}
				else if(list.search(Integer.parseInt(patEntered)) == null)
				{
					displayArea2.setText("Patient List is empty");
				}
				else
				{
					Patient p = list.search(Integer.parseInt(patEntered));
					HistoryList h = p.getHistoryList();
					if(p.getHistoryList().getTotal() == 0)
					{
						displayArea2.setText
						("No history has been added for this patient");
					}
					else
					{  
						NumberFormat nf = NumberFormat.getCurrencyInstance();
						String s;
						displayArea2.setText
						("ID" + "\t" + "Condition" + "\t" + "Date"+"\t" + "Medication"+"\n");
						for(i = 1; i <= h.getTotal(); i++)
						{
							int id = h.getHistory(i).getHistID();
							String name = h.getHistory(i).getConditionName();
							Date date = h.getHistory(i).getDateOccurred();
							String med = h.getHistory(i).getMedication();
							DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
							String d1 = formater.format(date);
							displayArea2.append("" + id 
									+ "\t"  + name  + "\t"  + d1+"\t"  + med +"\n");
						}
					}
				}
				
			}
		}      
     
		class SaveAndQuitListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent event) {
		PatientFileHandler.savePatients(list);
				System.exit(0);
			}
		} 

		class ReportsListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent event) {
				reportsFrame();
			}
		}      

		class QuitListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0); 
			}
		}      


		public void reportsFrame(){
			JFrame frame = new JFrame("report frame!" );
			frame.getContentPane().setLayout(new FlowLayout());
			frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			frame.setTitle("Reports");
			frame.setSize(600, 780);
			frame.setLocation(500,150);
			frame.getContentPane().setBackground(new Color(95, 158, 160));
			title5.setOpaque(false);
			title6.setOpaque(false);
			BevelBorder raisedBevel = new BevelBorder(BevelBorder.RAISED);
			
			frame.getContentPane().add(title3);
			frame.getContentPane().add(startDate);
			startDate.setBorder(new TitledBorder("YYYY-MM-DD"));
			frame.getContentPane().add(title4);
			frame.getContentPane().add(endDate);
			endDate.setBorder(new TitledBorder("YYYY-MM-DD"));
		
			frame.getContentPane().add(report1Button);
			report1Button.setBackground(new Color(143, 188, 143));
			report1Button.setBorder(raisedBevel);
			displayArea6.setBorder
			(new TitledBorder(new LineBorder(new Color(95, 158, 160)),
					"List of patients",TitledBorder.CENTER,TitledBorder.TOP));
			JScrollPane p1 = new JScrollPane(displayArea6);
			frame.getContentPane().add(p1);

			frame.getContentPane().add(report2Button);
			report2Button.setBackground(new Color(143, 188, 143));
			report2Button.setBorder(raisedBevel);
			displayArea7.setBorder
			(new TitledBorder(new LineBorder(new Color(95, 158, 160)),
					"List of unpaid patients",TitledBorder.CENTER,TitledBorder.TOP));
			JScrollPane p2 = new JScrollPane(displayArea7);
			frame.getContentPane().add(p2); 

			frame.getContentPane().add(report3Button);
			report3Button.setBackground(new Color(143, 188, 143));
			report3Button.setBorder(raisedBevel);
			displayArea8.setBorder
			(new TitledBorder(new LineBorder(new Color(95, 158, 160)),
					"List of paid patients",TitledBorder.CENTER,TitledBorder.TOP));
			JScrollPane p3 = new JScrollPane(displayArea8);
			frame.getContentPane().add(p3);

			frame.getContentPane().add(title5);
			frame.getContentPane().add(startDate2);
			startDate2.setBorder(new TitledBorder("YYYY-MM-DD"));
			frame.getContentPane().add(title6);
			frame.getContentPane().add(endDate2);
			endDate2.setBorder(new TitledBorder("YYYY-MM-DD"));
			frame.getContentPane().add(procReport);
			procReport.setBorder(new TitledBorder("Procedure ID"));
			frame.getContentPane().add(report4Button);
			report4Button.setBackground(new Color(143, 188, 143));
			report4Button.setBorder(raisedBevel);
			displayArea9.setBorder
			(new TitledBorder(new LineBorder(new Color(95, 158, 160)),
					"List of patients by procedure",TitledBorder.CENTER,TitledBorder.TOP));
			JScrollPane p4 = new JScrollPane(displayArea9);
			frame.getContentPane().add(p4);
			frame.setVisible( true );

			report1Button.addActionListener(new Report1Listener()); 
			report2Button.addActionListener(new Report2Listener());
			report3Button.addActionListener(new Report3Listener());
			report4Button.addActionListener(new Report4Listener());

	}
		
		class Report1Listener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent event) {
				int i;
				for(i=1; i<=temp1.getTotal(); i++){
				temp1.removePatient(i);
				}
				set1.clear();//clears set
				
				String startDateEntered = startDate.getText();
				String endDateEntered = endDate.getText();
				if(startDateEntered.length()==0 || endDateEntered.length()==0)
				{
					displayArea6.setText
					("Start date and end date must be entered");
				}
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");   
				try {
					java.util.Date startDate = formater.parse(startDateEntered);
					java.util.Date endDate = formater.parse(endDateEntered);
				
					for(i = 1; i <= list.getTotal(); i++){
					Patient p = list.getPatient(i);
					int id = p.getPatientNo();
					InvoiceList l = p.getInvoiceList();
					System.out.println("id" +id);
				boolean check = checkInvoices(l, startDate, endDate);//checks invoice date
				if(check==true){
				set1.add(i);//add to set
				}		
					}
				}
				catch (ParseException e) {
					
					e.printStackTrace();
				}
				for (Iterator j = set1.iterator(); j.hasNext();) {
				      Integer integer = (Integer) j.next();
				      Patient p = list.getPatient(integer);
				      temp1.add(p);
				    String name =  list.getPatient(integer).getPatientName();
				      System.out.println("set " + integer + name); 
				    }
				
				displayArea6.setText("ID:" + "\t" + "Name" + "\n");
				for(i= 1; i <= temp1.getTotal(); i++)
				{
					displayArea6.append(temp1.getPatient(i).getPatientNo()
							+ "\t" 
							+ temp1.getPatient(i).getPatientName() + "\n");
				}
				
			}
			
		}

	
			
			
			
		
		
		private static boolean checkInvoices(InvoiceList l, java.util.Date startDate, java.util.Date endDate ){
			boolean status = false;
			for(int i = 1; i <= l.getTotal(); i++){
				Invoice inv = l.getInvoice(i);
				java.util.Date myDate = inv.getInvoiceDate();
				if(myDate.after(startDate) && myDate.before(endDate))
				{  status = true;
					
				}			
				
			}
			return status;
		}
			
		private static boolean checkInvoices2(InvoiceList l){
			boolean status = false;
			for(int i = 1; i <= l.getTotal(); i++){
				Invoice inv = l.getInvoice(i);
				Double amt = inv.getInvoiceAmt();
				if(amt!=0)
				{  status = true;
					
				}			
				
			}
			return status;
		}
		
		private static boolean checkInvoices3(InvoiceList l){
			boolean status = false;
			for(int i = 1; i <= l.getTotal(); i++){
				Invoice inv = l.getInvoice(i);
				Double amt = inv.getInvoiceAmt();
				boolean paid = inv.isInvoicePaid();
				if(amt==0&&paid==true)
				{  status = true;					
				}						
			}
			return status;
		}
		
		class Report2Listener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent event) {
				set2.clear();//clears set
				int i;  
				for(i=1; i<=temp.getTotal(); i++){
					temp.removePatient(i);
					}
				
					for(i = 1; i <= list.getTotal(); i++){
					Patient p = list.getPatient(i);
					int id = p.getPatientNo();
					InvoiceList l = p.getInvoiceList();
					System.out.println("id" +id);
				boolean check = checkInvoices2(l);//checks invoice
				if(check==true){
					
				set2.add(i);//add to set
				set2.size();
				}		
					}
				double total = 0;
				double amt = 0;
				double amt1 = 0;
				int name;
				for (Iterator j = set2.iterator(); j.hasNext();) {
				      Integer integer = (Integer) j.next();
				      Patient p = list.getPatient(integer);
				      temp.add(p);
				      InvoiceList l = p.getInvoiceList();
				      for(int k = 1; k <= l.getTotal(); k++){
							Invoice inv = l.getInvoice(k);
							amt1 = inv.getInvoiceAmt();
							name=		inv.getInvoiceNo();
							
						total += amt1;
						}
				      amt +=amt1;
				      System.out.println("invoice amt" + amt1 + "amty" + amt);			      
				    
				    }
				
				 System.out.println("total for all patients" + total + "total??" + amt);
				System.out.println("temp" +temp.getTotal());
				
				displayArea7.setText("ID:" + "\t" + "Name" + "\t"+"Cost"+"\n");
			for(int g = 1; g<=temp.getTotal(); g++)	{
			Patient p =	temp.getPatient(g);
			int id = p.getPatientNo();
			String patname = p.getPatientName();
			InvoiceList l = p.getInvoiceList();
			System.out.println(p.getPatientName());
			double amount = 0;
			double tot = 0;
			for(i = 1; i <= l.getTotal(); i++){
			Invoice inv =	l.getInvoice(i);
				amount = inv.getInvoiceAmt();
				
			}
			tot += amount;
			System.out.println(p.getPatientName() + tot);
			displayArea7.append(id 
					+ "\t" 
					+ patname + "\t" +"€"+tot
					+ "\n");
			}
			displayArea7.append( 
					"\nTotal: "+"\t" 
					 + "\t" +"€"+total
					+ "\n");
			}
			
		}
		
		
		
		class Report3Listener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent event) {
				//clears set
				int i;  
				for(i=1; i<=temp3.getTotal(); i++){
					temp3.removePatient(i);
					temp3.removePatient(i-1);
					}
				set3.clear();
					for(i = 1; i <= list.getTotal(); i++){
					Patient p = list.getPatient(i);
					int id = p.getPatientNo();
					InvoiceList l = p.getInvoiceList();
					System.out.println("id" +id);
				boolean check = checkInvoices3(l);//checks invoice
				if(check==true){
					
				set3.add(i);//add to set
			System.out.println(	set3.size());
				}		
					}
				int name;
				for (Iterator j = set3.iterator(); j.hasNext();) {
				      Integer integer = (Integer) j.next();
				      Patient p = list.getPatient(integer);
				      temp3.add(p);
				     System.out.println(temp3.getTotal() + p.getPatientName() + integer);
				    }
	
				displayArea8.setText("ID:" + "\t" + "Name" +"\n");
			for(int g = 1; g<=temp3.getTotal(); g++)	{
			Patient p =	temp3.getPatient(g);
			int id = p.getPatientNo();
			String patname = p.getPatientName();
			System.out.println(p.getPatientName() + temp3.getTotal());
			displayArea8.append(id 
					+ "\t" 
					+ patname 
					+ "\n");
			}
				
			}
			
		}

		
		class Report4Listener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent event) {
				displayArea9.setText
				("");
			
				int i;
				for(i=1; i<=temp4.getTotal(); i++){
				temp4.removePatient(i);
				}
				set4.clear();//clears set
				
				String startDateEntered = startDate2.getText();
				String endDateEntered = endDate2.getText();
				String procID = procReport.getText();
				if(startDateEntered.length()==0 || endDateEntered.length()==0||procID.length()==0)
				{
					displayArea9.setText
					("Start date, end date and procedure ID must be entered");
				}
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");   
				try {
					java.util.Date startDate = formater.parse(startDateEntered);
					java.util.Date endDate = formater.parse(endDateEntered);
					int pID = Integer.parseInt(procID);
					for(i = 1; i <= list.getTotal(); i++){
					Patient p = list.getPatient(i);
					int id = p.getPatientNo();
					InvoiceList l = p.getInvoiceList();
					System.out.println("id" +id);
				boolean check = checkInvoicesProc(l, startDate, endDate, pID);//checks invoice date & procedure
				if(check==true){
				set4.add(i);//add to set
				}		
					}
				}
				catch (ParseException e) {
					
					e.printStackTrace();
				}
				for (Iterator j = set4.iterator(); j.hasNext();) {
				      Integer integer = (Integer) j.next();
				      Patient p = list.getPatient(integer);
				      temp4.add(p);
				    String name =  list.getPatient(integer).getPatientName();
				      System.out.println("set " + integer + name);  //to console
				    }
				
				displayArea9.setText("ID:" + "\t" + "Name" + "\n");
				for(i= 1; i <= temp4.getTotal(); i++)
				{
					displayArea9.append(temp4.getPatient(i).getPatientNo()
							+ "\t" 
							+ temp4.getPatient(i).getPatientName() + "\n");
				}
				
			}
			
		}
		
		private static boolean checkInvoicesProc(InvoiceList l, java.util.Date startDate, java.util.Date endDate, int id){
			boolean status = false;
			for(int i = 1; i <= l.getTotal(); i++){
				Invoice inv = l.getInvoice(i);
				java.util.Date myDate = inv.getInvoiceDate();
				ProcedureList pList = inv.getProcedureList();
				for(i = 1; i <= pList.getTotal(); i++){
					
					int id2 = pList.getProcedure(i).getProcNo();
					if(myDate.after(startDate) && myDate.before(endDate) && id2==id)
					{  						
						status = true;
					}
					
				}
										
			}
			return status;
		}
		
		
		
		
		public void detailsFrame(){
			JFrame frame = new JFrame("Procedures Frame" );
		
			frame.getContentPane().setLayout(new FlowLayout());

			frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			frame.setTitle("Invoice Procedures");
			frame.setSize(600, 400);
			frame.setLocation(500,150);
			frame.getContentPane().setBackground(new Color(95, 158, 160));

			BevelBorder raisedBevel = new BevelBorder(BevelBorder.RAISED);
			displayArea4.setBorder
			(new TitledBorder(new LineBorder(new Color(95, 158, 160)),
					"List of All Procedures",TitledBorder.CENTER,TitledBorder.TOP));

			JScrollPane p1 = new JScrollPane(displayArea4);
			frame.getContentPane().add(p1);
			frame.getContentPane().add(patIDField);
			patIDField.setBorder(new TitledBorder("Patient ID"));
			frame.getContentPane().add(invoiceID2Field);
			invoiceID2Field.setBorder(new TitledBorder("Invoice ID"));
			frame.getContentPane().add(procField);
			procField.setBorder(new TitledBorder("Procedure ID"));
			frame.getContentPane().add(addProcButton);
			addProcButton.setBackground(new Color(143, 188, 143));
			addProcButton.setBorder(raisedBevel);
			frame.getContentPane().add(displayProcButton);
			displayProcButton.setBackground(new Color(143, 188, 143));
			displayProcButton.setBorder(raisedBevel);
			frame.getContentPane().add(deleteProcButton);
			deleteProcButton.setBackground(new Color(143, 188, 143));
			deleteProcButton.setBorder(raisedBevel);
			displayArea5.setBorder
			(new TitledBorder(new LineBorder(new Color(95, 158, 160)),
					"Invoice Procedures",TitledBorder.CENTER,TitledBorder.TOP));
			JScrollPane p2 = new JScrollPane(displayArea5);
			frame.getContentPane().add(p2);
	
			frame.setVisible( true );
			
			
			displayArea4.setText("ID:" + "\t" + "Name" + "\t\t" + "Cost" + "\n" );
			displayArea4.append(proc1.getProcNo() + "\t" + proc1.getProcName()+ "\t\t" + proc1.getProcCost()+ "\n");
			displayArea4.append(proc2.getProcNo() + "\t" + proc2.getProcName()+ "\t" + proc2.getProcCost()+ "\n");
			displayArea4.append(proc3.getProcNo() + "\t" + proc3.getProcName()+ "\t" + proc3.getProcCost()+ "\n");
			displayArea4.append(proc4.getProcNo() + "\t" + proc4.getProcName()+ "\t\t" + proc4.getProcCost()+ "\n");
			displayArea4.append(proc5.getProcNo() + "\t" + proc5.getProcName()+ "\t\t" + proc5.getProcCost()+ "\n");
			displayArea4.append(proc6.getProcNo() + "\t" + proc6.getProcName()+ "\t\t" + proc6.getProcCost()+ "\n");
			displayArea4.append(proc7.getProcNo() + "\t" + proc7.getProcName()+ "\t" + proc7.getProcCost()+ "\n");
			displayArea4.append(proc8.getProcNo() + "\t" + proc8.getProcName()+ "\t" + proc8.getProcCost()+ "\n");
			displayArea4.append(proc9.getProcNo() + "\t" + proc9.getProcName()+ "\t" + proc9.getProcCost()+ "\n");
			displayArea4.append(proc10.getProcNo() + "\t" + proc10.getProcName()+ "\t\t" + proc10.getProcCost()+ "\n");
			displayArea4.append(proc11.getProcNo() + "\t" + proc11.getProcName()+ "\t\t" + proc11.getProcCost()+ "\n");
			displayArea4.append(proc12.getProcNo() + "\t" + proc12.getProcName()+ "\t" + proc12.getProcCost()+ "\n");
			displayArea4.append(proc13.getProcNo() + "\t" + proc13.getProcName()+ "\t" + proc13.getProcCost());
			
			// listeners given to buttons
			addProcButton.addActionListener(new AddProcListener()); 
			displayProcButton.addActionListener(new DisplayProcListener());
			deleteProcButton.addActionListener(new DeleteProcListener());

	}

class AddProcListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent event) {
		String patientID = patIDField.getText();
		String procID = procField.getText();
		String invoiceID = invoiceID2Field.getText();
		if(patientID.length()==0 || procID.length()==0 || patientID.length()==0)
		{
			displayArea5.setText
			("Patient id, invoice id and procedure id must be entered");
		}
		Patient p = list.search(Integer.parseInt(patientID));
		InvoiceList l = p.getInvoiceList();
		Invoice inv = l.search(Integer.parseInt(invoiceID));
		Double amt = inv.getInvoiceAmt();
		int prID = Integer.parseInt(procID);
		ProcedureList prList =	inv.getProcedureList();
		if(prID==1){
		double addamt = proc1.getProcCost();
		double newamt = (amt+addamt);
		inv.setInvoiceAmt(newamt);
		prList.add(proc1);
		}
		else if(prID==2){
			double addamt = proc2.getProcCost();
			double newamt = (amt+addamt);
			inv.setInvoiceAmt(newamt);
			prList.add(proc2);
		}
		else if(prID==3){
			double addamt = proc3.getProcCost();
			double newamt = (amt+addamt);
			inv.setInvoiceAmt(newamt);
			prList.add(proc3);
		}
		else if(prID==4){
			double addamt = proc4.getProcCost();
			double newamt = (amt+addamt);
			inv.setInvoiceAmt(newamt);
			prList.add(proc4);
		}
		else if(prID==5){
			double addamt = proc5.getProcCost();
			double newamt = (amt+addamt);
			inv.setInvoiceAmt(newamt);
			prList.add(proc5);
		}
		else if(prID==6){
			double addamt = proc6.getProcCost();
			double newamt = (amt+addamt);
			inv.setInvoiceAmt(newamt);
			prList.add(proc6);
		}
		else if(prID==7){
			double addamt = proc7.getProcCost();
			double newamt = (amt+addamt);
			inv.setInvoiceAmt(newamt);
			prList.add(proc7);
		}
		else if(prID==8){
			double addamt = proc8.getProcCost();
			double newamt = (amt+addamt);
			inv.setInvoiceAmt(newamt);
			prList.add(proc8);
		}
		else if(prID==9){
			double addamt = proc9.getProcCost();
			double newamt = (amt+addamt);
			inv.setInvoiceAmt(newamt);
			prList.add(proc9);
		}
		else if(prID==10){
			double addamt = proc10.getProcCost();
			double newamt = (amt+addamt);
			inv.setInvoiceAmt(newamt);
			prList.add(proc10);
		}
		else if(prID==11){
			double addamt = proc11.getProcCost();
			double newamt = (amt+addamt);
			inv.setInvoiceAmt(newamt);
			prList.add(proc11);
		}
		else if(prID==12){
			double addamt = proc12.getProcCost();
			double newamt = (amt+addamt);
			inv.setInvoiceAmt(newamt);
			prList.add(proc12);
		}
		else if(prID==13){
			double addamt = proc13.getProcCost();
			double newamt = (amt+addamt);
			inv.setInvoiceAmt(newamt);
			prList.add(proc13);
		}	
				patIDField.setText("");
				invoiceID2Field.setText("");
				procField.setText("");
				displayArea5.setText("Procedure added");		
	}
	
}

class DisplayProcListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent event) {
		int i;
		String patEntered = patIDField.getText();
		String invEntered = invoiceID2Field.getText();
		if(patEntered.length()==0||invEntered.length()==0)
		{
			displayArea5.setText("Patient ID and Invoice ID must be entered");
		}
		else if(list.search(Integer.parseInt(patEntered)) == null)
		{
			displayArea5.setText("Patient List is empty");
		}
		else
		{
			Patient p = list.search(Integer.parseInt(patEntered));
			InvoiceList l = p.getInvoiceList();
			Invoice inv = l.search(Integer.parseInt(invEntered));
			ProcedureList prList = inv.getProcedureList();
			if(inv.getProcedureList().getTotal()==0)
			{
				displayArea5.setText
				("No procedures have been added to this invoice");
			}
			else
			{  
				displayArea5.setText
				("ID" + "\t" + "Procedure Name" + "\t" + "Cost"+"\n");
				for(i = 1; i <= prList.getTotal(); i++)
				{
					Procedure pr = prList.getProcedure(i); 
					int id = prList.getProcedure(i).getProcNo();
					String name = prList.getProcedure(i).getProcName();
					Double cost = prList.getProcedure(i).getProcCost();
					displayArea5.append("" + id 
							+ "\t"  + name  + "\t\t"  + cost+"\n");
				}
			}
		}
		
	}
	
}
class DeleteProcListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent event) {
		String patientID = patIDField.getText();
		String invID = invoiceID2Field.getText();
		String procID = procField.getText();
		Patient p = list.search(Integer.parseInt(patientID));
		InvoiceList l = p.getInvoiceList();
		Invoice inv = l.search(Integer.parseInt(invID));
		ProcedureList prList = inv.getProcedureList();
		Procedure pr = prList.search(Integer.parseInt(procID));
		if(patientID.length()==0||invID.length()==0||procID.length()==0)
		{
			displayArea5.setText("Patient number, invoice ID and procedure ID must be entered");
		}
		else if(list.search(Integer.parseInt(patientID)) == null)
		{
			displayArea5.setText
			("Patient number " + patientID + " does not exist");
		}
		else if(l.search(Integer.parseInt(invID)) == null){
			displayArea5.setText
			("Invoice id " + invID + " does not exist");
		}
		else if(prList.search(Integer.parseInt(procID))==null){
			displayArea5.setText
			("Procedure id " + invID + " does not exist");
		}
		else
		{
			double oldamt = inv.getInvoiceAmt();
			double procamt = pr.getProcCost();
			double newamt = (oldamt-procamt);
			inv.setInvoiceAmt(newamt);
			prList.removeProcedure(Integer.parseInt(procID));
			
			displayArea5.setText("Procedure " + Integer.parseInt(procID) + " removed from invoice "
					+ Integer.parseInt(invID));
		}
		
		
		
		
	}
	
}		

	}   

