package com.example.dima.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //приватні змінні
    private static final String SOUP = "soup";
    private static final String APPETIZER = "appetizer";
    private static final String DESSERTS = "desserts";
    private static final String BEVERAGES = "beverages";
    private static final String KEY = "key";
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button soup_button, appetizer_button, desserts_button, beverages_button;

        soup_button = (Button) findViewById(R.id.soup_button);
        appetizer_button = (Button) findViewById(R.id.appetizer_button);
        desserts_button = (Button) findViewById(R.id.desserts_button);
        beverages_button = (Button) findViewById(R.id.beverages_button);

        soup_button.setOnClickListener(this);
        appetizer_button.setOnClickListener(this);
        desserts_button.setOnClickListener(this);
        beverages_button.setOnClickListener(this);

        intent = new Intent(this, MenuActivity.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.soup_button:
                intent.putExtra(KEY, SOUP);
                startActivity(intent);
                break;
            case R.id.appetizer_button:
                intent.putExtra(KEY, APPETIZER);
                startActivity(intent);
                break;
            case R.id.desserts_button:
                intent.putExtra(KEY, DESSERTS);
                startActivity(intent);
                break;
            case R.id.beverages_button:
                intent.putExtra(KEY, BEVERAGES);
                startActivity(intent);
                break;
            default:
                break;

        }

    }
}

