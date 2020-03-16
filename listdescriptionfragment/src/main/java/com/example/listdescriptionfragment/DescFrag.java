package com.example.listdescriptionfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class DescFrag extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_description,container,false);
        View view1 = view.findViewById(R.id.title);
        View view2 = view.findViewById(R.id.desc);

        Bundle bundle=getArguments();
        int position=bundle.getInt("itemposition");

        String title=getTitle(position);
        String desc=getDesc(position);

        ((TextView)view1).setText(title);
        ((TextView)view2).setText(desc);
        return view;

    }

    private String getTitle(int position) {
        ArrayList<String> title=new ArrayList<>();
        title.add("apple");
        title.add("orange");
        title.add("grapes");
        title.add("berry");
        title.add("watermelon");
        String title1=title.get(position);
        return  title1;
    }

    private String getDesc(int position) {
        ArrayList<String> description=new ArrayList<>();
        description.add("apple desc");
        description.add("orange desc");
        description.add("grapes desc");
        description.add("berry desc");
        description.add("watermelon desc");
        String desc=description.get(position);
        return desc;
    }



}
