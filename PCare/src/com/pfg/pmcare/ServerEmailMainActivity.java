package com.pfg.pmcare;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
import android.app.ProgressDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ServerEmailMainActivity extends Activity {
	// Declare Variables
	ListView listview;
	ServerEmailViewAdapter adapter;
	private List<ServerEmailPOJO> worldpopulationlist = null;
	ProgressDialog progressDialog ;
	SQLiteDatabase db;
	String dbId,dbFrom;
	String dbSubject,dbBody;
	String dbDate;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from listview_main.xml
		setContentView(R.layout.activity_server_email_main);
		// Execute RemoteDataTask AsyncTask
		
		db=openOrCreateDatabase("PMCare", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS employeeT(emailfrom VARCHAR,subject VARCHAR,emailcontent VARCHAR,date VARCHAR,isactive VARCHAR,readunreadflag VARCHAR);");
			
		isConnected();
	//	progressDialog=ProgressDialog.show(ServerEmailMainActivity.this, "Please wait ...", "Fetching Emails ...",true);
		//progressDialog.setCancelable(true);
		
		getemails();
		
	//	new LongRunningGetIO().execute();
	}
	
	public void getemails(){

		

	Cursor c=db.rawQuery("SELECT * FROM employeeTemp", null);
	if(c.getCount()==0)
	{
		showMessage("Error", "No emails found");
		return;
	}
	StringBuffer buffer=new StringBuffer();
	worldpopulationlist = new ArrayList<ServerEmailPOJO>();
	while(c.moveToNext())
	{
		dbFrom=c.getString(0);
		dbSubject=c.getString(1);
		dbBody=c.getString(2);
		dbDate=c.getString(3);
		//buffer.append("isactive: "+c.getString(4)+"\n\n");
		//buffer.append("readunreadflag: "+c.getString(5)+"\n\n");
		
		ServerEmailPOJO map = new ServerEmailPOJO();					
		map.setSubject(dbFrom);
	    map.setEmailContent(dbSubject);
		map.setDate(dbDate);
		
		worldpopulationlist.add(map);
		
	}
//	showMessage("Student Details", buffer.toString());
	
	listview = (ListView) findViewById(R.id.listview);
	// Pass the results into ListViewAdapter.java
	adapter = new ServerEmailViewAdapter(ServerEmailMainActivity.this,
			worldpopulationlist);
	// Binds the Adapter to the ListView
	listview.setAdapter(adapter);
	
	
		
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
			
		//	pBar.setVisibility(View.VISIBLE);
			 
			
			 HttpClient httpClient = new DefaultHttpClient();
			 HttpContext localContext = new BasicHttpContext();
             HttpGet httpGet = new HttpGet("http://pmcare.herokuapp.com/AnnouncementService");
             String text = null;
             try {
                   HttpResponse response = httpClient.execute(httpGet);
                   HttpEntity entity = response.getEntity();
                   text = getASCIIContentFromEntity(entity);
                   
                   JSONArray jsonArray = new JSONArray(text.toString());
              
             } catch (Exception e) {
            	 return e.getLocalizedMessage();
             }
             return text;
		}
		
		
		
		protected void onPostExecute(String results) {
			
			//Toast.makeText(, results, Toast.LENGTH_LONG).sh
			if (results!=null) {
			//	Toast.makeText(getApplicationContext(), results, Toast.LENGTH_LONG).show();
				worldpopulationlist = new ArrayList<ServerEmailPOJO>();
				Toast.makeText(getApplicationContext(), results, Toast.LENGTH_LONG).show();
				
                try {
					if(results!=null){
					JSONArray jsonArray = new JSONArray(results.toString());
					Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_LONG).show();
					for (int i = 0; i < jsonArray.length(); i++) {
						Toast.makeText(getApplicationContext(), jsonArray.toString(), Toast.LENGTH_LONG).show();
						ServerEmailPOJO map = new ServerEmailPOJO();					
						map.setSubject(jsonArray.getJSONObject(i).getString("subject"));
					    map.setEmailContent(jsonArray.getJSONObject(i).getString("id").toString());
						map.setDate(jsonArray.getJSONObject(i).getString("sentDate"));
						
						
						dbSubject = jsonArray.getJSONObject(i).getString("subject").toString();
						dbId = jsonArray.getJSONObject(i).getString("id").toString();						
						
						
						dbFrom = jsonArray.getJSONObject(i).getString("from").toString();
						dbSubject = jsonArray.getJSONObject(i).getString("subject").toString();
						dbBody = jsonArray.getJSONObject(i).getString("content").toString();
						dbDate = jsonArray.getJSONObject(i).getString("sentDate").toString();
						
						ContentValues values = new ContentValues();
						
						long retvalue = 0;
						
					//	db.execSQL("CREATE TABLE IF NOT EXISTS employeeT(emailfrom VARCHAR,subject VARCHAR,emailcontent VARCHAR,date VARCHAR,isactive VARCHAR,readunreadflag VARCHAR);");
					/*	values.put("emailfrom",dbFrom);
						values.put("subject",dbSubject);
						values.put("emailcontent",dbBody);
						values.put("date",dbDate);
						values.put("isactive","Y");
						values.put("readunreadflag","N");
						
						retvalue = db.insert(table, nullColumnHack, values)*/
						

			       	
						
				
							db.execSQL("INSERT INTO employeeT VALUES('"+dbFrom+"','"+dbSubject+"'," +
						
			       				"'"+dbBody+"','"+dbDate+"','Y','N');");
			       		
			       		

			    		Cursor c=db.rawQuery("SELECT * FROM employeeTemp", null);
			    		if(c.getCount()==0)
			    		{
			    			showMessage("Error", "No records found");
			    			return;
			    		}
			    		StringBuffer buffer=new StringBuffer();
			    		while(c.moveToNext())
			    		{
			    			buffer.append("from: "+c.getString(0)+"\n");
			    			buffer.append("subject: "+c.getString(1)+"\n");
			    			buffer.append("emailcontent: "+c.getString(2)+"\n\n");
			    			buffer.append("date: "+c.getString(3)+"\n\n");
			    			buffer.append("isactive: "+c.getString(4)+"\n\n");
			    			buffer.append("readunreadflag: "+c.getString(5)+"\n\n");
			    		}
			    		showMessage("Student Details", buffer.toString());
			    		
						
			    		
			    	//	db.execSQL("DELETE from employee");
						
						worldpopulationlist.add(map);
	       			}
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					progressDialog.dismiss();
					Toast.makeText(getApplicationContext(), e.getCause().toString(), Toast.LENGTH_LONG).show();
				}
			
			}
			
			listview = (ListView) findViewById(R.id.listview);
			// Pass the results into ListViewAdapter.java
			adapter = new ServerEmailViewAdapter(ServerEmailMainActivity.this,
					worldpopulationlist);
			// Binds the Adapter to the ListView
			listview.setAdapter(adapter);
			
		//	pBar.setVisibility(View.GONE);
			progressDialog.dismiss();
			
		}
    }	
	
	 public void showMessage(String title,String message)
	    {
	    	Builder builder=new Builder(this);
	    	builder.setCancelable(true);
	    	builder.setTitle(title);
	    	builder.setMessage(message);
	    	builder.show();
		}
	
}