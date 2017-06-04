package com.td.yang_gichang.jsouptesting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.td.yang_gichang.jsouptesting.UI.NoticeListItem;

import java.util.ArrayList;

/**
 * Created by yang-gichang on 2017. 5. 25..
 */

public class NoticeAdapter extends BaseAdapter {
    //Context context;
    ArrayList<String> notice;

    public void setArrayList(ArrayList<String> al) {
        this.notice = al;

    }

    //public NoticeAdapter(Context context) {
     //   this.context = context;
    //}

    @Override
    public int getCount() {
        return notice.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NoticeListItem item;

        if (convertView == null) item = new NoticeListItem(parent.getContext());
        else return convertView;


        ImageView img = (ImageView) item.findViewById(R.id.imageView);

        TextView txt;
        txt = (TextView) item.findViewById(R.id.itemText);
        txt.setText(notice.get(position));
        return item;
    }
}
