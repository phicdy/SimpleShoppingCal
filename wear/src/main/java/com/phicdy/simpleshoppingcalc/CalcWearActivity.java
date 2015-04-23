package com.phicdy.simpleshoppingcalc;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.ArrayAdapter;
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
        ArrayList<String> list = new ArrayList<String>();

        list.addAll(calcContents);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_list_item_1, list);
        gvCalc.setAdapter(adapter);
    }
}
