package com.example.gallery1.view.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.gallery1.R
import com.example.view.gallery1.LoginFragment

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var manager: FragmentManager
        var instance: MainActivity? = null
        fun applicationContext(): Context {
            return instance!!.applicationContext
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)


        manager = this.supportFragmentManager
        val transaction = manager.beginTransaction()
        val login_fragment = LoginFragment()
        transaction.add(R.id.login_holder, login_fragment)
        /*  transaction.addToBackStack(null)*/
        transaction.commit()

    }

    fun getTitle1(titleFrag: String) {
        supportActionBar!!.title = titleFrag
    }

    override fun onBackPressed() {

        super.onBackPressed()
        /* var count =supportFragmentManager.backStackEntryCount
         Log.d("backpress", count.toString())
         if (count == 0) {
             super.onBackPressed()
             finish()
         } else {
             supportFragmentManager.popBackStack()
         }*/
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        var id = item.itemId
//        if (id == R.id.login) {
//            supportActionBar?.title ="login"
//        }
//        return super.onOptionsItemSelected(item)
//
//    }

    override fun onSupportNavigateUp(): Boolean {
        Log.d("backpress", "top left back")
        this.onBackPressed()
        return super.onSupportNavigateUp()


    }

}
