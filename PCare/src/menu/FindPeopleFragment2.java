package menu;

import com.pfg.pcare.R;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FindPeopleFragment2 extends Fragment {
	
	public FindPeopleFragment2(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_find_people_2, container, false);
        
        TextView exerciseText1=(TextView)rootView.findViewById(R.id.exercisesLabel); 		
		
        String text="<b>Exercises - Before Childbirth:</b><br/><br/>Did you know that you can do prenatal exercises to help your body and baby be in optimal shape for a quicker, easier natural childbirth?"
+"<br/><br/>While it’s certainly no guarantee, prenatal exercises can open our pelvis and position our baby optimally. Truth is, for most of us mamas, natural childbirth is a marathon. We wouldn’t show up to a race like that without training and the same can be said with natural childbirth."
+"<br/><br/>Ideally, we would start these exercises once we discovered we were pregnant however ANYTIME you start will be beneficial."
+"<br/><br/><b>Walking:</b>Yes, simple walking can help keep your body in balance as you approach your big day. Aim for at least 30 minutes a day, preferably outdoors for the fresh air, sunlight and natural surroundings.";
       
        exerciseText1.setText(Html.fromHtml(text));
        
        
        
        TextView exerciseText2=(TextView)rootView.findViewById(R.id.exercisesLabel2); 		
		
        String text2="<b>Leaning:</b><br/><br/>To counteract all the time we are leaning back each day, it’s important to lean forward as a pregnant mama. Leaning on counters, tables and people all work :). An old wives tale was to flip a posterior baby, you were to scrub all your floors on hands and knees. Gravity would pull the baby’s back forward and get him/her in optimal position."
+"<br/><br/>Of course, an exercise ball can be a pregnant mamas best friend for this exercise not only pre-labor but during it. Draping your arms and upper body over exercise ball and roll around while your pelvis moves in midair can prepare your lower body for the work of natural labor.";
       
        exerciseText2.setText(Html.fromHtml(text2));
        
        
        
        TextView exerciseText3=(TextView)rootView.findViewById(R.id.exercisesLabel3); 		
		
        String text3="<b>Pelvic Rocks (aka Pelvic Tilts or Cat Cow Stretch):</b><br/><br/>These are a simple exercise that keeps the pelvis loose and the lower back limber. You can begin these from day one and continue through labor."
+"<br/><br/>If after 30 weeks, you want to try to flip a posterior baby to anterior position, do the pelvic rocks when you feel your baby move. She/he may be trying to get into a better position for birth and you can facilitate that process by doing Pelvic Rocks. I would recommend doing them 3 times a day for up to 20 minutes total time daily once you’re in third trimester.";
       
        exerciseText3.setText(Html.fromHtml(text3));
        
        
  TextView exerciseText4=(TextView)rootView.findViewById(R.id.exercisesLabel4); 		
		
        String text4="<b>Butterflies:</b><br/><br/>This simple exercise opens your pelvis and keeps your lower back limber. You can do these from the moment you’re pregnant till you deliver. Sit on bottom and put soles of feet together. Pulse your legs up and down till you feel the stretch. You can even have your partner add resistance for a deeper stretch.";
       
        exerciseText4.setText(Html.fromHtml(text4));
        
        
TextView exerciseText5=(TextView)rootView.findViewById(R.id.exercisesLabel5); 		
		
        String text5="<b>Forward Leaning Inversion:</b><br/><br/>This powerful move helps to untwist lower uterine ligaments. Because of our poor posture and sedentary lifestyles, our uterus can be twisted and cramped, leaving less room for baby to settle into the optimal position. Additionally, if we’ve been in any type of accident or like to carry an older child on our hip, this exercise is essential."
        +"<br/><br/>You want to kneel on the edge of a couch or bed. Slowly lower yourself to your hands on the floor and then to your forearms. Elbows out, hands close. Use a stool or a partner if you need help. Let your head hang freely. Your chin is tucked. Your bottom should be highest. Flatten your lower back. Hold for 30 seconds.Do 1-3 times a day. Please note: If you’ve had any abdominal or uterine cramping, have high blood pressure, or feel excessive baby movement, do not attempt this exercise.";
        
        exerciseText5.setText(Html.fromHtml(text5));
        
        
        
TextView exerciseText6=(TextView)rootView.findViewById(R.id.exercisesLabel6); 		
		
        String text6="<b>Optimal Sleeping Position:</b><br/><br/>Once you hit 20 weeks, most doctors and midwives will dissuade you from sleeping on your back because it can cause problems with backaches, breathing, digestive system, hemorrhoids, low blood pressure and decrease circulation to your heart and your baby."
        +"<br/><br/>Obviously, we want to avoid sleeping on our belly so side sleeping is our best bet.Sleeping on our left side is most optimal because it may in the amount of blood and nutrients that reach the placenta and your baby. It also works with gravity to get your baby in the most optimal position for birth, generally speaking, which is Left Occiput Anterior."
        		+"<br/><br/>Be sure to use extra pillows for support… particularly one between your knees to keep pelvis balanced and aligned as well as one for your tummy and or shoulder. Some swear by these pillows for full body support.";
        
        exerciseText6.setText(Html.fromHtml(text6));
        
TextView exerciseText7=(TextView)rootView.findViewById(R.id.exercisesLabel7); 		
		
        String text7="<b>Tailor Sitting:</b><br/><br/>This is an exercise that strengthens and stretches muscles in your back, thighs, and pelvis, and improves your posture. It also keeps your pelvic joints flexible, improves blood flow to your lower body, and eases delivery."
+"<br/><br/>Sit on the floor with your back straight in the 'butterfly position' (the bottoms of your feet together and your knees dropped comfortably). As you press both knees gently toward the floor using your elbows, you should feel a stretch in your inner thighs. Don't bounce your knees up and down rapidly. If you find it difficult at first to keep your back straight, use a wall to support your back. Hold the position for 10 or 15 seconds and repeat the stretch five or 10 times."
+"You'll find this exercise is not difficult to do, and it feels great. Your body is more flexible during pregnancy, and this exercise capitalizes on your newfound flexibility.";

       
        exerciseText7.setText(Html.fromHtml(text7));
        
       
         
        return rootView;
    }
}
