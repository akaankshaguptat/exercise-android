package com.example.listdescriptionfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = new Bundle();
        bundle.putInt("itemPosition", 0);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ListFrag listFrag = new ListFrag();
        DescFrag descFragment = new DescFrag();
        descFragment.setArguments(bundle);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            fragmentTransaction.replace(R.id.list_frag, listFrag, "listFrag");
            fragmentTransaction.replace(R.id.description_frag, descFragment);
            fragmentTransaction.commit();
        }
        else {
            fragmentTransaction.replace(R.id.listcontainer, listFrag, "listFrag");
            fragmentTransaction.addToBackStack("listFrag");
            fragmentTransaction.commit();
        }
    }
}
