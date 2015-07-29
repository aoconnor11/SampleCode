package com.bluemetrix.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.bluemetrix.R;
import com.bluemetrix.wheel.widget.BloodTypeActivity;
import com.bluemetrix.wheel.widget.SelectAgeActivity;

import com.slidingmenu.example.fragments.FragmentChangeActivity;

public class SignUpView extends SherlockActivity{

	EditText nameText;
	EditText passText;
	EditText confirmText;
	EditText emailText;
	CharSequence nameChar;
	String name = "";
	CharSequence passChar;
	String pass = "";
	CharSequence confirmChar;
	String confirm = "";
	CharSequence emailChar;
	String email = "";
	Button male;
	Button female;
	Boolean gender;
	TextView bloodText;
	TextView ageText;
	ImageView bloodImage;
	ImageView ageImage;
	int option = 0;
	int settingsOption = 0;
	String bloodString = "";
	String ageString = "";
	String nameString = "";
	String passString = "";
	String confirmString = "";
	String emailString = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.register_layout);
		setTitle("");


		String bloodDefault = (""+ R.string.bloodType); 
		String ageDefault = ("" + R.string.ageRange);


		Intent i = getIntent();
		Bundle extras = i.getExtras();
		option = extras.getInt("option", -1);//default
		bloodString = extras.getString("bloodType", bloodDefault);
		ageString = extras.getString("ageRange", ageDefault);
		nameString = extras.getString("name", null);
		passString = extras.getString("pass", null);
		confirmString = extras.getString("confirm", null);
		emailString = extras.getString("email", null);
		gender = extras.getBoolean("gender"); 	 


		System.out.println("extras: " + nameString);


		nameText = (EditText) findViewById(R.id.editTextName);
		passText = (EditText) findViewById(R.id.editTextPassword);
		confirmText = (EditText) findViewById(R.id.editTextConfirm);
		emailText = (EditText) findViewById(R.id.editTextEmail);
		male = (Button) findViewById(R.id.buttonMale);
		female = (Button) findViewById(R.id.buttonFemale);


		bloodText = (TextView) findViewById(R.id.textViewBloodType);
		ageText = (TextView) findViewById(R.id.textViewAgeRange);
		bloodImage = (ImageView) findViewById(R.id.imageViewBloodType);
		ageImage = (ImageView) findViewById(R.id.imageViewAgeRange);

		if(option==2 && ageString.equals(ageDefault)){//bloodType, default age
			bloodText.setText(bloodString);
			nameText.setText(nameString);
			passText.setText(passString);
			confirmText.setText(confirmString);
			emailText.setText(emailString);
			if (gender != null)
			{
				if(gender==true){
					male.setSelected(false);
					female.setSelected(true);
				}
				else{
					female.setSelected(false);
					male.setSelected(true);
				}
			}      			
		}
		else if(option==2 && !ageString.equals(ageDefault)){//bloodtype and age already selected
			bloodText.setText(bloodString);
			ageText.setText(ageString);
			nameText.setText(nameString);
			passText.setText(passString);
			confirmText.setText(confirmString);
			emailText.setText(emailString);

			if (gender != null)
			{
				if(gender==true){
					male.setSelected(false);
					female.setSelected(true);
				}
				else{
					female.setSelected(false);
					male.setSelected(true);
				}
			}
		}







		else if(option==3 && bloodString.equals(bloodDefault)){//age range, default blood type      			
			ageText.setText(ageString);
			nameText.setText(nameString);
			passText.setText(passString);
			confirmText.setText(confirmString);
			emailText.setText(emailString);
			if (gender != null)
			{
				if(gender==true){
					male.setSelected(false);
					female.setSelected(true);
				}
				else{
					female.setSelected(false);
					male.setSelected(true);
				}
			}	
		}

		else if(option==3 && !bloodString.equals(bloodDefault)){//age range and blood type already selected
			bloodText.setText(bloodString);
			ageText.setText(ageString);
			nameText.setText(nameString);
			passText.setText(passString);
			confirmText.setText(confirmString);
			emailText.setText(emailString);
			if (gender != null)
			{
				if(gender==true){
					male.setSelected(false);
					female.setSelected(true);
				}
				else{
					female.setSelected(false);
					male.setSelected(true);
				}
			}
		}










		nameText.setOnKeyListener(new OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {

				nameChar = nameText.getText();
				name = nameChar.toString();

				nameString = name;

				return false;
			}
		});

		passText.setOnKeyListener(new OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {

				passChar = passText.getText();
				pass = passChar.toString();
				passString = pass;

				return false;
			}
		});

		confirmText.setOnKeyListener(new OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {

				confirmChar = confirmText.getText();
				confirm = confirmChar.toString();
				confirmString = confirm;

				return false;
			}
		});

		emailText.setOnKeyListener(new OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {

				emailChar = emailText.getText();
				email = emailChar.toString();
				emailString = email;

				return false;
			}
		});




		male.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//back to login page

				v.setSelected(true);
				female.setSelected(false);
				gender = false;//false = male		
			}
		});


		female.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//back to login page
				v.setSelected(true);
				male.setSelected(false);
				gender = true;//true = female
			}
		});





		bloodImage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//go to blood type selection page    			
				Intent in = new Intent(SignUpView.this, BloodTypeActivity.class);
				in.putExtra("ageRange", ageString);
				in.putExtra("name", nameString);
				in.putExtra("pass", passString);
				in.putExtra("confirm", confirmString);
				in.putExtra("email", emailString);
				in.putExtra("gender", gender);
				startActivity(in);    			
			}
		});


		ageImage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//go to age range selection page     			
				Intent in = new Intent(SignUpView.this, SelectAgeActivity.class);
				in.putExtra("bloodType", bloodString);
				in.putExtra("name", nameString);
				in.putExtra("pass", passString);
				in.putExtra("confirm", confirmString);
				in.putExtra("email", emailString);
				in.putExtra("gender", gender);
				startActivity(in);    			
			}
		});







		//Inflate the custom view
		View customNav = LayoutInflater.from(this).inflate(R.layout.titlebar_register, null);

		Button cancel = (Button) customNav.findViewById(R.id.buttonCancelRegister);
		Button submit = (Button) customNav.findViewById(R.id.buttonSubmitRegister);  

		submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//go to home page
				boolean check;	
				check =	checkForm();
				System.out.println("checkForm: " + check);

				if(check==true){    	
					registerPerson();
					Intent in = new Intent(SignUpView.this, FragmentChangeActivity.class);
					startActivity(in);    			
				}
			}
		});  


		cancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//back to login page   			
				Intent in = new Intent(SignUpView.this, LoginView.class);
				startActivity(in);    			
			}
		});

		//Attach to the action bar
		getSupportActionBar().setCustomView(customNav);
		getSupportActionBar().setDisplayShowCustomEnabled(true);         
	}






	public void registerPerson(){

		//register details- email/password/name/gender/blood type/age

	}




	public boolean checkForm(){		

		boolean formOK = false;	

		if(pass.equals(confirm) && !name.equals("") && !pass.equals("") && !confirm.equals("") && !email.equals("")){
			formOK = true;
			//send info to server to register person
		}
		else if (!pass.equals(confirm)&& !name.equals("") && !pass.equals("") && !confirm.equals("") && !email.equals("")){
			//passwords don't match
			Toast.makeText(this, "Please confirm the correct password", Toast.LENGTH_SHORT).show();
		}
		else if(name.equals("")){
			Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
		}
		else if(pass.equals("")){
			Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
		}
		else if(confirm.equals("")){
			Toast.makeText(this, "Please enter your password confirmation", Toast.LENGTH_SHORT).show();
		}
		else if(email.equals("")){
			Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
		}		
		return formOK;
	}
}
