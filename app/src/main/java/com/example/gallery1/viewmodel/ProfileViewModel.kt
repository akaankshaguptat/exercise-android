package com.example.gallery1.viewmodel

import android.app.Activity
import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallery1.data.FireBaseData

import com.example.gallery1.model.pojo.ProfileModelClass
import com.example.gallery1.model.data.Repository

class ProfileViewModel : ViewModel()
{

    private var firebase= FireBaseData()
    private var repo= Repository(firebase)


    fun profiileData():MutableLiveData<ProfileModelClass>
    {
        var data=repo.profileData()
        return data
    }


    fun updateProfileData(bitmap: Bitmap,name:String,email:String,password:String,activity: Activity):MutableLiveData<Boolean>
    {
        var data=repo.updateProfileData(bitmap,email,password,name,activity)
        return data
    }



}