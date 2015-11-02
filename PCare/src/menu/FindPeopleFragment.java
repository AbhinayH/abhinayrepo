package menu;

import com.pfg.pcare.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FindPeopleFragment extends Fragment {
	
	public FindPeopleFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_find_people, container, false);
        
        TextView policy=(TextView)rootView.findViewById(R.id.policyId); 
		
		
		 String text="\n\nThis article should enable you understand about the maternity benefits that we as a group provide to our female employees."+ 
				 "\n\n * Women employees are entitled with 12 weeks of paid leave."+ 
				 "\n\n * 7.5 leaves will be added to the employee's account during this period."+
				 "\n\n * If any leave/s taken exceed/s these entitled leaves then exceeding leave/s shall be deducted from her balance leave/s, nd lack of balance leave in her account will incur loss of pay, for the duration she is willing to exceed the leave."+
				 "\n\n * Women employees will be paid with additional Rs. 3500/-, as maternity benefit."+
                "\n\nPlease get in touch with our HR contact person for any further details.";
		 
		 policy.setText(text);
         
        return rootView;
    }
}
