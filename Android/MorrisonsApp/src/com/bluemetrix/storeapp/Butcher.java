package com.bluemetrix.storeapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Butcher extends Activity{

	private ArrayList <StoreItem> myList;
	private Button shoppingList;
	private ImageView bacon;
	private ImageView chicken;
	private ImageView ham;
	private ImageView lamb;
	private ImageView porkchops;
	private ImageView roastbeef;
	private ImageView sausages;
	private ImageView steak;
	private int points;
	
	//Quantity
	private int baconCount = 0;
	private int chickenCount = 0;
	private int hamCount = 0;
	private int lambCount = 0;
	private int porkChopsCount = 0;
	private int roastBeefCount = 0;
	private int sausagesCount = 0;
	private int steakCount = 0;
	private StoreItem baconItem;
	private StoreItem chickenItem;
	private StoreItem hamItem;
	private StoreItem lambItem;
	private StoreItem porkChopsItem;
	private StoreItem roastBeefItem;
	private StoreItem sausagesItem;
	private StoreItem steakItem;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.meat_poultry);
		
		 shoppingList = (Button) findViewById(R.id.buttonList);
		
		 myList = getIntent().getParcelableArrayListExtra ("list");
		 points = getIntent().getIntExtra("points", 0);
	
		 bacon = (ImageView) findViewById(R.id.ImageView08);		 
		 chicken = (ImageView) findViewById(R.id.ImageView03);
		 ham = (ImageView) findViewById(R.id.imageView02);
		 lamb = (ImageView) findViewById(R.id.ImageView04);
		 porkchops = (ImageView) findViewById(R.id.ImageView02);
		 roastbeef = (ImageView) findViewById(R.id.ImageView07);
		sausages = (ImageView) findViewById(R.id.ImageView06);
		steak = (ImageView) findViewById(R.id.ImageView01);
		

		 
		 steak.setOnClickListener(new OnClickListener() 
	        {
	    		@Override
	    		public void onClick(View v)
	    		{	
	    				steakCount++;
	    		  		steakItem = new StoreItem(R.drawable.steak, "Steak", 51,steakCount, "");	
	    		  		Toast.makeText(Butcher.this, "Steak added to shopping list", Toast.LENGTH_SHORT).show();
	    		}
	     });
		 
		 sausages.setOnClickListener(new OnClickListener() 
	        {
	    		@Override
	    		public void onClick(View v)
	    		{	
	    				sausagesCount++;
	    		  		sausagesItem = new StoreItem(R.drawable.sausages, "Sausages", 50, sausagesCount,"");	
	    		  		Toast.makeText(Butcher.this, "Sausages added to shopping list", Toast.LENGTH_SHORT).show();
	    		}
	     });
		
		 roastbeef.setOnClickListener(new OnClickListener() 
	        {
	    		@Override
	    		public void onClick(View v)
	    		{	
	    				roastBeefCount++;
	    		  		roastBeefItem = new StoreItem(R.drawable.roastbeef, "Roast Beef", 49,roastBeefCount, "");	
	    		  		Toast.makeText(Butcher.this, "Roast beef added to shopping list", Toast.LENGTH_SHORT).show();
	    		}
	     });
		 
		 porkchops.setOnClickListener(new OnClickListener() 
	        {
	    		@Override
	    		public void onClick(View v)
	    		{	
	    				porkChopsCount++;
	    		  		porkChopsItem = new StoreItem(R.drawable.porkchops, "Pork", 48, porkChopsCount,"");	
	    		  		Toast.makeText(Butcher.this, "Pork chops added to shopping list", Toast.LENGTH_SHORT).show();
	    		}
	     });
		 
		 lamb.setOnClickListener(new OnClickListener() 
	        {
	    		@Override
	    		public void onClick(View v)
	    		{	
	    				lambCount++;
	    		  		lambItem = new StoreItem(R.drawable.lambchops, "Lamb Chops", 47,lambCount, "");	
	    		  		Toast.makeText(Butcher.this, "Lamb chops added to shopping list", Toast.LENGTH_SHORT).show();
	    		}
	     });
		 
		 ham.setOnClickListener(new OnClickListener() 
	        {
	    		@Override
	    		public void onClick(View v)
	    		{	
	    				hamCount++;
	    		  		hamItem = new StoreItem(R.drawable.ham, "Ham", 46, hamCount,"");	
	    		  		Toast.makeText(Butcher.this, "Ham added to shopping list", Toast.LENGTH_SHORT).show();
	    		}
	     });
		 
		 
		 chicken.setOnClickListener(new OnClickListener() 
	        {
	    		@Override
	    		public void onClick(View v)
	    		{	
	    				chickenCount++;
	    		  		chickenItem = new StoreItem(R.drawable.chicken, "Chicken", 45,chickenCount, "");	
	    		  		Toast.makeText(Butcher.this, "Chicken added to shopping list", Toast.LENGTH_SHORT).show();
	    		}
	     });
		 
		   bacon.setOnClickListener(new OnClickListener() 
	        {
	    		@Override
	    		public void onClick(View v)
	    		{	
	    				baconCount++;
	    		  		baconItem = new StoreItem(R.drawable.bacon, "Bacon", 44,baconCount, "");	
	    		  		Toast.makeText(Butcher.this, "Bacon added to shopping list", Toast.LENGTH_SHORT).show();
	    		}
	     });
		 
		 

		 
		 shoppingList.setOnClickListener(new OnClickListener() 
	        {
	    		@Override
	    		public void onClick(View v)
	    		{	
	    			if(baconCount!=0){	 
	    				 myList.add(baconItem);
	    			 }
	    			if(hamCount!=0){	 
	    				 myList.add(hamItem);
	    			 }
	    			if(chickenCount!=0){	 
	    				 myList.add(chickenItem);
	    			 }
	    			if(lambCount!=0){	 
	    				 myList.add(lambItem);
	    			 }
	    			if(porkChopsCount!=0){	 
	    				 myList.add(porkChopsItem);
	    			 }
	    			if(roastBeefCount!=0){	 
	    				 myList.add(roastBeefItem);
	    			 }
	    			if(sausagesCount!=0){	 
	    				 myList.add(sausagesItem);
	    			 }
	    			if(steakCount!=0){	 
	    				 myList.add(steakItem);
	    			 }

	    			
	    			Intent in = new Intent(Butcher.this, ShoppingList.class);
	    			
	    			ArrayList<StoreItem> sendList = new ArrayList <StoreItem>();
	    			for(int i=0; i<myList.size(); i++){
	    				sendList.add(myList.get(i));
	    			}
	    			 if (sendList.size()==0){
	    				 in.putExtra("option", 1);
	    				 in.putExtra("points", points);
	    			 }
	    			 else{
	    			in.putExtra("option", 3);
	    			 in.putExtra("points", points);
	    			 in.putParcelableArrayListExtra("list", sendList);//send array of storeitems
	    			 }
	    		   
	            	startActivity(in);    			
	    		}
	     });
		 
	
	
	}
}
