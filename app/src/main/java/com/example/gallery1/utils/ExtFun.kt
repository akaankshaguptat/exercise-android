package com.example.gallery1.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

fun Context.isNetworkAvailable(): Boolean {
    val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    var networkStatus=cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    if(networkStatus==false){
        Toast.makeText(this,"Network not available",Toast.LENGTH_SHORT).show()
    }
    return networkStatus
}