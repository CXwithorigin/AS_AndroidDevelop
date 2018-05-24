package com.babyxu.as_adapter_learn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView listview1;
    LinkedList<Object_Words> mdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //链表来构建Words的对象内容
        mdata  =new LinkedList<Object_Words>();
        //对应每个Object对象都有元素设置
        String[] str_words = {"Adapt","Program","demostration"};
        String[] str_description = {"this is Adapt","this is Program","this is demostration"};
        int[] item_res = {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};

        //将mdata用上面的数据元素构建起来
        for (int i=0 ; i<str_words.length; i++){
            mdata.add(new Object_Words(str_words[i],str_description[i],item_res[i]));
        }

        listview1 = (ListView)findViewById(R.id.listview1);

/*        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this
        ,android.R.layout.simple_expandable_list_item_1,strs);*/


        listview1.setAdapter(new WordsAdapter((LinkedList<Object_Words>)mdata,MainActivity.this));
    }
}
