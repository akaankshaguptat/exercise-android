package com.example.gallery1.viewmodel

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallery1.data.FireBaseData
import com.example.gallery1.model.data.Repository


class LoginViewModel: ViewModel() {
    private var firebase= FireBaseData()
    private var repo= Repository(firebase)

    fun loginStatus(email:String,password:String,activity: Activity):MutableLiveData<Boolean>{
        var status=repo.login(email,password,activity)
        return status
    }
}