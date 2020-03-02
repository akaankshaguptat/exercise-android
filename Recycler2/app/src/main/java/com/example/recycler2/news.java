package com.example.recycler2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recycler2.POJO.NewsModel;

import java.util.ArrayList;

public class news extends AppCompatActivity {
    RecyclerView recyclerview;
    ArrayList<NewsModel> al=new ArrayList<>();
    News_Adapterclass adapter1;
    ArrayList<String> title=new ArrayList<>();
    ArrayList<String> description=new ArrayList<>();
    ArrayList<String> time=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        recyclerview=findViewById(R.id.recyclerview2);
        for (int i=0;i<10;i++){
            title.add("Australia's coronavirus pandemic plan: mass vaccinations and stadium quarantine");
            description.add("Australia's coronavirus pandemic plan: mass vaccinations and stadium quarantine");
            time.add("20200227T02:41:00+00:00");
        }
        for(int i=0;i<10;i++){
            String title1=title.get(i);
            String desc=description.get(i);
            String time1=time.get(i);
            if(i==0)
            {
                al.add(new NewsModel(0,R.drawable.food1,title1,desc,time1));
            }
            else if(i==1)
            {
                al.add(new NewsModel(1,R.drawable.food1,title1,desc,time1));
            }
            else if(i%2==0)
                al.add(new NewsModel(2,R.drawable.food1,title1,desc,time1));

             else
            al.add(new NewsModel(1,R.drawable.food1,title1,desc,time1));

        }
        adapter1=new News_Adapterclass(this,al);
        recyclerview.setAdapter(adapter1);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        }


    }

