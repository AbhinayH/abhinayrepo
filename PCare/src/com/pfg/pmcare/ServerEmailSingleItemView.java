package com.pfg.pmcare;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONException;

import com.pfg.pcare.R;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ServerEmailSingleItemView extends Activity {
	// Declare Variables
	TextView txtFrom;
	TextView txtSubject;
	EditText txtBody;
	String from;
	String subject;
	String body;
	String mailId;
	ProgressDialog progressDialog ;
	SQLiteDatabase db;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_server_email_single_item_view);
		// Retrieve data from MainActivity on item click event
		
		Intent i = getIntent();
		// Get the results of rank
		from = i.getStringExtra("rank");
		// Get the results of country
		subject = i.getStringExtra("country");
		
		mailId=i.getStringExtra("population");
		
	//	population = i.getStringExtra("population");

		// Locate the TextViews in singleitemview.xml
		db=openOrCreateDatabase("PMCare", Context.MODE_PRIVATE, null);
	
		getSingleEmail(mailId);
	//	progressDialog=ProgressDialog.show(ServerEmailSingleItemView.this, "Please wait ...", "Fetching Emails ...",true);
	//	new LongRunningGetIO().execute();
	}
	
	
	public void getSingleEmail(String subject){		
		
		txtFrom = (TextView) findViewById(R.id.rank);
		txtSubject = (TextView) findViewById(R.id.country);
		txtBody = (EditText) findViewById(R.id.population);

		Cursor c=db.rawQuery("SELECT * FROM employee WHERE subject='"+subject+"'", null);
		if(c.getCount()==0)
		{
			showMessage("Error", "No emails found");
			return;
		}
		StringBuffer buffer=new StringBuffer();
		
		while(c.moveToNext())
		{
			txtFrom.setText(c.getString(0));
			txtSubject.setText(c.getString(1));
			txtBody.setText(c.getString(2));
			//=c.getString(3);
			//buffer.append("isactive: "+c.getString(4)+"\n\n");
			//buffer.append("readunreadflag: "+c.getString(5)+"\n\n");
			
			
			
		}
//		showMessage("Student Details", buffer.toString());
	
		
	}
	
	
	
	public void showMessage(String title,String message)
    {
    	Builder builder=new Builder(this);
    	builder.setCancelable(true);
    	builder.setTitle(title);
    	builder.setMessage(message);
    	builder.show();
	}

	
	private class LongRunningGetIO extends AsyncTask <Void, Void, String> {
		
		protected String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException {
	       InputStream in = entity.getContent();
	         StringBuffer out = new StringBuffer();
	         int n = 1;
	         while (n>0) {
	             byte[] b = new byte[4096];
	             n =  in.read(b);
	             if (n>0) out.append(new String(b, 0, n));
	         }
	         return out.toString();
	    }
		
		@Override
		protected String doInBackground(Void... params) {
			
			 HttpClient httpClient = new DefaultHttpClient();
			 HttpContext localContext = new BasicHttpContext();
			
			 //String url="http://pmcare.herokuapp.com/AnnouncementMockService/Subject/"+fromWord[0];
			 String url="http://pmcare.herokuapp.com/AnnouncementService";
           //  HttpGet httpGet = new HttpGet("http://www.cheesejedi.com/rest_services/get_big_cheese.php?puzzle=1");
            // HttpGet httpGet = new HttpGet("http://amolhelloworld.herokuapp.com/AnnouncementEmailService");
             HttpGet httpGet = new HttpGet(url);
             String text = null;
             try {
                   HttpResponse response = httpClient.execute(httpGet, localContext);
                   HttpEntity entity = response.getEntity();
                   text = getASCIIContentFromEntity(entity);                   
                                  
                                   
             } catch (Exception e) {
            	 return e.getLocalizedMessage();
            	 
             }
             return text;
		}	
		
		protected void onPostExecute(String results) {
			if (results!=null) {
				
				txtFrom = (TextView) findViewById(R.id.rank);
				txtSubject = (TextView) findViewById(R.id.country);
				txtBody = (EditText) findViewById(R.id.population);

				// Load the results into the TextViews
				txtFrom.setText(from);
				txtSubject.setText(subject);
				txtBody.setText(body);
				
				
				try {
					JSONArray jsonArray = new JSONArray(results.toString());
					
					for (int i = 0; i < jsonArray.length(); i++) {
						if(i== (Integer.valueOf(mailId))){
						txtFrom.append("\nfrom: "
	       						+ jsonArray.getJSONObject(i).getString("from").toString());
						txtSubject.append("\nsubject: "
	       						+ jsonArray.getJSONObject(i).getString("subject").toString());
						txtBody.append("\n body : "
	       						+ jsonArray.getJSONObject(i).getString("content").toString());
						
						

			    	
	       			     }
					}
				     } catch (JSONException e) {
						e.printStackTrace();
						progressDialog.dismiss();
				     }
				
				progressDialog.dismiss();
			}
			
		}
    }
	
	
	
	
	
	
	public void goToHomePage(View view){		
		Intent homeIntent = new Intent(getApplicationContext(),Home.class);
		homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(homeIntent);
	}
	
	public void navigatetoEmailList(View view){		
		Intent emailListScreen = new Intent(getApplicationContext(),ServerEmailMainActivity.class);
		emailListScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(emailListScreen);
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