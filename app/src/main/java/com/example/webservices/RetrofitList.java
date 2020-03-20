package com.example.webservices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitList extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    public static ArrayList<Post> arrayList = new ArrayList<>();
    public static final String URL="https://storage.googleapis.com/network-security-conf-codelab.appspot.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        setContentView(R.layout.activity_retrofit);
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        getData();

    }

    private void getData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi request = retrofit.create(JsonPlaceHolderApi.class);
        Call<model> call = request.getJsonObjectData();
        call.enqueue(new Callback<model>() {
            @Override
            public void onResponse(Call<model> call, Response<model> response) {

                model jsonResponse = response.body();

                Log.v("body",jsonResponse.getPosts().length+"" );
                ArrayList<Post> data = new ArrayList(Arrays.asList(jsonResponse.getPosts()));
                String name= data.get(0).getName();
                Log.v("name==",name+"");
                MyAdapter adapter = new MyAdapter(data,RetrofitList.this);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<model> call, Throwable t) {
                Log.v("Error",t.getMessage());
            }
        });

    }
}
