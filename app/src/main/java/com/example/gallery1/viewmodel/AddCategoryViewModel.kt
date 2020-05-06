package com.example.gallery1.viewmodel

import android.app.Activity
import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallery1.data.FireBaseData
import com.example.gallery1.model.pojo.CategoryModel
import com.example.gallery1.model.data.Repository

class AddCategoryViewModel: ViewModel() {

    private var firebase= FireBaseData()
    private var repo= Repository(firebase)

    fun uploadData(title:String, imageBitmap: Bitmap, activity: Activity):MutableLiveData<CategoryModel>
    {
        var data=repo.uploadCategory(title,imageBitmap
        ,activity)
        return data
    }
}