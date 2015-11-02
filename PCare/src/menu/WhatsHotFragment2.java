package menu;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pfg.pcare.R;

public class WhatsHotFragment2 extends Fragment {
	
	public WhatsHotFragment2(){}
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_whats_hot_2, container, false);
        
TextView foodHabit1=(TextView)rootView.findViewById(R.id.exercisesLabel); 		
		
        String text="<b>Food Habit - Before Childbirth:</b><br/><br/>While it is not always possible to detect when labor will come, as the big day approaches, you can change your eating habits so that when you do go into labor you will be prepared to get through it. Some obstetricians don't allow you to eat once labor has started, so fueling up beforehand will give you the energy you need to give birth, according to ‘what to Expect?’. Talk with your doctor for additional advice specific to your pregnancy."
+"<br/><br/>Scroller should be implemented for below items and below items should be accommodated into single screen.";

        foodHabit1.setText(Html.fromHtml(text));
        
        
        
        TextView foodhabit2=(TextView)rootView.findViewById(R.id.exercisesLabel2); 		
		
        String text2="<b>Fruit :</b><br/><br/>Fresh fruit is refreshing, but it will also give you a quick burst of energy. When your water breaks or you prepare to have your labor induced, a piece of fruit can give you enough energy to get through labor and delivery. BabyCentre ranks bananas as one of the best pre-labor fruits, but any fruit will give your energy a boost, so eat the ones you like best.";

       
        foodhabit2.setText(Html.fromHtml(text2));
        
        
        
        TextView foodhabit3=(TextView)rootView.findViewById(R.id.exercisesLabel3); 		
		
        String text3="<b>Yogurt :</b><br/><br/>Yogurt contains sugar and carbohydrates, both of which will give you a good energy boost as you prepare for labor. Keep your refrigerator stocked as the time becomes closer so that you are able to eat some right away when labor becomes imminent. Yogurt will give you the energy you need when labor begins, and you must work hard to bring your baby into the world. If your doctor won't allow food once you reach the hospital, eat some yogurt before or during your ride to the hospital for prolonged energy. ";
       
        foodhabit3.setText(Html.fromHtml(text3));
        
        
  TextView foodhabit4=(TextView)rootView.findViewById(R.id.exercisesLabel4); 		
		
        String text4="<b>Pasta :</b><br/><br/>Stay away from pasta floating in sauces because they can upset your stomach. However, plain pasta is bland and full of carbohydrates. Eating plenty of carbohydrates before you begin labor will give you sustained energy that is released slowly and steadily over the next several hours of labor. When you feel that is labor is about to occur, cook up a plate of plain pasta to get you ready for the big event. ";
       
        foodhabit4.setText(Html.fromHtml(text4));
         
        return rootView;
    }
}
