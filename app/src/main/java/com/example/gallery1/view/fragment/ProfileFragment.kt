package com.example.gallery1.view.fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.gallery1.R
import com.example.gallery1.view.activity.MainActivity
import com.example.gallery1.viewmodel.ProfileViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private val REQUEST_IMAGE_CAPTURE = 100
    private val TAG: String = "profile"
    private lateinit var imageUri: Uri


    private lateinit var btn_logout: Button
    private lateinit var email: TextView
    private lateinit var password: TextView
    private lateinit var name: TextView
    private lateinit var btn_changePic: Button

    private lateinit var fAuth: FirebaseAuth
    private lateinit var fStore: FirebaseStorage

    private lateinit var userId: String
    private lateinit var mUser: User
    private lateinit var mDatabase: DatabaseReference
    private lateinit var mEmail: String
    private lateinit var mPassword: String
    private lateinit var mName: String


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_profile, container, false)

        var profile_image = root.findViewById<ImageView>(R.id.imageView_profile)
        email = root.findViewById(R.id.Text_email)
        // password = root.findViewById(R.id.Text_pass)
        name = root.findViewById(R.id.Text_name)
        btn_changePic = root.findViewById(R.id.btn_changeprofilepic)
        var progressBar_pic = root.findViewById<ProgressBar>(R.id.progressBar_pic)


        var user = FirebaseAuth.getInstance().currentUser
        fAuth = FirebaseAuth.getInstance()
        fStore = FirebaseStorage.getInstance()


        btn_logout = root.findViewById(R.id.btn_logout)
        btn_logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            activity?.finish()
            var intent = Intent(activity, MainActivity::class.java)
            activity?.finish()
            startActivity(intent)
        }


        userId = fAuth.currentUser?.uid!!
        val db = FirebaseFirestore.getInstance()


        var profileViewModel: ProfileViewModel =
            ViewModelProvider(this)[ProfileViewModel::class.java]
        profileViewModel.profiileData().observe(activity!!, Observer {
            var profileData = it
            mEmail= profileData.email.toString()
            mName= profileData.name.toString()
            mPassword=profileData.pasword.toString()
            email.setText(profileData.email)
            name.setText(profileData.name)
            Glide.with(this).load(profileData.image_url).apply(RequestOptions.circleCropTransform())
                .into(profile_image)

        })



        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_changePic.setOnClickListener {
            takepictureIntent()
        }

    }

    private fun takepictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { pictureIntent ->
            pictureIntent.resolveActivity(activity?.packageManager!!)?.also {
                startActivityForResult(pictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView_profile.setImageBitmap(imageBitmap)
            var profileViewModel: ProfileViewModel =
                ViewModelProvider(this)[ProfileViewModel::class.java]
            profileViewModel.updateProfileData(imageBitmap,mEmail,mPassword, mName,activity!!)
                .observe(activity!!,
                    Observer {
                        if (it) {
                            Toast.makeText(
                                activity,
                                "Image Uploaded Sucessfully",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(activity, "Image Uploaded Failed", Toast.LENGTH_SHORT)
                                .show()
                        }
                    })


        }
    }

}