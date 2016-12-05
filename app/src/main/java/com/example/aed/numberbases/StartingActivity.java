package com.example.aed.numberbases;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class StartingActivity extends Activity {

    TextView tv1;
    ImageView iv1;
    TextView tv2;
    ImageView iv2;
   // ImageView iv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_starting);

        tv1 = (TextView)findViewById(R.id.textView);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/centaurus.ttf");
        tv1.setTypeface(font);

        iv1 = (ImageView)findViewById(R.id.imageView);
        iv1.setImageResource(R.drawable.nautilus);

        tv2 = (TextView)findViewById(R.id.textView2);
        Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/citycontrasts.ttf");
        tv2.setTypeface(font2);

        iv2 = (ImageView)findViewById(R.id.imageView2);
        iv2.setImageResource(R.drawable.what);
        //iv3 = (ImageView)findViewById(R.id.imageView3);
       // iv3.setImageResource(R.drawable.how);



        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartingActivity.this, InfoPage.class));
            }
        });

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartingActivity.this, Calculation.class));

            }
        });




    }



}
