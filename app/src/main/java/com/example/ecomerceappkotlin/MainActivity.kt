package com.example.ecomerceappkotlin

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.shashank.sony.fancytoastlib.FancyToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var sharedPref:SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetData.setOnClickListener {

            val serverURL = "http://192.168.1.8/PhpTest/newEmptyPHP.php";
            val requestQ: RequestQueue = Volley.newRequestQueue(this@MainActivity);
            val stringRequest =  StringRequest(Request.Method.GET,serverURL,Response.Listener <String>{
                txtHelloWorld.text = it.toString()

            },Response.ErrorListener {

                txtHelloWorld.text = "ERROR: %s".format(it.toString())
            })
            requestQ.add(stringRequest)


        }






    }
    private fun showToast(message:String,mode:Int){

        FancyToast.makeText(this,message,FancyToast.LENGTH_SHORT,mode,false).show();

    }
}
