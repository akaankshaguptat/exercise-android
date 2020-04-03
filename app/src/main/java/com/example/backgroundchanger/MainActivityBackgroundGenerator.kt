package com.example.backgroundchanger

import android.graphics.Color
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainActivityBackgroundGenerator:ViewModel(),LifecycleObserver {
    private var color:Int=0
    fun getColor():Int{
        if(color==0)
            color=generateBackground()
        return color
    }
    fun generateBackground(): Int {
        val random=Random
        color=Color.argb(255,random.nextInt(),random.nextInt(),random.nextInt())
        return color


    }


}