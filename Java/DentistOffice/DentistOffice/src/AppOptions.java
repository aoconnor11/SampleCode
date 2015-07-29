import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import javax.swing.border.*;



public class AppOptions extends JFrame{

	private  JButton noSaveButton = new JButton("  Run Application  ");
	private  JButton fileButton = new JButton("  Run Application (File)  ");
	private  JButton databaseButton = new JButton("  Run Application (Database)  ");
	private  JButton exitButton = new JButton("  Exit  ");
	private  JLabel title = new JLabel("Welcome to the Dental Office Application");
	private  JLabel title2 = new JLabel("Please choose from one of the options below");

	public AppOptions(){   

		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Welcome to Dental Application");
		setSize(350,150);
		setLocation(450,300);
		getContentPane().setBackground(new Color(95, 158, 160));
		BevelBorder raisedBevel = new BevelBorder(BevelBorder.RAISED);
		title.setOpaque(false);
		title2.setOpaque(false);
		getContentPane().add(title);
		getContentPane().add(title2);
		getContentPane().add(noSaveButton);
		noSaveButton.setBackground(new Color(143, 188, 143));
		noSaveButton.setBorder(raisedBevel);
		getContentPane().add(fileButton);
		fileButton.setBackground(new Color(143, 188, 143));
		fileButton.setBorder(raisedBevel);
		getContentPane().add(databaseButton);
		databaseButton.setBackground(new Color(143, 188, 143));
		databaseButton.setBorder(raisedBevel);
		getContentPane().add(exitButton);
		exitButton.setBackground(new Color(143, 188, 143));
		exitButton.setBorder(raisedBevel);

		noSaveButton.addActionListener(new NoSaveListener());
		fileButton.addActionListener(new FileListener());
		databaseButton.addActionListener(new DatabaseListener());
		exitButton.addActionListener(new ExitListener());
		setVisible(true); 
	}




	class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if( event.getSource() instanceof JButton ){
				System.exit(0);
			}
		}
	}

	class DatabaseListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if( event.getSource() instanceof JButton ){

				new  App("database");
			}
		}
	}

	class FileListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if( event.getSource() instanceof JButton ){

				new App("file");

			}
		}
	}

	class NoSaveListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if( event.getSource() instanceof JButton ){

				new App("no");
			}
		}
	}
}
