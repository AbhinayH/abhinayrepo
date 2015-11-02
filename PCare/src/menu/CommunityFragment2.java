package menu;

import com.pfg.pcare.R;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CommunityFragment2 extends Fragment {
	
	public CommunityFragment2(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_community_2, container, false);
        
TextView foodHabit1=(TextView)rootView.findViewById(R.id.exercisesLabel); 		
		
        String text="<b>Food Habits - After Childbirth :</b><br/><br/>After your delivery it is natural for you to focus all your attention on your newborn baby. But try to look after yourself as well by paying attention to your diet."
+"<br/><br/>Eating right can go a long way in helping you get back your strength and energy. After all, your baby needs a strong and healthy mum. And if you are breastfeeding, what you eat passes on to your baby through your milk. So all the more reason to eat well!"
+"<br/><br/><b>Carom seeds (ajwain) :</b>It is traditionally believed that ajwain, a good source of thymol, not only soothes pain from gas and indigestion, but also cleanses the uterus. There is not much evidence to support this belief, but thymol is known to have antioxidant, antibacterial, antifungal and antiseptic properties. You can make a range of dishes with ajwain from paranthas to halwa, or you could simply add it to your food as an extra seasoning. Some also make it a point to drink ajwain water every day.";

        foodHabit1.setText(Html.fromHtml(text));
        
        
        
        TextView foodhabit2=(TextView)rootView.findViewById(R.id.exercisesLabel2); 		
		
        String text2="<b>Finger millet (mandua):</b><br/><br/>Finger millet, mandua or ragi is an excellent source of calcium and iron, both of which you need in plenty after giving birth. It can help you regain strength after childbirth, and is a good alternative for mums who are allergic to milk and dairy products. You can use finger millet to prepare dosas, idlis, rotis and halwas. ";

       
        foodhabit2.setText(Html.fromHtml(text2));
        
        
        
        TextView foodhabit3=(TextView)rootView.findViewById(R.id.exercisesLabel3); 		
		
        String text3="<b>Almonds (badaam):</b><br/><br/>Almonds are rich in carbohydrates, fibre, vitamin B12 and E and contain minerals like magnesium, copper, manganese, potassium, calcium and zinc. As there are so many nutrients packed into an almond, it's an ideal food to have while you recover after childbirth. Almonds can be used in many recipes such as badaam milk, sheera, halwa and so on. If you aren't in the mood to cook they make a great snack to munch on!";
       
        foodhabit3.setText(Html.fromHtml(text3));
        
        
  TextView foodhabit4=(TextView)rootView.findViewById(R.id.exercisesLabel4); 		
		
        String text4="<b>Green Vegetables :</b><br/><br/>Green vegetables are a great source of iron, which you will need to help you recuperate. Consider eating spinach (paalak), beans (frans been), lotus stem (kamal kakri), fenugreek (methi) leaves, apple gourd (tinda), pointed gourd (parwal) or other such green seasonal vegetables. ";
       
        foodhabit4.setText(Html.fromHtml(text4));
         
        return rootView;
    }
}
