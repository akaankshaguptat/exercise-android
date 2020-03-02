package com.example.recycler2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler2.POJO.NewsModel;

import java.util.ArrayList;

public class News_Adapterclass extends RecyclerView.Adapter<News_Adapterclass.ViewHolder> {
    Context context;
    ArrayList<NewsModel> al;

    public News_Adapterclass(Context context, ArrayList<NewsModel> al) {
        this.context = context;
        this.al = al;
    }


    @NonNull
    @Override
    public News_Adapterclass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch(viewType){
            case NewsModel.IMAGE_ONLY:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_only,parent,false);
                return new MyViewHolder0(view);
            case NewsModel.IMAGE_TEXT:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_text,parent,false);
                return new MyViewHolder1(view);
            case NewsModel.TEXT_ONLY:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.text_only,parent,false);
                return new MyViewHolder2(view);


        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull News_Adapterclass.ViewHolder holder, int position) {
        NewsModel newsModel=al.get(position);
        String heading=newsModel.getHeading();
        String desc=newsModel.getSubheading();
        String time=newsModel.getTime();
        int image=newsModel.getImages();

        switch (newsModel.type)
        {
            case NewsModel.IMAGE_ONLY:
                int image1=newsModel.getImages();
                ((MyViewHolder0)holder).imageView.setImageResource(image1);
                break;
            case NewsModel.IMAGE_TEXT:
                ((MyViewHolder1)holder).mainHeading.setText(heading);
                ((MyViewHolder1)holder).heading.setText(desc);
                ((MyViewHolder1)holder).time.setText(time);
                ((MyViewHolder1)holder).imageView.setImageResource(image);
                break;
            case NewsModel.TEXT_ONLY:
                ((MyViewHolder2)holder).mainHeading.setText(heading);
                ((MyViewHolder2)holder).heading.setText(desc);

                break;

        }


    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private class MyViewHolder0 extends ViewHolder {
        ImageView imageView;
        CardView cardView;
        public MyViewHolder0(View view) {
            super(view);
            imageView=itemView.findViewById(R.id.image);
            cardView=itemView.findViewById(R.id.card1);
        }
    }

    private class MyViewHolder2 extends ViewHolder {
        TextView mainHeading,heading;
        public MyViewHolder2(View view) {
            super(view);
            mainHeading=itemView.findViewById(R.id.textView7);
            heading=itemView.findViewById(R.id.textView8);

        }
    }

    private class MyViewHolder1 extends ViewHolder {
        TextView mainHeading,heading,time;
        ImageView imageView;
        public MyViewHolder1(View view) {
            super(view);
            mainHeading=itemView.findViewById(R.id.textView2);
            heading=itemView.findViewById(R.id.textView3);
            time=itemView.findViewById(R.id.time);
            imageView=itemView.findViewById(R.id.imageView);

        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (al.get(position).type)
        {
            case 0:
                return NewsModel.IMAGE_ONLY;
            case 1:
                return NewsModel.IMAGE_TEXT;
            case 2:
                return NewsModel.TEXT_ONLY;
            default:
                return -1;

        }
    }
}
