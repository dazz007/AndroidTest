package com.hwtest.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class List_Custom_List extends BaseAdapter {
	private String[] data;
    private Context ctx;

	 public List_Custom_List(Context ctx, String[] importeddata) {
	    this.ctx = ctx;
	    this.data = importeddata;
	    }
	
	public int getCount() {
	    return data.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub	
		return 0;
	}
	private class ViewHolderPattern {
	    TextView tekst_w_layoucie;
	    }
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolderPattern view_holder;
		 
	    if (convertView == null) {
	        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        convertView = inflater.inflate(R.layout.list_item_view_custom_list, parent, false);
	 
	        view_holder = new ViewHolderPattern();
	        view_holder.tekst_w_layoucie = (TextView) convertView.findViewById(R.id.textView_item_custom);
	 
	        convertView.setTag(view_holder);
	    } else {
	        view_holder = (ViewHolderPattern) convertView.getTag();
	    }
	 
	    view_holder.tekst_w_layoucie.setText(data[position]);
	 
	    return convertView;
	}

}
