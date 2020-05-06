package com.example.gallery1.model.Adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery1.view.activity.Gallery1Activity
import com.example.gallery1.R
import com.example.gallery1.databinding.CategoryBinding
import com.example.gallery1.view.fragment.CategoryImagesFragment
import com.example.gallery1.viewmodel.CategoryList1ViewModel

class CategoryList1Adapter(private val context: Context, private val arrayList: ArrayList<CategoryList1ViewModel>)
    :RecyclerView.Adapter<CategoryList1Adapter.ItemView>() {

    class ItemView(val categoryBinding: CategoryBinding):RecyclerView.ViewHolder(categoryBinding.root){
        fun bind(categoryList1ViewModel: CategoryList1ViewModel){
            this.categoryBinding.categorymodel=categoryList1ViewModel
            categoryBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemView {
        val layoutInflater= LayoutInflater.from(parent.context)
        val categoryBinding:CategoryBinding=DataBindingUtil.inflate(layoutInflater,
            R.layout.category_list1,parent,false)
        return ItemView(categoryBinding)

    }

    override fun getItemCount(): Int {
         return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemView, position: Int) {
        val categoryList1ViewModel=arrayList[position]
        holder.bind(categoryList1ViewModel)
        holder.categoryBinding.categoryList.setOnClickListener {
            val categoryImagesFragment=
                CategoryImagesFragment()
            var args=Bundle()
            var id=categoryList1ViewModel.cat_id
            args.putString("data",id)
            categoryImagesFragment.setArguments(args)
            Gallery1Activity.manager.beginTransaction().replace(R.id.home_frag,
                categoryImagesFragment)
                .addToBackStack(null).commit()

        }
    }
}