package com.example.backgroundchanger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {
    var model=MainActivityBackgroundGenerator()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        var root=findViewById<LinearLayout>(R.id.root)
        model = ViewModelProviders.of(this).get(MainActivityBackgroundGenerator::class.java)
        lifecycle.addObserver(model)
        root.setBackgroundColor(model.getColor())
        button.setOnClickListener(){
         var obj=MainActivityBackgroundGenerator()
            lifecycle.addObserver(model)
             var randomColor=model.generateBackground()
            root.setBackgroundColor(randomColor)

        }
    }
}
