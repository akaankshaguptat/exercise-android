package com.example.gallery1.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.gallery1.Constants
import com.example.gallery1.R
import com.example.gallery1.view.fragment.HomeFragment
import com.example.gallery1.view.fragment.ProfileFragment
import com.example.gallery1.view.fragment.TimelineFragment
import com.example.gallery1.viewmodel.ProfileViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.nav_header_gallery1.*

class Gallery1Activity : AppCompatActivity() {

    companion object {
        lateinit var manager: FragmentManager
        var instance: Gallery1Activity? = null
        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var homeFragment: HomeFragment
    private lateinit var profileFragment: ProfileFragment
    private lateinit var timeLineFragment: TimelineFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery1)

        manager = this.supportFragmentManager
        val type = Constants.test.Bottom.type


        if (type.equals("l")) {
            val toolbar: Toolbar = findViewById(R.id.toolbar)
            setSupportActionBar(toolbar)
            val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
            val navView: NavigationView = findViewById(R.id.nav_view)
            val navController = findNavController(R.id.nav_host_fragment)
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.nav_home,
                    R.id.nav_gallery,
                    R.id.nav_slideshow
                ), drawerLayout
            )
            setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)

            updateNavHeader()
        }

        Log.d("flavor", type)
        if (type.equals("b")) {
            Log.d("flavor", type)
            val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_nav)
            homeFragment = HomeFragment()
            supportFragmentManager
                .beginTransaction().replace(R.id.home_frag, homeFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            bottomNavigation.setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.nav_home -> {
                        homeFragment =
                            HomeFragment()
                        supportFragmentManager
                            .beginTransaction().replace(R.id.home_frag, homeFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

                    }
                    R.id.nav_gallery -> {
                        profileFragment =
                            ProfileFragment()
                        supportFragmentManager
                            .beginTransaction().replace(R.id.home_frag, profileFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

                    }
                    R.id.nav_slideshow -> {
                        timeLineFragment =
                            TimelineFragment()
                        supportFragmentManager
                            .beginTransaction().replace(R.id.home_frag, timeLineFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

                    }

                }
                true
            }

        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.gallery1, menu)
        return true
    }

    fun updateNavHeader() {
        val auth = FirebaseAuth.getInstance()
        val userId = auth.currentUser!!.uid
        val db = FirebaseFirestore.getInstance()
        val navView: NavigationView = findViewById(R.id.nav_view)
        var headerView = navView.getHeaderView(0)
        var name = headerView.findViewById<TextView>(R.id.name1)
        var email = headerView.findViewById<TextView>(R.id.email1)
        var image = headerView.findViewById<ImageView>(R.id.imageView1)
        var profileViewModel: ProfileViewModel =
            ViewModelProvider(this)[ProfileViewModel::class.java]
        profileViewModel.profiileData().observe(this, Observer {
            var profileData = it
            email.setText(profileData.email)
            name.setText(profileData.name)

            Glide.with(this).load(profileData.image_url).apply(RequestOptions.circleCropTransform())
                .into(imageView1)

        })
        /* var documentReference = db.collection("users").document(userId)
         documentReference.addSnapshotListener { documentSnapshot, firebaseFirestoreException ->
             if(documentSnapshot!=null)
             {
                 var email1= documentSnapshot?.getString("email")!!
                 var  name1 = documentSnapshot?.getString("name")!!
                 name.setText(name1)
                 email.setText(email1)
                 var profile_image1 = documentSnapshot?.getString("profileImage")
                 //Toast.makeText(activity, profile_image1, Toast.LENGTH_SHORT).show()

                 Glide.with(this).load(profile_image1).apply(RequestOptions.circleCropTransform()).into(imageView1)
             }


         }
 */

    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun logout(item: MenuItem) {
        FirebaseAuth.getInstance().signOut()
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}
