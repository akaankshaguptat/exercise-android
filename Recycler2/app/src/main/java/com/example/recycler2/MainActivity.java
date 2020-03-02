package com.example.recycler2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter_class adapter;
    ArrayList<String> arrayList=new ArrayList<>();
    boolean isScrolling=false;
    int currentItems,totalItems,scrolledOutItem;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
         progressBar=findViewById(R.id.progressBar);
        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        arrayList.add("Akaanksha");
        arrayList.add("Astha");
        arrayList.add("Bharat");
        arrayList.add("Priya");
        arrayList.add("Ujjwal");
        arrayList.add("Tanvi");
        arrayList.add("Ashutosh");
        arrayList.add("Naveen");
        arrayList.add("Subarno");
        arrayList.add("Ankit");
        arrayList.add("Anupam");
        arrayList.add("Lakshya");

        adapter=new Adapter_class(arrayList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState== AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling=true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItems=linearLayoutManager.getChildCount();
                totalItems=linearLayoutManager.getItemCount();
                scrolledOutItem=linearLayoutManager.findFirstVisibleItemPosition();
                if(isScrolling &&(scrolledOutItem+currentItems==totalItems)){
                    isScrolling=false;
                    fetchdata();
                }
            }
        });




    }

    private void fetchdata() {
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    arrayList.add(Math.floor(Math.random()*100)+"");
                    adapter.notifyDataSetChanged();
                }
                progressBar.setVisibility(View.GONE);

            }
        }, 5000);
    }
}
