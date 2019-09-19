package com.awal.awalsatiaje.tugas1.biodatapegawai;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.awal.awalsatiaje.tugas1.R;

import java.util.List;

public class Adapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> items;

    public Adapter(Activity activity, List<Data> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int location) {
        return items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.activity_list_row_biodata, null);

        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView nik = (TextView) convertView.findViewById(R.id.nik);
        TextView name = (TextView) convertView.findViewById(R.id.name);

        Data data = items.get(position);

        id.setText(data.getId());
        nik.setText(data.getNik());
        name.setText(data.getName());

        return convertView;
    }
}
