package com.example.gallery1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery1.Adapters.CategoryListAdapter
import com.example.gallery1.model.CategoryListModel
import com.example.gallery1.view.CategoryImagesFragment
import com.example.gallery1.view.home.HomeViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Category.newInstance] factory method to
 * create an instance of this fragment.
 */
class Category : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var recyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var arrayList: ArrayList<CategoryListModel>? = null
    private var categoryListAdapter: CategoryListAdapter? = null
    private lateinit var fstore:FirebaseStorage
    val db = FirebaseFirestore.getInstance()
    var fAuth = FirebaseAuth.getInstance()
    var userId=fAuth.currentUser?.uid.toString()

    var bundle=Bundle()


    var TAG="category"


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val root=inflater.inflate(R.layout.fragment_category, container, false)

        recyclerView = root.findViewById(R.id.category_recyclerview)
        gridLayoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager =GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)

        arrayList = ArrayList()
        arrayList = setDataInList()
//        categoryListAdapter = context?.let { CategoryListAdapter(it, arrayList!!) }
//        recyclerView?.adapter = categoryListAdapter

        var btnAddCategory=root.findViewById<FloatingActionButton>(R.id.btnAddCategory)
        btnAddCategory.setOnClickListener {
            Toast.makeText(activity,"add btn clicked", Toast.LENGTH_SHORT).show()
            val addCategoryFragment=AddCategoryFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.home_frag,addCategoryFragment)
                ?.addToBackStack(null)?.commit()

        }
        return root
    }






    fun setDataInList(): ArrayList<CategoryListModel> {
        var items: ArrayList<CategoryListModel> = ArrayList()
        db.collection("users").document(userId).collection("category")
            .get()
            .addOnCompleteListener {task->
                if(task.isSuccessful){
                    for(document in task.result!!){
                        Log.d(TAG,document.id)
                        var id=document.id

                        var imageUrl=document.data.get("imageUrl").toString()
                        var title=document.data.getValue("title").toString()

                        val b = items.add(CategoryListModel(imageUrl, title,id))
//                        Glide.with(this).load(imageUrl).into(category_image)

                    }
                    categoryListAdapter = context?.let { CategoryListAdapter(it, items!!) }
                    recyclerView?.adapter = categoryListAdapter
                }
            }



        return items

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Category.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Category().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}


