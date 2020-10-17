package com.example.databaseexample2.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.databaseexample2.model.Company;
import com.example.databaseexample2.R;

public class SpinnerCompaniesAdapter extends BaseAdapter {
	
	public static final String TAG = "SpinnerCompnaiesAdapter";
	
	private List<Company> mItems;
	private LayoutInflater mInflater;
	
	public SpinnerCompaniesAdapter(Context context, List<Company> listCompanies) {
		this.setItems(listCompanies);
		this.mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return (getItems() != null && !getItems().isEmpty()) ? getItems().size() : 0 ;
	}

	@Override
	public Company getItem(int position) {
		return (getItems() != null && !getItems().isEmpty()) ? getItems().get(position) : null ;
	}

	@Override
	public long getItemId(int position) {
		return (getItems() != null && !getItems().isEmpty()) ? getItems().get(position).getId() : position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		ViewHolder holder;
		if(v == null) {
			v = mInflater.inflate(R.layout.spinner_item_company, parent, false);
			holder = new ViewHolder();
			holder.txtCompanyName = (TextView) v.findViewById(R.id.txt_company_name);
			holder.txtWebsite = (TextView) v.findViewById(R.id.txt_website);
			v.setTag(holder);
		}
		else {
			holder = (ViewHolder) v.getTag();
		}
		
		// fill row data
		Company currentItem = getItem(position);
		if(currentItem != null) {
			holder.txtCompanyName.setText(currentItem.getName());
			holder.txtWebsite.setText(currentItem.getWebsite());
		}
		
		return v;
	}
	
	public List<Company> getItems() {
		return mItems;
	}

	public void setItems(List<Company> mItems) {
		this.mItems = mItems;
	}

	class ViewHolder {
		TextView txtCompanyName;
		TextView txtWebsite;
	}
}
