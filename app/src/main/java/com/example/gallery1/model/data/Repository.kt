package com.example.gallery1.model.data

import android.app.Activity
import android.graphics.Bitmap
import android.widget.ImageView
import com.example.gallery1.data.FireBaseData


class Repository(private val firebase: FireBaseData){

    fun getCategoryData()=firebase.getCategoryArrayList()

    fun getTimeLineData()=firebase.getTimeLineArrayList()

    fun getImagesData(id:String)=firebase.getImagesArrayList(id)

    fun getSingleImageData(id:String)=firebase.getSingleImageData(id)

    fun deleteImage(id:String,cid:String)=firebase.deleteImage(cid,id)

    fun login(email:String,password:String,activity:Activity)=firebase.login(email,password,activity)

    fun signup(email:String,password:String,name:String,activity:Activity,profileImageView:ImageView)=firebase.signUp(email,password,name,activity,profileImageView)

    fun updateProfileData(bitmpa:Bitmap,email:String,password: String,name:String,activity: Activity)=
        firebase.uplaodImageAndSaveUri(bitmpa,email,password,name,activity)

    fun profileData()=firebase.getProfileData()

    fun uploadCategory(title:String,imageBitmap: Bitmap,activity: Activity)=firebase.uploadCategoryImage(title,imageBitmap,activity)

}