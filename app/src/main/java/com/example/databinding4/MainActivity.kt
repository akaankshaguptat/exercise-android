package com.example.databinding4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val linearLayoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerview.layoutManager=linearLayoutManager

        val userAdapter=MyAdapter(prepareData())
        recyclerview.adapter=userAdapter
    }

    private fun prepareData(): ArrayList<User> {


        var user1=User("test1", "test1@gmail.com", "1231323312")
        var user2=User("test2", "test2@gmail.com", "1313131")
        var user3=User("test3", "test3@gmail.com", "312131313")
        var user4=User("test4", "test4@gmail.com", "1313131")
        var user5=User("test", "test5@gmail.com", "13131311313")


        return arrayListOf<User>(user1,user2,user3,user4,user5,user1,user2,user3,user4,user5)
    }

}
