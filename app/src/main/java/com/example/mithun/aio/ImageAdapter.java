package com.example.mithun.aio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mithun on 28/3/18.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<AppGridDisplay.appObject> applications;

    public ImageAdapter(Context c,ArrayList<AppGridDisplay.appObject> applications) {
        mContext = c;
        this.applications=applications;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return applications.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        /*LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {


            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_list_item, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(applications.get(position).appName);
            imageView.setBackground(applications.get(position).icon);

        } else {
            grid = (View) convertView;
        }

        return grid;*/

        if (convertView == null) {  // if it's not recycled, initialize some attributes
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid = inflater.inflate(R.layout.grid_list_item, parent, false);
        } else {
            grid = (View) convertView;
        }
        TextView text = (TextView)grid.findViewById(R.id.grid_text);
        text.setText(applications.get(position).appName);
        ImageView image = (ImageView)grid.findViewById(R.id.grid_image);
        image.setBackground(applications.get(position).icon);
        return grid;
    }
}