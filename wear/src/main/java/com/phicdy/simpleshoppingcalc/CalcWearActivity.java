package com.phicdy.simpleshoppingcalc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalcWearActivity extends Activity {

    private GridView gvCalc;
    private WatchViewStub stub;
    private List<String> calcContents = Arrays.asList("7","8","9","÷","4","5","6","×","1","2","3","-");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_wear);
        stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
               initView();
            }
        });
    }

    private void initView () {
        gvCalc = (GridView) stub.findViewById(R.id.gv_calc);
        gvCalc.setAdapter(new CalcAdapter(getApplicationContext(), R.layout.item_calc_gridview, calcContents));
    }

    private class ViewHolder {
        Button btnCalc;
    }

    private class CalcAdapter extends ArrayAdapter<String> {

        private Context context;
        private int resource;

        public CalcAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            this.context = context;
            this.resource = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(resource, parent, false);
                holder = new ViewHolder();
                holder.btnCalc = (Button)convertView.findViewById(R.id.btn_calc_button);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }

            holder.btnCalc.setText(getItem(position));

            return convertView;
        }
    }
}
