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

public class HomeFragment extends Fragment {
	
	public HomeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        
TextView workText=(TextView)rootView.findViewById(R.id.workLabel); 		
		
        String text="<b>Work :</b><br/><br/>Whether you plan to go on long leave or you are already availing it, current section will provide you with glimpse of the items you may want to finish as quickly as possible. "
+"<br/><br/>This will help you in creating your own checklist while you are away from work."
+"<br/><br/>Where should you go to get all these required details?"
+"<br/><br/>Well .. Look at the top left-hand corner of the screen with three dashed lines one below other. Tap on it and you will get to the menu for everything you may require."
+"<br/><br/>Feel free to drop us a note using ‘Contact us’ option which is second icon from left hand side.";

        workText.setText(Html.fromHtml(text));
        
         
        return rootView;
    }
	
	


}
