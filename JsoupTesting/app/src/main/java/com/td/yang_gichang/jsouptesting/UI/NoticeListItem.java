package com.td.yang_gichang.jsouptesting.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.td.yang_gichang.jsouptesting.R;

/**
 * Created by yang-gichang on 2017. 5. 25..
 */

public class NoticeListItem extends LinearLayout{

    TextView notice;
    ImageView imageView;

    public NoticeListItem(Context context) {
        super(context);
        init(context);

        notice=(TextView)findViewById(R.id.itemText);
        imageView=(ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.ic_dehaze_black_24dp);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.list_item,this);


    }

}
