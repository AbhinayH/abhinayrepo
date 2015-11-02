package menu;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pfg.pcare.R;

public class PagesFragment2 extends Fragment {
	
	public PagesFragment2(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_pages_2, container, false);
        
TextView exerciseText1=(TextView)rootView.findViewById(R.id.exercisesLabel); 		
		
        String text="<b>Exercises - After Childbirth :</b><br/><br/>Getting your body back after having a baby is not as hard as you might think."
+"<br/><br/>Research shows that starting a regular exercise program soon after giving birth is not only good for your overall health, but may also help reduce the risk ofpostpartum depression"
+"<br/><br/>Every pregnancy and delivery is different, so check with your doctor before engaging in any workout program after giving birth. If you experience any heavy bleeding, excessive soreness, headaches, or other unusual symptoms during or right after exercising, stop immediately and call your doctor for advice."
+"<br/><br/>Here are some moves that will help you get your body ready for regular exercise."
+"<br/><br/><b>Starting Back Slowly :</b><br/><br/>As a general rule, I recommend that women do not return to postnatal or mommy and me yoga until their bleeding has stopped. If a woman gave birth via cesarean section, she needs to wait 6 weeks before rejoining class. If you push yourself too hard in the beginning, then you can actually be setting yourself back from real recovery. That of course does not mean you need to be held hostage in your house for 6 weeks. A walk can be considered a good start to your road back!"
+"<br/><br/>Of course, an exercise ball can be a pregnant mamas best friend for this exercise not only pre-labor but during it. Draping your arms and upper body over exercise ball and roll around while your pelvis moves in midair can prepare your lower body for the work of natural labor.";
       
        exerciseText1.setText(Html.fromHtml(text));
        
        
        
        TextView exerciseText2=(TextView)rootView.findViewById(R.id.exercisesLabel2); 		
		
        String text2="<b>Watch For Your Bleeding to Stop :</b><br/><br/>Once you do embark on some heavier activities, pay attention to signs from your body. Some women find that their bleeding that had tapered down starts to get heavier again, which is a sign that the body needs more time to heal.";
       
        exerciseText2.setText(Html.fromHtml(text2));
        
        
        
        TextView exerciseText3=(TextView)rootView.findViewById(R.id.exercisesLabel3); 		
		
        String text3="<b>How Is Your Pelvic Floor? :</b><br/><br/>Also, if the pelvic floor is weak, putting intra-abdominal pressure (like crunches, pilates or general ab work) can put too much pressure on the pelvic floor and inhibit healing or even lead to a chance of organ prolapse. One of the first forms of exercise you can start to incorporate daily can be a kegel routine, restrengthening or even re-familiarizing yourself with your pelvic floor muscles.";

       
        exerciseText3.setText(Html.fromHtml(text3));
        
        
  TextView exerciseText4=(TextView)rootView.findViewById(R.id.exercisesLabel4); 		
		
        String text4="<b>Repairing Diastasis</b><br/><br/>It is very common that women experience a separation of the abdominal muscles, specifically the rectus abdominals — aka the six-pack muscles. Your care provider can check this for you when you return for your six week checkup. If it is severe enough, you may need to work with a physical therapist to help draw the muscles back together. So, when easing back to an abdominal workout, be mindful not to overdo it. In postnatal and mommy and me yoga, we focus more on plank pose and variations of plank instead of old fashion crunches. It is also advised not to do extremely deep twisting poses which can also inhibit the muscles from repair.";
       
        exerciseText4.setText(Html.fromHtml(text4));
        
        
TextView exerciseText5=(TextView)rootView.findViewById(R.id.exercisesLabel5); 		
		
        String text5="<b>Wiggly, Wobbly Joints :</b><br/><br/>Relaxin, the hormone that is responsible for softening the ligaments and joints during pregnancy and childbirth, can stay in the body for up to six months postpartum. This can lead to wobbly, unstable joints and a loose pelvis. Again, just be mindful that the activity your choose is not too jerky in movement.";
              
        exerciseText5.setText(Html.fromHtml(text5));
        
        
        
TextView exerciseText6=(TextView)rootView.findViewById(R.id.exercisesLabel6); 		
		
        String text6="<b>Find All Sorts of Exercise! :</b><br/><br/>You do not need to attend a scheduled class to start to return to a general fitness routine. As I mentioned earlier, walking is a great place to start: don’t discount walking as a gentle cardiovascular exercise! At one point, I was told to avoid higher impact cardio since I was healing from some pretty severe pelvic floor issues and was instructed to try swimming. Fortunately, I have been an avid swimmer for years, so it felt like a nice welcome back to exercise and rediscovering my body. The nice thing about swimming is that it is gentle on the joints and pelvic floor, and is great for strengthening the core and back muscles.";
        
        
        exerciseText6.setText(Html.fromHtml(text6));
        
TextView exerciseText7=(TextView)rootView.findViewById(R.id.exercisesLabel7); 		
		
        String text7="<b>Hydrate :</b><br/><br/>Once you do start to ease back into your routine, please remember to hydrate well, especially if you are breastfeeding. If you are out for a stroll with your baby, put your water bottle in the cup holder as a reminder to drink often.";

       
        exerciseText7.setText(Html.fromHtml(text7));
         
        return rootView;
    }
}
