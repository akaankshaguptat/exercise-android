package com.example.gallery1.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery1.R
import com.example.gallery1.databinding.ImageBinding
import com.example.gallery1.viewmodel.ImageListViewModel

class ImageListAdapter(private val context: Context,private val arrayList: ArrayList<ImageListViewModel>)
    :RecyclerView.Adapter<ImageListAdapter.ItemView>() {


    class ItemView(val imageBinding: ImageBinding):RecyclerView.ViewHolder(imageBinding.root){
        fun bind(imageListViewModel:ImageListViewModel){
            this.imageBinding.imagemodel=imageListViewModel
            imageBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemView {
        val layoutInflater=LayoutInflater.from(parent.context)
        val imageBinding:ImageBinding=DataBindingUtil.inflate(layoutInflater, R.layout.image_list,parent,false)
        return ItemView(imageBinding)
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemView, position: Int) {
       val imageListViewModel = arrayList[position]
        holder.bind(imageListViewModel)
    }
}