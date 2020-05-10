package com.example.gallery1.utils

import android.content.Context
import android.net.ConnectivityManager

fun Context.isNetworkAvailable(): Boolean {
    val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    var networkStatus = cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    return networkStatus
}