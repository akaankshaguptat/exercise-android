package com.example.gallery1.view.fragment

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gallery1.R
import com.example.gallery1.viewmodel.AddCategoryViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_add_category.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddCategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddCategoryFragment : Fragment() {
    private val REQUEST_IMAGE_CAPTURE = 101
    private lateinit var imageUri: Uri
    private lateinit var mTitle: EditText


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var auth = FirebaseAuth.getInstance()
    var userId = auth.currentUser?.uid.toString()
    val db = FirebaseFirestore.getInstance()
    var fstore = FirebaseFirestore.getInstance()

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
        val view = inflater.inflate(R.layout.fragment_add_category, container, false)
        mTitle = view.findViewById(R.id.category_title)
        var title = mTitle.text.toString()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        imageView_category.setOnClickListener {
            var title = mTitle.text.toString()
            if (TextUtils.isEmpty(title)) {
                mTitle.setError("please enter title of category")
                mTitle.requestFocus()
                return@setOnClickListener
            }

            takepictureIntent()
        }

    }

    private fun takepictureIntent() {
        progressBar_addcategory.visibility = View.VISIBLE
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { pictureIntent ->
            pictureIntent.resolveActivity(activity?.packageManager!!)?.also {
                startActivityForResult(pictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            var loginViewModel: AddCategoryViewModel =
                ViewModelProvider(this)[AddCategoryViewModel::class.java]
            var progressBar = view?.findViewById(R.id.progressBar_addcategory) as ProgressBar

            loginViewModel.uploadData(mTitle.text.toString(), imageBitmap, activity!!)
                .observe(activity!!,
                    Observer {
                        imageView_category.setImageBitmap(imageBitmap)
                        progressBar.visibility = View.INVISIBLE
                        btn_save_category.setOnClickListener {
                            val category = Category1()
                            activity?.supportFragmentManager?.beginTransaction()
                                ?.replace(R.id.home_frag, category)
                                ?.addToBackStack(null)?.commit()
                        }

                    })


        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddCategoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddCategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
