package menu;

import com.pfg.pcare.R;
import com.pfg.pmcare.Email;
import com.pfg.pmcare.Home;
import com.pfg.pmcare.ImageSliderMain;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment2 extends Fragment {
	
	public HomeFragment2(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_home_2, container, false);
        
TextView HealthText=(TextView)rootView.findViewById(R.id.healthLabel); 		
		
        String text="<b>Health :</b><br/><br/>Congratulations!! As you are going to begin new phase of your life… "
+"<br/><br/>While you may have already started following the best practices which one should follow during this period we (as a ‘Principal Global Services’) are enabling here some of the best practices those are generally followed."
+"<br/><br/>Where should you go to get all these required details?"
+"<br/><br/>Well .. Look at the top left-hand corner of the screen with three dashed lines one below other. Tap on it and you will get to the menu for everything you may require."
+"<br/><br/>Feel free to drop us a note using ‘Contact us’ option which is second icon from left hand side."
+"<br/><br/>The information provided here is solely for a convenience and general health care purpose only and not as a guarantee or recommendation by the Principal Global Services. You are requested to consult this with your doctor/ physician and act accordingly for maximum benefits.";

        HealthText.setText(Html.fromHtml(text));
        

              
         
        return rootView;
    }
	
	


}
