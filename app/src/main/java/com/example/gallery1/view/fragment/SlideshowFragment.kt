package com.example.gallery1.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.gallery1.R


class SlideshowFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)


        val timelineFragment=
            TimelineFragment()
        activity?.supportFragmentManager?.beginTransaction()
            ?.add(R.id.timeline_frag,timelineFragment)
            ?.addToBackStack(null)?.commit()
        return root
    }
}
