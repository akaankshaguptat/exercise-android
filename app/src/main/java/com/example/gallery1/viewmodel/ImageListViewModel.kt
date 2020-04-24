package com.example.gallery1.viewmodel

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.gallery1.model.ImageListModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ImageListViewModel:ViewModel, LifecycleObserver {


    private var id1: String? = null
    val TAG="viewmodel"
    private lateinit var userId:String
    private lateinit var fAuth: FirebaseAuth


    var id:String =""
    var imageUrl1:String = ""
    var timeStamp=""
    constructor() : super()
    constructor(imageListModel: ImageListModel) : super() {
        this.id = imageListModel.id
        this.imageUrl1 = imageListModel.imageUrl1
        this.timeStamp = imageListModel.timeStamp
    }



    fun getImageUrl():String{
        return imageUrl1
    }

    fun getArrayList(id1:String): MutableLiveData<ArrayList<ImageListViewModel>> {



        val db = FirebaseFirestore.getInstance()
        fAuth = FirebaseAuth.getInstance()
        userId = fAuth.currentUser?.uid!!
        Log.d(TAG,id1)
        var arraylistmutablelivedata=MutableLiveData<ArrayList<ImageListViewModel>>()


        db.collection("users").document(userId).collection("category").document(id1)
            .collection("CategoryImages")
            .get()
            .addOnCompleteListener {task->
                if(task.isSuccessful){
                    var arrayList=ArrayList<ImageListViewModel>()
                    for(document in task.result!!){
                        Log.d(TAG,document.id)
                        var id=document.id
                        var imageUrl=document.data.get("imageUrl").toString()
                        var timeStamp=document.data.get("timeStamp").toString()
                        var imageListModel1=ImageListModel(id,imageUrl,timeStamp)
                        var imageListViewModel1:ImageListViewModel= ImageListViewModel(imageListModel1)
                        arrayList!!.add(imageListViewModel1)
                        arraylistmutablelivedata.value=arrayList



                    }

                }
            }


        return arraylistmutablelivedata

    }

}


object ImageBindingAdapter{
    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUrl(view:ImageView,url:String){
        Glide.with(view.context).load(url).into(view)
    }
}