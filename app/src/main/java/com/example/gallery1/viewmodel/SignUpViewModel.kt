package com.example.gallery1.viewmodel

import android.app.Activity
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallery1.data.FireBaseData
import com.example.gallery1.model.data.Repository


class SignUpViewModel:ViewModel()
{

    private var firebase= FireBaseData()
    private var repo= Repository(firebase)

    fun signupStatus(email:String, password:String, name:String, activity: Activity, profileImageView: ImageView):MutableLiveData<Boolean>
    {
        var data=repo.signup(email,password,name,activity,profileImageView)
        return data
    }
}