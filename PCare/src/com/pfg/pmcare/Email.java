package com.pfg.pmcare;

import com.pfg.pcare.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Email extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email);
		
		EditText toMail=(EditText)findViewById(R.id.recipient);
		toMail.setText("PGSHRHelpdesk@exchange.principal.com");
		toMail.setEnabled(false);
	}
	
	public void goToHomePage(View view){
		
		Intent homeIntent = new Intent(getApplicationContext(),Home.class);
		homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(homeIntent);
}
}
