package com.example.gallery1.Adapters

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.example.gallery1.*
//import com.example.gallery1.databinding.CategoryListBinding
import com.example.gallery1.model.CategoryListModel
import com.example.gallery1.view.CategoryImagesFragment
import com.squareup.picasso.Picasso
import java.util.*

class CategoryListAdapter(var context: Context, var arrayList: ArrayList<CategoryListModel>) :
    RecyclerView.Adapter<CategoryListAdapter.ItemHolder>() {

    private lateinit var category: Category
    val TAG="catadapter"



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {


        val itemHolder=LayoutInflater.from(context).inflate(R.layout.category_list,parent,false)
        return ItemHolder(itemHolder)
//        val inflater = LayoutInflater.from(parent.context)
//        val binding: CategoryListBinding =
//            DataBindingUtil.inflate(inflater, R.layout.category_list, parent, false)
//        return ItemHolder(binding)

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var categoryListModel:CategoryListModel=arrayList.get(position)
        holder.title.text=categoryListModel.cat_title
        Glide.with(context).load(categoryListModel.cat_image).into(holder.image)
        holder.listItem.setOnClickListener {
            val categoryImagesFragment= CategoryImagesFragment()
            var args: Bundle = Bundle()
            var  id=categoryListModel.cat_id
            args.putString("data",id)
            Log.d(TAG,id)
            categoryImagesFragment.setArguments(args)
            Gallery1Activity.manager.beginTransaction().replace(R.id.home_frag,
                categoryImagesFragment)
                .addToBackStack(null).commit()


        }
//        holder.binding.categorylist = arrayList.get(position)
//        Glide.with(context).load(CategoryListModel().cat_image).into(ImageView())
//
//        holder.binding.executePendingBindings()
    }

//    class ItemHolder(var binding: CategoryListBinding) : RecyclerView.ViewHolder(binding.root){
//        var imageView=binding.categoryImage
//    }
    class  ItemHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var image=itemView.findViewById<ImageView>(R.id.category_image)
    var title=itemView.findViewById<TextView>(R.id.category_title)
    var listItem=itemView.findViewById(R.id.category_item) as ConstraintLayout

}


}