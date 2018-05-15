package com.babyxu.as_radiobutton_learn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button btn_submit;
private RadioGroup radiogroup1;
private RadioButton radiobutton_checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_submit = (Button)findViewById(R.id.button_submit);
        radiogroup1 = (RadioGroup)findViewById(R.id.radiogroup_grade);

        radiogroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radiobutton_checked = (RadioButton)findViewById(checkedId);
                Toast.makeText(MainActivity.this, "按钮值改变为:"
                        +radiobutton_checked.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"你提交的年级值为:"+
                        radiobutton_checked.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
