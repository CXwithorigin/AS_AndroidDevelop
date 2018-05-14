package com.babyxu.as_imageview_learn;

import android.graphics.Rect;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private RelativeLayout relativeLayout1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout1 = (RelativeLayout)findViewById(R.id.relative1);

        RelativeLayout.LayoutParams layoutparam_relative =
                new RelativeLayout.LayoutParams(500,500);


        LinearLayout linearLayout = new LinearLayout(MainActivity.this);
        LinearLayout.LayoutParams layoutparam_linear = new LinearLayout.LayoutParams(100,100);

        img1 = (ImageView) findViewById(R.id.imgview1);
        img2 = (ImageView) findViewById(R.id.imgview2);

        img1.setImageResource(R.drawable.yellow1);
        img2.setBackgroundResource(R.drawable.yellow1);

        img3 =(ImageView)new ImageView(MainActivity.this);

        img3.setBackgroundResource(R.drawable.yellow1);

        layoutparam_relative.addRule(RelativeLayout.BELOW,img2.getId());
//        linearLayout.addView(img3,layoutparam_linear);
        //可以动态设置img3
        relativeLayout1.addView(img3,layoutparam_relative);



        //relativeLayout1.addView(img3,layoutparam);

    }
}
