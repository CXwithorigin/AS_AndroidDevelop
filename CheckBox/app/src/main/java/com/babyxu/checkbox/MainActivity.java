package com.babyxu.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CompoundButton checkbox1;
    private CompoundButton checkbox2;
    private CompoundButton checkbox3;

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        CompoundButton.OnCheckedChangeListener oncheckedlistener;

        checkbox1 = (CompoundButton)findViewById(R.id.checkbox1);
        checkbox2 = (CompoundButton)findViewById(R.id.checkbox2);
        checkbox3 = (CompoundButton)findViewById(R.id.checkbox3);

        button = (Button)findViewById(R.id.button_submit);

/*        checkbox1.setOnCheckedChangeListener(oncheckedlistener);
        checkbox2.setOnCheckedChangeListener(oncheckedlistener);
        checkbox3.setOnCheckedChangeListener(oncheckedlistener);*/
        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this,buttonView.getText().toString()
                            ,Toast.LENGTH_SHORT);
                }
            }
        });
        checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this,buttonView.getText().toString()
                            ,Toast.LENGTH_SHORT);
                }
            }
        });
        checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this,buttonView.getText().toString()
                            ,Toast.LENGTH_SHORT);
                }
            }
        });
        button.setOnClickListener(onclicklistener);



    }

    /*CompoundButton.OnCheckedChangeListener oncheckedlistener = new CompoundButton.OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        {
            if(buttonView.isChecked()){
                Toast.makeText(MainActivity.this,buttonView.getText()
                        +"被选中",Toast.LENGTH_SHORT);
            }

        }
    };*/
    View.OnClickListener onclicklistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String choose = "";
            if(checkbox1.isChecked())choose += checkbox1.getText().toString() + "";
            if(checkbox2.isChecked())choose += checkbox2.getText().toString() + "";
            if(checkbox3.isChecked())choose += checkbox3.getText().toString() + "";
            Toast.makeText(MainActivity.this,choose,Toast.LENGTH_SHORT).show();
        }
    };

}
