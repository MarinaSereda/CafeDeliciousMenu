package com.example.dima.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class CheckPrint extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_layout);

        ListView checkListPrintView = (ListView) findViewById(R.id.check_list);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, CheckList.getList());
        checkListPrintView.setAdapter(adapter);

        TextView tvSum = (TextView) findViewById(R.id.suma_check);
        tvSum.setText(String.valueOf(getResources().getString(R.string.text_suma) + CheckList.suma));
    }
}
