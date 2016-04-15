package com.example.dima.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BuyFood extends AppCompatActivity implements View.OnClickListener {
    private final static String ID = "id";
    private final static String PRICE = "price";
    private final static String NAME = "name";
    private TextView tvCount, sum;
    private int i = 1;
    private int parsPrice;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_layout);

        ImageView itemImage = (ImageView) findViewById(R.id.itemImage);
        TextView tvName = (TextView) findViewById(R.id.textItemSelection);
        TextView tvPrice = (TextView) findViewById(R.id.priceItem);
        sum = (TextView) findViewById(R.id.amount);
        tvCount = (TextView) findViewById(R.id.tv_id_count);
        Button arrowLeft, arrowRight, buy;
        arrowLeft = (Button) findViewById(R.id.but_id_arrow_left);
        arrowRight = (Button) findViewById(R.id.but_id_arrow_right);
        buy = (Button) findViewById(R.id.but_id_buy);
        // отримуєм дані
        Intent intent = getIntent();
        // отримуєм адресу зображення, якщо вона є. Якщо немає ід дорівнює -1.
        int id = intent.getIntExtra(ID, -1);
        String price = getResources().getString(R.string.price_item) + " - " + intent.getStringExtra(PRICE);
        parsPrice = parseString(intent.getStringExtra(PRICE));
        String amount = "Sum = $" + String.valueOf(parsPrice);
        sum.setText(amount);
        name = intent.getStringExtra(NAME);
        if (id != -1) {
            itemImage.setImageResource(id);
            tvPrice.setText(price);
            tvName.setText(name);
        }

        arrowLeft.setOnClickListener(this);
        arrowRight.setOnClickListener(this);
        buy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_id_arrow_left:
                if (i > 0 && i != 1) {
                    i--;
                    int res = parsPrice * i;
                    String amount = "Sum = $" + String.valueOf(res);
                    sum.setText(amount);
                    tvCount.setText(String.valueOf(i));
                }
                break;
            case R.id.but_id_arrow_right:
                if (i > 0 && i < 10) {
                    i++;
                    int res = parsPrice * i;
                    String amount = "Sum = $" + String.valueOf(res);
                    sum.setText(amount);
                    tvCount.setText(String.valueOf(i));
                }
                break;
            case R.id.but_id_buy:
                int parsSum = parseString(String.valueOf(sum.getText()));
                String s = name + "\n                      "
                        + String.valueOf(tvCount.getText()) + "x" + String.valueOf(parsPrice) + " = $" + parsSum;
                CheckList.setS(s);
                CheckList.addToBill();
                CheckList.Sum(parsSum);
                Toast.makeText(BuyFood.this, "Added to the bill", Toast.LENGTH_SHORT).show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        finish();
                    }
                }, 500);
                break;
            default:
                break;
        }
    }

    public int parseString(String p) {
        Pattern pattern = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher matcher = pattern.matcher(p);
        String res = null;
        while (matcher.find()) {
            res = matcher.group();
        }
        if (res != null) {
            return Integer.valueOf(res);
        } else {
            return -1;
        }
    }
}
