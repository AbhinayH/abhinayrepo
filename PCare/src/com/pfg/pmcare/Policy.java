package com.pfg.pmcare;

import com.pfg.pcare.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Policy extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_policy);
		
		TextView policy=(TextView)findViewById(R.id.policyId); 
		
		
		 String text="\n\nThis article should enable you understand about the maternity benefits that we as a group provide to our female employees."+ 
				 "\n\n * Women employees are entitled with 12 weeks of paid leave."+ 
				 "\n\n * 7.5 leaves will be added to the employee's account during this period."+
				 "\n\n * If any leave/s taken exceed/s these entitled leaves then exceeding leave/s shall be deducted from her balance leave/s, nd lack of balance leave in her account will incur loss of pay, for the duration she is willing to exceed the leave."+
				 "\n\n * Women employees will be paid with additional Rs. 3500/-, as maternity benefit."+
                 "\n\nPlease get in touch with our HR contact person for any further details.";
		 
		 policy.setText(text);
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
