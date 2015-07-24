package com.presslab.noticias.adapters;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.presslab.R;

import java.util.List;

//Adapter do Navigation Drawer
/**
 * Created by ramonferreira on 24/07/15.
 */
public class Adapterdrawer extends BaseAdapter {
    private Context context;
    private List<MenuItem> list;

    public Adapterdrawer(Context context, List<MenuItem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View view, ViewGroup parent) {

        TextView textView = new TextView(context);
        textView.setText(list.size());
        textView.setTextColor(Color.BLACK);

        return parent;
    }
}
