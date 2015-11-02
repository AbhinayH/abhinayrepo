package com.pfg.pmcare;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import com.pfg.pcare.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
	
	EditText fName,lName,email,birthDate,expectedDate;
	ProgressDialog progressDialog ;
	boolean validdata = false;
	Integer statusCode =100;
	final Context context = this;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
	}
	
	
	
	public void temp(View view){
		Intent homeIntent = new Intent(getApplicationContext(),Home.class);
		homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(homeIntent);
		
	}
	
	public void selectBirthDate(View view) {
		 /*dateTextView is static text view. addReminderScreenDateTxtView is
		 assigned to dateTextView where date will be displayed after getting
		 selected.*/
	//	setContentView(R.layout.activity_register);
		birthDate = (EditText) findViewById(R.id.birthDate);
		DatePickerImplementation.dateTextView = birthDate;
		new DatePickerImplementation().displayDatePickerDialog(view);
	}
	
	public void selectExpectedDate(View view) {
		 /*dateTextView is static text view. addReminderScreenDateTxtView is
		 assigned to dateTextView where date will be displayed after getting
		 selected.*/
	//	setContentView(R.layout.activity_register);
		expectedDate = (EditText) findViewById(R.id.expectedDate);
		DatePickerImplementation.dateTextView = expectedDate;
		new DatePickerImplementation().displayDatePickerDialog(view);
	}
	
	public boolean isConnected(){
		ConnectivityManager cmgr=(ConnectivityManager)getSystemService(Activity.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo= cmgr.getActiveNetworkInfo();
		
		if(networkInfo!=null && networkInfo.isConnected()){
			Toast.makeText(this, "connection is ok", Toast.LENGTH_LONG).show();
			return true;
		}else{
			Toast.makeText(this, "connection problem ", Toast.LENGTH_LONG).show();
			return false;
		}
	}
	
	private boolean isValidMail(String email2){
		boolean check;
		Pattern p;
		Matcher m;
		String EMAIL_STRING ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    p =Pattern.compile(EMAIL_STRING);
    m = p.matcher(email2);
    check = m.matches();if(!check){
       // txtEmail.setError("Not Valid Email");
        }return check;}
	
	
	public boolean goToHomePage(View view) throws UnsupportedEncodingException{	
		
		fName = (EditText) findViewById(R.id.firstName);
		lName = (EditText) findViewById(R.id.lastName);
		email = (EditText) findViewById(R.id.emailId);
		birthDate = (EditText) findViewById(R.id.birthDate);
		
		
		
		if(fName.getText()!=null && fName.getText().toString().trim().equalsIgnoreCase("")){
			fName.setError("Please enter First Name");
			return false;
		}
		else if(lName.getText()!=null && lName.getText().toString().trim().equalsIgnoreCase("")){
			lName.setError("Please enter Lasr Name");
			return false;
		}/*else if(email.getText()!=null && email.getText().toString().trim().equalsIgnoreCase("")){
			lName.setError("Please enter Email");
			return false;
		}*/else if(!isValidMail(email.getText().toString())){
			email.setError("Invalid Email Id");
			return false;
		}
		
		
		
		isConnected();
		progressDialog=ProgressDialog.show(Register.this, "Please wait ...", "Authenticating ...",true);
		
		
		new LongRunningGetIO().execute();
		
		return true;

	
		
	
}
	
private class LongRunningGetIO extends AsyncTask <Void, Void, Integer> {
		
	String text;
	
		@Override
		protected Integer doInBackground(Void... params) {

			HttpClient httpClient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("https://pmcare.herokuapp.com/AuthService/Signup");
			
			
			
			try{
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("firstName", fName.getText().toString());
				jsonObj.put("lastName", lName.getText().toString());
				jsonObj.put("dateOfBirth", birthDate.getText().toString());
				jsonObj.put("emailId", email.getText().toString());
				
				StringEntity se = new StringEntity(jsonObj.toString());
				httppost.setEntity(se);
				httppost.setHeader("Accept","application/json");
				httppost.setHeader("Content-type","application/json");
				
				List<NameValuePair> nameValyPairs = new ArrayList<NameValuePair>();
				nameValyPairs.add(new BasicNameValuePair("req",jsonObj.toString()));
				
				
				HttpResponse response = httpClient.execute(httppost);
				
				if(response.getStatusLine()!=null){
					statusCode = response.getStatusLine().getStatusCode();
				}
				
			/*	InputStream is = response.getEntity().getContent();
				
				
				String line;
				StringBuilder sb = new StringBuilder();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				while((line =br.readLine())!=null){
					sb.append(line);
				}
				text = sb.toString();
			//	 text = new String(baf.toByteArray());
				System.out.println(text);
			*/	
				
				
				
			}catch(Exception e ){
				e.printStackTrace();
			}
			 return statusCode;
			
			
		}	
		
		protected void onPostExecute(Integer results) {
			
			System.out.println(results);
			
			if(results == 200){
				progressDialog.dismiss();
				Toast.makeText(getApplicationContext(), "Authentication successful", Toast.LENGTH_LONG).show();
				
				Intent homeIntent = new Intent(getApplicationContext(),Home.class);
				homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(homeIntent);
			}else if(results == 400){
				progressDialog.dismiss();
				Toast.makeText(getApplicationContext(), "Bad Request 400", Toast.LENGTH_LONG).show();
				alertMessge("400 : Bad Request");
				
			}else if(results == 406){
				progressDialog.dismiss();
				Toast.makeText(getApplicationContext(), "Not Acceptable 406", Toast.LENGTH_LONG).show();
				alertMessge("406 :Not Acceptable");
				
			}else if(results == 500){
				progressDialog.dismiss();
				Toast.makeText(getApplicationContext(), "Internal error 500", Toast.LENGTH_LONG).show();
				alertMessge("500 :Internal Error");
				
			}else{
				progressDialog.dismiss();
				Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
				alertMessge("Unknown Error");
				
			}				
		}
		
		
		
		
		
		
		
		public void alertMessge(String message){
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

			// set title
			alertDialogBuilder.setTitle("Authentication Failed");

			// set dialog message
			alertDialogBuilder
					.setMessage(message)
					.setCancelable(false)
					.setNegativeButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// if this button is clicked, just close
									// the dialog box and do nothing
									dialog.cancel();
								}
							});

			// create alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();

			// show it
			alertDialog.show();
			
		}
    }		
	
}
