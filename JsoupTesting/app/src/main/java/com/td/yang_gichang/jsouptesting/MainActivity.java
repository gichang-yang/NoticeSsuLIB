package com.td.yang_gichang.jsouptesting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView textView;
    Parser parse;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.RELOAD) {

            parse = new Parser();
            parse.setListView(textView);
            parse.setContext(getApplicationContext());
            parse.execute();
            return true;
        }

        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reload, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (ListView) findViewById(R.id.notice_list);


        parse = new Parser();
        parse.setListView(textView);
        parse.setContext(getApplicationContext());
        parse.execute();
        textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("touchAct", "touched");
                Intent intent = new Intent(getApplicationContext(), NoticeDetail.class);
                intent.putExtra("position", position);
                intent.putExtra("title", parse.getNoticeList().get(position));
                intent.putExtra("url", parse.getLink().get(position));
                startActivity(intent);

            }


        });

    }


}
