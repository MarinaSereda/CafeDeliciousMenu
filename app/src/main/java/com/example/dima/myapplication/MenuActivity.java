package com.example.dima.myapplication;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MenuActivity extends AppCompatActivity {


    private static final String KEY = "key";
    private static final int PADDING_EIGHT = 8;
    private final static String ID = "id";
    private final static String PRICE = "price";
    private final static String NAME = "name";
    private String result;
    private RelativeLayout relativeLayout;
    private Product product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        Intent intent;
        // отпримуєм дані з Main Activity
        intent = getIntent();
        // записуєм їх в result
        result = intent.getStringExtra(KEY);
        // створюєм екземпляр класу Product
        product = new Product();
        // знаходим по ід лайоут
        LinearLayout layout = (LinearLayout) findViewById(R.id.relative_container);
        // створюєм цикл від 0 до лічильника який вказаний в класі Product в методі ItemCount
        for (int i = 0; i < product.itemCount(result); i++) {
            // динамічно створюєм рел.лай
            relativeLayout = new RelativeLayout(this);
            // сворюєм параметри wrap content/match parent
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            relativeLayout.setLayoutParams(params);
            inputData(i);
            if (layout != null) {
                layout.addView(relativeLayout);
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void createView(final String s, final int id, final String price) {
        ImageView imageView = new ImageView(this);
        RelativeLayout.LayoutParams paramsImage = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        imageView.setPadding(PADDING_EIGHT, PADDING_EIGHT, PADDING_EIGHT, PADDING_EIGHT);
        imageView.setContentDescription(getResources().getString(R.string.desc));
        imageView.setLayoutParams(paramsImage);
        imageView.setId(getResources().getInteger(R.integer.id_image));
        imageView.setImageResource(id);
        relativeLayout.addView(imageView);

        TextView textViewName = new TextView(this);
        RelativeLayout.LayoutParams paramsTextName = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsTextName.addRule(RelativeLayout.END_OF, imageView.getId());
        paramsTextName.addRule(RelativeLayout.CENTER_VERTICAL);
        textViewName.setPadding(PADDING_EIGHT, PADDING_EIGHT, PADDING_EIGHT, PADDING_EIGHT);
        textViewName.setLayoutParams(paramsTextName);
        textViewName.setTextSize(14);
        textViewName.setText(s);
        relativeLayout.addView(textViewName);

        ImageButton imageButtonNext = new ImageButton(this);
        RelativeLayout.LayoutParams paramsImageButtonNext = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsImageButtonNext.addRule(RelativeLayout.ALIGN_PARENT_END);
        paramsImageButtonNext.addRule(RelativeLayout.CENTER_VERTICAL);
        //   imageButtonNext.setPadding(PADDING_EIGHT, PADDING_EIGHT, PADDING_EIGHT, PADDING_EIGHT);
        imageButtonNext.setContentDescription(getResources().getString(R.string.desc));
        imageButtonNext.setLayoutParams(paramsImageButtonNext);
        imageButtonNext.setId(getResources().getInteger(R.integer.id_image_button));
        imageButtonNext.setBackgroundResource(R.drawable.next);
        relativeLayout.addView(imageButtonNext);

        imageButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(MenuActivity.this, BuyFood.class);
                // передаєм дані: зображення, назву, ціну в наст.лояут
                menuIntent.putExtra(ID, id);
                menuIntent.putExtra(PRICE, price);
                menuIntent.putExtra(NAME, s);
                startActivity(menuIntent);
            }
        });

        TextView textViewPrice = new TextView(this);
        RelativeLayout.LayoutParams paramsTextPrice = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsTextPrice.addRule(RelativeLayout.START_OF, imageButtonNext.getId());
        paramsTextPrice.addRule(RelativeLayout.CENTER_VERTICAL);
        // textViewPrice.setPadding(PADDING_EIGHT, PADDING_EIGHT, PADDING_EIGHT, PADDING_EIGHT);
        textViewPrice.setPadding(0, 0, PADDING_EIGHT, 0);
        textViewPrice.setLayoutParams(paramsTextPrice);
        textViewPrice.setTextSize(14);
        textViewPrice.setText(price);
        relativeLayout.addView(textViewPrice);

    }

    private void inputData(int i) {
        switch (result) {
            case "soup": {
                String s = product.getSoupName()[i];
                int drawableId = product.getDrawableSoupId()[i];
                String price = product.getSoupPrice()[i];
                createView(s, drawableId, price);
                break;
            }
            case "appetizer": {
                String s = product.getAppetizerName()[i];
                int drawableId = product.getDrawableAppetizerId()[i];
                String price = product.getAppetizerPrice()[i];
                createView(s, drawableId, price);
                break;
            }
            case "desserts": {
                String s = product.getDessertsName()[i];
                int drawableId = product.getDrawableDessertsId()[i];
                String price = product.getDessertsPrice()[i];
                createView(s, drawableId, price);
                break;
            }
            case "beverages": {
                String s = product.getBeveragesName()[i];
                int drawableId = product.getDrawableBeveragesId()[i];
                String price = product.getBeveragesPrice()[i];
                createView(s, drawableId, price);
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actvity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.but_check) {
            Intent intentCheckPrint = new Intent(MenuActivity.this, CheckPrint.class);
            startActivity(intentCheckPrint);
        }
        return super.onOptionsItemSelected(item);
    }
}
