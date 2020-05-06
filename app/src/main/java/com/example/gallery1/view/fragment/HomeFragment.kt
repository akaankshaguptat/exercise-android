package com.example.gallery1.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.gallery1.*


class HomeFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        // val textView: TextView = root.findViewById(R.id.text_home)

        val categoryFragment= Category1()
        activity?.supportFragmentManager?.beginTransaction()
            ?.add(R.id.home_frag,categoryFragment)
            ?.addToBackStack(null)?.commit()

        return root
    }


}
