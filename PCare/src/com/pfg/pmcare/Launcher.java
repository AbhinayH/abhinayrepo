package com.pfg.pmcare;

import menu.HomeFragment;

import com.pfg.pcare.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class Launcher extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		
new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			//	Intent i = new Intent(Launcher.this,Register.class);
				Intent i = new Intent(Launcher.this,Home.class);
				startActivity(i);
				
				finish();
				
			}
		},3000);
	}
}
