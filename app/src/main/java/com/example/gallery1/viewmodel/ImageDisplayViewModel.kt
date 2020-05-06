package com.example.gallery1.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallery1.data.FireBaseData
import com.example.gallery1.model.data.Repository


class ImageDisplayViewModel: ViewModel,LifecycleObserver {
    private var firebase= FireBaseData()
    private var repo= Repository(firebase)

    constructor() : super()


    fun getImage(id:String):MutableLiveData<String>
    {
        var data=repo.getSingleImageData(id)
        return data
    }

    fun deleteImage(cid:String,id:String):MutableLiveData<Boolean>{

        var data=repo.deleteImage(id,cid)
        return data
    }
}