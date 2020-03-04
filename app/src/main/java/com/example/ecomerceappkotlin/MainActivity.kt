package com.example.ecomerceappkotlin

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var sharedPref:SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener{

            sharedPref = getSharedPreferences("addData", Context.MODE_PRIVATE);
            var myEditor = sharedPref?.edit()
            myEditor.putString("Xin chao","cac ban");
            


        }




    }
}
