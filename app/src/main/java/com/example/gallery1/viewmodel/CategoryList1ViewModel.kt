package com.example.gallery1.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.gallery1.data.FireBaseData


import com.example.gallery1.model.pojo.CategoryList1Model
import com.example.gallery1.model.data.Repository
import com.google.firebase.auth.FirebaseAuth

class CategoryList1ViewModel:ViewModel {
    private lateinit var userId:String
    private lateinit var fAuth: FirebaseAuth
    private var firebase= FireBaseData()
    private var repo= Repository(firebase)

    var cat_image:String = ""
    var cat_title:String?=null
    var cat_id:String?=null
    constructor() : super()
    constructor(categoryList1Model: CategoryList1Model) : super() {
        this.cat_image = categoryList1Model.cat_image
        this.cat_title = categoryList1Model.cat_title
        this.cat_id = categoryList1Model.cat_id
    }


    fun getImageUrl():String{
        return cat_image
    }

    fun getArrayList(): MutableLiveData<ArrayList<CategoryList1ViewModel>> {
        var list=repo.getCategoryData()

        return  list


    }

}
object CategoryBindingAdapter{
    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUrl(view: ImageView, url:String){
        Glide.with(view.context).load(url).into(view)
    }
}