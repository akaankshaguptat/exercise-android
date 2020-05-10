package com.example.gallery1.data

import android.app.Activity
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData
import com.example.gallery1.R
import com.example.gallery1.model.pojo.CategoryList1Model
import com.example.gallery1.model.pojo.CategoryModel
import com.example.gallery1.model.pojo.ImageListModel
import com.example.gallery1.model.pojo.ProfileModelClass
import com.example.gallery1.view.activity.Gallery1Activity
import com.example.gallery1.view.fragment.CategoryImagesFragment
import com.example.gallery1.viewmodel.CategoryList1ViewModel
import com.example.gallery1.viewmodel.ImageListViewModel
import com.example.gallery1.viewmodel.TimelineViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import java.io.ByteArrayOutputStream

class FireBaseData {
    /* creating the instance of the firebase authentication*/
    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    /* creating the instance of the firebase database*/
    private val firebaseStorageInstance: FirebaseDatabase by lazy {
        FirebaseDatabase.getInstance()
    }
    private val firebasedb: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }


    fun getCategoryArrayList(): MutableLiveData<ArrayList<CategoryList1ViewModel>> {
        var arraylistmutablelivedata = MutableLiveData<ArrayList<CategoryList1ViewModel>>()


        var userId = firebaseAuth.currentUser?.uid!!
        firebasedb.collection("users").document(userId).collection("category")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    var arrayList = ArrayList<CategoryList1ViewModel>()
                    for (document in task.result!!) {
                        Log.d("test", document.id)
                        var id = document.id

                        var imageUrl = document.data.get("imageUrl").toString()
                        var title = document.data.getValue("title").toString()

                        var categoryList1Model =
                            CategoryList1Model(
                                imageUrl,
                                title,
                                id
                            )
                        var categoryList1ViewModel = CategoryList1ViewModel(categoryList1Model)
                        arrayList.add(categoryList1ViewModel)
                        arraylistmutablelivedata.value = arrayList
                    }
                }
            }
        return arraylistmutablelivedata
    }

    /*for getting timeline data from the firebase server*/

    fun getTimeLineArrayList(): MutableLiveData<ArrayList<TimelineViewModel>> {

        var fAuth = firebaseAuth
        var userId = fAuth.currentUser?.uid!!
        var arraylistmutablelivedata = MutableLiveData<ArrayList<TimelineViewModel>>()

        firebasedb.collection("users").document(userId).collection("timeline")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    var arrayList = ArrayList<TimelineViewModel>()
                    for (document in task.result!!) {
                        var imageUrl = document.data.get("imageUrl").toString()
                        var timestamp1: String = document.data.get("timeStamp").toString()

                        var imageListModel1 =
                            ImageListModel(
                                "1",
                                imageUrl,
                                timestamp1
                            )
                        var timelineViewModel = TimelineViewModel(imageListModel1)
                        arrayList.add(timelineViewModel)
                        arrayList.sortByDescending({ selector(it) })
                        arraylistmutablelivedata.value = arrayList
                    }

                }
            }

        return arraylistmutablelivedata

    }

    //for sorting recent image on top of the view
    fun selector(p: TimelineViewModel): String = p.timeStamp


    /* for getting the images of the category*/

    fun getImagesArrayList(id1: String): MutableLiveData<ArrayList<ImageListViewModel>> {

        var userId = firebaseAuth.currentUser?.uid!!

        var arraylistmutablelivedata = MutableLiveData<ArrayList<ImageListViewModel>>()


        firebasedb.collection("users").document(userId).collection("category").document(id1)
            .collection("CategoryImages")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    var arrayList = ArrayList<ImageListViewModel>()


                    for (document in task.result!!) {

                        var id = document.id
                        var imageUrl = document.data.get("imageUrl").toString()

                        var timeStamp = document.data.get("timeStamp").toString()
                        var imageListModel1 =
                            ImageListModel(
                                id,
                                imageUrl,
                                timeStamp
                            )
                        var imageListViewModel1: ImageListViewModel =
                            ImageListViewModel(imageListModel1)
                        arrayList.add(imageListViewModel1)
                        arraylistmutablelivedata.value = arrayList


                    }

                }
            }


        return arraylistmutablelivedata

    }


    fun getSingleImageData(id: String): MutableLiveData<String> {
        var liveData: MutableLiveData<String> = MutableLiveData()
        var userId = firebaseAuth.currentUser?.uid!!
        var documentReference = firebasedb.collection("users").document(userId)
            .collection("timeline").document(id)
        documentReference.addSnapshotListener { documentSnapshot, firebaseFirestoreException ->
            var imageurl1 = documentSnapshot?.getString("imageUrl")
            liveData.value = imageurl1
            Log.v("imageUrl", imageurl1 + "url")

        }
        return liveData
    }


    fun deleteImage(cid: String, id: String): MutableLiveData<Boolean> {
        var liveData: MutableLiveData<Boolean> = MutableLiveData()
        var userId = firebaseAuth.currentUser?.uid!!
        firebasedb.collection("users").document(userId).collection("category")
            .document(cid).collection("CategoryImages").document(id).delete()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    firebasedb.collection("users").document(userId).collection("timeline")
                        .document(id).delete().addOnCompleteListener {
                            if (it.isSuccessful) {
                                liveData.value = true
                                // Toast.makeText(context, "image deleted", Toast.LENGTH_SHORT).show()
                                val categoryImagesFragment =
                                    CategoryImagesFragment()
                                var b = Bundle()
                                b.putString("data", cid)
                                categoryImagesFragment.arguments = b
                                Gallery1Activity.manager.popBackStack(
                                    "image display 1",
                                    FragmentManager.POP_BACK_STACK_INCLUSIVE
                                )
                                Gallery1Activity.manager.beginTransaction()
                                    .replace(R.id.home_frag, categoryImagesFragment)
                                    .commit()
                            }
                        }
                }
            }
        return liveData

    }


    fun login(
        email_login: String,
        password_login: String,
        activity: Activity
    ): MutableLiveData<Boolean> {
        var liveData: MutableLiveData<Boolean> = MutableLiveData()
        firebaseAuth.signInWithEmailAndPassword(email_login, password_login)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    liveData.value = true


                } else {
                    liveData.value = false
                    // If sign in fails, display a message to the user.
                    Log.w(ContentValues.TAG, "loginUserWithEmail:failure", task.exception)


                }
            }
        return liveData
    }


    /* for signup*/

    fun signUp(
        email: String,
        password: String,
        name: String,
        activity: Activity,
        imageView_progilesignup: ImageView
    ): MutableLiveData<Boolean> {
        var liveData: MutableLiveData<Boolean> = MutableLiveData()
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    liveData.value=true
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(ContentValues.TAG, "createUserWithEmail:success")

                    var imageBitmap: Bitmap = imageView_progilesignup.drawable.toBitmap()

                   // uplaodImageAndSaveUri(imageBitmap, email, password, name, activity)

                } else {
                    liveData.value=false
                    if (task.exception is FirebaseAuthUserCollisionException) {
                        Log.w(ContentValues.TAG, "user already exists", task.exception)
                        Toast.makeText(activity, "user already exists", Toast.LENGTH_SHORT).show()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(ContentValues.TAG, "createUserWithEmail:failure", task.exception)

                        Toast.makeText(activity, "Authentication failed.", Toast.LENGTH_SHORT)
                            .show()
                    }

                }
            }
        return liveData
    }


    /* uploading user the data to the database*/
    fun uplaodImageAndSaveUri(
        imageBitmap: Bitmap,
        email: String,
        password: String,
        name: String, activity: Activity
    ): MutableLiveData<Boolean> {
        var liveData: MutableLiveData<Boolean> = MutableLiveData()
        var image1: String
        var userId = firebaseAuth.currentUser?.uid!!
        val baos = ByteArrayOutputStream()


        val storafgeRef = FirebaseStorage.getInstance()
            .reference.child("profileImages/${FirebaseAuth.getInstance().currentUser?.uid}")
        imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val image = baos.toByteArray()
        val uplaod = storafgeRef.putBytes(image)
        uplaod.addOnCompleteListener { uplaodTask ->
            if (uplaodTask.isSuccessful) {
                storafgeRef.downloadUrl.addOnCompleteListener { urlTask ->
                    urlTask.result?.let {
                        liveData.value = true
                        var intent= Intent(activity,Gallery1Activity::class.java)
                        var imageUri = it
                        image1 = imageUri.toString()

                        val user = hashMapOf(
                            "email" to email,
                            "password" to password,
                            "name" to name,
                            "profileImage" to image1
                        )

// Add a new document with a generated ID
                        firebasedb.collection("users").document(userId)
                            .set(user as Map<String, Any>)
                            .addOnSuccessListener {

                                Log.d(TAG, "successfully saved user data")
                            }
                            .addOnFailureListener { e ->
                                Log.w(ContentValues.TAG, "Error adding document", e)
                            }
                        //startActivity(intent)

                    }
                }
            } else {
                uplaodTask.exception?.let {
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()
                    liveData.value = false
                }
            }

        }
        return liveData

    }


    fun getProfileData(): MutableLiveData<ProfileModelClass> {
        var livedata: MutableLiveData<ProfileModelClass> = MutableLiveData<ProfileModelClass>()
        var userId = firebaseAuth.currentUser?.uid!!
        var documentReference = firebasedb.collection("users").document(userId)
        documentReference.addSnapshotListener { documentSnapshot,
                                                firebaseFirestoreException ->

            if (documentSnapshot != null) {
                var mEmail = documentSnapshot?.getString("email")!!
                var mPassword = documentSnapshot?.getString("password")!!
                var mName = documentSnapshot?.getString("name")!!

                var profile_image1 = documentSnapshot?.getString("profileImage")
                var profile = ProfileModelClass(
                    mEmail,
                    mPassword,
                    mName,
                    profile_image1
                )
                livedata.value = profile
            }


        }
        return livedata
    }


    /*uploading image */

    fun uploadCategoryImage(
        title: String,
        imageBitmap: Bitmap,
        activity: Activity
    ): MutableLiveData<CategoryModel> {

        var livedata: MutableLiveData<CategoryModel> = MutableLiveData<CategoryModel>()

        val baos = ByteArrayOutputStream()
        val storafgeRef = FirebaseStorage.getInstance()
            .reference.child("categoryImage/${FirebaseAuth.getInstance().currentUser?.uid}/${title}")
        imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val image = baos.toByteArray()
        val uplaod = storafgeRef.putBytes(image)
        uplaod.addOnCompleteListener { uplaodTask ->
            if (uplaodTask.isSuccessful) {
                storafgeRef.downloadUrl.addOnCompleteListener { urlTask ->
                    urlTask.result?.let {
                        var imageUri = it
                        var data = CategoryModel(
                            imageUri.toString(),
                            title
                        )
                        livedata.value = data
                        //  imageView_category.setImageBitmap(imageBitmap)
                        Toast.makeText(activity, imageUri.toString(), Toast.LENGTH_SHORT).show()
                        //  var title=mTitle.text.toString()
                        uplaodImageAndTitle(imageUri, title)


                    }
                }
            } else {
                uplaodTask.exception?.let {
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()
                }
            }

        }
        return livedata
    }

    private fun uplaodImageAndTitle(imageUri: Uri, title: String) {

        var userId = firebaseAuth.currentUser?.uid!!
        val user = hashMapOf(
            "imageUrl" to imageUri.toString(),
            "title" to title
        )

// Add a new document with a generated ID
        firebasedb.collection("users").document(userId).collection("category")
            .add(user as Map<String, Any>)
            .addOnSuccessListener { documentReference ->
                Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(ContentValues.TAG, "Error adding document", e)
            }

    }


}