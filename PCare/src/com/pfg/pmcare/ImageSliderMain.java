package com.pfg.pmcare;

import com.pfg.pcare.R;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class ImageSliderMain extends Activity {

	// Declare Variables
	ViewPager viewPager;
	PagerAdapter adapter;
	String[] rank;
	String[] country;
	String[] population;
	int[] flag;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from viewpager_main.xml
		setContentView(R.layout.viewpager_main);

		// Generate sample data
		rank = new String[] { "1", "2", "3"};

		country = new String[] { "China", "India", "United States"};

		population = new String[] {"aa","bb", "honrao.abhinay@gmail.com"};

		flag = new int[] {R.drawable.test1,
				R.drawable.test2, R.drawable.test3
				};

		// Locate the ViewPager in viewpager_main.xml
		viewPager = (ViewPager) findViewById(R.id.pager);
		// Pass results to ViewPagerAdapter Class
		adapter = new ImageSliderAdapter(ImageSliderMain.this, rank, country, population, flag);
		// Binds the Adapter to the ViewPager
		viewPager.setAdapter(adapter);

	}
}