package com.pfg.pmcare;

import java.util.ArrayList;
import java.util.List;

import com.pfg.pcare.R;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ServerEmailViewAdapter extends BaseAdapter {

	// Declare Variables
	Context mContext;
	LayoutInflater inflater;
	private List<ServerEmailPOJO> worldpopulationlist = null;
	private ArrayList<ServerEmailPOJO> arraylist;

	public ServerEmailViewAdapter(Context context,
			List<ServerEmailPOJO> worldpopulationlist) {
		mContext = context;
		this.worldpopulationlist = worldpopulationlist;
		inflater = LayoutInflater.from(mContext);
		this.arraylist = new ArrayList<ServerEmailPOJO>();
		this.arraylist.addAll(worldpopulationlist);
	}

	public class ViewHolder {
		TextView rank;
		TextView country;
		TextView population;
	}

	@Override
	public int getCount() {
		return worldpopulationlist.size();
	}

	@Override
	public ServerEmailPOJO getItem(int position) {
		return worldpopulationlist.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View view, ViewGroup parent) {
		final ViewHolder holder;
		if (view == null) {
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.listview_item, null);
			// Locate the TextViews in listview_item.xml
			holder.rank = (TextView) view.findViewById(R.id.rank);
			holder.country = (TextView) view.findViewById(R.id.country);
			holder.population = (TextView) view.findViewById(R.id.population);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		// Set the results into TextViews
		holder.rank.setText(worldpopulationlist.get(position).getSubject());
		holder.country.setText(worldpopulationlist.get(position).getDate());
		holder.population.setText(worldpopulationlist.get(position)
				.getEmailContent());

		// Listen for ListView Item Click
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Send single item click data to SingleItemView Class
				Intent intent = new Intent(mContext, ServerEmailSingleItemView.class);
				// Pass all data rank
				intent.putExtra("rank",
						(worldpopulationlist.get(position).getSubject()));
				// Pass all data country
				intent.putExtra("country",
						(worldpopulationlist.get(position).getDate()));
				// Pass all data population
				intent.putExtra("population",
						(worldpopulationlist.get(position).getEmailContent()));
				// Start SingleItemView Class
				mContext.startActivity(intent);
			}
		});

		return view;
	}
	
	
}