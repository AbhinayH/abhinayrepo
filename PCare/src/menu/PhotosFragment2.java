package menu;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pfg.pcare.R;

public class PhotosFragment2 extends Fragment {
	
	public PhotosFragment2(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_photos_2, container, false);
        
        TextView babyDayCare=(TextView)rootView.findViewById(R.id.babyDayCare); 
		
		
		 String text="<hr><b>DOMO Childcare</b><br/><br/><b>Address:</b><br/>No. A-2-1205, Runwal Seagull, Handewadi Road,<br/>Hadapsar<br/>pune - 411028<br/><br/><b>Contact number</b> :<br/>+(91)-9561112991<br/><br/><hr>"
				    +"<hr><b>Eureka</b><br/><br/><b>Address:</b><br/>No. A-2-1205, Runwal Seagull, Handewadi Road,<br/>Hadapsar<br/>pune - 411028<br/><br/><b>Contact number</b> :<br/>+(91)-9561112991<br/><br/><hr>"
				 +"<hr><b>Euro Kids</b><br/><br/><b>Address:</b><br/>No. A-2-1205, Runwal Seagull, Handewadi Road,<br/>Hadapsar<br/>pune - 411028<br/><br/><b>Contact number</b> :<br/>+(91)-9561112991<br/><br/><hr>";
		 
		 babyDayCare.setText(Html.fromHtml(text));
        
        
        
         
        return rootView;
    }
}
