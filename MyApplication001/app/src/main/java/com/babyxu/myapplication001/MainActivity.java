package com.babyxu.myapplication001;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity
{
    private TextView textView;
    private TextView textview1;
    private TextView txt2;
    private EditText edittext1;
    private Button btn1;
    private Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//加载布局文件的
        textView = (TextView)findViewById(R.id.textview_web);
        //
        textView.setAutoLinkMask(Linkify.ALL);
        //must have txt1是一个连接跳转的功能
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        textview1 = (TextView)findViewById(R.id.textview1);
        //EditView是文本输入框,点击就会全选
        //EditView是文本输入框，点击不会全选
        edittext1 = (EditText)findViewById(R.id.edittext);
        //
        //edittext1.setSelected(true);

        //txt2的跑马灯效果
        txt2 = (TextView)findViewById(R.id.txt2);

        //必须要setSelected
        txt2.setSelected(true);

        //给小黄人图片添加链接
        String s1 = "图片:<img src= 'yellow1'/><br>";
        textview1.setText(Html.fromHtml(s1,1 ,new Html.ImageGetter()
        {
            @Override
            public Drawable getDrawable(String source)
            {
                Drawable draw = null;
                try
                {
                    Field field = R.drawable.class.getField(source);
                    int resourceId = Integer.parseInt(field.get(null).toString());
                    draw = getResources().getDrawable(resourceId, getTheme());

                    draw.setBounds(0,0,draw.getIntrinsicWidth(),draw.getIntrinsicHeight());
                    draw.setAlpha(50);

                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }

                return draw;
            }
        },null));
        textview1.setAutoLinkMask(Linkify.ALL);
        textview1.setMovementMethod(LinkMovementMethod.getInstance());

        //btn1,btn2展示按钮的功能
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(btn2.getText().toString().equals("上面的按钮可用")){
                    btn1.setEnabled(false);
                    btn2.setText("上面的按钮不可用");

                }
                else{
                    btn1.setEnabled(true);
                    btn2.setText("上面的按钮可用");
                }
            }
        });
    }
}
