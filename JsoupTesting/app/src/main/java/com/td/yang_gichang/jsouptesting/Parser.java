package com.td.yang_gichang.jsouptesting;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import static android.util.Log.d;

/**
 * Created by yang-gichang on 2017. 5. 24..
 */

public class Parser extends AsyncTask<ArrayList<String>, Integer, Void> {

    TextView txt;
    Elements list;
    Context context;
    ListView li;
    private ArrayList<String> noticeList = new ArrayList<String>();
    private ArrayList<String> link = new ArrayList<String>();

    public Parser() {

    }

    public ArrayList<String> getLink() {
        return link;
    }

    public ArrayList<String> getNoticeList() {
        return noticeList;
    }

    @Override
    protected Void doInBackground(ArrayList<String>... params) {
        try {
            String initUrl = "http://oasis.ssu.ac.kr";
            Document doc = Jsoup.connect("http://oasis.ssu.ac.kr/bbs/Bbs.ax?bbsID=1").get();
            list = doc.select(".boardlist tbody > tr");
            for (int i = 0; i < list.size(); i++) {
                Elements tmp = list.get(i).select("[headers=" + "listTitle" + "]").select("a");
                Log.d("parsed", list.get(i).select("[headers=" + "listTitle" + "]").select("a").attr("href").toString());
                Log.d("parsed", list.get(i).select("[headers=" + "listTitle" + "]").select("a").text().toString());
                noticeList.add(tmp.text().toString());

                String url = initUrl + tmp.attr("href").substring(2);
                Log.d("linkY", url);
                // Document detailNotice = Jsoup.connect(url).get();
                // Elements el=detailNotice.select(".board");
                link.add(url);

            }
        } catch (Exception e) {
            list = new Elements();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        onProgressUpdate();


    }


    @Override
    protected void onCancelled() {
        d("parser", "canceled");

    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setListView(ListView li) {
        this.li = li;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        //txt.setText("");
        for (int i = 0; i < list.size(); i++) {

            d("uith", list.get(i).select("[headers=" + "listTitle" + "]").select("a").toString());


            //link.add(list.get(i).select("[headers=" + "listTitle" + "]").select("a").attr("href").toString()+'\n');


            NoticeAdapter adapter = new NoticeAdapter();
            adapter.setArrayList(noticeList);

            li.setAdapter(adapter);

            /*li.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent=new Intent(context,NoticeDetail.class);
                    intent.putExtra("title",noticeList.get(position));
                    intent.putExtra("tag",link.get(position));
                    context.startActivity(intent);

                }

            });*/

            d("parser", "parse finished");
        }
    }
}
