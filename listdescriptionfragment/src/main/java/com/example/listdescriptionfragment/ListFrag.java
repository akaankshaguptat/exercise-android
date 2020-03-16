package com.example.listdescriptionfragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

public class ListFrag extends ListFragment {
    private String list_array[]={"apple","orange","grapes","berry","watermelon"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListAdapter listAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list_array);
        setListAdapter(listAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Bundle bundle=new Bundle();
        bundle.putInt("itemposition",position);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        DescFrag descFragment = new DescFrag();
        descFragment.setArguments(bundle);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragmentTransaction.replace(R.id.description_frag, descFragment);
            fragmentTransaction.addToBackStack("descFrag");
            fragmentTransaction.commit();
        }else{
            fragmentTransaction.replace(R.id.listcontainer,descFragment);
            fragmentTransaction.addToBackStack("descFrag");
            fragmentTransaction.commit();
        }
    }
}
