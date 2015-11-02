package com.pfg.pmcare;

import menu.HealthMainActivity;
import menu.WorkMainActivity;

import com.pfg.pcare.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Home extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		ImageView maternityPolicy = (ImageView) findViewById(R.id.policy_id);
		maternityPolicy.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("clicked on policy icon");
				
			//	Intent email = new Intent(getApplicationContext(),Policy.class);
				Intent email = new Intent(getApplicationContext(),WorkMainActivity.class);
				email.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(email);
			}
		});
		
		
		ImageView impUpdates = (ImageView) findViewById(R.id.important_updates_id);
		impUpdates.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("clicked on updates icon");
				
			//	Intent email = new Intent(getApplicationContext(),ImpUpdates.class);
			//	Intent email = new Intent(getApplicationContext(),FetchEmailFromServer.class);
			
				//Intent email = new Intent(getApplicationContext(),ServerEmailMainActivity.class);
				Intent email = new Intent(getApplicationContext(),HealthMainActivity.class);
				email.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(email);
			}
		});
		
		
		}
	
	
	public void goToReadEmail(View view){		
		Intent homeIntent = new Intent(getApplicationContext(),ServerEmailMainActivity.class);
		homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(homeIntent);
}

	public void goToHomePage(View view){		
		Intent homeIntent = new Intent(getApplicationContext(),Home.class);
		homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(homeIntent);
}
	
	public void goToEmailScreen(View view){		
		Intent email = new Intent(getApplicationContext(),Email.class);
		email.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(email);
}	
	

	public void goToCallHRScreen(View view){		
		Intent callHRIntent = new Intent(Intent.ACTION_DIAL);
		callHRIntent.setData(Uri.parse("tel:02066214000"));
		startActivity(callHRIntent);
}
	
	public void goToDidYouKnowScreen(View view){
		Intent imageSlider = new Intent(getApplicationContext(),ImageSliderMain.class);
		imageSlider.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	startActivity(imageSlider);
    }
	
}
