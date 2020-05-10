package com.example.gallery1.viewmodel

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallery1.data.FireBaseData
import com.example.gallery1.model.data.Repository
import com.example.gallery1.utils.isNetworkAvailable


class SignUpViewModel:ViewModel()
{

    private var firebase= FireBaseData()
    private var repo= Repository(firebase)
    private lateinit var context:Context

    fun signupStatus(email:String, password:String, name:String, activity: Activity, profileImageView: ImageView):MutableLiveData<Boolean>
    {

        var data=repo.signup(email,password,name,activity,profileImageView)
        return data
    }
    fun updateProfileData(bitmap: Bitmap, email:String, password:String, name:String, activity: Activity):MutableLiveData<Boolean>{
        var data=repo.updateProfileData(bitmap,email,password,name,activity)
        return data
    }

}