package com.example.soskdientu.activity.thongbao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.camnangyte.DetailActivity;
import com.example.soskdientu.activity.camnangyte.XMLParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ThongbaoActivity extends AppCompatActivity {
    ListView listView;
    List<String> arrList = new ArrayList<>();//mang luu title
    List<String> arrLink = new ArrayList<>();//mang luu duong dan
    ArrayAdapter<String> arrayAdapter;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongbao);
        listView = findViewById(R.id.demo51Listview2);
        //goi ham ket noi den server
        new  RSSHauTruong().execute("https://vnexpress.net/rss/suc-khoe.rss");
        //dua len listview
        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrList);
        listView.setAdapter(arrayAdapter);
        //click item -> bai viet
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String link = arrLink.get(i);//lay ve vi tri cua link
                intent = new Intent(ThongbaoActivity.this, DetailActivity.class);
                intent.putExtra("linkBaiViet",link);
                startActivity(intent);
            }
        });

    }
    //dinh nghia lop noi:
    //Lay du lieu tu server
    public class RSSHauTruong extends AsyncTask<String,Void,String> {
        //1. thuc thi yeu cau
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();//ket qua tra ve luu o content
            //1.1 Khai bao duong link can doc du lieu
            try {
                URL url = new URL(strings[0]);//lay ve duong link dau tien
                //bat dau doc du lieu (~java2)
                //mo ket noi va dua du lieu vao stream reader
                InputStreamReader reader
                        = new InputStreamReader(url.openConnection().getInputStream());
                //khai bao chuoi ket quaa
                String line="";
                //tao luong doc
                BufferedReader bufferedReader = new BufferedReader(reader);
                //cho vao vong lap de lay tung thanh phan du lieu
                while ((line=bufferedReader.readLine())!=null)//doc theo tung dong
                {
                    content.append(line);//noi cac dong line doc duoc vao content
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }
        //2. dua ket qua len dien thoai
//chu y: sau khi ham doInBackground thuc hien xong se tra ve content, va content nay duoc truyen vao s
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //su dung cac ham phan tich cu phap xml de dua ket qua len listview
            com.example.soskdientu.activity.camnangyte.XMLParser xmlParser = new XMLParser();
            try {
                Document document = xmlParser.getDocument(s);//tao tai lieu tu ket qua tra ve content
                NodeList nodeList = document.getElementsByTagName("item");
                String title="";
                for(int i=0;i<nodeList.getLength();i++)
                {
                    Element element = (Element)nodeList.item(i);//lay ve item thu i
                    title = xmlParser.getValue(element,"title")+"\n";//lay ve title
                    arrList.add(title);//lay title dua vao list
                    arrLink.add(xmlParser.getValue(element,"link"));//lay link dua vao list
                }
                //cap nhat vao adapter
                arrayAdapter.notifyDataSetChanged();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }
    }
}