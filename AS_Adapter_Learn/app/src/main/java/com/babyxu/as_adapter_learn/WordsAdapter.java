package com.babyxu.as_adapter_learn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class WordsAdapter extends BaseAdapter{
    private LinkedList<Object_Words> mdata;
    private Context mcontext;


    public WordsAdapter(LinkedList<Object_Words> mdata, Context mcontext) {
        this.mdata = mdata;
        this.mcontext = mcontext;
    }


    @Override
    public int getCount() {
        return mdata.size();
    }

    @Override
    public Object getItem(int position) {
        return mdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        item_words_Viewholder item_words_viewholder;
        if (convertView==null){

            convertView = LayoutInflater.from(mcontext).inflate(R.layout.item_words,null);
            item_words_viewholder = new item_words_Viewholder();
            item_words_viewholder.img = (ImageView)convertView.findViewById(R.id.img1);
            item_words_viewholder.txt_title = (TextView)convertView.findViewById(R.id.txt_title);
            item_words_viewholder.txt_content =(TextView)convertView.findViewById(R.id.txt_content);

            item_words_viewholder.img.setBackgroundResource(mdata.get(position).getaIcon());
            item_words_viewholder.txt_title.setText(mdata.get(position).getaName());
            item_words_viewholder.txt_content.setText(mdata.get(position).getaSpeak());




            convertView.setTag(item_words_viewholder);
        }else{
            item_words_viewholder = (item_words_Viewholder) convertView.getTag();
        }

        return convertView;
    }

    private class item_words_Viewholder{
        ImageView img;
        TextView txt_title;
        TextView txt_content;
    }

}
